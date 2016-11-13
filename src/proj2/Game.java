/**
* File:    Game.java
* Project: 2
* Author:  Dave Van
* Date:    10/6/10
* Section: 07
* E-mail:  dvan3@umbc.edu
* Got help from help center and brother.
* 
* Class Invariant: Every game made has rows, columns, tableau and a deck.
*
*/
package proj2;

public class Game {
	
	//Constants
	private static final int WINSCORE = 52, ADDSCORE = 2;
	
	//initialize instance variables
	private int gRows, gCols, score;
	private long nGame;
	private Tableau grid;
	private Deck deck; 
	
	/**
	* Name: Game
	* Description: creates a game with a tableau and a deck of cards
	* PreCondition: none
	* PostCondition: makes a grid, deck and initializes the rows and columns
	*/
	public Game(int rows, int cols)
	{
		//makes a tableau
		grid = new Tableau(rows, cols);
		
		//makes a deck
		deck = new Deck();
		
		gRows = rows;
		gCols = cols;
	}
	
	/**
	* Name: cardsLeft
	* Description: gets the cares that are left in the game's deck
	* PreCondition: none
	* PostCondition: returns the remaining cards in the deck
	*/
	public int cardsLeft()
	{
		//gets the remaining cards
		return deck.cardsRemain();
	}
	
	/**
	* Name: consolidate
	* Description: if there is a empty space on the tableau, move all of the cards to the left and up one
	*              until the tableau is full with 25 cards
	* PreCondition: there are spaces on the tableau that can be filled with cards
	* PostCondition: fills the tableau by move cards left and up and adding new cards
	*/
	public void consolidate()
	{
		//consolidates the cards
		grid.consolidate();

		//add cards to tableau
		grid.addCard(deck);
	}
	
	/**
	* Name: getRank
	* Description: gets the coordinates of the card and returns the rank of the card
	* PreCondition: none
	* PostCondition: returns the rank of the card on the tableau
	*/
	public Rank getRank(Coordinates coord)
	{
		int cardRow, cardCol;
		
		//get the rows and column coordinates
		cardRow = coord.getRow();
		cardCol = coord.getColumn();
		
		//gets the coordinates for the card
		Card cardRank = grid.getCoord(cardRow, cardCol);
		
		//gets the rank of the card
		Rank rank = cardRank.getRank();
		
		//returns the rank
		return rank;
	}
	
	/**
	* Name: getSuit
	* Description: gets the coordinates of the card and returns the suit of the card
	* PreCondition: none
	* PostCondition: returns the suit of the card on the tableau
	*/
	public Suit getSuit(Coordinates coord)
	{
		int cardRow, cardCol;
		
		//get the rows and column coordinates
		cardRow = coord.getRow();
		cardCol = coord.getColumn();
		
		//gets the coordinates for the card
		Card cardSuit = grid.getCoord(cardRow, cardCol);
		
		//gets the suit of the card
		Suit suit = cardSuit.getSuit();
		
		//returns the suit
		return suit;
	}
	
	/**
	* Name: help
	* Description: returns a string of words that gives the directions on how to play the game
	* PreCondition: none
	* PostCondition: returns a stirng of words that give a description of the game
	*/
	public String help()
	{
		//returns a string of words
		return "- A five by five grid of cards is deal." 
				+ "\n- Find cards that have the same value that are next to each"
				+ "\n  other horizontally, vertically or diagonally."
				+ "\n- When you have removed as many pairs of cards as you can,"
				+ "\n  click on consolidate to condense the board and add new"
				+ "\n  cards."
				+ "\n- You have to try to clear the whole board"
				+ "\n- GOOD LUCK AND HAVE FUN!!!!";
	}
	
	public Coordinates[] hint()
	{
		return null;
	}
	
	/**
	* Name: newGame
	* Description: creates a new game with a new shuffle seed, new Tableau, and a new deck
	* PreCondition: there must be a game in play already
	* PostCondition: makes a new game with a tableau, deck, and add cards onto the tableau.
	*/
	public void newGame(long gameNr)
	{
		//makes a new game with a new shuffle pattern
		nGame = gameNr;
		
		//makes a new Tableau
		grid = new Tableau(gRows, gCols);
		
		//makes a new deck
		deck = new Deck();
		
		//shuffles the cards with need seed
		deck.shuffle(nGame);
		
		//add cards to the tableau
		grid.addCard(deck);
		
		//set score to 0
		score = 0;
	}
	
	/**
	* Name: playerWins
	* Description: if the score is 52 then the player wins, if not player keeps playing the game
	* PreCondition: the score must be less that 52
	* PostCondition: if the player has a score of 52 the player wins if not, the game keeps running
	*/
	public boolean playerWins()
	{
		//if the score is 52 then player wins
		if(score() == WINSCORE)
		{
			return true;	
		}
		//if score is not 52 then player hasn't won yet.
		else
		{
			return false;
		}
	}
	
	/**
	* Name: removeCards
	* Description: if the cards match horizontally, vertically, and diagonally remove the cards
	* PreCondition: no cards are removed because cards don't match
	* PostCondition: removes the cards that match horizontally, vertically, and diagonally.
	*/
	public boolean removeCards(Coordinates card1, Coordinates card2)
	{
		//for card1
		int rowOne, colOne;
		//for card2
		int rowTwo, colTwo;
		
		//gets the row and column of card1
		rowOne = card1.getRow();
		colOne = card1.getColumn();
		
		//gets the row and column of card2
		rowTwo = card2.getRow();
		colTwo = card2.getColumn();
		
		//gets the coordinates of card 1
		Card cardOne = grid.getCoord(rowOne, colOne);
		
		//gets the coordinates of card 2
		Card cardTwo = grid.getCoord(rowTwo, colTwo);
		
		//checks if the cards are vertically, horizontally, and diagonally touching.
		if(cardOne.equalsRank(cardTwo) && ((Math.abs(rowTwo - rowOne) == 1 && Math.abs(colTwo - colOne) == 1) //Checks if diagonally touching
										|| (Math.abs(rowTwo - rowOne) == 0 && Math.abs(colTwo - colOne) == 1)  //checks if horizontally touching
										|| (Math.abs(rowTwo - rowOne) == 1 && Math.abs(colTwo - colOne) == 0))) //checks if vertically touching
		{
			//removes the 2 matching cards
			grid.removeCard(rowOne, colOne);
			grid.removeCard(rowTwo, colTwo);
			
			//adds 2 to the score. One point for each card
			score += ADDSCORE;
			
			//return true if cards matched
			return true;
		}
		else
		{
			//returns false if card doesn't match
			return false;
		}
	}
	
	/**
	* Name: replay
	* Description: replays the game with the same random seed from the current game
	* PreCondition: there must be a game in play
	* PostCondition: starts the current game over again with the same random shuffle seed
	*/
	public void replay()
	{
		//make a new game from the previous game
		newGame(nGame);
		
		//set the score to 0
		score = 0;
	}
	
	/**
	* Name: score
	* Description: gets the score of the game
	* PreCondition: none
	* PostCondition: returns the score of the game
	*/
	public int score()
	{
		//returns the score of the game
		return score;
	}
	
	/**
	* Name: toString
	* Description: sets the game deck into a string and returns it
	* PreCondition: none
	* PostCondition: returns a string of words
	*/
	public String toString()
	{
		String deckCard;
		
		deckCard = deck.toString();
		return deckCard;
	}
	
	//*************************UNIT TESTING************************
	//
	//
	//*************************************************************
	//use this method to set the score to 52 so the player can win
	private void setScore(){	
		score = WINSCORE;
	}
	public static void main(String[] args)
	{
		System.out.println("CREATING NEW GAME\n");
		Game game = new Game(5, 5);//creating new game
		
		System.out.println("PRINTING CARDS");
		System.out.println(game.toString());//printing cards
		
		System.out.println("\nSHUFFLING DECK\n");
		game.newGame(12345);//shuffling deck
		
		System.out.println("PRINTING CARDS");
		System.out.println(game.toString());//printing cards after shuffle
		
		System.out.println("\nCARDS LEFT");
		System.out.println(game.cardsLeft() + " cards left");//cards left
		
		System.out.println("\nHELP");
		System.out.println(game.help());//help
		
		System.out.println("\nTHE GAME SCORE");
		System.out.println(game.score());//game score
		
		System.out.println("\nHAS NOT WON YET TEST HERE");
		if(game.playerWins() == false){//test player didn't win
			System.out.println("You didn't win yet");
		}
		else{
			System.out.println("You win!");
		}
		
		System.out.println("\nCONSOLIDATE TEST");
		game.consolidate();//test if consolidate pass
		
		System.out.println("\nTESTING REPLAY\n");
		game.replay();//test if pass
		
		System.out.println("\nSETTING THE GAME TO WIN\n");
		game.setScore();//set score to winning
		
		System.out.println("THE GAME SCORE WIN");
		System.out.println(game.score());//game score
		
		System.out.println("\nHAS WON TEST HERE");
		if(game.playerWins() == false){//test if won
			System.out.println("You didn't win yet");
		}
		else{
			System.out.println("You win!");
		}
		
		System.out.println("\nNEW GAME TEST");
		game.newGame(14242);//new game
		
		System.out.println("\nTHE GAME SCORE");
		System.out.println(game.score());//game score
	}
}
