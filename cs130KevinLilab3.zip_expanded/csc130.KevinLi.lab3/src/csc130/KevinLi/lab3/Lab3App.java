package csc130.KevinLi.lab3;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.FileWriter;
import java.io.IOException;

/**
* <b>Title:</b> Lab 3<br>
* <b>Filename:</b> Lab3App.java<br>
* <b>Date Written:</b> October 3, 2023<br>
* <b>Due Date:</b> October 4, 2023<br>
* <p>
* <b>Description:</b><br>
* Creates a Date object representing a date on a calendar, with parameters Month, Day, and Year.
* </p>
* <br>
* Special cases, such as leap years and invalid months, like a month beyond 12, 
* or a day beyond 31, and leap years are taken into consideration and handled appropriately.
  <br>
* <p>
* </p>
* 
*@author Kevin Li
*/

public class Lab3App {

	public static void main(String[] args){
		
		// Allows for user input. Users are asked to enter the Month, Day, and Year.
		Scanner scanner = new Scanner(System.in);
		
		// Initializes and assigns the variables as needed for the loop to work on
		Date aDate = new Date();
		int month;
		int day;
		int year;
		boolean done = false;
		
		/**
		 * 	Asks user to input a month. If the user inputs a number outside of 1 - 12 inclusive or a non-number,
		 * 	an exception is handled gracefully and they will be asked to input a valid number instead.
		 */
		while (!done) {
			try {
				System.out.println("Enter the month as an integer:");
				month = scanner.nextInt();
				aDate.setMonth(month);
						
				done = true;
			}
			catch (DateException de) {
				System.out.println(de.getMessage());
				scanner.nextLine();
			}
			catch (InputMismatchException ime) {
				System.out.println("Invalid input entered.");
				scanner.nextLine();
			}
		}
		/**
		 * 	Asks user to input a day. If the user inputs a number outside of 1 - 31 inclusive or a non-number,
		 * 	an exception is handled gracefully and they will be asked to input a valid number instead.
		 * 
		 * 	Another loop is created to avoid forcing the user to reenter the month when an invalid day 
		 * 	is entered.
		 */
		done = false;
		while (!done) {
			try {
				System.out.println("Enter the day as an integer:");
				day = scanner.nextInt();
				aDate.setDay(day);
						
				done = true;
			}
			catch (DateException de) {
				System.out.println(de.getMessage());
					
				scanner.nextLine();
			}
			catch (InputMismatchException ime) {
				System.out.println("Invalid input entered.");
				scanner.nextLine();
			}
		}
		/**
		 * 	Asks user to input a year. If the user inputs a number smaller than 1752
		 * 	for the purpose of the program or a non-number,
		 * 	an exception is handled gracefully and they will be asked to input a valid number instead.
		 * 
		 * 	Another loop is created to avoid forcing the user to reenter the month and day when an invalid day is entered.
		 */
		done = false;
		while (!done) {
			try {
				System.out.println("Enter the year as an integer:");
				year = scanner.nextInt();
				aDate.setYear(year);
						
				done = true;
			}
			catch (DateException de) {
				System.out.println(de.getMessage());
				scanner.nextLine();
			}
			catch (InputMismatchException ime) {
				System.out.println(ime.getMessage());
				scanner.nextLine();
			}
		}
		// Prints the Date object 
		System.out.println(aDate);
	}
}