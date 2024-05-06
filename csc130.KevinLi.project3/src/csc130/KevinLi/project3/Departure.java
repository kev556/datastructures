package csc130.KevinLi.project3;

/**
* <b>Title:</b> Project3 <br>
* <b>Filename:</b> Departure.java<br>
* <b>Date Written:</b> November 16, 2023<br>
* <b>Due Date:</b> November 19, 2023<br>
* <p>
* <b>Description:</b><br>
* Defines a Departure Thread, a thread creating flights and adding them to a departure queue.
* Departure Threads have a delay after each creation based on a next mean time algorithm.
* </p> <br>
* <p>
*</p>
*@author Kevin Li
*/

public class Departure extends Thread {
	private Queue<Airline> queue = new ArrayQueue<Airline>(); // The departure queue
	private int time = 4000; // The time it takes for a flight to depart
	private boolean running; // Whether the thread is running or not
	
	/**
	 * Constructor
	 * @param t The time it takes for a flight to depart
	 */
	public Departure(int t) {
		time = t;
	}
	/**
	 * Accessor for Departure queue
	 * @return
	 */
	public Queue<Airline> getQueue() {
		return queue;
	}
	/**
	 * Accessor for time
	 * @return The time it takes for a flight to depart
	 */
	public int getTime() {
		return time;
	}
	/**
	 * Changes running to false, stopping the thread
	 */
	public void stopRunning() {
		running = false;
	}
	/**
	 * returns the String representation of a Departure thread
	 */
	public String toString() {
		
		if (running) 
			return String.format("Flights are currently running with an estimated takeoff of %d seconds.", time / 1000);  
		else 
			return "Flights have stopped departing.";
	}
	/**
	 * Creates flights and adds them to the departure queue. Thread sleeps for a random time after each flight is added.
	 */
	public void run() {
		running = true;
		
		while (running) {
			try {
				Airline flight = new Airline();
				System.out.printf("Added flight %s to departure queue\n", flight.getFlightID());
				queue.enqueue(flight);
				int nextTime = SimulationTime.timeTillNext(7000);
				System.out.println("Random time before next departure: " + nextTime / 1000 + " minutes");
				sleep(nextTime);
				
			}
			catch (InterruptedException ie) {
				System.out.println("Departure Interrupted");
			}
			catch (QueueFullException qee) {
				System.out.println("Too many flights in departure queue");
			}
		}
	}
	
}
