package com.luklak.inventory;

public class AchiSet {
	private Achievement pve[];
	private Achievement pvp[];
	private Achievement wvw[];
	private Achievement fractals[];
	private Achievement special[];
	
	public Achievement getPve(int i)
	{
		return pve[i];
	}
	
	public Achievement getPvp(int i)
	{
		return pvp[i];
	}
	
	public Achievement getWvw(int i)
	{
		return wvw[i];
	}
	
	public Achievement getFractals(int i)
	{
		return fractals[i];
	}
	
	public Achievement getSpecial(int i)
	{
		return special[i];
	}
	
	public int getPveLength()
	{
		return pve.length;
	}
	
	public int getPvpLength()
	{
		return pvp.length;
	}
	
	public int getWvwLength()
	{
		return wvw.length;
	}
	
	public int getFractalsLength()
	{
		return fractals.length;
	}
	
	public int getSpecialLength()
	{
		return special.length;
	}
	
	public String toString()
	{
		String achi = "pve: \n";
		for(int i = 0;i<pve.length;i++)
		{
			achi = achi + pve[i].toString();
		}
		achi = achi + " pvp: \n";
		for(int i = 0;i<pvp.length;i++)
		{
			achi = achi + pvp[i].toString();
		}
		achi = achi + " wvw: \n";
		for(int i = 0;i<wvw.length;i++)
		{
			achi = achi + wvw[i].toString();
		}
		achi = achi + " fractals: \n";
		for(int i = 0;i<fractals.length;i++)
		{
			achi = achi + fractals[i].toString();
		}
		achi = achi + " special: \n";
		for(int i = 0;i<special.length;i++)
		{
			achi = achi + special[i].toString();
		}
		return achi;
	}
}
