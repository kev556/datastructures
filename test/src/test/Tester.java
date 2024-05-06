package test;

import java.util.Arrays;

public class Tester {

	public static void main(String[] args) {
		int[] arr = {7,3,5,1,9,8,6,4,2};
		
		selectionSort(arr);
		
		System.out.println(Arrays.toString(arr));
	}
	static void bubbleSort(int[] arr) {
		int temp;
		boolean swapped = false;
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				swapped = false;
				if (arr[j + 1] < arr[j]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					swapped = true;
				}
			}
			if (!swapped)
				break;
		}
	}
	static void selectionSort(int[] arr) {
		int si = 0, temp;
		
		for (int i = 0; i < arr.length - 1; i++) {
			si = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[si])
					si = j;
			}
			temp = arr[si];
			arr[si] = arr[i];
			arr[i] = temp;
		}
	}
	static void radixSort(int[] arr) {
		
	}
}
