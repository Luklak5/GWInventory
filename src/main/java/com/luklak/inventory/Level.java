package com.luklak.inventory;

public class Level {
	private int min;
	private int max;
	
	public int getMin()
	{
		return min;
	}
	
	public int getMax()
	{
		return max;
	}
	
	public String toString()
	{
		return "Min: " + min + ", Max: " + max + "\n";
	}
}

