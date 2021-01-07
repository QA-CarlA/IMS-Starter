package com.qa.ims.controller;

import java.sql.Connection;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Order>
{
	public static final Logger LOGGER = LogManager.getLogger();

	private OrderDAO orderDAO;
	private Utils utils;
	
	public OrderController(OrderDAO orderDAO, Utils utils) {
		super();
		this.orderDAO = orderDAO;
		this.utils = utils;
	}

	@Override
	public List<Order> readAll() 
	{
		List<Order> orders = orderDAO.readAll();
		for(Order i : orders)
		{
			LOGGER.info(i.toString());
		}
		return orders;
	}

	@Override
	public Order create() 
	{
		LOGGER.info("Enter Customer ID");
		long customerID = utils.getLong();
		LOGGER.info("Enter the Item ID to be placed in the order:");
		long itemID = utils.getLong();
		LOGGER.info("How many items would you like to add to the order?");
		long itemQuantity = utils.getLong();
		HashMap<Long, Long> items = new HashMap<Long, Long>();
		items.put(itemID, itemQuantity);
		
		boolean bool = true;
		do
		{
			LOGGER.info("Do you want to add more items to the order? (Yes/No)");
			String yesNo  = utils.getString();
			if(yesNo.equalsIgnoreCase("Yes"))
			{
				LOGGER.info("Enter the Item ID to be placed in the order:");
				itemID = utils.getLong();
				LOGGER.info("How many items would you like to add to the order?");
				itemQuantity = utils.getLong();
				items.put(itemID, itemQuantity);
			}
			else
			{
				bool = false;
			}
		}while (bool == true);
		Order order = orderDAO.create(new Order(customerID, items));
		LOGGER.info("Order created");
		return order;
	}

	@Override
	public Order update() 
	{
		LOGGER.info("Please enter the id of the order you would like to update");
		Long orderID = utils.getLong();
		LOGGER.info("What would you like to do with the order?");
		LOGGER.info("ADD: Add item to the current order");
		LOGGER.info("DELETE: Remove item from the current order");
		LOGGER.info("CANCEL: Cancel update");
		String choice = utils.getString().toUpperCase();
		Order order = null;
		switch (choice)
		{
		case "ADD" :
			LOGGER.info("Enter the Item ID to be placed in the order:");
			Long addItemID = utils.getLong();
			LOGGER.info("How many items would you like to add to the order?");
			Long itemQuantity = utils.getLong();
			orderDAO.addToOrder(orderID, addItemID, itemQuantity);
			LOGGER.info("Item Added!... Returning to Menu\n");
			break;
		case "DELETE":
			LOGGER.info("Enter the Item ID to be deleted in the order:");
			Long deleteItemID = utils.getLong();
			orderDAO.deleteFromOrder(orderID, deleteItemID);
			LOGGER.info("Item Deleted from Order!... Returning to Menu\n");
			break;
		case "CANCEL":
			return null;
		default:
			LOGGER.info("Invalid Choice... Returning to Update Menu\n");
			update();
		}
		return order;
	}

	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the order you would like to delete");
		Long deleteID = utils.getLong();
		int rID = orderDAO.delete(deleteID);
		if (rID == 0)
		{
			LOGGER.info("Delete Failed! Order ID not found... returning to Menu\n");
		}
		else
		{
			LOGGER.info("Delete Success!... returning to Menu\n");
		}
		return rID;
	}
}
