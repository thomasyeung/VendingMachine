package com.tom.VendingMachine;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Customer implements Person {
	
	public Customer() { }
	
	public Object turnKnobOnVendingMachine(List<Describable> inventory, VendingMachine vendingMachine) {
		Object o = vendingMachine.turnKnob();
		if (o != null) {
			Describable d = (Describable) o;
			System.out.println("\nYou turn the knob. The machine cranks out a "
					+ d.getDescription());
			inventory.add(d);
		} else {
			System.out.println("\nYou turn the knob. The vending machine is empty!");
			System.out.println("The owner needs to refill it.");
		}
		return o;
	}

	public void openCapsule(List<Describable> inventory, List<Capsule> unopenedCapsules) {
		
		if (unopenedCapsules.isEmpty()) {
			System.out.println("\nThere are no unopened capsules");
		} else {
			Capsule capsule = unopenedCapsules.remove(0);
			Describable capsuleDesc = (Describable) capsule;
			Describable content = capsule.open();
			System.out.println("\nYou open a "+capsuleDesc.getDescription()
					+". Inside is a "+ content.getDescription());
			inventory.remove(capsuleDesc);
			if (content instanceof Content) {
				for (Describable d : (Content) content) {
					inventory.add(d);
				}
			} else {
				inventory.add(content);
			}
		}
	}

	public void checkInventory(List<Describable> inventory) {
		System.out.println("\nYour inventory:");
		for (Describable d : inventory) {
			System.out.println("  "+d.getDescription());
		}
	}

	public void interact(VendingMachine vm) throws Exception {
		List<Describable> inventory = new ArrayList<Describable>();
		List<Capsule> unopenedCapsules = new ArrayList<Capsule>();
		
		System.out.println("You are a customer.");
		
		while (true) {
			System.out.println();
			System.out.println("What would you like to do?");
			System.out.println("1. Turn knob on vending machine");
			System.out.println("2. Open a capsule");
			System.out.println("3. Check inventory");
			System.out.println("4. Exit");
			
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
				System.out.println("Good bye!");
				break;
			} 
		}
	}
}
