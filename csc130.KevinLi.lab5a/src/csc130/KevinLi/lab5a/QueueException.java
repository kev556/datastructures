package csc130.KevinLi.lab5a;

/**
* <b>Title:</b> Lab 5a:<br>
* <b>Filename:</b> QueueException.java<br>
* <b>Date Written:</b> October 21, 2023<br>
* <b>Due Date:</b> October 21, 2023<br>
* <p>
* <b>Description:</b><br>
* Defines a QueueException, an Exception that describes the behaviors that may
* occur during runtime regarding queue operations.
* </p>
* <p>
*</p>
*@author Kevin Li
*/

public class QueueException extends Exception{

	public QueueException() {
		super("Queue Exception");
	}
	public QueueException(String msg) {
		super(msg);
	}
}
