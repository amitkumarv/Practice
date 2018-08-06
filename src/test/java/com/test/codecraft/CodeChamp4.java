package com.test.codecraft;

import java.util.ArrayList;

public class CodeChamp4 {

	public static int Consonant(String input1, int input2) {
		
		int minLengthSubStr = input2;
		int beginIndex = 0;
		int count;
		ArrayList<String> ALS = new ArrayList<>();
		
		while (minLengthSubStr <= input1.length()) {
			String subStr = input1.substring(beginIndex, minLengthSubStr);
			ALS.add(subStr);
			char[] charArr = subStr.toCharArray();
			count = 0;
			for (int i = 0; i < charArr.length; i++) {
				if (charArr[i] != 'a' && charArr[i] != 'e' && charArr[i] != 'i' && charArr[i] != 'o'
						&& charArr[i] != 'u') {
					count++;
				}
			}
			if (count < input2) {
				beginIndex = 0;
				minLengthSubStr++;
				ALS.clear();
			}  else if (count >= input2) {
				beginIndex++;
				minLengthSubStr++;
			} 
		}
		System.out.println(ALS);
		if(ALS.size() == 0) {
			return -1;
		} else {
			return ALS.get(0).length();
		}
	}

	public static void main(String[] args) {
		System.out.println(Consonant("dgfgdhfghdfghdfaghghgaghghgaghgh", 1));
	}

}
