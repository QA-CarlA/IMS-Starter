package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.ItemController;
import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class ItemControllerTest
{
	@Mock
	private Utils utils;
	
	@Mock
	private ItemDAO dao;
	
	@InjectMocks
	private ItemController controller;
	
	@Test
	public void testCreate()
	{
		final String testName = "Poster";
		final Double testPrice = 19.99;
		final Long testStock = 100L;
		final Item created = new Item(testName, testPrice, testStock);
		
		Mockito.when(utils.getString()).thenReturn(testName);
		Mockito.when(utils.getDouble()).thenReturn(testPrice);
		Mockito.when(utils.getLong()).thenReturn(testStock);
		Mockito.when(dao.create(created)).thenReturn(created);
		
		assertEquals(created, controller.create());
		
		Mockito.verify(utils, Mockito.times(1)).getString();
		Mockito.verify(utils, Mockito.times(1)).getDouble();
		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).create(created);
	}
	
	@Test
	public void testReadAll()
	{
		List<Item> items = new ArrayList<>();
		items.add(new Item("Poster", 19.99, 100L));
		
		Mockito.when(dao.readAll()).thenReturn(items);
		assertEquals(items,controller.readAll());
		
		Mockito.verify(dao, Mockito.times(1)).readAll();
	}
	
	@Test
	public void testUpdate()
	{
		Item updated = new Item(1L, "B2 Poster", 25.99, 20L);
		
		Mockito.when(this.utils.getLong()).thenReturn(1L, updated.getItemStock());
		Mockito.when(this.utils.getString()).thenReturn(updated.getItemName());
		Mockito.when(this.utils.getDouble()).thenReturn(updated.getItemCost());
		Mockito.when(this.dao.update(updated)).thenReturn(updated);
		
		assertEquals(updated, this.controller.update());
		
		Mockito.verify(this.utils, Mockito.times(2)).getLong();
		Mockito.verify(this.utils, Mockito.times(1)).getString();
		Mockito.verify(this.utils, Mockito.times(1)).getDouble();
		Mockito.verify(this.dao, Mockito.times(1)).update(updated);
	}
	
	@Test
	public void testUpdateFail()
	{
		Item updated = new Item(10L, "B2 Poster", 25.99, 20L);
		
		Mockito.when(this.utils.getLong()).thenReturn(updated.getId(), updated.getItemStock());
		Mockito.when(this.utils.getString()).thenReturn(updated.getItemName());
		Mockito.when(this.utils.getDouble()).thenReturn(updated.getItemCost());
		Mockito.when(this.dao.update(updated)).thenReturn(null);
		
		assertNotEquals(updated, this.controller.update());
		
		Mockito.verify(this.utils, Mockito.times(2)).getLong();
		Mockito.verify(this.utils, Mockito.times(1)).getString();
		Mockito.verify(this.utils, Mockito.times(1)).getDouble();
		Mockito.verify(this.dao, Mockito.times(1)).update(updated);
	}
	
	@Test
	public void testDelete()
	{
		final long testID = 1L;
		
		Mockito.when(utils.getLong()).thenReturn(testID);
		Mockito.when(dao.delete(testID)).thenReturn(1);
		
		assertEquals(1l, this.controller.delete());
		
		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).delete(testID);
	}
	
	@Test
	public void testDeleteFail()
	{
		final long testID = 1L;
		
		Mockito.when(utils.getLong()).thenReturn(testID);
		Mockito.when(dao.delete(testID)).thenReturn(0);
		
		assertNotEquals(1l, this.controller.delete());
		
		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).delete(testID);
	}
}
