package csc130.KevinLi.project4;

import java.util.Collections;
import java.util.LinkedList;
/**
 * <p>
 * Title: The Player Class
 * </p>
 * 
 * <p>
 * Description: Defines the properties and behaviors of a GoFish Player.
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
* <b>Filename:</b> Player.java<br>
* <b>Date Written:</b> December 11, 2023<br>
* <b>Due Date:</b> December 16, 2023<br>
* <p>
* <b>Description:</b><br>
*  Defines the properties and behaviors of a GoFish Card.
* </p> <br>
* <p>
*</p>
*@author Kevin Li
*/
public class Player {
	private String name;
	private Hand hand = new Hand();
	private int points;
	/**
	 * Parameterized constructor
	 * @param n - the name of the player
	 */
	public Player(String n){
		name = n;
		points = 0;
	}
	/**
	 * Returns the player's name
	 * @return - the player's name
	 */
	public String getName() {
		return name;
	}
	/**
	 * Sets the name
	 * @param name - the new value for name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Returns all of the cards of the specified rank as a LinkedList without removing
	 * @param rank - the rank to search for
	 * @return - the cards of the specified rank as a LinkedList
	 */
	public LinkedList<GoFishCard> findCards(int rank) {
		return hand.findRank(rank);
	}
	public Hand getHand() {
		return hand;
	}
	/**
	 * Sets the hand
	 * @param hand
	 */
	public void setHand(Hand hand){
		this.hand = hand;
	}
	public void addPoints(int p) {
		points += p;
	}
	/**
	 * Returns the number of books the player has
	 * @return the number of books the player has
	 */
	public int getPoints() {
		return points;
	}
	/**
	 * Returns the string representation of the player
	 * @return the string representation of the player
	 */
	public String toString(){
		return String.format("%s [Books: %d]\n", name, points);
	}
	/**
	 * Returns the string representation of the hand
	 * @return the string representation of the hand 
	 */
	public String showHand() {
		return hand.toString();
	}
	/**
	 * Returns <i>true</> if the player has a specified rank
	 * @param rank - the rank to search for
	 * @return - Returns <i>true</> if the player has a specified rank, <i>false</> otherwise
	 */
	public boolean hasRank(int rank){
		
		if (hand.hasRank(rank))
			return true;
		else
			return false;
	}
	/**
	 * Adds a card to the hand
	 * @param card - the card to add
	 */
	public void addCard(GoFishCard card){
		hand.insertByRank(card);
	}
	/**
	 * Adds a LinkList of Cards to the hand
	 * @param otherHand - the LinkedList of cards
	 */
	public void addCards(LinkedList<GoFishCard> otherHand) {
		hand.insertHand(otherHand);
	}
	/**
	 * returns the card at a specified index in the hand
	 * @param index - the position of the card
	 * @return - the card at that position
	 */
	public GoFishCard getCardAt(int index){
		return hand.getHand().get(index);
	}
	 /**
	  * Returns the number of cards the player has
	  * @return Return the number of cards the player has
	  */
	public int getTotalCards() {
		return hand.getHand().size();
	}
	/**
	 * Removes and returns the cards of a specified rank as a LinkedList
	 * @param rank - the rank to search for
	 * @return - the Linked List of cards
	 */
	public LinkedList<GoFishCard> getCards(int rank){
		return hand.getCards(rank);
	}
}