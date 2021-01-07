package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CustomerDomainTest
{
	
	Customer customer = new Customer(1L, "Fubuki", "Shirakami");
	
	
	@Test
	public void testSetAndGetID()
	{
		long id = 1L;
		customer.setId(id);
		assertEquals(Long.valueOf(id), customer.getId());
	}
	
	@Test
	public void testGetFirstName()
	{
	}
	
}
