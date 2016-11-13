/**
* File:    Card.java
* Project: 2
* Author:  Dave Van
* Date:    10/7/10
* Section: 07
* E-mail:  dvan3@umbc.edu
* Class Invariant: Every card must have a suit and a rank.
*                  A card that is face up has a status of Card or never null
*                  If the card is face down the status is null
*/
package proj2;

public class Card 
{
	//initialize instance variables
	private Suit cardSuit;
	private Rank cardRank;
	private String cardStatus = "";
	
	/**
	* Name: Card
	* Description: creates a card with a suit and rank
	* PreCondition: the card doesn't have a suit or rank or state
	* PostCondition: makes the card with a suit, rank and state
	*/
	public Card(Suit suit, Rank rank)
	{
		this.cardSuit = suit;
		this.cardRank = rank;
		cardStatus = "Card";
	}
	
	/**
	* Name: Card
	* Description: sets the state of the card to nothing
	* PreCondition: card doesn't have a state
	* PostCondition: state of the card is None
	*/
	public Card()
	{
		cardStatus = "None";
	}
	
	/**
	* Name: getSuit
	* Description: gets the suit of the card
	* PreCondition: none
	* PostCondition: returns the suit of the card
	*/
	public Suit getSuit()
	{
		//returns the card's suit
		return cardSuit;
	}
	
	/**
	* Name: getRank
	* Description: gets the rank of the card
	* PreCondition: none
	* PostCondition: returns the rank of the card
	*/
	public Rank getRank()
	{
		//returns the card's rank
		return cardRank;
	}
	
	/**
	* Name: cardString
	* Description: returns the status of the card whether it has something or not
	* PreCondition: none
	* PostCondition: returns the status of the card
	*/
	public String cardString()
	{
		//returns the card's status
		return cardStatus;
	}
	
	/**
	* Name: toString
	* Description: returns a string of words with the suit and rank of the card
	* PreCondition: none
	* PostCondition: returns a string of words with the rank and suit
	*/
	public String toString()
	{
		//returns a string of words with the rank and suit
		return cardSuit.getName() + ":" + cardRank.getName() + " ";
	}
	
	/**
	* Name: equalsRank
	* Description: checks to see if the cards are equal
	* PreCondition: cards don't match
	* PostCondition: returns whether true if cards match or false if cards don't match
	*/
	public boolean equalsRank(Card card)
	{
		//returns true or false depending if equal
		return cardRank.equals(card.cardRank);
	}
	
	//*************************UNIT TESTING************************
	//
	//
	//*************************************************************
	public static void main(String[] args)
	{
		Card card = new Card(Suit.CLUBS, Rank.ACE);//create a card
		
		System.out.println("CARD NUMBER 1");
		card.getSuit().getName();//gets the suit
		card.getRank().getName();//gets the rank
		System.out.println(card.toString() + "\n");
		
		Card card2 = new Card(Suit.SPADES, Rank.TWO);//create a card

		System.out.println("CARD NUMBER 2");
		card2.getSuit().getName();//gets the suit
		card2.getRank().getName();//gets the rank
		System.out.println(card2.toString() + "\n");
		
		Card card3 = new Card(Suit.HEARTS, Rank.QUEEN);//create a card

		System.out.println("CARD NUMBER 3");
		card3.getSuit().getName();//gets the suit
		card3.getRank().getName();//gets the rank
		System.out.println(card3.toString() + "\n");
		
		Card card4 = new Card(Suit.DIAMONDS, Rank.KING);//create a card
		
		System.out.println("CARD NUMBER 4");
		card4.getSuit().getName();//gets the suit
		card4.getRank().getName();//gets the rank
		System.out.println(card4.toString() + "\n");
		
		Card cardNull = new Card();//create a card
		
		System.out.println("NULL CARD");
		System.out.println(cardNull.getRank());//gets the rank
		
	}
	
}
