package csc130.KevinLi.lab7;

public class LinkedList<T> implements List<T> {
	private class Node<E> {
		private E data;
		private Node<E> prev;
		private Node<E> next;
		public Node() {
			data = null;
			next = null;
		}
		public Node(E d) {
			data = d;
			next = null;
		}
		public Node(E d, Node<E> n) {
			data = d;
			next = n;
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
	private int size;
	private Node<T> front = new Node<T>();  // dummy Node
	
	@Override
	public void add(T item) {
		add(item, size);
	}
	public void add(T item, int index) {
		if(index < 0 || index > size)
			throw new RuntimeException("Invalid index exception...");
		Node<T> trav = front;
		for(int i=0; i < index; i++)
			trav = trav.next;
		trav.next = new Node<T>(item, trav.next);
		size++;
	}
	@Override
	public T remove(T item) {
		Node<T> trav = front;
		boolean found =false;
		T data = null;
		while(trav.next != null && !found) {
			if(trav.next.data.equals(item)) {
				found = true;
				data = trav.next.data;
				trav.next = trav.next.next;
			}
			else
				trav = trav.next;
		}
		return data;
	}
	@Override
	public boolean contains(T item) {
		return indexOf(item) >= 0;
	}

	@Override
	public int indexOf(T item) {
		Node<T> trav = front;
		int index = 0;
		while(trav.next != null) {
			if(trav.next.data.equals(item))
				return index;
			trav = trav.next;
			index++;
		}
		return -1;
	}
	@Override
	public int lastIndexOf(T item) {
		Node<T> trav = front;
		int currentIndex = 0, lastIndex = -1;
		while(trav.next != null) {
			if(trav.next.data.equals(item))
				lastIndex = currentIndex;
			trav = trav.next;
			currentIndex++;
		}
		return lastIndex;
	}
	@Override
	public T remove(int index) {
		if(index < 0 || index > size)
			throw new RuntimeException("Invalid index exception...");
		Node<T> trav = front;
		for(int i=0; i < index; i++)
			trav = trav.next;
		T data = trav.next.data;
		trav.next = trav.next.next;
		size--;
		return data;
	}
	@Override
	public T get(int index) {
		if(index < 0 || index > size)
			throw new RuntimeException("Invalid index exception...");
		Node<T> trav = front;
		for(int i=0; i < index; i++)
			trav = trav.next;
		return trav.next.data;
	}
	@Override
	public T set(int index, T item) {
		if(index < 0 || index >= size)
			throw new RuntimeException("Invalid index exception...");
		Node<T> trav = front;
		for(int i=0; i < index; i++)
			trav = trav.next;
		T oldValue = trav.next.data;
		trav.next.data = item;
		return oldValue;
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
	public void clear() {
		size = 0;
		front = new Node<T>();
		System.gc();
	}
	
	@Override
	public String toString() {
		String str = new String("LinkedList size=" + size + "\n[");
		Node<T> trav = front.next;
		while(trav != null) {
			str += trav.data + "\n";
			trav = trav.next;
		}
		return str + "]";
	}
	/**
	 * subList method - returns a LinkedList starting from fromIndex to ToIndex-1
	 * 
	 * @throws RuntimeException if the indices are out of bounds or toIndex < fromindex
	 * @param fromIndex is the index from which to start
	 * @param toIndex is the index to stop (non included)
	 * @return the sublist
	 */
	public LinkedList<T> subList(int fromIndex, int toIndex)  throws RuntimeException{
		return null;
	}
	public int compareTo(Object other) {
		if(other instanceof LinkedList)
			return size - ((LinkedList)other).size;
		return -1;
	}
	@Override
	public T set(T oldItem, T newItem) {
		// TODO Auto-generated method stub
		return null;
	}
}