package com.luklak.inventory;

public class Achievement {
	private int id;
	private Level level;
	private Access required_access;
	
	public int getId()
	{
		return id;
	}
	
	public Level getLevel()
	{
		return level;
	}
	
	public Access getAccess()
	{	
		if(required_access!= null)
		{
			return required_access;
		}
		else
		{
			return new Access(null,null);
		}
	}
	
	public String toString()
	{
		if(required_access.getCondition() != null)
			return "Id: " + id + "\n" + level.toString() + required_access.toString();
		else
			return "Id: " + id + "\n" + level.toString();
	}
}
