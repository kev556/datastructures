package datastructures;

public class Node<T> {
	private T data;
	private Node<T> prev;
	private Node<T> next;
	
	public Node() {
		data = null;
		next = null;
	}
	public Node(T item) {
		data = item;
		next = null;
	}
	public Node(T item, Node<T> n) {
		data = item;
		next = n;
	}
	public Node(T item, Node<T> p, Node<T> n) {
		data = item;
		prev = p;
		next = n;
	}
	public T getData() {
		return data;
	}
	public Node<T> getPrev() {
		return prev;
	}
	public Node<T> getNext() {
		return next;
	}
	public void setData(T data) {
		this.data = data;
	}
	public void setPrev(Node<T> data) {
		prev = data;
	}
	public void setNext(Node<T> data) {
		next = data;
	}
}