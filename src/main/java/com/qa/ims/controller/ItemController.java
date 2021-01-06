package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.Utils;

public class ItemController implements CrudController<Item>
{
	public static final Logger LOGGER = LogManager.getLogger();
	
	private ItemDAO itemDAO;
	private Utils utils;
	
	public ItemController(ItemDAO itemDAO, Utils utils)
	{
		super();
		this.itemDAO = itemDAO;
		this.utils = utils;
	}

	@Override
	public List<Item> readAll() 
	{
		List<Item> items = itemDAO.readAll();
		for (Item i : items) 
		{
			LOGGER.info(i.toString());
		}
		return items;
	}

	@Override
	public Item create() 
	{
		LOGGER.info("Please enter the name of the item");
		String itemName = utils.getString();
		LOGGER.info("Please enter the price of the item");
		double itemPrice = utils.getDouble();
		LOGGER.info("How much stock have you got for it?");
		Long itemStock = utils.getLong();
		Item item = itemDAO.create(new Item(itemName, itemPrice, itemStock));
		LOGGER.info("Item Created!... Returning back to Menu\n");
		return item;
	}

	@Override
	public Item update() 
	{
		LOGGER.info("Please enter the id of the item you would like to update");
		Long id = utils.getLong();
		LOGGER.info("Please enter the name of the new product name");
		String itemName = utils.getString();
		LOGGER.info("What is the price of the item?");
		double itemPrice = utils.getDouble();
		LOGGER.info("What is the stock count of the item?");
		Long itemStock = utils.getLong();
		Item item = itemDAO.update(new Item(id, itemName, itemPrice, itemStock));
		if (item != null)
		{
			LOGGER.info("Item Updated!... returning to Menu\n");
			return item;
		}
		else
		{
			LOGGER.info("Update Failed! Customer ID not found... returning to Menu\n");
			return null;
		}		
	}

	@Override
	public int delete() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
