package com.tom.VendingMachine;

import java.util.List;

public interface DAO {
	Object add(Object t);
	void remove(Object t);
	void update(Object t);
	List<Object> getlist();
}
