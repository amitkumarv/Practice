package com.test.codecraft;

import java.util.HashMap;

public class Challenge6 {

	/**
	 * Given an array of N strings, which has repeating strings, print the
	 * occurrences of the string. e.g. N = 6 A = {‘abc’, ‘cdcd’,
	 * ‘24242’,’cdcd’,’24242’,’xyz’)
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String[] A = { "abc", "cdcd", "24242", "cdcd", "24242", "xyz" };
		HashMap<String, Integer> HM = new HashMap<>();
		for (int i = 0; i < A.length; i++) {
			int count = 1;
			if (!HM.containsKey(A[i])) {
				for (int j = i + 1; j < A.length; j++) {
					if (A[i].equals(A[j])) {
						count = count + 1;
					}
				}
				HM.put(A[i], count);
			}
		}
		System.out.println(HM);
	}

}
