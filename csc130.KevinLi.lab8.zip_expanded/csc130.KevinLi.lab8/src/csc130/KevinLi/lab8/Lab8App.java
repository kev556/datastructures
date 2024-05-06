package csc130.KevinLi.lab8;

import java.io.File;

/**
* <b>Title:</b> Lab 8:<br>
* <b>Filename:</b> Lab8App.java<br>
* <b>Date Written:</b> December 7, 2023<br>
* <b>Due Date:</b> December 9, 2023<br>
* <p>
* <b>Description:</b><br>
* Hosts the main method testing a variety of recursive methods.
* </p>
* <p>
*</p>
*@author Kevin Li & Adam Alssaidi
*/

public class Lab8App {
	public static final char[] table = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
	public static void main(String[] args) {
		Lab8App recursion = new Lab8App();
		System.out.println(recursion.strToNum("12341"));
		System.out.println(recursion.findMin(new int[] {3,2,1,4,5}, 5, 0));
	 	System.out.println(recursion.isPalindrome("racecar", 0, 6));
		System.out.println(recursion.reverseString("pots&pans"));
		traverse(new File("J:/")); 
		
		LinkedList<String> ulist = new LinkedList<String>(); 
		String[] str = {"hello","this","is","a","test"};
		for(String s : str)
			ulist.insert(s);
		System.out.println(ulist);
		Node<String> node = ulist.getfront();
		System.out.println(recursion.countNodes(node));
		
		System.out.println("======================"); 
		System.out.println("Start of lab 8"); 
		System.out.println("======================"); 
		System.out.println(hanoi(31));
		System.out.println("Sum(1 to 8) = " + sum(1, 8)); 
		System.out.println("Sum(1 to 7) = " + sum(1, 7)); 
		System.out.println("Sum(1 to 5) = " + sum(1, 5)); 
		System.out.println("3^2 = " + pow(3,2)); 
		System.out.println("2^16 = " + pow(2,16)); 
		// convert 12 to base 16 – result should be C 
		System.out.println("12 in base 16 = " + convert(12,16)); 
		System.out.println("12 in base 2 = " + convert(12,2));  
		System.out.println("511 in base 16 = " + convert(511,16)); 
		System.out.println("65535 in base 16 = " + convert(65535,16));
		
		printListReverse(ulist.head.getNext());
	}
	public int strToNum(String str) { 
		if(str.length() < 1) 
			return 0; 
		else 
			return ((str.charAt(str.length() - 1) - '0') + (10 * strToNum(str.substring(0, str.length() - 1)))); 
	}
	private <T> int countNodes(Node<T> trav){ 
		if(trav == null) 
			return 0; 
		return 1 + countNodes(trav.getNext()); 
	}
	public int findMin(int array[], int size, int index) { 
		if(index == size - 1) 
			return array[index]; 
		int result = findMin(array, size, index + 1); 
		if (array[index] < result) 
			return array[index]; 
		else 
			return result; 
	}
	public boolean isPalindrome(String str, int low, int high) { 
		if(high <= low) 
			return true; 
		else if (str.charAt(low)!= str.charAt(high)) 
			return false; 
		else 
			return isPalindrome(str,low+1,high-1); 
	}
	public String reverseString(String s){ 
		if(s.length() == 0) 
			return s; 
		return reverseString(s.substring(1)) + s.charAt(0); 
	}
	public static void traverse(File file) { 
		if(file.isDirectory()) { 
			System.out.println(file); 
			String dirContents[] = file.list(); 
			if (dirContents != null) 
				for (String directory : dirContents) 
					traverse(new File(file, directory)); 
		} 
	}
	/**
	 * 
	 * @param discs number of discs in a hanoi game
	 * @return number of times discs must be moved to finish the game
	 */
	public static long hanoi(long discs){ 
		long times = 0;
		for (long x = 1L; x < (1L << discs); x++) { 
			long from = (x & x - 1L) % 3L; 
			long to = ((x | x - 1L) + 1L) % 3L;
			times++;
		}
		return times;
	}
	public static int sum(int num) { 
		int result; 
		if(num == 1) 
			result = 1; 
		else result = num + sum(num - 1); 
		return result; 
	}
	/*
	 * 1. Modify the method that calculates the sum of the integers between 1 and N 
	 * shown above. Have the new version match the following recursive definition: 
	 * The sum of 1 to N is the sum of 1 to (N/2) plus the sum of (N/2 + 1) to N. 
	 * Trace your solution using an N of 7.
	 */
	/**
	 * 
	 * @param left 1
	 * @param right the number to add up to
	 * @return the sum of 1 to right
	 */
	public static int sum(int left, int right) {
		// base case, if numbers are adjacent numbers, adds them to obtain sum
		if (left == right - 1)
			return left + right;
		// base case, if numbers are equivalent, returns the number
		else if (left == right)
			return left;
		// recursive case, adds all of the sums to be returned later
		else return sum(left,(left + right)/2) + sum(((left + right)/2) + 1, right);
	}
	/**
	 * 2. Modify the method, above, and produce an Excel chart showing the number of moves required
	 * to solve the Towers of Hanoi puzzle using the following number of discs:
	 * 2, 3, 4, 5, 6, 7, 8, 9, 10, 15, 20, 30, and 31.
	 * 
	 */
	
	/*
	 * 3. Write a recursive definition of x^y, where x and y are integers and y >= 0. 
	 * In addition, write the recursive method.
	 */
	/**
	 * Recursively calculates x to the power of y
	 * @param x number to be raised to the power of y
	 * @param y power for number to be raised to 
	 * @return x raised to the power of y
	 */
	public static int pow(int x, int y) {
		// base case, returns 1;
		if (y == 0) 
			return 1;
		// recursive case. returns x * x^(y - 1 / 2) * x^(y - 1 / 2), mathematically equivalent to x^y
		else if (y > 0 && y % 2 == 1)
			return (x * pow(x,(y - 1) / 2) * pow(x,(y - 1) / 2));
		// recursive case. returns x * x^(y / 2) * x^(y / 2), mathematically equivalent to x^y
		else
			return pow(x, y / 2) * pow(x, y / 2);
	}
	/*
	 * 4. Write a recursive method to display the contents of a linked-list in reverse order.
	 */
	/**
	 * Prints all values of a linked list in reverse order
	 * @param head first node of linkedlist (after dummy node)
	 */
	public static void printListReverse(Node<String> head) {
		
		// base case, quits method when there are no values left in linked list
		if (head == null)
			return;
		// recursively calls printListReverse until head is null
		printListReverse(head.getNext());
		// only prints after all printListReverse calls are exhausted, starting at most recent call
		System.out.println(head.getData());
	}
	/*
	 * 5. Write a recursive method to convert a number, n, to a base, b, and return result as a String.
	 */
	/**
	 * Converts a number from base 10 to a different base etc. Binary, Octal, Hexadeximal
	 * @param num number in base 10 to be converted
	 * @param base base of new number
	 * @return equivalent number in new base 
	 */
	public static String convert(int num, int base) {
		// error prevention, cannot convert number beyond base 16 (lack of characters)
		if (base > 16)
			return "";
		// base case, returns the number itself, as it is already in decimal form
		if (base == 10)
			return "" + num;
		// base case, returns 0 if number is 0, as 0 is 0 universally
		if (num == 0)
			return "";
		/* recursive case, recursively returns number divided by the base to obtain the new number, followed by 
		 * table at index [num modulus base], as it will obtain the equivalent number up to 16 in hexadecimal.
		 * Placing convert before table will show the number from right to left as intended.
		 */
		else return convert(num / base, base) + table[num % base];
	}
}
class Node<E>{
	private E data;
	private Node<E> next;
	
	public Node(){
		data = null;
		next = null;
	}
	public Node(E d){
		data = d;
		next = null;
	}
	public Node(E d, Node<E> n){
		data = d;
		next = n;
	}
	public Node<E> getNext(){
		return next;
	}
	public void setNext(Node<E> n){
		next = n;
	}
	public E getData() {
		return data;
	}
	public void setData(E data) {
		this.data = data;
	}		
}
class LinkedList<T extends Comparable<T>>{
	
	protected Node<T> head = new Node<T>(); // dummy Node
	protected int numItems;
	
	public Node<T> getfront(){
		return head.getNext();
	}
	public int getSize(){
		return numItems;
	}
	public boolean isEmpty(){
		return numItems == 0;
	}
	public void insert(T insertItem) {
		if(insertItem == null)
			throw new   NullPointerException();
		Node<T> trav = head;
		while(trav.getNext() != null)
			trav = trav.getNext();
		trav.setNext(new Node<T>(insertItem));
		++numItems;
	}
	public String toString(){
		String str = "\n==================================\n"
				+ "The list contains " + numItems + " items.\n"
				+ "==================================\n[";
		Node<T> trav = head.getNext();
		while(trav != null){
			// str += trav.data + "\n"; 
			str += trav.getData() + ((trav.getNext() == null) ? "" : "->");
			trav = trav.getNext();
		}
		return str + "]";
	}
}