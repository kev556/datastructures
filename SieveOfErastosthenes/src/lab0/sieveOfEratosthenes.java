package lab0;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
* <b>Title:</b> Lab 0:<br>
* <b>Filename:</b> sieveOfEratosthenes.java<br>
* <b>Date Written:</b> September 9, 2023<br>
* <b>Due Date:</b> September 10, 2023<br>
* <p>
* <b>Description:</b><br>
* Displays prime numbers using The Sieve of Eratosthenes.
* </p>
* <p>
* The user is permitted to enter a value for n, and then all prime numbers
* in the range 2 to n are displayed.
* </p>
* <p><b>Algorithm:</b></p>
* <p>
* We start with a table of numbers (e.g., 2, 3, 4, 5, . . ., n) and progressively
* cross off numbers in the table until the only numbers left are primes. </p>
* <p>Specifically, we begin with the first number, p, in the table, and<br>
* 1. Declare p to be prime, then display it<br>
* 2. Cross off all the multiples of that number in the table, starting from p^2<br> * 3. Find the next number in the table after p that is not yet crossed off and
* set p to that number; and then repeat steps 1 to 3.
*</p>
*@author Brandon Kenney & Kevin Li
*/

public class sieveOfEratosthenes {
	
	public static void main(String[] args) {
		
		int[][] newArr = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
		
		System.out.println(contains1toN(newArr, 10));
		
	}
	public static boolean contains1toN(int[][] nArr, int n) {
		boolean[] boolArr = new boolean[n];
		
		for (int i = 0; i < boolArr.length; i++) {
			boolArr[i] = false;
		}
		
		for (int i = 1; i <= n; i++) {
			for (int r = 0; r < nArr.length; r++) {
				for (int c = 0; c < nArr[0].length; c++) {
					if (nArr[r][c] == i) {
						boolArr[i - 1] = true; 
					}
				}
			}
		}
		
		for (int i = 0; i < boolArr.length; i++) {
			if (boolArr[i] == false) {
				return false;
			}
		}
		return true;
		
	}
	public static boolean contain1toN(int[][] nArr, int n) {
		
		int sum = 0;
		
		for (int r = 0; r < nArr.length; r++) {
			for (int c = 0; c < nArr[0].length; c++) {
				sum += nArr[r][c];
			}
		}
		if (sum == (Math.pow((double)1 , 4.0))) {
			return true;
		}
		else {
			return false;
		}
		
	}
}		
		
