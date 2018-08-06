package com.test.codecraft;

public class Challenge1 {

	/**
	 * For an array of size N, print the numbers in a given list in reverse order.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] A = { 1, 4, 5, 6 };
		for (int i = A.length-1; i >= 0; i--) {
			System.out.print(A[i]+",");
		}

	}

}
