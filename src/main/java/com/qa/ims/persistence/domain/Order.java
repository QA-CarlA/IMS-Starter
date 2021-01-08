package com.qa.ims.persistence.domain;

import java.util.HashMap;

public class Order
{
	Long orderID;
	Long customerID;
	String dateOrdered;
	HashMap<Long, Long> itemsOrdered = new HashMap<Long, Long>();
	
	public Order (Long orderID, Long customerID, String dateOrdered)
	{
		this.orderID = orderID;
		this.customerID = customerID;
		this.dateOrdered = dateOrdered;
	}
	
	public Order (Long customerID, HashMap<Long, Long> itemsOrdered)
	{
		this.customerID = customerID;
		this.itemsOrdered = itemsOrdered;
	}
	
	// needed for testing
	public Order (Long orderID, Long customerID, HashMap<Long, Long> itemsOrdered)
	{
		this.orderID = orderID;
		this.customerID = customerID;
		this.itemsOrdered = itemsOrdered;
	}
	
	public Order(Long orderID, Long customerID, String dateOrdered, HashMap<Long, Long> itemsOrdered)
	{
		super();
		this.orderID = orderID;
		this.customerID = customerID;
		this.dateOrdered = dateOrdered;
		this.itemsOrdered = itemsOrdered;
	}
	

	public Long getOrderID() {
		return orderID;
	}

	public void setOrderID(Long orderID) {
		this.orderID = orderID;
	}

	public Long getCustomerID() {
		return customerID;
	}

	public void setCustomerID(Long customerID) {
		this.customerID = customerID;
	}

	public String getDateOrdered() {
		return dateOrdered;
	}

	public void setDateOrdered(String dateOrdered) {
		this.dateOrdered = dateOrdered;
	}
	
	
	public HashMap<Long, Long> getItemsOrdered() {
		return itemsOrdered;
	}

	public void setItemsOrdered(HashMap<Long, Long> itemsOrdered) {
		this.itemsOrdered = itemsOrdered;
	}

	@Override
	public String toString()
	{
		return "Order ID: " + orderID + ", Customer ID: " + customerID + ", Date Ordered: " + dateOrdered;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if(obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (customerID != other.customerID)
			return false;
		if (dateOrdered == null)
		{
			if (other.dateOrdered != null)
			{
				return false;
			}
		}
		else if (!dateOrdered.equals(other.dateOrdered))
		{
			return false;
		}
		if (itemsOrdered == null)
		{
			if (other.itemsOrdered != null)
			{
				return false;
			}
		}
		else if (!itemsOrdered.equals(other.itemsOrdered))
		{
			return false;
		}
		if (orderID != other.orderID)
		{
			return false;
		}
		return true;
	}
}