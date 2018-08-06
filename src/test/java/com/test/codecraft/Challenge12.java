package com.test.codecraft;

import java.util.ArrayList;

public class Challenge12 {

	/**
	 * Given an array with size s and number of unique elements n where n < s, find
	 * the duplicate elements in the array and print them Note : Time complexity
	 * should be the least possible e.g. Input: Array a = 4,2,4,6,7,2,8 Size = 7
	 * Unique elements = 5 Output: 4 2
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = {4,2,4,6,7,2,8,4};
		ArrayList<Integer> AL = new ArrayList<>();
		for (int i = 0; i < a.length; i++) {
			int count = 1;
			for (int j = i+1; j < a.length; j++) {
				if(a[i] == a[j]) {
					count++;
				}
			}
			if (count > 1 && AL.indexOf(a[i]) < 0) {
				AL.add(a[i]);
			}
		}
		System.out.println(AL);
	}

}
