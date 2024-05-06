package csc130.KevinLi.project3;

/**
* <b>Title:</b> Project3 <br>
* <b>Filename:</b> Arrival.java<br>
* <b>Date Written:</b> November 16, 2023<br>
* <b>Due Date:</b> November 19, 2023<br>
* <p>
* <b>Description:</b><br>
* Defines an Arrival Thread, a thread creating flights and adding them to a arrival queue.
* Arrival Threads have a delay after each creation based on a next mean time algorithm.
* </p> <br>
* <p>
*</p>
*@author Kevin Li
*/

public class Arrival extends Thread{
	private Queue<Airline> queue = new ArrayQueue<Airline>(); // The arrival queue
	private int time = 5000; // The time it takes for a flight to arrive
	private boolean running; // Whether the thread is running or not
	
	/**
	 * Arrival Constructor 
	 * @param t the time it will take for the flight to arrive
	 */
	public Arrival(int t) {
		time = t;
	}
	/**
	 * Queue accessor
	 * @return The memory location of the arrival queue 
	 */
	public Queue<Airline> getQueue() {
		return queue;
	}
	/**
	 * Accessor for time
	 * @return the time it takes for a flight to arrive
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
	 * returns the String representation of an Arrival thread
	 */
	public String toString() {
		
		if (running) 
			return String.format("Flights are currently running with an estimated arrival of %d seconds.", time / 1000);  
		else 
			return "Flights have stopped arrival.";
	}
	/**
	 * Creates flights and adds them to the arrival queue. Thread sleeps for a random time after each flight is added.
	 */
	public void run() {
		running = true;
		
		while (running) {
			try {
				Airline flight = new Airline();
				System.out.printf("Added flight %s to arrival queue\n", flight.getFlightID());
				queue.enqueue(flight);
				int nextTime = SimulationTime.timeTillNext(7000);
				System.out.println("Random time before next arrival: " + nextTime / 1000 + " minutes");
				sleep(nextTime);
			}
			catch (InterruptedException ie) {
				System.out.println("Arrival Interrupted");
			}
			catch (QueueFullException qee) {
				System.out.println("Too many flights in Departure Queue");
			}
		}
	}
}
