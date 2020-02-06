package edu.wit.dcsn.comp2000.bagapp;

public class GroceryItem implements Comparable<GroceryItem>
	{
	final private String itemName ;
	final private int weight ; 
	final private int firmness ; 
	final private boolean breakable ; //true if breakable, else false
	final private int size ; // light - ex large, 1 - 4
	
	public GroceryItem() 
		{
		
		this.itemName =   "Default Item" ;
		this.weight =	  1 ;
		this.firmness =   1 ;
		this.breakable =  true ;
		this.size = 	  1 ;
		
		}
	
	public GroceryItem( String[] item )
		{
		this.itemName 			= item[ 0 ] ;
		String itemSize 		= item[ 1 ] ;
		String itemWeight		= item[ 2 ] ;
		String itemFirmness		= item[ 3 ] ;
		String itemBreakability = item[ 5 ] ;
		
		if( itemSize.equals( "small" ) )
			{
			this.size = 1 ;
			
			}
		else
			{
			if( itemSize.equals( "medium" ) )
				{
				this.size = 2 ;
				
				}
			else
				{
				if( itemSize.equals( "large" ) )
					{
					this.size = 3 ;
					
					}
				else
					{
					this.size = 4 ;
					
					}
				
				}
			
			}		
		if( itemWeight.equals( "light" ) )
			{
			this.weight = 1 ;
			
			}
		else
			{
			if( itemWeight.equals( "medium" ) )
				{
					this.weight = 2 ;
					
				}
			else
				{
				this.weight = 3 ;
					
				}
					
			}
		
			if( itemFirmness.equals( "light" ) )
			{
			this.firmness = 1 ;
			
			}
			
		else
			{
			if( itemFirmness.equals( "medium" ) )
				{
				this.firmness = 2 ;
					
				}
			
			else
				{
				this.firmness = 3 ;
					
				}
			
			}
			if( itemBreakability.equals( "breakable" ) ) 
				{
				this.breakable = true ;
				
				}
			else
				{
				this.breakable = false ;
				
				}		
			
			}
	
	@Override
	/**
	 * Compares two items to determine if one can be put in a bag
	 * @return -1 yes, 0 program specific, 1 no
	 */
	public int compareTo( GroceryItem otherItem )
		{
		if( this.breakable && otherItem.getBreakable() )
			{
			if( this.weight == otherItem.getWeight() )
				{
				if( this.firmness == otherItem.getFirmness() )
					{
					return 0 ;
					
					}
				else if( this.firmness < otherItem.getFirmness() )
					{
					return -1 ;
					
					}
				return 1 ;
								
				}
			else if( this.weight < otherItem.getWeight() )
				{
				return -1 ;
				
				}
			return 1 ;
			
			}
		else if( this.breakable && !otherItem.getBreakable() )
			{
			return -1 ;
		
			}
		else if( !this.breakable && otherItem.getBreakable() )
			{
			return 1 ;
			
			}
		//When both items are not breakable
		return 0 ;
			
		}

	public int getWeight() 
		{
		return this.weight ;
		
		}
	
	public int getFirmness() 
		{
		return this.firmness ;
	
		}
	
	public boolean getBreakable() 
		{
		return this.breakable ;
	
		}
	
	public int getSize()
		{
		return this.size ;
		
		}
	
	public String getItemName()
		{
		return this.itemName ;

		}
	
	}