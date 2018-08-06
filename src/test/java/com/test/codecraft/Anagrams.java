package com.test.codecraft;

import java.util.Arrays;

public class Anagrams {

	public static void main(String[] args) {
		String str1 = "Mary";
		String str2 = "Army";
		if(str1.length() == str2.length()) {
			char[] arr1 = str1.toUpperCase().toCharArray();
			char[] arr2 = str2.toUpperCase().toCharArray();
			Arrays.sort(arr1);
			Arrays.sort(arr2);
			if(Arrays.equals(arr1, arr2)) {
				System.out.println("Anagram");
			} else {
				System.out.println("Not an anagram");
			}
		} else {
			System.out.println("Not an anagram");
		}
	}
}
