package datastructures;

public class LinkedStack<T> implements Stack<T> {
	/**
	 * Inner-class for the Node
	 * 
	 * @author F. Graham
	 *
	 * @param <E>
	 */
	private class Node<E> {
		private E data;
		private Node<E> next;

		public Node() {
			this.data = null;
			next = null;
		}

		public Node(E data) {
			this.data = data;
			next = null;
		}

		public Node(E data, Node<E> next) {
			this.data = data;
			this.next = next;
		}

		public E getData() {
			return data;
		}

		public void setData(E data) {
			this.data = data;
		}

		public Node<E> getNext() {
			return next;
		}

		public void setNext(Node<E> next) {
			this.next = next;
		}
	}

	private int size = 0;
	private Node<T> top = null;

	/**
	 * Pushes an object onto the top of this stack.
	 * 
	 * @param item The object to be stored onto the stack.
	 * @throws StackFullException - if this stack is full
	 */
	public void push(T item) throws RuntimeException {
		if (isFull())
			throw new RuntimeException("Stack full exception...");

		top = new Node(item, top);
		size++;
	}

	/**
	 * Removes and returns the object at the top of this stack.
	 * 
	 * @return The object at the top of the stack.
	 * @throws RuntimeException - if this stack is full
	 */
	public T pop() throws RuntimeException {
		if (isEmpty())
			throw new RuntimeException("Stack empty exception...");
		T tempData = top.data;
		top = top.next;
		size--;
		return tempData;
	}

	/**
	 * Returns the object at the top of this stack without removing it.
	 * 
	 * @return The object at the top of the stack.
	 * @throws RuntimeException - if this stack is full
	 */
	public T peek() throws RuntimeException {
		if (isEmpty())
			throw new RuntimeException("Stack empty exception...");
		return top.data;
	}

	/**
	 * Returns the number of objects on the stack.
	 * 
	 * @return The number of objects on the stack.
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Tests if this stack is empty.
	 * 
	 * @return <i>true</i> if and only if this stack is empty; <i>false</i>
	 *         otherwise.
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Tests if this stack is full.
	 * 
	 * @return <i>true</i> if and only if this stack is full; <i>false</i>
	 *         otherwise.
	 */
	public boolean isFull() {
		return false;
	}

	public String toString() {
		String str = "Size = " + size + "\n";
		Node<T> trav = top;
		for (int i = 0; i < size; i++) {
			str += trav.data + "\n";
			trav = trav.next;
		}
		return str;
	}
}
