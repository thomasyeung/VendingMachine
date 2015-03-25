package com.tom.VendingMachine;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Owner implements Person {
	private Customer customer = new Customer();
	
	public Object turnKnobOnVendingMachine(List<Describable> inventory, VendingMachine vendingMachine) {
		return customer.turnKnobOnVendingMachine(inventory, vendingMachine);
	}

	public void openCapsule(List<Describable> inventory, List<Capsule> unopenedCapsules) {
		customer.openCapsule(inventory, unopenedCapsules);
	}

	public void checkInventory(List<Describable> inventory) {
		customer.checkInventory(inventory);
	}
	
	public void refill(VendingMachine vendingMachine) {
		vendingMachine.refill();
		System.out.println("\nYou refill the vending machine.");
	}

	public void interact(VendingMachine vm) throws Exception {
		List<Describable> inventory = new ArrayList<Describable>();
		List<Capsule> unopenedCapsules = new ArrayList<Capsule>();
		
		System.out.println("You are the owner.");
		
		while (true) {
			System.out.println();
			System.out.println("What would you like to do?");
			System.out.println("1. Turn knob on vending machine");
			System.out.println("2. Open a capsule");
			System.out.println("3. Check inventory");
			System.out.println("4. Refill vending machine");
			System.out.println("5. Exit");
			
			System.out.print("Choose an option: ");
			
			// read user input
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String prompt = br.readLine();
	        
			if (prompt.contains("1")) {
				Object o = turnKnobOnVendingMachine(inventory, vm);
				if (o != null) {
					unopenedCapsules.add((Capsule) o);
				}
			} else if (prompt.contains("2")) {
				openCapsule(inventory, unopenedCapsules);
			} else if (prompt.contains("3")) {
				checkInventory(inventory);
			} else if (prompt.contains("4")) {
				refill(vm);
			} else if (prompt.contains("5")) {
				System.out.println("Good bye!");
				break;
			} 
		}
	}
}
