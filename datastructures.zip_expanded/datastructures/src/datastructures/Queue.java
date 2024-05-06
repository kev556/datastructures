package datastructures;

public interface Queue<T> {
	void enqueue(T item);
	T dequeue();
	T front();
	boolean isFull();
	boolean isEmpty();
	int getSize();
	
	
}