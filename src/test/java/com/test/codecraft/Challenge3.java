package com.test.codecraft;

import java.util.ArrayList;

public class Challenge3 {

	/**
	 * Given two arrays of size N, with few common elements, create an array of their intersection.
	 * @param args
	 */
	public static void main(String[] args) {
		int[] A = {1,4,5,6,};
        int[] B = {6,3,1,7,9,10};
        ArrayList<Integer> AL = new ArrayList<>();
        
        for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				if(A[i] == B[j]) {
					if(AL.indexOf(A[i]) < 0) {
						AL.add(A[i]);
					}
				}
			}
		}
        System.out.println(AL);

	}

}
