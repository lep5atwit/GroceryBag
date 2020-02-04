package edu.wit.dcsn.comp2000.bagapp;

public class GroceryItem 
	{
	private String weight ; 
	private String firmness ;
	private String breakable ; 
	
	public GroceryItem() 
		{
		this.weight =	 "heavy" ;
		this.firmness =  "firm" ;
		this.breakable = "unbreakable" ;
		
		}
	
	public GroceryItem( String[] item )
		{
		
		
		
		}
	
	
	
	
	
	/**
	 * Takes in a line and splits it on the tabs, extracting the characteristics we want.
	 * @param line
	 */
	public GroceryItem(String line) 
		{
		line.toLowerCase() ; 
		String[] elements = line.split( "/t" ) ;
	
		int nameIsTwoWords = 0 ;
		if( elements[ 1 ] != "large" || elements[ 1 ] != "medium" || elements[ 1 ] != "small" ) 
			{
			nameIsTwoWords = 1 ;
			
			}
		weight =    elements[ 1 ] ;
		firmness =  elements[ 2 ] ;
		breakable = elements[ 4 ] ;
		
		}
	
	public String getWeight() 
		{
		return this.weight ;
		
		}
	
	public String getFirmness() 
		{
		return this.firmness;
	
		}
	
	public String getBreakable() 
		{
		return this.breakable;
	
		}
	
	}	