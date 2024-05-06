package csc130.KevinLi.lab5b;

/**
* <b>Title:</b> Lab 5a:<br>
* <b>Filename:</b> Lab5aApp.java<br>
* <b>Date Written:</b> October 21, 2023<br>
* <b>Due Date:</b> October 21, 2023<br>
* <p>
* <b>Description:</b><br>
* An interface defining the behaviors in a Queue, a user defined data structure.
* </p>
* <p>
* </p>
*@author Kevin Li
*/

public interface Queue<T> {
	void enqueue(T item) throws QueueFullException;
	T dequeue() throws QueueEmptyException;
	T front() throws QueueEmptyException;
	T rear() throws QueueEmptyException;
	boolean isFull();
	boolean isEmpty();
	int getSize();
	
	
}
