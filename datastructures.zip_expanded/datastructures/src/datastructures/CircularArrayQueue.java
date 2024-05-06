package datastructures;

public class CircularArrayQueue<T> implements Queue<T> {
	
	private T[] data;
	private int size, front, rear;
	static final int CAPACITY = 100;
	
	public CircularArrayQueue() {
		data = (T[])new Object[CAPACITY];
		size = 0;
	}
	public CircularArrayQueue(int capacity) {
		data = (T[]) new Object[capacity];
		size = 0;
	}
	
	@Override
	public void enqueue(T item) throws RuntimeException {
		if (size == data.length) {
			throw new RuntimeException("Queue Full Exception");
		}
		data[rear] = item;
		rear = (rear + 1) % data.length;
		size++;
	}
	
	@Override
	public T dequeue() throws RuntimeException {
		if(size == 0) {
			throw new RuntimeException("Queue Empty Exception");
		}
		
		size--;
		T item = data[front];
		front = (front + 1) % data.length;
		
		return item;
	}
	
	@Override
	public T front() throws RuntimeException {
		if(size == 0) {
			throw new RuntimeException("Queue Empty Exception");
		}
		return data[front];
	}
	public T rear() throws RuntimeException {
		if(size == 0) {
			throw new RuntimeException("Queue Empty Exception");
		}
		return data[front + (size - 1) % data.length];
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
	
	

}
