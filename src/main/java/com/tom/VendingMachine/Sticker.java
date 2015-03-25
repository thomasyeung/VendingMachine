package com.tom.VendingMachine;

public class Sticker implements Describable {

	private int stickerId;
	private String name;
	
	public void setName (String name) {
		this.name = name;
	}
	
	public String getName () {
		return this.name;
	}
	
	public void setStickerId (int id) {
		stickerId = id;
	}
	
	public int getStickerId () {
		return this.stickerId;
	}
	
	public String getDescription() {
		return name + " sticker";
	}
}
