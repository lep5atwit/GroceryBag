package edu.wit.dcsn.comp2000.bagapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import edu.wit.dcsn.comp2000.bagadt.ResizableArrayBag;

public class GroceryBagger {

	public static void main( String args[] ) throws FileNotFoundException 
		{
		// Creates items from groceries.txt
		Scanner sc 							= new Scanner( new File( "./data/groceries.txt" ) ) ; 
		ArrayList<GroceryItem> groceries 	= new ArrayList<GroceryItem>() ;
		
		while ( sc.hasNext() )
			{
			groceries.add( new GroceryItem( sc.nextLine().split( "\t" ) ) ) ;

			}
		sc.close() ;
		//sorts bags
		ArrayList<ResizableArrayBag<GroceryItem>> bagArray 	= new ArrayList<>() ;
		bagArray 											= bagGroceries( groceries, bagArray ) ;
		
		ResizableArrayBag<GroceryItem> currentBag ;
		GroceryItem item ;
		String breakable ;
		String weight ;
		String firmness ;
		//prints bags
			
		for( int bagInArr = 0 ; bagInArr < bagArray.size() ; bagInArr++ ) //traverse array of bags
			{
			System.out.printf( "Bag %d:%n", bagInArr + 1 ) ;
			currentBag = bagArray.get( bagInArr ) ;
			
			for( int itemIndex = 0 ; itemIndex < currentBag.getCurrentSize() ; ) //traverse the contents of each bag 
				{ 
				item = currentBag.remove() ;
				
				if( item.getBreakable() )
					{
					breakable = "breakable" ;
					
					}
				else
					{
					breakable = "nonbreakable" ;
					
					}


				if( item.getWeight() == 1 )
					{
					weight = "light" ;
					
					} 
				else 
					{
					if( item.getWeight() == 2 ) 
						{
						weight = "medium" ;
						
						}
					else 
						{
						weight = "heavy" ;
						
						}
					
					}

				if( item.getFirmness() == 1 )
					{
					firmness = "soft" ;
					
					}
				else 
					{
					if( item.getFirmness() == 2 ) 
						{
						firmness = "firm" ;
						
						}
					else 
						{
						firmness = "hard" ;
						
						}
					
					}
				System.out.printf( "	%s(%s):	%s,	%s,	%s%n",
								   item.getItemName(),
								   item.getSize(),
								   breakable,
								   weight,
								   firmness ) ;
				}
			
			}
		
		}

	/** 
	 * Method to sort a GroceryItem array-list into Bags
	 * @param groceries
	 * @param bagArray
	 * @return bagArray array of sorted bags
	 */
	public static ArrayList<ResizableArrayBag<GroceryItem>> bagGroceries( ArrayList<GroceryItem> groceries,
																		  ArrayList<ResizableArrayBag<GroceryItem>> bagArray ) 
		{
		ResizableArrayBag<GroceryItem> bag = new ResizableArrayBag<GroceryItem>() ;
		String s 					= "item large heavy hard rigid unbreakable unperishable" ;
		String[] sArr 				= s.split( " " ) ;
		GroceryItem previousItem 	= new GroceryItem(sArr); // TODO: Initialize to an unbreakable at the lowest tier
		int size					= 0 ; 
		// Traverse the groceries, placing them into bags
		for (int i = 0; i < groceries.size(); i++) {
			
			if (previousItem.compareTo(groceries.get(i)) != 1) {
				
				// Placing a item into a full bag...
				if (size+groceries.get(i).getSize()>25) {  //Add current size to grocery size > 25n
					bagArray.add(bag);
					bag= new ResizableArrayBag<GroceryItem>();
					size =0;
					bag.add(groceries.get(i));
					size= groceries.get(i).getSize()+size; 
				}
				
				// Placing a item into a bag...
				if (size+groceries.get(i).getSize()<=25) {
					bag.add(groceries.get(i)); // add the groceryItem into the bag
					size=size+groceries.get(i).getSize(); //		
				}
				
			} 
			
			else { //Unable to place the item in this bag 
				bagArray.add(bag); // Get a new bag for it
				bag=new ResizableArrayBag<GroceryItem>();
				size=0;
				bag.add(groceries.get(i));
				size=size+ groceries.get(i).getSize();

			}

		}

		return bagArray;

	}

}
