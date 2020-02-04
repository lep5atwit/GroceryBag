package edu.wit.dcsn.comp2000.bagapp;

import java.util.ArrayList;
import java.util.Scanner;

import edu.wit.dcsn.comp2000.bagadt.ResizableArrayBag;

public class GroceryBagger {

	public static void main(String args[])
	{
		
		// Creates items from groceries.txt
		Scanner sc = new Scanner( System.in ) ; //replace with groceries.txt
		ArrayList<GroceryItem> groceries = new ArrayList<GroceryItem>() ;
		while( sc.hasNext() )
			{
			groceries.add( new GroceryItem ( sc.nextLine().split( "\t" ) ) ) ;
			
			}		
		//Take GroceryItems and sorts them into bags
		//All nonbreakables in one bag. remove from groceries
		// parse the items into new bags
		while( !groceries.isEmpty() )
			{
			
			
			}	
		
		
		
	}
}
