package csc130.KevinLi.project3;

/**
* <b>Title:</b> Project3 <br>
* <b>Filename:</b> Project3.java<br>
* <b>Date Written:</b> November 16, 2023<br>
* <b>Due Date:</b> November 19, 2023<br>
* <p>
* <b>Description:</b><br>
* Hosts the main method testing the functionality of multiprocessing through use of Threads.
* </p> <br>
* <p>
* Threads are used to simulate an airport runway.
* Three Threads are utilized in this simulation, two to create flights for departure and arrival,
* and the last to process arrival and departure. 
* Priority is given to arrivals, as flights have limited fuel capacity upon entering.
*</p>
*@author Kevin Li
*/

public class Project3 {
	
	public static void main(String[] args) {
		// Declares the Threads
		Arrival arrival = new Arrival(SimulationTime.LANDING_TIME);
		Departure departure = new Departure(SimulationTime.TAKEOFF_TIME);
		Runway runway = new Runway(arrival, departure);
		
		// Creates the Project3 object necessary to use the startSimulation method
		Project3 project = new Project3();
		
		// Starts the simulation for 5 real world minutes
		project.startSimulation(arrival, departure, runway, 5);
		
		// Pauses the program until both arrival and departure stop running
		while (arrival.isAlive() || departure.isAlive()) {
			
		}
		// Prints the state of arrival and departure, then finally stops runway
		System.out.printf("%s\n%s", arrival, departure);
		runway.stopRunning();
		
	}
	public Project3() {
		
	}
	public void startSimulation(Arrival arrival, Departure departure, Runway runway, long time) {
		
		//Starts all threads
		arrival.start();
		departure.start();
		runway.start();
		
		// Pauses the program before time minutes has passed since simulation start
		while (System.currentTimeMillis() < SimulationTime.getStartTime() + (time * 60000)) {
			
		}
		//Stops all threads
		arrival.stopRunning();
		departure.stopRunning();
		runway.stopRunning();
		
		//Interrupts all threads
		arrival.interrupt();
		departure.interrupt();
		runway.interrupt();
		
		//Waits for all threads to stop
		try {
			arrival.join();
			departure.join();
			runway.join();
		}
		catch (InterruptedException ie) {
			System.out.println("Shutdown interrupted");
		}
	}
}
