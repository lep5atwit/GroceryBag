package edu.wit.dcsn.comp2000.bagapp;

import java.util.ArrayList;
import java.util.Scanner;

import edu.wit.dcsn.comp2000.bagadt.ResizableArrayBag;

public class GroceryBagger {

	public static void main(String args[]) {
		
		// Creates items from groceries.txt
		Scanner sc = new Scanner(System.in); //replace with groceries.txt
		ArrayList<String> items = new ArrayList<String>();
		while(sc.hasNext()==true) {
			items.add(sc.nextLine());
		}
		
		// Creates GroceryItems from the items
		ArrayList<GroceryItem> groceries= new ArrayList<GroceryItem>();
		for(int i =0; i< items.size(); i++) {
			groceries.add(new GroceryItem(items.get(i))); 
		}	
	
		// Creates a bag 
		ResizableArrayBag<GroceryItem> bag = new ResizableArrayBag<GroceryItem>();
		
		//Take GroceryItems and sorts them into bags
		//All nonbreakables in one bag. remove from groceries
		// parse the items into new bags
		GroceryBag bag = new GroceryBag();
		
	}
}
