package com.qa.ims.persistence.domain;

public class Item
{
	private Long id;
	private String itemName;
	private double itemCost;
	private Long itemStock;
	
	public Item (String itemName, Long itemStock, double itemCost)
	{
		this.itemName = itemName;
		this.itemStock = itemStock;
		this.itemCost = itemCost;
	}
	
	public Item (Long id, String itemName, Long itemStock, double itemCost)
	{
		this.id = id;
		this.itemName = itemName;
		this.itemStock = itemStock;
		this.itemCost = itemCost;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getItemCost() {
		return itemCost;
	}

	public void setItemCost(double itemCost) {
		this.itemCost = itemCost;
	}

	public Long getItemStock() {
		return itemStock;
	}

	public void setItemStock(Long itemStock) {
		this.itemStock = itemStock;
	}
	
	@Override
	public String toString() 
	{
		return "ID: " + id + ", Item Name: " + itemName + ", Cost: " + itemCost + ", Stock: " + itemStock;
	}
	
	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;	
		if (itemCost != other.itemCost)
			return false;
		if (itemStock != other.itemStock)
			return false;
		return true;
	}
	
}
