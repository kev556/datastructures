package csc130.KevinLi.project3;

/**
* <b>Title:</b> Project3 <br>
* <b>Filename:</b> Runway.java<br>
* <b>Date Written:</b> November 16, 2023<br>
* <b>Due Date:</b> November 19, 2023<br>
* <p>
* <b>Description:</b><br>
* Defines a Runway Thread, a thread dequeuing airlines from arrival and departure queues.
* Runways have a delay after each takeoff and landing based on whether they are taking off or landing.
* Priority is given to arrivals, as flights have limited fuel capacity upon entering.
* </p> <br>
* <p>
*</p>
*@author Kevin Li
*/

public class Runway extends Thread{
	private Arrival arrival; // The arrival thread
	private Departure departure; // The departure thread
	private boolean running; // The running state of the runway thread
	
	/**
	 * Parameterized Constructor
	 * @param arrive Arrival Thread
	 * @param depart Departure Thread
	 */
	public Runway(Arrival arrive, Departure depart) {
		arrival = arrive;
		departure = depart;
	}
	public void stopRunning() {
		running = false;
	}
	public String toString() { 
		return "Arrival: " + arrival + "Departure: " + departure + "Running: " + running;
	}
	/**
	 * Runs the thread. Thread cyclically removes flights from arrival and departure queues.
	 */
	public void run() { 
		running = true;
		while (running) { 
			try {
				while (!arrival.getQueue().isEmpty()) {
					// removes flight from arrival queue
					Airline temp = arrival.getQueue().dequeue();
					
					// prints a message containing flight information, and puts thread to sleep simulating flight landing time
					System.out.printf("Flight %s cleared for landing - Entered queue at %d - waited %d minutes\n", 
							temp, (temp.getStartTime() - SimulationTime.getStartTime()) / 1000, (System.currentTimeMillis() - temp.getStartTime()) / 1000);
					sleep(arrival.getTime());
				}
				while (!departure.getQueue().isEmpty()) {
					// breaks the departure loop to process arrivals if arrival queue is too big
					if (arrival.getQueue().getSize() > 5)
						break;
					// removes flight from departure queue
					Airline temp = departure.getQueue().dequeue();
					
					// prints a message containing flight information, and puts thread to sleep simulating flight takeoff time
					System.out.printf("Flight %s cleared for takeoff - Entered queue at %d - waited %d minutes\n", 
							temp, (temp.getStartTime() - SimulationTime.getStartTime()) / 1000, (System.currentTimeMillis() - temp.getStartTime()) / 1000);
					sleep(departure.getTime());
				}
			}
			catch (InterruptedException ie) {
				System.out.println("Runway Interrupted");
			}
			catch (QueueEmptyException qee) {
				System.out.println("Queue Empty");
			}
		}
		
	}
}
