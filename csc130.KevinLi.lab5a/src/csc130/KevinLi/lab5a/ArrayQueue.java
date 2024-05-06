package csc130.KevinLi.lab5a;
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
	public void enqueue(T item) throws QueueException {
		if (isFull()) {
			throw new QueueException("Queue Full Exception");
		}
		data[rear] = item;
		rear = (rear + 1) % data.length;
		size++;
	}
	
	@Override
	public T dequeue() throws QueueException {
		if(isEmpty()) {
			throw new QueueException("Queue Empty Exception");
		}
		
		size--;
		T item = data[front];
		front = (front + 1) % data.length;
		
		return item;
	}
	
	@Override
	public T front() throws QueueException {
		if(isEmpty()) {
			throw new QueueException("Queue Empty Exception");
		}
		return data[front];
	}
	public T rear() throws QueueException {
		if(isEmpty()) {
			throw new QueueException("Queue Empty Exception");
		}
		return data[front + (size - 1) % data.length];
	}
	
	public void makeEmpty() throws QueueException{
		
		while (isEmpty()) {
			dequeue();
		}
	}
	@Override
	public boolean isFull() {
		return size == data.length;
	}
	
	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	
	@Override
	public int getSize() {
		return size;
	}
	@Override
	public String toString() {
		
		if (isEmpty()) {
			return "Queue is Empty! Maximum number of items that can be stored is " + (data.length - size);
		}
		else
		return "The number of items in the queue is: " + size + 
				"\nThe queue contains the following: " + Arrays.toString(data);
	}
	
	
	
	

}