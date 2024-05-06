package datastructures;

public interface Stack<T> {
	void push(T item) throws StackException;
	T pop() throws StackException;
	T peek() throws StackException;
	int getSize();
	boolean isFull();
	boolean isEmpty();
	
	
}
