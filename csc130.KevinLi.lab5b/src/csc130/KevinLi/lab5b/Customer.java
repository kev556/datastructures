package csc130.KevinLi.lab5b;

/**
* <b>Title:</b> Lab 5b:<br>
* <b>Filename:</b> Customer.java<br>
* <b>Date Written:</b> October 30, 2023<br>
* <b>Due Date:</b> November 4, 2023<br>
* <p>
* <b>Description:</b><br>
* Defines a Customer, an object simulating a bank customer and storing related 
* information such as time entered, wait time and transaction time.
* </p>
* <br>
* <p>
*</p>
*@author Kevin Li & Racine Diop
*/

public class Customer {
	private int number;
	private long transactionStartTime;
	private long arrivalTime;
	private long transactionEndTime;
	
	public Customer(int id, long atime) {
		number = id;
		arrivalTime = atime;
		
		
	}
	public int getID() {
		return number;
	}
	public long getArrivalTime() {
		return arrivalTime;
	}
	public long getTransactionStartTime() {
		return transactionStartTime;
	}
	public long getTransactionEndTime() {
		return transactionEndTime;
	}
	public long getWaitTime() {
		return (getTransactionStartTime() - getArrivalTime()) / 1000;
	}
	
	public void setArrivalTime(long at) {
		arrivalTime = at;
	}
	public void setTransactionStartTime(long tst) {
		transactionStartTime = tst;
	}
	public void setTransactionEndTime(long tet) {
		transactionEndTime = tet;
	}
	
	public String toString() {
		
		if (getTransactionStartTime() == 0 || transactionEndTime == 0) {
			return String.format("Customer: %1$d, entered the bank at minute %2$d", number, (arrivalTime - SimulationTime.getStartTime()) / 1000);
		}
		return String.format("Customer: %d, entered the bank at minute %d, [Transaction Time: %d mins, Wait Time: %d mins]"
				,number, (arrivalTime - SimulationTime.getStartTime()) / 1000, (transactionEndTime - transactionStartTime) / 1000, 
				getWaitTime());
	}
	
}
