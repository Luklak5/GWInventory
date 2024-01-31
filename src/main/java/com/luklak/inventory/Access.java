package com.luklak.inventory;

public class Access {
	private String product;
	private String condition;
	
	public Access(String p, String c)
	{
		product = p;
		condition = c;
	}
	
	public String getProduct()
	{
		if(product != null)
		{
			return product;
		}
		else
		{
			return null;
		}
	}
	
	public String getCondition()
	{
		if(condition != null)
		{
			return condition;
		}
		else
		{
			return null;
		}
	}
	
	public String toString()
	{
		return "Product: " + product + ", Condition: " + condition + "\n";
	}
}
