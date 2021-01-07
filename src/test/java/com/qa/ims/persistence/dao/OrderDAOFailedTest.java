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

public class OrderDAOFailedTest {

	private final OrderDAO order = new OrderDAO();

	@Before
	public void setup() 
	{
		DBUtils.connect("root", "password");
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}
	
	@Test
	public void testCreate()
	{
		final Order created = new Order(10L, 10L, "2020-12-01 01:01:01");
		assertEquals(null, order.create(created));
	}
	
	@Test
	public void testReadAll()
	{
		assertEquals(new ArrayList<>(), order.readAll());
	}
	
	@Test
	public void testDelete()
	{
		assertEquals(0, order.delete(1));
	}
	
	@Test
	public void testAddToOrder() {
		assertEquals(0, order.addToOrder(1L, 1L, 1L));
	}
	
	@Test
	public void testRemoveFromOrder() {
		assertEquals(0, order.deleteFromOrder(1L, 1L));
	}


}