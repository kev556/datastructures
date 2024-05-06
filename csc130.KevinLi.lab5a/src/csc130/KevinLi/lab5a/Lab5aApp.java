package csc130.KevinLi.lab5a;

/**
* <b>Title:</b> Lab 5a:<br>
* <b>Filename:</b> Lab5aApp.java<br>
* <b>Date Written:</b> October 21, 2023<br>
* <b>Due Date:</b> October 21, 2023<br>
* <p>
* <b>Description:</b><br>
* Hosts the main method which tests the functionality of the ArrayQueue class and its methods.
* </p>
* <p>
*</p>
*@author Kevin Li
*/

public class Lab5aApp {

	public static void main(String[] args) {
		ArrayQueue<Integer> aq = new ArrayQueue<Integer>();
		
		System.out.println(aq);
		
		ArrayQueue<Integer> aq2 = new ArrayQueue<Integer>(3);
		
		System.out.println(aq2);
		
		/**
		 * 	Test for enqueue()
		 */
		try {
			aq2.enqueue(new Integer(4));
			aq2.enqueue(new Integer(5));
			aq2.enqueue(new Integer(6));
		} catch (QueueException qe){
			System.out.println("No values in Queue");
		}
		//aq2.enqueue(new Integer(7));
		
		/**
		 * 	isFull() test
		 */
		System.out.println(aq2);
		System.out.println("\nisFull() Test");
		if (aq.isFull()) {
			System.out.println("AQ is Full");
		}
		else {
			System.out.println("AQ isn't Full");
		}
		if (aq2.isFull()) {
			System.out.println("AQ2 is Full");
		}
		else {
			System.out.println("AQ2 isn't Full");
		}
		
		/**
		 * 	front() test
		 */
		System.out.println("\nfront() Test");
		try {
			System.out.println(aq2.front());
			System.out.println(aq.front());
		} catch (QueueException qe){
			System.out.println(qe.getMessage());
		}
		
		/**
		 * 	rear() test
		 */
		System.out.println("\nrear() Test");
		try {
			System.out.println(aq2.rear());
			System.out.println(aq.rear());
		} catch (QueueException qe){
			System.out.println(qe.getMessage());
		}
		
		/**
		 * 	dequeue() test
		 */
		try {
			System.out.println("Dequeueing aq: \n");
			while(!aq.isEmpty()) {
				System.out.println(aq.dequeue());
			}
		} catch (QueueException qe) {
			System.out.println(qe.getMessage());
		}
		
		try {
			System.out.println("Dequeueing aq2: \n");
			while(!aq2.isEmpty()) {
				System.out.println(aq2.dequeue());
			}
		} catch (QueueException qe) {
			System.out.println(qe.getMessage());
		}
		
		/**
		 * 	repopulate aq2 with values
		 */
		try {
			aq2.enqueue(new Integer(4));
			aq2.enqueue(new Integer(5));
			aq2.enqueue(new Integer(6));
		} catch (QueueException qe){
			System.out.println("No values in Queue");
		}
		
		/**
		 * 	isEmpty() test
		 */
		System.out.println("\nisEmpty() Test");
		if (aq.isEmpty()) {
			System.out.println("AQ is Empty");
		}
		else {
			System.out.println("AQ isn't Empty");
		}
		if (aq2.isEmpty()) {
			System.out.println("AQ2 is Empty");
		}
		else {
			System.out.println("AQ2 isn't Empty");
		}
		
		/**
		 * 	makeEmpty() test
		 */
		System.out.println("\nmakeEmpty() Test");
		try {
			aq.makeEmpty();
		} catch (QueueException qe){
			System.out.println("No values in Queue");
		}
		try {
			aq2.makeEmpty();
		} catch (QueueException qe){
			System.out.println("No values in Queue");
		}
	}

}
