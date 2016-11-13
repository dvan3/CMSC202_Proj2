/**
* File:    Deck.java
* Project: 2
* Author:  Dave Van
* Date:    10/7/10
* Section: 07
* E-mail:  dvan3@umbc.edu
* Class Invariant: The deck has cards and has how many cards used.
*                  There must never be more than 52 cards in the deck.
*/
package proj2;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
	
	//Constants
	private static final int WHOLEDECK = 52, SHUFFLEDECK = 51, SUIT = 3, RANK = 12;
							 
	
	//initialize instance variables
	private ArrayList<Card> deck = new ArrayList<Card>();
	private int cardsUsed = 0;
	
	/**
	* Name: Deck
	* Description: Creates a deck of cards
	* PreCondition: there are no cards in the deck
	* PostCondition: adds 52 cards to the deck
	*/
	public Deck()
	{
		//set the array with the values
		Rank rankArray[] = Rank.VALUES();
		Suit suitArray[] = Suit.VALUES();
		
		//add cards to the deck up to 52
		for(int suit = 0; suit <= SUIT; suit++)
		{
			for(int rank = 0; rank <= RANK; rank++)
			{
				deck.add(new Card(suitArray[suit], rankArray[rank]));
			}
		}
	}
	
	/**
	* Name: shuffle
	* Description: shuffles the deck of cards
	* PreCondition: the deck isn't shuffled and is still in order
	* PostCondition: shuffles the deck
	*/
	public void shuffle(long gameNR)
	{
		//set the seed of the shuffle
		long randomSeed = gameNR;
		
		//making a random object
		Random gen = new Random(randomSeed);
		
		//initialize variable
		int N = SHUFFLEDECK;
		
		//shuffling the deck
	    while (N > 0)
	    {
	    	int k = gen.nextInt(N + 1);
	    	Card card = deck.get(k);
	    	deck.set(k, deck.get(N));
	    	deck.set(N, card);
	    	N--;
	    }
	}
	
	/**
	* Name: cardsRemain
	* Description: gets the remaining cards in the deck
	* PreCondition: none
	* PostCondition: returns the number of cards used
	*/
	public int cardsRemain()
	{
		//returns the remaining cards in the deck
		return WHOLEDECK - cardsUsed;
	}
	
	/**
	* Name: dealCard
	* Description: deals a card from the deck
	* PreCondition: none
	* PostCondition: removes a card from the deck
	*/
	public Card dealCard()
	{
		//add 1 to the counter
		cardsUsed++;
		
		//removes a card from the deck
		return deck.remove(0);
	}

	/**
	* Name: toString
	* Description: returns a string of words with the rank and suit
	* PreCondition: none
	* PostCondition: returns a string of words with the rank and suit
	*/
	public String toString()
	{
		//initialize variable
		String card2 = "";
		
		//get every card of the deck and put them in a string
		for(Card card: deck)
		{
			card2 += card.toString();
		}
		
		//from the string add how many cards have been used also
		card2 += "Cards used: " + cardsUsed;
		
		//return the string
		return card2;
	}
	
	//*************************UNIT TESTING************************
	//
	//
	//*************************************************************
	public static void main(String[] args)
	{
		System.out.println("CREATING DECK\n");
		Deck deck = new Deck();//create a deck
		
		System.out.println("PRINTING ALL CARDS");
		System.out.println(deck.toString());//print each card out
		
		System.out.println("\nSHUFFLING DECK\n");
		deck.shuffle(12345);//shuffle the cards
		
		System.out.println("CARDS REMAINING: " + deck.cardsRemain() + "\n");//how many cards remain
		
		System.out.println("DEALING A CARD\n");
		deck.dealCard();//deal a card
		
		System.out.println("PRINTING ALL CARDS");
		System.out.println(deck.toString());//print each card out
		
		System.out.println("\nCARDS REMAINING: " + deck.cardsRemain());//how many cards remain
		
		System.out.println("\nDEALING A CARD\n");
		deck.dealCard();//deal another card
		
		System.out.println("PRINTING ALL CARDS");
		System.out.println(deck.toString());//print each card out
		
		System.out.println("\nCARDS REMAINING: " + deck.cardsRemain());//how many cards remain
	}

}
