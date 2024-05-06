package dll;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Stack;

//Kevin Li N00969115

public class Test {

	public static void main(String[] args) {
		
        DoubleLinkedList<Person> pdll = new DoubleLinkedList<Person>();
        
        // Adds 5 Person objects to the doubly linked list
        pdll.addToRear(new Person("Kevin", "Li", "N00969115", "Computer Science"));
        pdll.addToRear(new Person("Johnny", "Appleseed", "N00969116", "Electrical Engineering"));
        pdll.addToRear(new Person("Seymour", "Butz", "N00969117", "Mathematics"));
        pdll.addToRear(new Person("Robin", "Banks", "N00969118", "Underwater Basket Weaving"));
        pdll.addToRear(new Person("Hugh", "Janus", "N00969119", "Underwater Computer Science"));
        
        // initializes variables necessary to retrieve and store user input
        Scanner scan = new Scanner(System.in);
        String banner;
        String lname;
        
        // obtains user input and stores it in said strings
        System.out.println("Please enter a Banner ID");
        banner = scan.nextLine();
        System.out.println("Please enter a last name");
        lname = scan.nextLine();
        
        // uses user input to create an object for the purpose of comparison
        Person correctPerson = new Person("", lname, banner, "");
        
        // uses enhanced for loop to iterate through the doubly linked list
        for (Person p: pdll) { 
        	// using defined equals method, determines equivalence for each object in pd11.
        	if (p.equals(correctPerson))
        		System.out.println(p);
        }
        scan.close();
	}
	
}
