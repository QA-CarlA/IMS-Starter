package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class OrderDAO implements Dao<Order>
{
	public static final Logger LOGGER = LogManager.getLogger();

	@Override
	public List<Order> readAll() 
	{
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select * from orders");) {
			List<Order> orders = new ArrayList<>();
			while (resultSet.next()) {
				orders.add(modelFromResultSet(resultSet));
			}
			return orders;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}
	
	public Order readOrder(Long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders WHERE orderID =" + id);) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	public Order readLatest() 
	{
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders ORDER BY orderID DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	@Override
	public Order create(Order order) 
	{
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("INSERT INTO orders(customerID) values('" + order.getCustomerID()+ "')");
			HashMap<Long, Long> orderItems = order.getItemsOrdered();
			for(Entry<Long, Long> i : orderItems.entrySet())
			{
				statement.executeUpdate("INSERT INTO order_items(orderID, itemID, itemQuantity) values(" + readLatest().getOrderID()
						+ "," + i.getKey() + "," + i.getValue() + ")");
			}
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
			return null;
		}
		return readLatest();
	}

	@Override
	public Order update(Order t) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void addToOrder(Long orderID, Long itemID, Long itemQuantity)
	{
		try (Connection connection = DBUtils.getInstance().getConnection();
				 Statement statement = connection.createStatement();)
			{
			statement.executeUpdate("INSERT INTO order_items VALUES (" + orderID  + ", " + itemID + ", " + itemQuantity +")");
			} catch (Exception e) {
				LOGGER.debug(e);
				LOGGER.error(e.getMessage());
			}
	}
	
	public void deleteFromOrder(Long orderID, Long itemID)
	{
		try (Connection connection = DBUtils.getInstance().getConnection();
				 Statement statement = connection.createStatement();)
			{
			statement.executeUpdate("DELETE FROM order_items WHERE orderID =" + orderID + " AND itemID = " + itemID);
			} catch (Exception e) {
				LOGGER.debug(e);
				LOGGER.error(e.getMessage());
			}
	}

	@Override
	public int delete(long id) 
	{
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();) {
				statement.executeUpdate("DELETE from order_items WHERE orderID = " + id);
				return statement.executeUpdate("DELETE from orders WHERE orderID = " + id);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
			LOGGER.info(e.getClass());
		}
		return 0;
	}
	

	@Override
	public Order modelFromResultSet(ResultSet resultSet) throws SQLException 
	{
		Long orderID = resultSet.getLong("orderID");
		Long customerID = resultSet.getLong("customerID");
		String datePlaced = resultSet.getString("datePlaced");
		return new Order(orderID, customerID, datePlaced);
	}
	
}
