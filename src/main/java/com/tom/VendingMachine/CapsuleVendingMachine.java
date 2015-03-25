package com.tom.VendingMachine;

import java.util.List;

public class CapsuleVendingMachine implements VendingMachine {

	private DAO dao;
	private CapsuleFactory capsuleFactory;
	
	public void setDao(DAO dao) {
		this.dao = dao;
	}
	
	public void setCapsuleFactory(CapsuleFactory capsuleFactory) {
		this.capsuleFactory = capsuleFactory;
	}
	
	public Object turnKnob() {
		List<Object> lo = dao.getlist();
		if (lo.isEmpty())
			return null;
		
		Object o = lo.remove(0);
		dao.remove(o);
		return o;
	}

	public void refill() {
		List<Object> lo = dao.getlist();
		
		for (int i=lo.size(); i<10; i++) {
			Object o = capsuleFactory.makeRandom();
			dao.add(o);
		}
	}
}
