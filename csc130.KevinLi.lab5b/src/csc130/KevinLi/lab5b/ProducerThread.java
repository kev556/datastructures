package csc130.KevinLi.lab5b;

/**
* <b>Title:</b> Lab 5b:<br>
* <b>Filename:</b> ProducerThread.java<br>
* <b>Date Written:</b> October 30, 2023<br>
* <b>Due Date:</b> November 4, 2023<br>
* <p>
* <b>Description:</b><br>
* Defines a ProducerThread, a Thread creating Customer Objects and adding them to a Queue
* simulating the line of a bank.
* </p>
* <br>
* <p>
*</p>
*@author Kevin Li & Racine Diop
*/

public class ProducerThread extends Thread {

	private ArrayQueue<Customer> line; // the line the customers wait in
	private long simulationTime; // how long to run the simulation
	private int averageArrivalTime; // average time to arrive at the bank
	private int count; // amount of customers produced after simulation time ends
	private final long STARTTIME = System.currentTimeMillis(); // time at thread creation
	
	public ProducerThread() {
	}
	/**
	 * @param aq	Queue the ProducerThread will enqueue into
	 * @param st	Time the ProducerThread will run.
	 * @param aat	Average arrival time between customer arrivals
	 */
	public ProducerThread(ArrayQueue<Customer> aq, long st, int aat) {
		line = aq;
		simulationTime = st;
		averageArrivalTime = aat;
	}
	/**
	 * 	Creates Customer objects, enqueuing them into a bank line
	 */
	@Override
	public void run() {
		try {
			// waits until bank is open
			sleep(10000);
		}
		catch(InterruptedException ie) {
			System.out.println(ie.getMessage());
		}
		
		while (System.currentTimeMillis() - STARTTIME < simulationTime) {
			try {
				// Creates the customer object to be added to the queue.
				Customer c = new Customer(count, System.currentTimeMillis());
				System.out.println("Customer " + c.getID() + " arrived at minute " + (c.getArrivalTime() - SimulationTime.getStartTime()) / 1000 + "\n");
				
				// If the queue is full, the customer will leave, or not be added to the queue. Else, they will be added.
				if (line.isFull())
					System.out.println("Queue is Full. Customer " + c.getID() + " left the bank.\n");
				else {
					line.enqueue(c);
					System.out.println("Customer " + c.getID() + " added to the queue.\n");
				}
				// Waits to create another Customer object.
				long waitTime = SimulationTime.timeTillNext(averageArrivalTime);
				sleep(waitTime);
				count++;
			}
			catch (QueueFullException qe) {
				System.out.println("Queue is Full!\n\n");
			}
			catch (InterruptedException ie) {
				System.out.println("Producer Thread was interrupted!\n\n");
			}
		}
		System.out.println("Thread has stopped. Number of customers produced: " + count + "\n");
	}

}
