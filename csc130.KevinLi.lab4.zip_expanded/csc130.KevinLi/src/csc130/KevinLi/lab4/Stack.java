package csc130.KevinLi.lab4;
/**
 * <p>
 * Title: Stack
 * </p>
 * 
 * <p>
 * Description: Interface for the Abstract Data Type Stack
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2023
 * </p>
 * 
 * @author Kevin Li
 */
/**
 * This Stack interface represents a last-in-first-out (LIFO) stack of objects.
 * The usual push and pop operations are provided, as well as a method to peek 
 * at the top item on the stack, and methods to test whether the stack is empty or full.
 */
public  interface Stack<T> {
	/**
	 * Pushes an object onto the top of this stack.
	 * @param item The object to be stored onto the stack.
	 * @throws StackFullException - if this stack is full
	 */
	public void push(T item) throws StackFullException;
	/**
	 * Removes and returns the object at the top of this stack.
	 * @return The object at the top of the stack.
	 * @throws StackEmptyException - if this stack is full
	 */
	public T pop() throws StackEmptyException;
	/**
	 * Returns the object at the top of this stack without removing it.
	 * @return The object at the top of the stack.
	 * @throws StackEmptyException - if this stack is full
	 */
	public T peek() throws StackEmptyException;
	/**
	 * Tests if this stack is empty.
	 * @return <i>true</i> if and only if this stack is empty; <i>false</i> otherwise.
	 */
	public boolean isEmpty();
	/**
	 * Tests if this stack is full.
	 * @return <i>true</i> if and only if this stack is full; <i>false</i> otherwise.
	 */
	public boolean isFull();
	/**
	 * Returns the number of objects on the stack.
	 * @return The number of objects on the stack.
	 */
	public int getSize();
}