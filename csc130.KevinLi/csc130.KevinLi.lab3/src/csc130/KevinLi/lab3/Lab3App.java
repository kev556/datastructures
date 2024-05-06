package csc130.KevinLi.lab3;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Lab3App {

	public static void main(String[] args){
		
		Scanner scanner = new Scanner(System.in);
		
		Date aDate; 
		int month;
		int day;
		int year;
		boolean done = false;
		
		while (!done)
			try {
				System.out.println("Enter the month as an integer:");
				month = scanner.nextInt();
				
				System.out.println("Enter the day as an integer:");
				day = scanner.nextInt();
				
				System.out.println("Enter the year as an integer:");
				year = scanner.nextInt();
				
				aDate = new Date(month, day, year);
				
				done = true;
			}
			catch (InputMismatchException ime) {
				System.out.println("Invalid input entered. Enter an integer.");
				scanner.nextLine();
			}
		if ()
		
	}

}
