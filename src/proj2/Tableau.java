/**
* File:    Tableau.java
* Project: 2
* Author:  Dave Van
* Date:    10/10/10
* Section: 07
* E-mail:  dvan3@umbc.edu
* Got help from help center and brother.
* 
* Class Invariant: The tableau has rows and columns.
*                  The columns and rows must equal each other
*/
package proj2;

public class Tableau {
	
	//initialize instance variables
	private int gRow, gCol;
	Card[][] tableau; 
	
	/**
	* Name: Tableau
	* Description: creates a 5 by 5 board
	* PreCondition: no rows or columns
	* PostCondition: creates a tableau 5 by 5
	*/
	public Tableau(int rows, int cols)
	{
		gRow = rows;
		gCol = cols;
		
		//makes a new 5 x 5 tableau
		tableau = new Card[gRow][gCol];
		
		for(int i = 0; i < gRow; i++)
		{
			for(int j = 0; j < gCol; j++)
			{
				tableau[i][j] = new Card();
			}
		}
	}
	
	/**
	* Name: addCard
	* Description: add cards to the tableau if there is no card in the space
	* PreCondition: there must be a space on the tableau
	* PostCondition: adds the card onto the tableau
	*/
	public void addCard(Deck deck)
	{
		//for every spot that is empty, deal a card onto the tableau
		for(int i = 0; i < gRow; i++){
			for(int j = 0; j < gCol; j++){
				if(tableau[i][j].cardString() == "None" && deck.cardsRemain() > 0)
				{
					tableau[i][j] = deck.dealCard();
				}
			}
		}
	}
	
	/**
	* Name: removeCard
	* Description: removes the card at the specific coordinate
	* PreCondition: none
	* PostCondition: returns the row and column of the card and sets it to null
	*/
	public void removeCard(int row, int column)
	{
		//gets the cards from the tableau
		tableau[row][column] = new Card();
	}
	
	/**
	* Name: getCoord
	* Description: gets the coordinates of the card
	* PreCondition: none
	* PostCondition: returns the coordinates of the card
	*/
	public Card getCoord(int row, int column)
	{
		//gets the coordinates
		return tableau[row][column];
	}
	
	/**
	* Name: consolidate
	* Description: if there is a empty space on the tableau, move all of the cards to the left and up one
	*              until the tableau is full with 25 cards 
	* PreCondition: there must be empty spaces on the tableau
	* PostCondition: fills the tableau by move cards left and up and adding new cards
	*/
	public void consolidate()
	{
		//runs through all of the rows and columns of the tableau
		for(int i = 0; i < gRow; i++)
		{
			for(int j = 0; j < gCol; j++)
			{
				//a temp card variable
				Card temp = new Card();
				
				//if space has no card. move next card to it.
				if(tableau[i][j].cardString() == "None")
				{
					//finds the next card and moves it to the empty space
					int moveCard = (i * gRow) + j;
					
					//keep doing it until all the spaces are full
					while( (moveCard < (gRow * gCol)) && (tableau[moveCard / gRow][moveCard % gCol].cardString() == "None"))
					{	
						moveCard++;
					}
					
					if(moveCard < (gRow * gCol))
					{
						//keeps the empty card in the temp variable
						temp = tableau[moveCard / gRow][moveCard % gCol];
						
						//swap out the empty card
						tableau[i][j] = temp;
						
						//move the next card into the empty card's space
						tableau[moveCard / gRow][moveCard % gCol] = new Card();
					}
				}
			}
		}
	}
	
	//*************************UNIT TESTING************************
	//
	//
	//*************************************************************
	 public static void main(String[] args)
	{
		System.out.println("CREATING A TABLEAU");
		Tableau tableau = new Tableau(5, 5);//making a tableau
		System.out.println("IF THIS PRINTS THEN NO ERRORS");
		
		System.out.println("\nCREATING A DECK");
		Deck deck = new Deck();//making a deck
		System.out.println("IF THIS PRINTS THEN NO ERRORS");
		
		System.out.println("\nSHUFFLING AND ADDING CARDS TO TABLEAU\n");
		deck.shuffle(12345);//shuffling deck
		tableau.addCard(deck);//adding cards to the tableau
		
		System.out.println("FINDING FIRST CARD OF TABLEAU");
		System.out.println(tableau.getCoord(0, 0));//coordinates of the 1st card
		System.out.println("\nFINDING SECOND CARD OF TABLEAU");
		System.out.println(tableau.getCoord(0, 1));//coordinates of 2nd card
		
		System.out.println("\nREMOVIING CARDS TO TABLEAU");
		System.out.println(tableau.getCoord(2, 2));//card being removed
		tableau.removeCard(2, 2);//removing a card from the deck
		
		System.out.println("\nCONSOLIDATING");
		tableau.consolidate();//consolidating the deck
		System.out.println("IF THIS PRINTS THEN NO ERRORS");
	}
}
	
