package csc130.KevinLi.lab5b;

/**
* <b>Title:</b> Lab 5b:<br>
* <b>Filename:</b> Lab5SimApp.java<br>
* <b>Date Written:</b> October 30, 2023<br>
* <b>Due Date:</b> November 4, 2023<br>
* <p>
* <b>Description:</b><br>
* Hosts the main method testing the functionality of multiprocessing through use of Threads.
* Two BankTellerThread threads are created to process Customers created by ProducerThreads.
* </p>
* <br>
* <p>
*</p>
*@author Kevin Li & Racine Diop
*/

public class Lab5SimApp {

	public static void main(String[] args) {
		
		// Defines the number of values that must be passed through args
		final int VALUES = 5;
		int[] input = new int[VALUES];
		
		// declares the variables that will store the values passed through args
		int tellers;
		int queueSize;
		int avgArrivalTime;
		long simulationTime;
		
		// Defines the threads that will be used within the program
		ThreadGroup tg = new ThreadGroup("tellers");
		Thread[] teller = null;
		ProducerThread producer;
		ArrayQueue<Customer> queue;
		
		// Program will not run without 5 arguments
		if (args.length != VALUES) {
			System.out.println("Invalid input detected. Terminating program");
		}
		// Populates the array input with the arguments passed through args
		try {
			for (int i = 0; i < args.length; i++) {
				input[i] = Integer.parseInt(args[i]);
			}
		}
		catch (NumberFormatException nfe) {
			System.out.println("Invalid input detected. Terminating program");
		}
		
		// instantiates the arguments passed
		tellers = input[0];
		queueSize = input[1];
		avgArrivalTime = input[2] * 1000;
		
		// instantiates the queues and threads
		queue = new ArrayQueue<Customer>(queueSize);
		teller = new Thread[tellers];
		simulationTime = SimulationTime.minutesToMilisecs(input[4]);
		producer = new ProducerThread(queue, simulationTime, avgArrivalTime);
		
		System.out.println("Tellers are getting ready. The bank will open in 10 minutes...\n");
		
		SimulationTime st = new SimulationTime();
		
		// Begins production of customers
		producer.start();
		
		// Instantiates and starts the Bank Tellers and storing them into the Thread array teller.
		for (int i = 0; i < tellers; i++) {
			teller[i] = new Thread(tg, new BankTellerThread(i, queue, producer));
			teller[i].start();
		}
		
		// pauses the program until the producer stops creating customers
		while (producer.isAlive()) {
		}
		
		System.out.println("The Producer Thread has finished...\n");
		
		// pauses the program until all customers are handled
		while (tg.activeCount() > 0) {
			
		}
		// Notifies end of program
		System.out.println("The tellers have completed all transactions...\n");
		System.out.println("End of Program! \n");
		
	}

}
