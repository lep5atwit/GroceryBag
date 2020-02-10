
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
		String[] stringArr				   = "item large heavy hard rigid unbreakable unperishable".split( " " ) ;
		GroceryItem previousItem 		   = new GroceryItem( stringArr ) ; // TODO: Initialize to an unbreakable at the lowest tier
		int bagCapacity					   = 0 ; 
		// Traverse the groceries, placing them into bags
		for ( int index = 0 ; index < groceries.size() ; index++ ) 
			{
			GroceryItem item = groceries.get( index ) ;
			if ( previousItem.compareTo( item ) != 1 ) 
				{
				// Placing a item into a full bag...
				if ( bagCapacity + item.getSize() > 25 )
					{ 
					bagArray.add( bag ) ;
					bag  = new ResizableArrayBag<GroceryItem>() ;
					bagCapacity = 0 ;
					bag.add(item ) ;
					bagCapacity = item.getSize() + bagCapacity ; 
					
					}
				// Placing a item into a bag...
				else 
					{
					if ( bagCapacity + item.getSize() <= 25 ) 
						{
						bag.add( item ) ; 
						bagCapacity = bagCapacity + item.getSize() ;	
					
						}
					
					}
				
				} 
			//Unable to place the item in this bag 
			else
				{ 
				bagArray.add( bag ) ; 
				bag  = new ResizableArrayBag<GroceryItem>() ;
				bagCapacity = 0 ;
				bag.add( item ) ;
				bagCapacity = bagCapacity + item.getSize() ;

				}
			
			//Places the last bag into bagArray
			if( index == groceries.size() - 1 && !bag.isEmpty() )
				{
				bagArray.add( bag ) ;
				
				}

			}
		return bagArray;

	}

}
