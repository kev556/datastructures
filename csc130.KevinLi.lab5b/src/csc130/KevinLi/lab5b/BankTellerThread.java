package csc130.KevinLi.lab5b;

import java.util.Random;

/**
* <b>Title:</b> Lab 5b:<br>
* <b>Filename:</b> BankTellerThread.java<br>
* <b>Date Written:</b> October 30, 2023<br>
* <b>Due Date:</b> November 4, 2023<br>
* <p>
* <b>Description:</b><br>
* Defines a BankTellerThread, a Thread object whose purpose is to process Customer objects
* created by ProducerThread. 
* </p>
* <br>
* <p>
*</p>
*@author Kevin Li & Racine Diop
*/

public class BankTellerThread extends Thread {

	private int idNumber; // teller's id number
	private ArrayQueue<Customer> queue;// the queue for the customers
	private long startIdleTime = System.currentTimeMillis();// start of idle time
	private long endIdleTime = startIdleTime;// end of idle time
	private int count; // number of customers processed by this teller
	private ProducerThread producer; //the producer thread
	
	public BankTellerThread(int id, ArrayQueue<Customer> q , ProducerThread prod){

		idNumber = id;
		queue = q;
		producer = prod ;
	}
	/**
	 * Synchronously processes customers from the bank line (Queue). Processing is accomplished by dequeuing Customers from the queue. 
	 * After ProducerThread is done processing, BankTellerThread will process customers until there are 
	 * no customers.
	 */
	public void run() {

		while(producer.isAlive()) {
			if (!queue.isEmpty()) {			
				try {
					// Removes a customer from a queue and changes transaction, idle, and waiting times accordingly
					Customer c = queue.dequeue();	
					endIdleTime = System.currentTimeMillis();
					c.setTransactionStartTime(endIdleTime);
					
					// Defines a random number representing the time it takes to process a customer's transaction.
					Random rnd = new Random();			
					int random =  1000 + rnd.nextInt(14001);
					
					// Prints out the information showing the current status of the teller
					System.out.printf("Minute: %d\n\nTeller %d: [idle time: %d minutes, processing transaction for customer: %d]\n\n"
							,(System.currentTimeMillis() - SimulationTime.getStartTime()) / 1000, this.idNumber, (endIdleTime - startIdleTime) / 1000, c.getID());
					
					// Puts the teller to "sleep" simulating the time it takes to process a customer's transaction.
					sleep(random);
					
					// After the transaction is processed, updates transaction end time for the customer accordingly
					long cTime = System.currentTimeMillis();
					c.setTransactionEndTime(cTime);
					
					// Prints updated teller and customer statuses, and updates the number of customers this teller has served accordingly.
					System.out.printf("Minute: %d\nTeller %d: [idle time: %d minutes, processed: \n%s]\n\n"
							,(cTime - SimulationTime.getStartTime()) / 1000, this.idNumber, ((endIdleTime - startIdleTime) / 1000), c);
					count++;
					
					// Updates idle time for teller as it is no longer processing a customer. sleep added for fun.
					startIdleTime = System.currentTimeMillis();
					sleep(random / 4);
					
				}
				catch (QueueEmptyException qee) {
					System.out.printf("Queue is empty... Teller %d waiting for a customer\n\n", this.idNumber);
				}
				catch(InterruptedException ie) {
					System.out.println(ie.getMessage());
				}
			}
		}
		// updated teller status after all customers are processed
		System.out.printf("Teller %d shift complete. Customers served: %d \n", this.idNumber, count);

	}

}

