package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.ItemDAO;
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
	public Item update() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
