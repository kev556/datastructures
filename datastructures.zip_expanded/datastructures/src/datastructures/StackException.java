package datastructures;

public class StackException extends Exception{
	public StackException() {
		super("Stack Full Exception...");
	}
	public StackException(String msg) {
		super(msg);
	}
}
