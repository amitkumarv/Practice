package com.test.codecraft;

public class SecLargestInArray {

	public static void main(String[] args) {
		int[] arr = {2,4,1,6,8,10,6};
		int f_largest = arr[0];
		int s_largest = arr[0];
		
		for (int i = 1; i < arr.length; i++) {
			if(arr[i] > f_largest) {
				s_largest = f_largest;
				f_largest = arr[i];
			}
		}
		System.out.println(s_largest);
	}

}
