
package edu.wit.dcsn.comp2000.bagapp;

public class GroceryItem implements Comparable<GroceryItem> {
	final private String itemName;
	final private int weight;
	final private int firmness;
	final private boolean breakable; // true if breakable, else false
	final private int size; // light - ex large, 1 - 4

	public GroceryItem() {
		this.itemName = "Default Item";
		this.weight = 1;
		this.firmness = 1;
		this.breakable = true;
		this.size = 1;

	} //end default constructor

	public GroceryItem(String[] item) {
		this.itemName = item[0];
		String itemSize = item[1];
		String itemWeight = item[2];
		String itemFirmness = item[3];
		String itemBreakability = item[5];

		if (itemSize.equals("small")) {
			this.size = 1;

		} else {
			if (itemSize.equals("medium")) {
				this.size = 2;

			} else {
				if (itemSize.equals("large")) {
					this.size = 3;

				} else {
					this.size = 4;

				}
			}
		}

		if (itemWeight.equals("light")) {
			this.weight = 1;

		} else {
			if (itemWeight.equals("medium")) {
				this.weight = 2;

			} else {
				this.weight = 3;

			}

		}

		if (itemFirmness.equals("soft")) {
			this.firmness = 1;

		} else {
			if (itemFirmness.equals("firm")) {
				this.firmness = 2;

			} else {
				this.firmness = 3;

			}

		}

		if (itemBreakability.equals("breakable")) {
			this.breakable = true;

		} else {
			this.breakable = false;

		}
	} //end array cloning constructor

	@Override
	/**
	 * 
	 */
	public int compareTo(GroceryItem otherItem) {
		if (this.breakable && otherItem.getBreakable()) {
			if (this.weight == otherItem.getWeight()) {
				if (this.firmness == otherItem.getFirmness()) {
					return 0;

				} else if (this.firmness < otherItem.getFirmness()) {
					return -1;

				}
				return 1;

			} else if (this.weight < otherItem.getWeight()) {
				return -1;

			}
			return 1;

		} else if (this.breakable && !otherItem.getBreakable()) {
			return -1;

		} else if (!this.breakable && otherItem.getBreakable()) {
			return 1;

		}
		// When both items are not breakable
		return 0;

	} //end compareTo() 
	
	/**
	 * ToString() return a string of the item and its attributes
	 */
	public String toString() {
		String[] sArr = this.toArray();
		return String.format("   %s(%s):	%s	%s	%s", sArr[0], sArr[1], sArr[2], sArr[3], sArr[4]);
		
	} //end toString()
	
	/**
	 * Creates a toArray() with each attribute in String form: ItemName | Size | Breakable | Weight | Firmness
	 * @return result the resulting array of Strings
	 */
	public String[] toArray() {
		String[] result = new String[5] ; 
		result[0] = this.getItemName() ;
		result[1] = Integer.toString(this.getSize()) ;
		
		//Breakable attribute
		if( this.getBreakable() )
			{
			result[2] = "	breakable" ;
			
			}
		else
			{
			result[2] = "	nonbreakable" ;
			
			}

		//Weight Attribute
		if( this.getWeight() == 1 )
			{
			result[3] = "	light" ;
			
			} 
		else if( this.getWeight() == 2 ) 
			{
			result[3] = "	medium" ;
			
			}
		else 
			{
			result[3] = "	heavy" ;
			
			}
			
		//Firmness Attribute
		if( this.getFirmness() == 1 )
			{
			result[4] = "	soft" ;
			
			}
		else if( this.getFirmness() == 2 ) 
			{
			result[4] = "	firm" ;
			
			}
		else 
			{
			result[4] = "	hard" ;
			
			}
		
		return result;

	} //end toArray()

	public int getWeight() {
		return this.weight;

	} //end getWeight

	public int getFirmness() {
		return this.firmness;

	} //end getFirmness()

	public boolean getBreakable() {
		return this.breakable;

	} //end getBreakable

	public int getSize() {
		return this.size;

	} //end getSize()

	public String getItemName() {
		return this.itemName;

	} //end getItemName()
}
