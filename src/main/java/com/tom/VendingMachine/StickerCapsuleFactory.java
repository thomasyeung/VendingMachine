package com.tom.VendingMachine;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class StickerCapsuleFactory implements CapsuleFactory, ApplicationContextAware {

	private ApplicationContext context;
	
	public Object makeRandom() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "purple capsule");
		map.put(2, "orange capsule");
		map.put(3, "yellow capsule");
		
		int i = (int) (Math.random() * 3 + 1);
		return context.getBean(map.get(i));
	}

	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		context=arg0;
	}

}
