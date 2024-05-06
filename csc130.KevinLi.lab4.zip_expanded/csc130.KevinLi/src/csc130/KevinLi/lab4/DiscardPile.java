package csc130.KevinLi.lab4;

/**
* <b>Title:</b> Lab 4<br>
* <b>Filename:</b> DiscardPile.java<br>
* <b>Date Written:</b> October 13, 2023<br>
* <b>Due Date:</b> October 15, 2023<br>
* <p>
* <b>Description:</b><br>
* Defines a DiscardPile, a Stack containing an array of Card objects.
* </p>
* <br>
  <br>
* <p>
* A DiscardPile contains functionality to add and remove cards just like a stack,
* and is also able to locate the existence of a certain card, and to remove all 
* cards above and including a certain card.
* </p>
* 
*@author Kevin Li
*/

public class DiscardPile<T> implements Stack<Card> {

	/**
	 * The array into which the objects of the stack are stored.
	 */
	private Card[] data;
	/**
	 * The number of objects in this stack.
	 */
	private int numItems;
	/**
	 * The default capacity of this stack.
	 */
	private final int DEFAULT_SIZE = 52;
	/**
	 * Constructs a new empty DiscardPile with capacity for 
	 * 52 cards, the maximum amount of cards in a deck
	 */
	public DiscardPile(){
		data = new Card[DEFAULT_SIZE];
		numItems = 0;
	}
	/**
	 * Finds the location of a certain card within the stack and returns its index.
	 * @param theCard  card object to be compared against
	 * @return index of the card, -1 if not found
	 * @throws StackEmptyException  if the stack is empty
	 * @throws StackFullException  if the stack is full
	 */
	public int find(Card theCard) throws StackEmptyException, StackFullException{
		int location = -1;
		int index = 0;
		
		DiscardPile<Card> temp = new DiscardPile<Card>();
		
		while (!isEmpty()) {
			Card tempCard = this.pop();
			temp.push(tempCard);
		}
		while (!temp.isEmpty()) {
			Card tempCard = temp.pop();
			this.push(tempCard);
			
			if (tempCard.equals(theCard)) { 
				location = index;
			}
			index++;
		}
		
		return location;
	}
	/**
	 * Removes all cards above and including a certain card
	 * @param theCard  Card object to be removed and compared with to remove all cards above
	 * @return  an array containing all cards above and including theCard
	 * @throws StackEmptyException  if the stack is empty
	 * @throws StackFullException  if the stack does not contain the card
	 */
	public Card[] removeTopCards(Card theCard) throws StackEmptyException, StackFullException{
		int index = 0;
		int cardAmt = 0;
		DiscardPile<Card> temp = new DiscardPile<Card>();
		
		if (find(theCard) == -1) {
			throw new StackFullException("Discard Pile does not contain card");
		}
		else {
			try {
				while (index <= find(theCard)) {
					temp.push(this.pop());
					cardAmt++;
				}
			}
			catch (StackEmptyException see) {
				System.out.println("Stack Empty Exception");
			}
		}
		
		Card[] cardArr = new Card[cardAmt];
		
		for (int i = 0; i < cardArr.length; i++) {
			cardArr[i] = temp.pop();
		}
		return cardArr;
	}
	/**
	 * Removes every object stored within the stack
	 * @throws StackEmptyException  if the stack is empty
	 */
	public void makeEmpty() throws StackEmptyException{
		while (!isEmpty()) {
			pop();
		}
	}
	/**
	 * Pushes an object onto the top of this stack.
	 * @param item The object to be stored onto the stack.
	 * @throws StackFullException  if this stack is full
	 */
	public void push(Card item) throws StackFullException {
		if(isFull())
			throw new StackFullException("Stack full Exception...");
		data[numItems] = (Card)item;
		numItems++;
	}
	/**
	 * Removes and returns the object at the top of this stack.
	 * @return The object at the top of the stack.
	 * @throws StackEmptyException  if this stack is empty
	 */
	public Card pop() throws StackEmptyException{
		if(isEmpty())
			throw new StackEmptyException("Stack empty Exception...");
		numItems--;
		Card item = data[numItems];
		return item;		
	}
	/**
	 * Returns the object at the top of this stack without removing it.
	 * @return The object at the top of the stack.
	 * @throws StackEmptyException  if this stack is empty
	 */
	public Card peek() throws StackEmptyException{
		if(isEmpty())
			throw new StackEmptyException("Stack empty Exception...");
		return data[numItems-1];
	}
	public boolean isEmpty(){
		return numItems == 0;
	}
	
	public boolean isFull(){
		return numItems == data.length;
	}
	/**
	 * Returns the number of objects on the stack.
	 * @return The number of objects on the stack.
	 */
	public int getSize(){
		return numItems;
	}
	/**
	 * Returns the current state of this stack. 
	 * @return String representation of this stack.
	 */
	public String toString(){
		String str = "";
		for(int i = numItems-1; i >= 0; i--){
			str += data[i] + "\n";
		}
		return str;
	}

}
