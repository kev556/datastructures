package csc130.KevinLi.project3;
import java.lang.Math;

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

public class Airline {
	private String flightID; // The flight ID of the individual flight
	private final long STARTTIME = System.currentTimeMillis(); // The time which the flight was created
	
	/**
	 * Randomly assigns a alphabetical flight ID accessing the AIRLINES array based 
	 * on the randomly generated index. A random number from 10 to 200 is appended to the flight ID.
	 */
	public Airline() {
		flightID = SimulationTime.AIRLINES[(int)(Math.random() * 18)] + (int)((Math.random() * 191) + 10);
		
	}
	/**
	 * Creates a flight with a predetermined flight ID. Not used in this program.
	 * @param f name of the flight passed as an argument.
	 */
	public Airline(String f) {
		flightID = f;
	}
	/**
	 * 
	 * @return The time the flight was created
	 */
	public long getStartTime() {
		return STARTTIME;
	}
	public String getFlightID() {
		return flightID;
	}
	/**
	 * Returns the flight in its String representation.
	 */
	public String toString() {
		return flightID + " arrived at time " + (STARTTIME - SimulationTime.getStartTime()) / 1000;
	}
}
