package com.qa.ims.controller;

import java.util.HashMap;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Order;
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
	public Order update() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete() {
		// TODO Auto-generated method stub
		return 0;
	}
}
