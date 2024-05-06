package lab0;

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
		
		Scanner scnr = new Scanner(System.in);
		
		System.out.print("Enter a number: ");
		int inputNumber = scnr.nextInt();
		
		int[] allNumbers = new int[inputNumber + 1];
		
		for (int i = 0; i <= inputNumber; i++) {
			allNumbers[i] = i;
		}
		
		//unreachableNumber is the "marker" for a non-prime number
		int unreachableNumber = inputNumber + 1;
		
		/* First loop declares p, the number used to multiply 
		 * by itself. p starts at 2 because it is the first prime number
		 * used to mark numbers in the Sieve of Eratosthenes.
		 * 
		 * @param  p  number used to multiply by itself to mark numbers as non prime
		 */		
		for (int p = 2; p * p <= inputNumber; p++) {
			if (allNumbers[p] != unreachableNumber) {
				/* Marks the result of p * p as non-prime, since the definition 
				* of a prime number is to be indivisible by any number 
				* other than itself and 1.
				* 
				* @param  primeResult  The result of p * p that will be non prime and 
				*         marked as such. Adding p to primeResult will result in yet
				*         another non prime multiple of p, until the largest number
				*         inputNumber is reached.
				*/
				for (int primeResult = p * p; primeResult <= inputNumber; primeResult += p) {
					allNumbers[primeResult] = unreachableNumber;
				}
					
			}
		}
		/* Loops through all values in allNumbers[] and prints them out,
		 * starting at 2 because 0 and 1 are not prime. All values equal
		 * to unreachableNumber are non prime.
		 */
		for (int i = 2; i < allNumbers.length; i++) {
			if (allNumbers[i] != unreachableNumber) {
				System.out.print(allNumbers[i] + " ");
			}
		}
		
	}
}		
		
