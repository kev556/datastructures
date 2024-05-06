package csc130.KevinLi.project4;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
import java.lang.Math;
/**
* <b>Title:</b> Project 4 <br>
* <b>Filename:</b> GoFish.java<br>
* <b>Date Written:</b> December 11, 2023<br>
* <b>Due Date:</b> December 16, 2023<br>
* <p>
* <b>Description:</b><br>
* Defines a GoFish object, an object representing a GoFish game 
* and its behaviors. Contains the game itself and all other objects and methods 
* necessary for a GoFish game to run.
* </p> <br>
* <p>
*</p>
*@author Kevin Li
*/
public class GoFish {
	private Deck deck = new Deck(); // Deck containing 52 unique cards
	private Player[] player = new Player[2]; // Array of Player objects representing players of the game
	
	private final Scanner scan = new Scanner(System.in); // Global scanner used for reading input;
	
	/**
	 * Constructor getting user player's name
	 */
	public GoFish() {
		getNames();
	}
	/**
	 * Starts the game
	 */
	public void playGame(){
		System.out.println("Let the game begin!");
		
		int rank;
		GoFishCard card = null;
		
		
		while (!gameEnded()){
			
			/**
			 * Computer Turn
			 */
			
			// Chooses a random rank obtained from a random card within Computer's hand.
			rank = player[0].getHand().getHand().get((int)(Math.random() * player[0].getHand().getHand().size())).getRank();
			
			System.out.println("*******************************************************************");
			// Displays Computer info, then displays a message requesting a random rank.
			System.out.println(player[0]);
			System.out.println(player[0].showHand());
			System.out.printf("%s, do you have any: %s\n", player[1].getName(), GoFishCard.RANKS[rank]);
			
			/** 
			 * If the other player has the rank specified, prints all cards of said rank,
			 * removing them from the other players hand and adding them to Computer's hand.
			 * 
			 * Immediately checks if there is a book in Computer's hand,
			 * if there is, adds a point and removes the book.
			 */
			if (player[1].getHand().hasRank(rank)) {
				
				System.out.printf("%s says: Yes!\n", player[1].getName());
				System.out.printf("%s added to %s's hand\n",player[1].findCards(rank), player[0].getName());
				player[0].addCards(player[1].getCards(rank));
				
				if (player[0].getHand().hasBook() > -1) {
					System.out.printf("Book: %s\n", player[0].findCards(rank));
					player[0].addPoints(player[0].getHand().evaluate());
				}
			}
			/**
			 *  If the other player does not have the rank specified, 
			 *  adds a card from the deck to Computer's hand and checks if there is a book.
			 *  Adds a point if there is, and removes the book.
			 */
			else {
				System.out.printf("%s says: No, Go Fish!\n", player[1].getName());
				card = (GoFishCard)deck.deal();
				rank = card.getRank();
				player[0].addCard(card);
				
				if (player[0].getHand().hasBook() > -1) {
					System.out.printf("\nBook: %s\n\n", player[0].findCards(rank));
					player[0].addPoints(player[0].getHand().evaluate());
				}
			}
			// ends the game if the deck or either player's hand is empty 
			if (gameEnded()) 
				break;
			System.out.println("*******************************************************************");
			
			/**
			 * Player Turn
			 */
			
			// Displays player information and gets a rank from the keyboard
			System.out.println(player[1]);
			System.out.println(player[1].showHand());
			rank = getRank(player[1]);
			
			/** 
			 * If the computer has the rank specified, prints all cards of said rank,
			 * removing them from the computer hand and adding them to the player's hand.
			 * 
			 * Immediately checks if there is a book in the player's hand,
			 * if there is, adds a point and removes the book.
			 */
			if (player[0].getHand().hasRank(rank)) {
							
				System.out.printf("Computer says: Yes!\n");
				System.out.printf("%s added to %s's hand\n",player[0].findCards(rank), player[1].getName());
				player[1].addCards(player[0].getCards(rank));
				
				if (player[1].getHand().hasBook() > -1) {
					System.out.printf("Book: %s\n", player[1].findCards(rank));
					player[1].addPoints(player[1].getHand().evaluate());
				}
			}
			/**
			 *  If the computer does not have the rank specified, 
			 *  adds a card from the deck to the player's hand and checks if there is a book.
			 *  Adds a point if there is, and removes the book.
			 */
			else {
				System.out.printf("%s says: No, Go Fish!\n", player[0].getName());
				card = (GoFishCard)deck.deal();
				rank = card.getRank();
				player[1].addCard(card);
				
				if (player[1].getHand().hasBook() > -1) {
					System.out.printf("Book: %s\n", player[1].findCards(rank));
					player[1].addPoints(player[1].getHand().evaluate());
				}
				
			}
			// ends the game if the deck or either player's hand is empty 
			if (gameEnded()) 
				break;
		}
		//displays winning player and closes scanner
		gameResults(player[0], player[1]);
		scan.close();
	}
	/**
	 * Obtains user players name through keyboard.
	 */
	public void getNames() {
		System.out.println("Please enter a name: ");
		String playerName = scan.nextLine();
		
		while (playerName.length() > 20) {
			System.out.printf("Please enter a name shorter than 21 characters!\n");
			playerName = scan.nextLine();
		}
		player[0] = new Player("Computer");
		player[1] = new Player(playerName);
	}
	
	/**
	 * Adds the first 14 cards of the deck to each player's hand
	 */
	public void dealCards() {
		for (int i = 0; i < 7; i++)
			player[0].addCard((GoFishCard)deck.deal());
		for (int i = 0; i < 7; i++)
			player[1].addCard((GoFishCard)deck.deal());
	}
	/**
	 * Displays each player's hand
	 */
	public void displayHands() {
		System.out.println(player[0].showHand());
		System.out.println(player[1].showHand());
	}
	/**
	 * Method for player to request a Go Fish card rank from the keyboard
	 * 
	 * @param p Player object for requesting player
	 * @return an integer representing the rank being requested
	 */
	public int getRank(Player p) {
		
		System.out.println("Computer, do you have any: ");
		
		String rankStr = scan.nextLine();
		int rank = GoFishCard.convertToRank(rankStr);
		
		while (rank == -1 || !p.getHand().hasRank(rank)) {
			if (rank == -1) {
				System.out.printf("That's not a rank! Enter a rank 2-9 J-A.\n");
				rankStr = scan.nextLine();
			}
			else if (!p.getHand().hasRank(rank)) {
				System.out.printf("Rank not in hand! Enter a rank you have in your hand.\n");
				rankStr = scan.nextLine();
			}
			rank = GoFishCard.convertToRank(rankStr);
		}
		return rank;
	}
	/**
	 * Go Fish ends when either the deck is empty or either player's hand is empty.
	 * @return
	 */
	public boolean gameEnded() {
		return (deck.isEmpty() || player[0].getHand().isEmpty() || player[1].getHand().isEmpty());
	}
	/**
	 * Prints out a message detailing which player has won.
	 * @param p1 Player 1 object
	 * @param p2 Player 2 object
	 */
	public static void gameResults(Player p1, Player p2) {
		System.out.printf("**************************************************\n\n");
		System.out.printf(p1.getPoints() > p2.getPoints() ? "Computer Wins with " + p1.getPoints() + " points!" 
				: p2.getName() + "Player 2 wins with " + p2.getPoints() + " points!");
	}
	/**
	 * Driver method for the game.
	 * @param args
	 */
	public static void main(String[] args) {
		
		/**
		 * Creates the game object, shuffles the deck and deals the cards to each player.
		 */
		GoFish game = new GoFish();
		game.deck.shuffle();
		game.dealCards();
		
		// Initially sorts the players hands, necessary for Hand.evaluate() method to work
		Collections.sort(game.player[0].getHand().getHand(), new RankComparator());
		Collections.sort(game.player[1].getHand().getHand(), new RankComparator());
		
		// Starts the game
		game.playGame();
	}
}
