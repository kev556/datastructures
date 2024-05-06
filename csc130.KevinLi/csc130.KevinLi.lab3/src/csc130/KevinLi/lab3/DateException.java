package csc130.KevinLi.lab3;

public class DateException extends Exception {

	public DateException() {
		super("Invalid value for date");
	}

	public DateException(String message) {
		super(message);
	}

	public DateException(Throwable cause) {
		super(cause);
	}

	public DateException(String message, Throwable cause) {
		super(message, cause);
	}

	public DateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
