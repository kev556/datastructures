package csc130.KevinLi.project2;

public class StackException extends Exception{
	public StackException() {
		super("Stack Full Exception...");
	}
	public StackException(String msg) {
		super(msg);
	}
}
