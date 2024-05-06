package csc130.KevinLi.project4;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
/**
 * <p>
 * Title: The Hand Class
 * </p>
 * 
 * <p>
 * Description: Defines the properties and behaviors of a GoFish Hand.
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2010
 * </p>
 * 
 * @author F. Graham
 */
/**
* <b>Title:</b> Project 4 <br>
* <b>Filename:</b> Hand.java<br>
* <b>Date Written:</b> December 11, 2023<br>
* <b>Due Date:</b> December 16, 2023<br>
* <p>
* <b>Description:</b><br>
*  Defines the properties and behaviors of a GoFish Hand.
* </p> <br>
* <p>
*</p>
*@author Kevin Li
*/
public class Hand{
	/**
	 * LinkList of GoFish Cards
	 */
	private LinkedList<GoFishCard> hand;
	/**
	 * Default constructor
	 */
	public Hand(){
		hand = new LinkedList<GoFishCard>();
	}
	/**
	 * Returns the number of cards in the hand
	 * @return the number of cards in the hand
	 */
	public int getCount(){
		return hand.size();
	}
	/**
	 * Returns the hand as LinkedList of GoFish cards
	 * @return the hand as a LinkedList of GoFish Cards
	 */
	public LinkedList<GoFishCard> getHand() {
		return hand;
	}	
	/**
	 * Returns <i>true</i> if this rank is in the hand
	 * @param rank - the rank to search for
	 * @return Returns <i>true</i> if this rank is the hand,<br> 
	 * <i>false</i> otherwise
	 */
	public boolean hasRank(int rank) {
		for (int i = 0; i < hand.size(); i++) {
			if (hand.get(i).getRank() == rank) {
				return true;
			}
		}
		return false;
	}
	/**
	 * Returns a string representation of the hand
	 */
	public String toString(){
		String tempStr = "";
		for (int i = 0; i < hand.size(); i++)
			tempStr += hand.get(i) + " ";
		return tempStr;
	}
	/**
	 * Finds and returns all cards of the specified rank
	 * @param rank - the rank to search for
	 * @return all of the cards of that rank as a LinkedList of GoFish Cards
	 */
	public LinkedList<GoFishCard> findRank(int rank){
		LinkedList<GoFishCard> list = new LinkedList<GoFishCard>();
		
		for (GoFishCard g : hand) {
			if (g.getRank() == rank)
				list.add(g);
		}
		return list;
	}
	/**
	 * Adds a Card to the hand, the hand is sorted by rank
	 * @param card - a GoFish Card
	 */
	public void insertByRank(GoFishCard card){
		hand.add(card);
		Collections.sort(hand, new RankComparator());
	}
	/**
	 * Adds a LinkList of Cards to the hand, the hand is sorted by rank
	 * @param otherHand LinkedList of GoFish Cards
	 */
	public void insertHand(Collection<? extends GoFishCard> otherHand) {
		for (GoFishCard c: otherHand)
			hand.add(c);
		
		Collections.sort(hand, new RankComparator());
	}
	/**
	 * Determines if the hand is empty
	 * @return - Returns <i>true</i> if the hand is empty, <i>false</i> otherwise
	 */
	public boolean isEmpty() {
		if (hand.isEmpty())
			return true;
		return false;
	}
	/**
	 * Returns 1 if a book (all 4 cards of a particular rank) is 
	 * in the hand and removes the book from the hand
	 * @return the number of books (all 4 cards of a particular rank) in the hand
	 */
	public int evaluate() {
		int indexOfBook = hasBook();
		int rank = 0;
		
		if (indexOfBook > -1) {
			rank = hand.get(indexOfBook).getRank();
			getCards(rank);
			return 1;
		}
		else return 0;
	}
	/**
	 * Determines whether there is a book in the hand
	 * @return
	 */
	public int hasBook() {
		Card prev = hand.get(0);
		int counter = 1;
		for (int i = 1; i < hand.size(); i++) {
			if (hand.get(i).compareByRank(prev) == 0) {
				counter++;
				if (counter == 4) {
					return i;
				}
			}
			else {
				prev = hand.get(i);
				counter = 1;
			}
		}
		return -1;
	}
	/**
	 * Counts the number of cards of a particular rank in the hand
	 * @param rank - the rank to count
	 * @return the number of cards of that rank
	 */
	public int countRank(int rank){
		int count = 0;
		Card find = new Card(rank);
		
		for (int i = 0; i < hand.size(); i++) {
			if (((GoFishCard)hand.get(i)).equals(find))
				count++;
		}
		return count;
	}
	/**
	 * Returns the card at the specified position in this list.
	 * @param index the index of the list
	 * @return
	 */
	public GoFishCard getCardAt(int index){
		return hand.get(index);
	}
	/**
	 * Returns a list of cards of a specified rank
	 * @param rank - the rank to search for 
	 * @return the cards as LinkedList of GoFish Cards
	 */
	public LinkedList<GoFishCard> getCards(int rank) {
		LinkedList<GoFishCard> list = new LinkedList<GoFishCard>();
		
		while(hasRank(rank))
			for (int i = 0; i < hand.size(); i++) {
				if (hand.get(i).getRank() == rank) {
					list.add(hand.get(i));
					hand.remove(i);
					i--;
				}
			}
		return list;
	}
}



