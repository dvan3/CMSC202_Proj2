/**
* File:    Coordinates.java
* Project: 2
* Author:  Dave Van
* Date:    10/6/10
* Section: 07
* E-mail:  dvan3@umbc.edu
* Class Invariant: The row and column are nonnegative
*                  Coordinate objects are immutable 
*/
package proj2;

public class Coordinates 
{
	//initialize instance variables
	private int row;
	private int column;
	
	/**
	* Name: Coordinates
	* Description: creates a constructor with rows and columns
	* PreCondition: none
	* PostCondition: makes rows and columns
	*/
	public Coordinates(int row, int column)
	{
		this.row = row;
		this.column = column;
		
	}
	
	/**
	* Name: getColumn
	* Description: gets the column of the card
	* PreCondition: none
	* PostCondition: returns the column
	*/
	public int getColumn()
	{
		//returns the column
		return column;
	}
	
	/**
	* Name: getRow
	* Description: gets the row of the card
	* PreCondition: none
	* PostCondition: returns the row
	*/
	public int getRow()
	{
		//returns the row
		return row;
	}
	
	//*************************UNIT TESTING************************
	//
	//
	//*************************************************************
	public static void main(String[] args)
	{
		System.out.println("CREATING COORDINATES");
		Coordinates coord = new Coordinates(5, 10);//making coordinates
		
		System.out.println("\nPRINTING ROW");
		System.out.println(coord.getRow());//printing the row
		
		System.out.println("\nPRINTING COLUMN");
		System.out.println(coord.getColumn());//printing the column
	}

}
