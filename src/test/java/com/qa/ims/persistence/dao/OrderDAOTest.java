package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class OrderDAOTest {

	private final OrderDAO order = new OrderDAO();

	@Before
	public void setup() 
	{
		DBUtils.connect("root", "root");
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}
	
	@Test
	public void testCreate()
	{
		final Long customerID = 1L;
		HashMap<Long, Long> items = new HashMap<Long, Long>();
		items.put(1L, 10L);
		items.put(2L, 13L);
		final Order created = new Order(8L, customerID, items);
		
		assertEquals(created.getOrderID(), order.create(created).getOrderID());
		assertEquals(created.getCustomerID(), order.create(created).getCustomerID());
	}
	
	@Test
	public void testReadAll()
	{
		List<Order> orders = new ArrayList<>();
		orders.add(new Order(1L, 1L, "2020-12-01 01:01:01"));
		orders.add(new Order(2L, 2L, "2020-12-02 02:02:02"));
		orders.add(new Order(3L, 3L, "2020-12-03 03:03:03"));
		orders.add(new Order(4L, 4L, "2020-12-04 04:04:04"));
		orders.add(new Order(5L, 5L, "2020-12-05 05:05:05"));
		orders.add(new Order(6L, 6L, "2020-12-06 06:06:06"));
		orders.add(new Order(7L, 7L, "2020-12-07 07:07:07"));
		assertEquals(orders, order.readAll());
		
	}
	
	@Test
	public void testDelete()
	{
		assertEquals(1, order.delete(1));
	}
	
	@Test
	public void testAddToOrder()
	{
		assertEquals(0, order.addToOrder(1L, 3L, 6L));
	}
	
	@Test
	public void deleteFromOrder()
	{
		assertEquals(0, order.deleteFromOrder(1L, 1L));
	}
}