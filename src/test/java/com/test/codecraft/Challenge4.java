package com.test.codecraft;

import java.util.ArrayList;
import java.util.Arrays;

public class Challenge4 {

	/**
	 * Given an array of size n, perform d left operations on the array and print
	 * the output.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int d = 6;
		Integer[] A = { 1, 2, 3, 4, 5 };
		Integer[] B = new Integer[A.length];
		ArrayList<Integer> ALOne = new ArrayList<>(Arrays.asList(A));
		System.out.println(ALOne);
		for (int i = 0; i < A.length; i++) {
			while(d>A.length) {
				d=d-A.length;
			}
			int newIndex = i-d;
			if(newIndex < 0) {
				newIndex = newIndex+A.length;
			}
			B[newIndex] = A[i];
		}
		ArrayList<Integer> ALTwo = new ArrayList<>(Arrays.asList(B));
		System.out.println(ALTwo);
	}
}
