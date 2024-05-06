package ht;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * 	Kevin Li N00969115
 */

public class Main {

	public static void main(String[] args) {
		
		SimpleHashTable<Lastname, Person> ht = new SimpleHashTable<Lastname, Person>();
		
		// Creates the file object to be read from
		File data = new File("MOCK_DATA.csv");
		Scanner s;
		String temp[] = null;
		
		// Try block reads in every value in the CSV and puts it into temp[]
		try {
			s = new Scanner(data);
			
			while (s.hasNextLine()) {
				// Splits the line by "," firstname goes into [0], lastname goes to [1], email goes to [2]
				temp = s.nextLine().split(",");
				Lastname ln = new Lastname(temp[1]);
				
				// Puts the two values into a SimpleEntry object and adds it to the hashtable
				ht.put(ln, new Person(temp[0], temp[2], ln));
			}
		}
		catch (IOException ioe){
			ioe.printStackTrace();
		}
		
		System.out.println(ht);
	}

}
