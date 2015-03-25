package com.tom.VendingMachine;

import java.util.ArrayList;

public class Content extends ArrayList<Describable> implements Describable {

	private String description;
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return this.description;
	}

	

}
