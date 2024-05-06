package csc130.KevinLi.project4;
/**
 * <p>
 * Title: The GoFishCard Class
 * </p>
 * 
 * <p>
 * Description: Defines the properties and behaviors of a GoFishcard.
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
* <b>Filename:</b> GoFishCard.java<br>
* <b>Date Written:</b> December 11, 2023<br>
* <b>Due Date:</b> December 16, 2023<br>
* <p>
* <b>Description:</b><br>
*  Defines the properties and behaviors of a GoFishcard.
* </p> <br>
* <p>
*</p>
*@author Kevin Li
*/
public class GoFishCard extends Card implements Comparable<GoFishCard>{
	
	public static final String[] RANKS = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };
	
	/**
	 * Default Constructor
	 */
	public GoFishCard(){
		super();
	}
	/**
	 * Constructor 
	 * @param n a number between 0 and 51 inclusive
	 */
	public GoFishCard(int n){
		super(n);
	}
	/**
	 * Constructor 
	 * @param r - a rank (0 to 12) representing the Card's rank 
	 * @param s - a suit (0 to 3) representing the Card's suit 
	 */
	public GoFishCard(int r, int s){
		super(r,s);
	}
	/**
	 * @param otherCard - a GoFishCard
	 * @return -1 if this card's rank is lower than than other's,<br>
	 * 	0 if they are the same, <br>1 if this card's rank is higher than the other's
	 */
	public int compareTo(GoFishCard otherCard) {
		return compareByRank((Card) otherCard);
	}
	/**
	 * @param otherCard - a GoFishCard
	 * @return Returns <i>true</i> if this card's rank is the same as otherCard's,<br>
	 *  <i>false</i> otherwise
	 */
	public boolean equals(GoFishCard otherCard) {
		return (getRank() == otherCard.getRank());
	}
	/**
	 * A static method that converts a string to a card's equivalent rank
	 * @param str - "2", "3", "4", "5", "6", "7", "8", "9", "10", "J","Q", "K", "A"
	 * @return the equivalent rank (0 - 12)
	 */
	public static int convertToRank(String str){
		String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J",
				"Q", "K", "A" };
		for(int i=0; i<ranks.length; i++)
			if(ranks[i].equalsIgnoreCase(str))
				return i;
		return -1;
	}
	/**
	 * Gets a random card rank
	 * @return random card rank
	 */
	public static int getRandomRank() {
		return convertToRank(RANKS[((int)(Math.random() * 13))]);
		
	}
}
/**
 * Comparator object used for the java.utils.Collections.sort() method
 */
class RankComparator implements java.util.Comparator<GoFishCard> {
	public int compare(GoFishCard thisCard, GoFishCard otherCard) {
		return thisCard.compareTo(otherCard);
	}
}
