package com.tom.VendingMachine;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    	
    	// display greeting
        System.out.println( "Hello! Welcome to the store!" );
        
        try {
        	// prompt user: ask for 'customer or owner' status
            System.out.println("Are you a customer or the owner?[customer, owner]");
            
            // read user input
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String prompt1 = br.readLine();
	        
			// prompt user
            System.out.println("Which capsule vending machine to use?[mini figurine, sticker]");
			
			// read user input
            BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
			String prompt2 = br.readLine();
			
			VendingMachine vendingMachine = null;
			
			// The user interacts with the machine. 
			if (new String("sticker").contains(prompt2.toLowerCase())) {
				vendingMachine = (VendingMachine) context.getBean("sticker vending machine");
	        } else if (new String("mini figurine").contains(prompt2.toLowerCase())) {
	        	vendingMachine = (VendingMachine) context.getBean("figurine vending machine");
	        } else {
	        	throw new Exception("unsupported vending machine");
	        }
			
			// The user interacts with the machine. 
			if (new String("owner").contains(prompt1.toLowerCase())) {
	        	Person person = new Owner();
	        	person.interact(vendingMachine);
	        } else if (new String("customer").contains(prompt1.toLowerCase())) {
	        	Person person = new Customer();
	        	person.interact(vendingMachine);
	        } else {
	        	throw new Exception("unknown person category");
	        }
	        
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
    }
}
