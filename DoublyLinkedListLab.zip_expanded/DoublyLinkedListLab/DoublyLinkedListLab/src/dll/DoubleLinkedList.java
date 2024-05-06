package dll;
import java.util.Iterator;

// Double Linked List for CSC 230

// Kevin Li N00969115

import java.util.NoSuchElementException;
import java.lang.StringBuilder;

// N00969115

public class DoubleLinkedList<E> implements Iterable<E>{

	private class Node<E> {
		
		private E data;
		
		private Node<E> next;
		private Node<E> prev;
		
		public Node() {
			data = null;
			prev = null;
			next = null;
		}
		
		public Node(E data, Node<E> next) {
			this.data = data;
			this.prev = null;
			this.next = next;
		}

		// Constructor allowing you to specify a previous node 
		public Node(E data, Node<E> prev, Node<E> next) {
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
		public String toString() {
			return data.toString();
		}
	}
	
	private class LinkedListIterator<E> implements Iterator<E> {
		// The node where the LinkedList will first iterate from
		private Node<E> current;
		
		public LinkedListIterator(Node<E> first) {
			current = first;
		}
		// Checks if the current node is null before iterating,
		// returns false if so and true otherwise
		public boolean hasNext() {
			if (current == null)
				return false;
			return true;
		}
		// Changes current node to the one after it, then returns the value stored in current
		public E next() {
			Node<E> temp = current;
			current = current.next;
			return temp.data;
		}
		
	}

	private Node<E> front;
	private Node<E> rear;
	
	private int size;
	
	// Iterator instance variable for Double Linked List
	private LinkedListIterator<E> iterator;
	
	public int size() {
		return size;
	}
	
	// Adds a node to the rear of the LinkedList.
	public void addToRear(E data) {
		if (size() == 0) {
			/*
			 * If there is nothing inside the linked list, the front and rear are set to 
			 * the new node, with the front and rear pointing to null since it is the only element.
			 */
			front = rear = new Node<E>(data, null);
			size++;
		}
		else {
			/*
			 * Otherwise, a new node is created with its prev pointing to the rear of the LL,
			 * and its rear pointing to null because it will be the last element.
			 * 
			 * The rear node's next is then set to the newly created node, creating the double link.
			 */
			rear.next = new Node<E>(data, rear, null);
			// rear is now the newly created node at the end of the LL.
			rear = rear.next;
			size++;
		}
	}
	
	// Adds a node to the front of the LinkedList.
	public void addToFront(E data) {
		if (size() == 0) {
			/*
			 * If there is nothing inside the linked list, the front and rear are set to 
			 * the new node, with the front and rear pointing to null since it is the only element.
			 */
			front = rear = new Node<E>(data, null);
			size++;
		}
		else {
			/*
			 * Otherwise, a new node is created with its rear pointing to the front of the LL
			 * and its prev pointing to null because it is the first element. 
			 * 
			 * The front node's previous is then set to the newly created node, creating the double link.
			 */
			front.prev = new Node<E>(data, null, front);
			// front is now set to the newly created node at the front of the LL.
			front = front.prev;
			size++;
		}
	}
	
	/**
	 *  Removes the node at the end of the LinkedList, breaks the link
	 *  and decrements size
	 * @return the data stored by the node removed
	 */
	public E removeFromRear() {
		if (size() == 0)
			throw new NoSuchElementException("There are no elements!");
		else {
			Node<E> temp = rear;
			// sets the rear pointer to the value before. If its the only node, sets it to null.
			rear = rear.prev;
			// breaks the links to the current node, allowing it to be garbage collected
			rear.next = null;
			size--;
			// returns data stored in the node removed
			return temp.data;
		}
	}
	/**
	 *  Removes the node at the front of the LinkedList, breaks the link
	 *  and decrements size
	 * @return the data stored by the node removed
	 */
	public E removeFromFront() {
		if (size() == 0)
			throw new NoSuchElementException("There are no elements!");
		else if(size() == 1) {
			Node<E> temp = front;
			/*
			 * If there is only one node in the list, only sets front to null
			 * and sets the next pointer of the node to be removed to null.
			 */
			front = rear = null;
			temp.next = null;
			temp.prev = null;
			size--;
			return temp.data;
		}
		else {
			Node<E> temp = front;
			// sets the front pointer to the next pointer since the node will be removed from the front.
			front = front.next;
			// unlinks the prev of the new front from the removed node
			front.prev = null;
			// fully unlinks the node to be removed
			temp.prev = null;
			temp.next = null;
			size--;
			return temp.data;
		}
	}
	
	/**
	 * Returns the data stored in the node at index pos of the LinkedList
	 * 
	 * @param pos  The index of the LinkedList
	 * @return The data stored in the Node at the specified position
	 */
	public E get(int pos) {
		// Throws an exception if there is nothing in the LL or index is out of bounds
		if (pos < 0) {
			throw new NoSuchElementException("Negative Index detected: " + pos);
		}
		else if (pos >= size()) {
			throw new NoSuchElementException("LinkedList Out of Bounds at index: " + pos);
		}
		// moves the pointer to node at position pos
		Node<E> temp = front;
		for (int i = 0; i < pos; i++) {
			temp = temp.next;
		}
		// returns the data stored in the node at position pos
		return temp.data;
	}
	public E eget(int pos) {
		// Throws an exception if there is nothing in the LL or index is out of bounds
		if (pos < 0) {
			throw new NoSuchElementException("Negative Index detected: " + pos);
		}
		else if (pos >= size()) {
			throw new NoSuchElementException("LinkedList Out of Bounds at index: " + pos);
		}
		else {
			Node<E> temp;
			if (pos >= size / 2) {
				temp = rear;
				for (int i = size - 1; i >= size / 2; i--)
					rear = rear.next;
			}
			else {
				temp = front;
				
			}
			// returns the data stored in the node at position pos
			return temp.data;
		}
	}
	
	/**
	 *  Removes node at a specified position, breaking the link and decrementing size.
	 *  
	 * @param pos  The position of the node in the LinkedList
	 * @return The data stored in the Node at the specified position
	 */
	public E remove(int pos) {
		if (pos < 0) {
			throw new NoSuchElementException("Negative Index detected: " + pos);
		}
		else if (pos >= size) {
			throw new NoSuchElementException("LinkedList Out of Bounds");
		}
		/* If there is only one element, does not assign node previous to
		 * the node at index pos to the node after, because previous will be null 
		 * and will not have a next parameter.
		 */
		else if (size == 1) {
			Node<E> temp = front;
			// unlinks all links from the node so it will be garbage collected
			front.prev = null;
			front.next = null;
			// sets front pointer to null
			front = front.prev;
			// newly added, sets rear pointer to null
			rear = null;
			size--;
			return temp.data;
		}
		// Removes from the front if pos represents the front of the list
		else if (pos == 0)
			return removeFromFront();
		// Removes from the rear if pos is the last index of the list
		else if (pos == size - 1) 
			return removeFromRear();
		
		Node<E> temp = front;
		for (int i = 0; i < pos; i++) {
			temp = temp.next;
		}
		/* sets the next pointer of the previous node to the node after the current node, 
		 * and sets the prev pointer of the node after temp to the node before temp
		 */
		temp.prev.next = temp.next;
		temp.next.prev = temp.prev;
		// breaks the links of the current node, hastening the garbage collection process
		temp.prev = null;
		temp.next = null;
		size--;
		return temp.data;
	}

	
	/**
	 *  Returns the String representation of the LinkedList
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		Node<E> ptr = front;
		
		// Starts at front working backwards and adding the value of each node to the String.
		while (ptr != null) {
			// appends each node, separated by space
			sb.append(ptr + " ");
			ptr = ptr.next;
		}
		
		sb.append("]");
		
		// returns the string built by stringbuilder
		return sb.toString();
	}

	/**
	 * 	Returns the String representation of the LinkedList in reverse order
	 * @return
	 */
	public String reverseString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		Node<E> ptr = rear;
		
		// Starts at rear working backwards and adding the value of each node to the String.
		while (ptr != null) {
			sb.append(ptr + " ");
			ptr = ptr.prev;
		}
		
		sb.append("]");
		
		// returns the string built by stringbuilder
		return sb.toString();
	}

	/**
	 *	Public method that returns an instance of the LinkedList's iterator.
	 *	The Iterator will iterate from the front.
	 */
	@Override
	public Iterator<E> iterator() {
		iterator = new LinkedListIterator<E>(front);
		return iterator;
	}
	
}
