package csc130.KevinLi.lab5b;

public class QueueFullException extends RuntimeException {

	public QueueFullException() {
		super("Queue Full Exception");
	}

	public QueueFullException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public QueueFullException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public QueueFullException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public QueueFullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
