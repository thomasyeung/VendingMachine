package com.tom.VendingMachine;

public class MiniFigurineCapsule extends ColoredToyCapsule {
	private MiniFigurine figurine;
	
	public void setFigurine(MiniFigurine figurine) {
		this.figurine = figurine;
	}
	
	public MiniFigurine getFigurine() {
		return figurine;
	}

	@Override
	public Describable open() {
		return figurine;
	}
}
