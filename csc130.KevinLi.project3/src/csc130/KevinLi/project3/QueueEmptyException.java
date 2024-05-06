package csc130.KevinLi.project3;

public class QueueEmptyException extends RuntimeException {

	public QueueEmptyException() {
		super("Queue Empty Exception");
	}

	public QueueEmptyException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public QueueEmptyException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public QueueEmptyException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public QueueEmptyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
