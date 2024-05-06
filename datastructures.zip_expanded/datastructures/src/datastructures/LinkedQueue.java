package datastructures;

public class LinkedQueue<T> implements Queue<T>{

	private Node<T> front, rear;
	private int numItems;
	
	@Override
	public void enqueue(T item) throws RuntimeException{
		
		if (isFull())
			throw new RuntimeException("Queue Full");
		else if (isEmpty())
			front = rear = new Node<T>(item);
		else {
			rear.setNext(new Node<T>(item));
			rear = rear.getNext();
		}
		numItems++;
	}

	@Override
	public T dequeue() throws RuntimeException {
		
		if (isEmpty()) 
			throw new RuntimeException("Queue Empty");
		
		T item = front.getData();
		front = front.getNext();
		
		if (front == null) 
			rear = null;
		
		numItems--;
		return item;	
	}

	@Override
	public T front() throws RuntimeException {
		// TODO Auto-generated method stub
		return front.getData();
	}

	public T rear() throws RuntimeException {
		// TODO Auto-generated method stub
		return rear.getData();
	}
	@Override
	public boolean isFull() {
		
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return numItems == 0;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return numItems;
	}
	
	

}
