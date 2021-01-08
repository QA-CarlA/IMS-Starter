package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class OrderDomainTest
{
	Order order;
	HashMap<Long, Long> items = new HashMap<Long, Long>();
	
	@Before
	public void setup()
	{
		items.put(1L, 20L);
		items.put(2L, 10L);
		order = new Order(1L, 2L, "2020/12/01 01:01:01", items);
	}
	
	@Test
	public void testGetDateOrdered() 
	{
		Order newOrder = new Order(4L, 6L, "03/07/2020");
		assertEquals("03/07/2020",newOrder.getDateOrdered());
	}
	
	@Test
	public void testSetDateOrdered() 
	{
		order.setDateOrdered("01/01/2020");
		assertEquals("01/01/2020", order.getDateOrdered());
	}
	
	@Test
	public void testEquals() 
	{
		EqualsVerifier.simple().forClass(Order.class).verify();
	}
}
