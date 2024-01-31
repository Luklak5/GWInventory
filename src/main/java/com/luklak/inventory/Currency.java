package com.luklak.inventory;

public class Currency {
	private int id;
	private String name;
	private String description;
	private String icon;
	private int order;
	
	public String getName()
	{
		return name;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public String getIcon()
	{
		return icon;
	}
	
	public String toString()
	{
		return "Id: " + id + " Name: " + name + " Description: " + description + " Icon: " + icon + " Order: " + order;
	}
	
	public String toStringNoURL()
	{
		return "Id: " + id + " Name: " + name + " Description: " + description + " Order: " + order;
	}
}
