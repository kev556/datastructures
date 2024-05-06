package csc130.KevinLi.project4;

import java.util.ArrayList;
import java.util.Collections;

/**
 * <p>
 * Title: The Deck Class
 * </p>
 * 
 * <p>
 * Description: Defines the properties and behaviors of a Deck of Cards.
 * </p>
 * 
 * @author F. Graham
 *
 */
/**
* <b>Title:</b> Project 4 <br>
* <b>Filename:</b> Deck.java<br>
* <b>Date Written:</b> December 11, 2023<br>
* <b>Due Date:</b> December 16, 2023<br>
* <p>
* <b>Description:</b><br>
*  Defines the properties and behaviors of a Deck of Cards.
* </p> <br>
* <p>
*</p>
*@author Kevin Li
*/
public class Deck {
	
	/**
	 * ArrayList of Cards
	 */
	private ArrayList<Card> cards = new ArrayList<Card>();
	
	public Deck() {
		cards.ensureCapacity(52);
		initialize();
	}
	/**
	 * Generates 52 Cards and stores them in the ArrayList
	 */
	public void initialize(){
		for(int i = 0; i < 52; i++)	{
			cards.add(new GoFishCard(i));
		}		
	}
	public ArrayList<Card> getCards() {
		return cards;
	}
	/**
	 * Returns a string representation of the Deck
	 * @return String representation of the list of Cards in the Deck
	 */
	public String toString(){
		return "No. of cards: " + cards.size() +"\n" + cards.toString();
	}
	/**
	 * Shuffles the Deck of Cards
	 */
	public void shuffle() {
		Collections.shuffle(cards);
	}	

	/**
	 * Returns a card from the Deck
	 * @return returns a Card from the Deck
	 */
	public Card deal() {
		if(!cards.isEmpty())
			return cards.remove(0);
		return null;
	}
	
	/**
	 * Returns <i>true</i> if the Deck is empty
	 * @return Returns <i>true</i> if the Deck is empty, <i>false</i> otherwise
	 */
	public boolean isEmpty(){
		return cards.isEmpty();
	}
}