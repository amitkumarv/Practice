package com.test.codecraft;

import java.util.ArrayList;
import java.util.Arrays;

public class Challenge2 {

	/**
	 * Given two arrays of size N, create an union of both, sort the final array and
	 * print it.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] A = { 1, 4, 5, 6 };
		Integer[] B = { 10, 20, 6, 82, 50, 22 };
		
		ArrayList<Integer> AL = new ArrayList<Integer>(Arrays.asList(B));
		for (int i = 0; i < A.length; i++) {
			if(AL.indexOf(A[i]) < 0) {
				AL.add(A[i]);
			} else {
				continue;
			}
		}
		
		System.out.println(AL);
		boolean isNotSorted = true;
		while (isNotSorted) {
			for (int i = 0; i < AL.size() - 1; i++) {
				int AX = AL.get(i);
				int BX = AL.get(i + 1);
				if (BX < AX) {
					AL.remove(i);
					AL.remove(i);
					AL.add(i, BX);
					AL.add(i + 1, AX);
				}
				System.out.println(AL);
			}
			isNotSorted = checkSorted(AL);
		}

	}

	private static boolean checkSorted(ArrayList<Integer> aL) {
		boolean isNotSorted = true;
		for (int i = 0; i < aL.size()-1; i++) {
			if(aL.get(i) < aL.get(i+1)) {
				isNotSorted = false;
			} else {
				isNotSorted = true;
				break;
			}
		}
		return isNotSorted;
	}

}
