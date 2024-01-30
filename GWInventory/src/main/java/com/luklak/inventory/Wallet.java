package com.luklak.inventory;

public class Wallet {
	private int id;
	private int value;
	
	public int getId()
	{
		return id;
	}
	
	public int getValue()
	{
		return value;
	}
	
	public String toString()
	{
		return "Id: " + id + ", Amount: " + value + " \n";
	}
}
