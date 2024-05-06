package csc130.KevinLi.project2;

import java.util.Arrays;

/**
* <b>Title:</b> Project 2:<br>
* <b>Filename:</b> ArrayStack.java<br>
* <b>Date Written:</b> October 27, 2023<br>
* <b>Due Date:</b> October 31, 2023<br>
* <p>
* <b>Description:</b><br>
* Defines the ArrayStack, an abstract data structure implementing the first in last out concept.
* </p>
* <p>
* </p>
* <p><b></b></p>
* <p>
*</p>
*@author Kevin Li
*/

public class ArrayStack<T> implements Stack<T> {

	private T[] data;
	private int size;
	private final int CAPACITY = 100;
	
	
	
	public ArrayStack() {
		data = (T[])new Object[CAPACITY];
	}

	@Override
	public void push(T item) throws StackException {
		
		if (isFull()) {
			throw new StackException("Stack Full Exception");
		}
		this.data[size] = item;
		size++;
	}

	@Override
	public T pop() throws StackException {
		
		if (isEmpty()) {
			throw new StackException("Stack Empty Exception");
		}
		
		return this.data[--size];
	}

	@Override
	public T peek() throws StackException {

		if (isEmpty()) {
			throw new StackException("Stack Empty Exception");
		}
		return this.data[size - 1];
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
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
	public String toString() {
		
		String str = new String();
		
		for (int i = size - 1; i >= 0; i--) {
			str += data[i] + "\n";
		}
		
		return str;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
