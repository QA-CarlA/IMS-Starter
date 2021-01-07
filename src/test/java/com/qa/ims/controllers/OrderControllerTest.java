package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.any;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.OrderController;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {

	@Mock
	private Utils utils;
	
	@Mock
	private OrderDAO dao;
	
	@InjectMocks
	private OrderController controller;
	
	@Test
	public void testCreate(){
		final Long customerID = 1L;
		final Long itemID = 2L;
		final Long itemIDTwo = 6L;
		final Long itemQuantity = 10L;
		final Long itemQuantityTwo = 22L;
		
		HashMap<Long,Long> items = new HashMap<Long,Long>();
		items.put(itemID, itemQuantity);
		items.put(itemIDTwo, itemQuantityTwo);
		final Order ordered = new Order(customerID, items);
	
		Mockito.when(utils.getLong()).thenReturn(customerID, itemID, itemQuantity, itemIDTwo, itemQuantityTwo);
		Mockito.when(utils.getString()).thenReturn("yes", "no");
		Mockito.when(dao.create(any(Order.class))).thenReturn(ordered);
		
		
		assertEquals(ordered, controller.create());
		Mockito.verify(utils, Mockito.times(5)).getLong();
		Mockito.verify(utils, Mockito.times(2)).getString();
		Mockito.verify(dao, Mockito.times(1)).create(any(Order.class));
	}
	
	@Test
	public void testReadAll() 
	{
		List<Order> orders = new ArrayList<>();
		orders.add(new Order(1L, 1L, "2020-12-01 01:01:01"));
		
		Mockito.when(dao.readAll()).thenReturn(orders);
		
		assertEquals(orders, controller.readAll());
		Mockito.verify(dao, Mockito.times(1)).readAll();
	}
	
	@Test
	public void testUpdate()
	{
		final Long orderID = 1L;
		final Long itemID = 2L;
		final Long itemQuantity = 10L;
		final String selection = "ADD";
		final Long customerID = 1L;
		
		List<Order> orders = new ArrayList<>();
		orders.add(new Order(orderID, customerID, "2020-12-01 01:01:01"));
		
		
		Mockito.when(utils.getLong()).thenReturn(orderID, itemID, itemQuantity);
		Mockito.when(utils.getString()).thenReturn(selection);
		Mockito.lenient().when(dao.readAll()).thenReturn(orders);
		Mockito.when(dao.addToOrder(orderID, itemID, itemQuantity)).thenReturn(1);
		
		assertEquals(null, controller.update());
		Mockito.verify(utils, Mockito.times(3)).getLong();
		Mockito.verify(dao, Mockito.times(1)).addToOrder(orderID, itemID, itemQuantity);
	}
	
	@Test
	public void testDelete() 
	{
		final long orderID = 1L;
		
		Mockito.when(utils.getLong()).thenReturn(orderID);
		Mockito.when(dao.delete(orderID)).thenReturn(1);
		
		assertEquals(1, controller.delete());
		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).delete(orderID);
	}
}