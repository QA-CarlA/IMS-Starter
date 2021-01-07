package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.DBUtils;

public class ItemDAOTest {

	private final ItemDAO DAO = new ItemDAO();

	@Before
	public void setup() 
	{
		DBUtils.connect("root", "root");
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}
	
	@Test
	public void testCreate()
	{
		final Item created = new Item(4L, "Wrist Band", 2.99, 67L);
		assertEquals(created, DAO.create(created));
	}
	
	@Test
	public void testReadAll()
	{
		List<Item> testItems = new ArrayList<>();
		testItems.add(new Item(1L, "Key Chain", 1.99, 100L));
		testItems.add(new Item(2L, "Clear File", 4.99, 100L));
		testItems.add(new Item(3L, "Acrylic Stand", 8.99, 100L));
		assertEquals(testItems, DAO.readAll());
		
	}
	
	@Test
	public void testUpdate()
	{
		final Item testUpdate = new Item(1L, "Key Chain Pack", 10.99, 100L);
		assertEquals(testUpdate, DAO.update(testUpdate));
	}
	
	@Test
	public void testDelete()
	{
		assertEquals(1, DAO.delete(1));
	}
}