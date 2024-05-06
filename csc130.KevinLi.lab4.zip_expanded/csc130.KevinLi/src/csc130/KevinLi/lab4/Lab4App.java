package csc130.KevinLi.lab4;

import java.util.*;
import java.util.stream.Collectors;

/**
* <b>Title:</b> Lab 4<br>
* <b>Filename:</b> Lab4App.java<br>
* <b>Date Written:</b> October 13, 2023<br>
* <b>Due Date:</b> October 15, 2023<br>
* <p>
* <b>Description:</b><br>
* Creates and tests the properties of the DiscardPile class included within the project.
* </p>
* <br>
* <p>
* Tests the functionality of methods find() and removeTopCards(). 
* Includes populate() method for easy population of a set of Cards.
* </p>
* 
*@author Kevin Li
*/

public class Lab4App {

	public static void main(String[] args) throws StackFullException, StackEmptyException{
		
		/**
		 * DiscardPile<Card> discardPile = new DiscardPile<Card>();
		
		populate(discardPile);
		System.out.println("\nInitial DiscardPile\n\n" + discardPile);
		
		Card[] arr = discardPile.removeTopCards(new Card(20));
		System.out.println("\nResult of removeTopCards(new Card(20))\n");
		for (int i = arr.length; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		discardPile.makeEmpty();
		populate(discardPile);
		
		arr = discardPile.removeTopCards(new Card(50));
		System.out.println("\nResult of removeTopCards(new Card(50))\n");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		System.out.println("\nResultant DiscardPile\n\n" + discardPile);
		 */
		
		Stack<Integer> stack = new ArrayStack<Integer>();
		Stack<Integer> ostack = new ArrayStack<Integer>();
		
		stack.push(11);
		stack.push(12);
		stack.push(15);
		stack.push(19);
		ostack.push(13);
		ostack.push(14);
		ostack.push(16);
		ostack.push(18);
		ostack.push(20);
	
		Stack<Integer> newstack = mergeInOrder(stack, ostack);
		System.out.println("hi");
		
		System.out.println(newstack);
	}
	/**
	 * Populates DiscardPile dp with a predetermined set of Cards
	 * @param dp - DiscardPile to be populated with Cards
	 */
	public static void populate(DiscardPile<Card> dp) {
		
		try {
			dp.push(new Card(8));
			dp.push(new Card(32));
			dp.push(new Card(48));
			dp.push(new Card(2));
			dp.push(new Card(17));
			dp.push(new Card(20));
			dp.push(new Card(25));
			dp.push(new Card(50));
			dp.push(new Card(19));
			dp.push(new Card(41));
		}
		catch (StackFullException sfe) {
			System.out.println("Stack Full!");
		}
	}
	public static Stack<Integer> mergeInOrder(Stack<Integer> s, Stack<Integer> os) throws StackFullException, StackEmptyException{
		
		int[] intArr = new int[s.getSize() + os.getSize()];
		Stack<Integer> ns = new ArrayStack<Integer>();
		int index = 0;
		int temp = 0;
		
		while(!s.isEmpty()) {
			temp = s.pop();
			intArr[index] = temp;
			ns.push(temp);
			index++;
		}
		while(!os.isEmpty()) {
			temp = os.pop();
			intArr[index] = temp;
			ns.push(temp);
			index++;
		}
		while(!ns.isEmpty())
			s.push(ns.pop());
		List<Integer> intList = Arrays.stream(intArr).boxed().collect(Collectors.toList());	
		
		while(ns.getSize() <= intArr.length) {
			while(!intList.contains((Integer)index)) {
				index++;
				System.out.println("hi");
			}
			while(!s.isEmpty()) {
				if(s.peek() == index) {
					ns.push(s.pop());
					index++;
				}
				else 
					os.push(s.pop());
				
			}
			while(!os.isEmpty()) {
				if(os.peek() == index) {
					ns.push(os.pop());
					index++;
				}
				else 
					s.push(os.pop());
			}
			
		}
			
		return ns;
		
	}

}
