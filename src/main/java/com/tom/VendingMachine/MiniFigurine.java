package com.tom.VendingMachine;

public class MiniFigurine implements Describable {

	private int figurineId;
	private String name;
	
	public void setFigurineId (int id) {
		figurineId = id;
	}
	
	public int getFigurineId () {
		return figurineId;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return getName() + " mini figurine";
	}

}
