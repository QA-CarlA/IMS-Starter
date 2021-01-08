package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class ItemDomainTest
{
	private final Item item = new Item(1L, "B2 Poster", 19.99, 50L);
	
	@Test
	public void testSetID()
	{
		Long newID = 2L;
		item.setId(newID);;
		assertEquals(newID, item.getId());
	}
	
	@Test
	public void testSetItemName()
	{
		String newItemName = "B2 Wall Scroll";
		item.setItemName(newItemName);
		assertEquals(newItemName, item.getItemName());
	}
	
	@Test
	public void testSetItemCost()
	{
		Double newCost = 25.99;
		item.setItemCost(newCost);;
		assertEquals(newCost, item.getItemCost(), 1.);
	}
	
	@Test
	public void testSetItemStock()
	{
		Long newStock = 10L;
		item.setItemStock(newStock);;
		assertEquals(newStock, item.getItemStock());
	}
	
	// TESTING EQUALS METHOD
//	@Test
//	public void testEquals()
//	{
//		EqualsVerifier.simple().forClass(Item.class).verify();
//	}
}
