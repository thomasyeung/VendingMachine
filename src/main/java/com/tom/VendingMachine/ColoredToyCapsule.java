package com.tom.VendingMachine;

public abstract class ColoredToyCapsule implements Describable, Capsule {

	private int capsuleId;
	private String color;
	
	public void setCapsuleId (int id) {
		capsuleId = id;
	}
	
	public int getCapsuleId () {
		return capsuleId;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public String getColor() {
		return this.color;
	}
	
	public abstract Describable open();

	public String getDescription() {
		return getColor() + " capsule";
	}

}
