package com.luklak.inventory;

public class Price {
	private int id;
	private boolean whitelisted;
	private PriceInfo buys;
	private PriceInfo sells;
	
	public int getId() {
		return id;
	}
	public boolean isWhitelisted() {
		return whitelisted;
	}
	public PriceInfo getBuys() {
		return buys;
	}
	public PriceInfo getSells() {
		return sells;
	}
	
}
