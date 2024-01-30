package com.luklak.inventory;

public class Bank {
	private int id;
	private int count;
	private int charges;
	private int skin;
	private int dyes[];
	private int upgrades[];
	private int upgrade_slot_indices[];
	private int infusions[];
	private String binding;
	private String bound_to;
	private Stats stats;
	public int getId() {
		return id;
	}
	public int getCount() {
		return count;
	}
	public int getCharges() {
		return charges;
	}
	public int getSkin() {
		return skin;
	}
	public int[] getDyes() {
		return dyes;
	}
	public int[] getUpgrades() {
		return upgrades;
	}
	public int[] getUpgrade_slot_indices() {
		return upgrade_slot_indices;
	}
	public int[] getInfusions() {
		return infusions;
	}
	public String getBinding() {
		return binding;
	}
	public String getBound_to() {
		return bound_to;
	}
	public Stats getStats() {
		return stats;
	}
}
 