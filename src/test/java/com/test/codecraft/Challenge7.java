package com.test.codecraft;

public class Challenge7 {

	/**
	 * Given an array of characters formed with a’s and b’s. And X represents the
	 * middle of the list with the same characters in mirror sequence on either side
	 * of the X. Check if the string is balanced. e.g. Input String sequence =
	 * “abababababXbababababa”
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "abababababXbababababa";
		String[] strArray = str.split("[X]");

		System.out.println(strArray[0]);
		System.out.println(strArray[1]);

		StringBuffer sb = new StringBuffer(strArray[1]);
		strArray[1] = sb.reverse().toString();

		if (strArray[0].equals(strArray[1])) {
			System.out.println("String is balanced");
		} else {
			System.out.println("String is not balanced");
		}

	}

}
