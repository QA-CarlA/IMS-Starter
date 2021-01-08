package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

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
	public void testSetFirstName()
	{
		String fName = "Marine";
		customer.setFirstName(fName);;
		assertEquals(String.valueOf(fName), customer.getFirstName());
	}
	
	@Test
	public void testSetLastName()
	{
		String lName = "Housho";
		customer.setSurname(lName);;
		assertEquals(String.valueOf(lName), customer.getSurname());
	}
	
	// TESTING EQUALS METHOD
//	@Test
//	public void testEquals()
//	{
//		EqualsVerifier.simple().forClass(Customer.class).verify();
//	}
}
