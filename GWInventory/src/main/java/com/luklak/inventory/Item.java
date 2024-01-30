package com.luklak.inventory;

public class Item {
	private int id;
	private String name;
	private String icon;
	private String description;
	private String[] flags;
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getIcon() {
		return icon;
	}
	public String getDescription() {
		return description;
	}
	
	public String[] getFlags() {
		return flags;
	}
	
	public boolean isAccountBound() {
		for(int i = 0;i<flags.length;i++)
		{
			if(flags[i].equals("AccountBound"))
			{
				return true;
			}
		}
		return false;
	}
	
	public boolean isSoulbound() {
		for(int i = 0;i<flags.length;i++)
		{
			if(flags[i].equals("SoulbindOnAcquire"))
			{
				return true;
			}
		}
		return false;
	}
}
