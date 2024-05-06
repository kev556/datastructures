package csc130.KevinLi.lab7;

/**
* <b>Title:</b> Lab 7:<br>
* <b>Filename:</b> Lab7App.java<br>
* <b>Date Written:</b> November 30, 2023<br>
* <b>Due Date:</b> December 2, 2023<br>
* <p>
* <b>Description:</b><br>
* Hosts the main method further testing File reading functionality, this time
* utilizing a LinkedList.
* <br>
* Includes a Scanner section where user can interact with program to obtain desired COVID-19 information.
* </p>
* <p>
*</p>
*@author Kevin Li
*/

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.time.LocalDate;
import java.util.Scanner;

public class Lab7App {
	public static void main(String[] args) {
		LinkedList<CovidCase> cases = new LinkedList<CovidCase>();
		File data = new File("WHO-COVID-19-global-data.csv");
		Scanner s;
		String[] vals;
		LocalDate lastDate = LocalDate.parse("2023-11-22");
		String nextFlag = "c";
		CovidCase search = null;
		
		// Creates a file if a file does not yet exist
		if (!data.exists())
			createFile();
		try {
			s = new Scanner(data);
			s.nextLine();
			
			// Splits the line by , or any extra delimiter that may scramble results
			while (s.hasNextLine()) {
				vals = s.nextLine().split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
				
				// ignores all cases not on 2023-11-22
				if (LocalDate.parse(vals[0]).equals(lastDate))
					cases.add(new CovidCase(vals));
			}
			// Enters a user input section where users can search for Covid statistics by country.
			System.out.println(cases);
			s = new Scanner(System.in);
			while (!nextFlag.equals("Q")) {
				
				try {
					System.out.println("\nEnter a country code to display COVID cases");
					nextFlag = s.nextLine().toUpperCase().trim();
					
					// creates an "equivalent" object and grabs it from the LinkedList via both indexOf and get.
					search = new CovidCase(lastDate, nextFlag, nextFlag, 0, 0, 0, 0);
					search = cases.get(cases.indexOf(search));
					
					System.out.printf("\nCOVID-19 Data for %s \nCases Today: %d \nDeaths Today: %d \nCumulative Cases to date: %d \nCumulative Cases to date: %d\n"
							,search.getCountry(), search.getNewCases(), search.getNewDeaths(), search.getCumulativeCases(), search.getCumulativeDeaths());
				}
				catch (RuntimeException re) {
					if (nextFlag.equals("Q"))
						System.out.println("Terminating program");
					else
						System.out.println("Could not locate country or country code. Please reenter.");
				}
			}
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
	}
	/**
	 * Recycled from Lab6b. Creates a file if a file is yet to be created.
	 * Reads data from the who Covid-19 website and writes it to the csv to be read by the main method.
	 */
	public static void createFile() {
		// 1. Declare variables
		// "WHO-COVID-19-global-data.csv"
		Scanner s = null;
		PrintWriter pw = null;
		File file = new File("WHO-COVID-19-global-data.csv");
		String u = "https://covid19.who.int/WHO-COVID-19-global-data.csv";
		// 2. Create a try/catch block to download the data from the URL above
		try {
			pw = new PrintWriter(file);
			s = new Scanner(new URL(u).openStream());
			
			// 3. Write the contents to a file called WHO-COVID-19-global-data.csv
			while (s.hasNextLine()) {
				pw.println(s.nextLine());
			}
		}
		catch(IOException ioe) {
			System.out.println("Error creating file, aborting");
			System.exit(1);
		}
	}
}
