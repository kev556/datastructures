package csc130.KevinLi.project3;
import java.util.Arrays;

/**
* <b>Title:</b> Lab 5a:<br>
* <b>Filename:</b> ArrayQueue.java<br>
* <b>Date Written:</b> October 21, 2023<br>
* <b>Due Date:</b> October 21, 2023<br>
* <p>
* <b>Description:</b><br>
* Defines an ArrayQueue, an implementation of a Queue,
* a data structure following the first come first serve principle.
* </p>
* <p>
*</p>
*@author Kevin Li
*/

public class ArrayQueue<T> implements Queue<T> {
	
	private T[] data;
	private int size, front, rear;
	static final int CAPACITY = 100;
	private int capacity;
	
	/**
	 * 	Creates an ArrayQueue with default capacity of 100
	 */
	public ArrayQueue() {
		data = (T[])new Object[CAPACITY];
		size = 0;
	}
	/**
	 * 	Creates ArrayQueue of specified capacity.
	 * @param capacity specified size of new ArrayQueue to be created
	 */
	public ArrayQueue(int capacity) {
		data = (T[]) new Object[capacity];
		size = 0;
	}
	
	@Override
	public synchronized void enqueue(T item) throws QueueFullException {
		if (isFull()) {
			throw new QueueEmptyException("Queue Full Exception");
		}
		data[rear] = item;
		rear = (rear + 1) % data.length;
		size++;
	}
	
	@Override
	public synchronized T dequeue() throws QueueEmptyException {
		if(isEmpty()) {
			throw new QueueEmptyException("Queue Empty Exception");
		}
		
		size--;
		T item = data[front];
		front = (front + 1) % data.length;
		
		return item;
	}
	
	@Override
	public synchronized T front() throws QueueEmptyException {
		if(isEmpty()) {
			throw new QueueEmptyException("Queue Empty Exception");
		}
		return data[front];
	}
	public synchronized T rear() throws QueueEmptyException {
		if(isEmpty()) {
			throw new QueueEmptyException("Queue Empty Exception");
		}
		return data[front + (size - 1) % data.length];
	}
	
	public synchronized void makeEmpty() throws QueueEmptyException{
		
		while (isEmpty()) {
			dequeue();
		}
	}
	@Override
	public synchronized boolean isFull() {
		return size == data.length;
	}
	
	@Override
	public synchronized boolean isEmpty() {
		return size == 0;
	}
	
	@Override
	public synchronized int getSize() {
		return size;
	}
	@Override
	public synchronized String toString() {
		
		if (isEmpty()) {
			return "Queue is Empty! Maximum number of items that can be stored is " + (data.length - size);
		}
		else
		return "The number of items in the queue is: " + size + 
				"\nThe queue contains the following: " + Arrays.toString(data);
	}
	
	
	
	

}