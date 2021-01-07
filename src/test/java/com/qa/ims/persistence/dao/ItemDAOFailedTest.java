package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.DBUtils;

public class ItemDAOFailedTest {

	private final ItemDAO DAO = new ItemDAO();

	@Before
	public void setup() 
	{
		DBUtils.connect("root", "password");
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}
	
	@Test
	public void testCreate()
	{
		final Item created = new Item(6L, "Wrist Band", 2.99, 67L);
		assertEquals(null, DAO.create(created));
	}
	
	@Test
	public void testReadAll()
	{
		List<Item> testItems = new ArrayList<>();
		assertEquals(testItems, DAO.readAll());
		
	}
	
	@Test
	public void testUpdate()
	{
		final Item testUpdate = new Item(1L, "Key Chain Pack", 10.99, 100L);
		assertEquals(null, DAO.update(testUpdate));
	}
	
	@Test
	public void testDelete()
	{
		assertEquals(0, DAO.delete(1));
	}
	
	@Test
	public void testReadLatest() {
		assertEquals(null, DAO.readLatest());
	}

	@Test
	public void testRead() {
		assertEquals(null, DAO.readItem(1L));
	}
}