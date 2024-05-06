package datastructures;

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
