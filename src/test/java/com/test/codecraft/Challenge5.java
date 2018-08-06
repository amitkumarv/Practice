package com.test.codecraft;

import java.util.Stack;

public class Challenge5 {

	/**
	 * Given two number stacks of equal size N, create a new stack of size 2N and
	 * arrange the numbers in an order such that the lowest number is at the peek.
	 * e.g. Input Stack A = {2,39,6, 62, 27} Stack B = {100,37, 53, 28, 1000} Output
	 * Stack AB = Bottom -> {1000, 100,62,53,39,37,28,27,6,2}
	 * 
	 * @param args
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Stack<Integer> A = new Stack<>();
		A.push(2);
		A.push(39);
		A.push(6);
		A.push(62);
		A.push(27);
		System.out.println(A);
		Stack<Integer> B = new Stack<>();
		B.push(100);
		B.push(37);
		B.push(53);
		B.push(28);
		B.push(1000);
		System.out.println(B);
		Stack<Integer> AB = new Stack<>();
		while (A.size() > 0) {
			AB.push(A.pop());
			AB.push(B.pop());
		}
		System.out.println(AB);
		boolean isNotSorted = true;
		
		while (isNotSorted) {
			Stack<Integer> temp = new Stack<>();
			while (AB.size() > 0) {
				int a = AB.pop();
				int b = 0;
				if (AB.size() > 0) {
					b = AB.pop();
				} else {
					temp.push(a);
					break;
				}
				if (a > b) {
					temp.push(a);
					AB.push(b);
				} else if (b > a) {
					temp.push(b);
					AB.push(a);
				} else {
					temp.push(a);
					AB.push(b);
				}
			}
			Stack<Integer> temp2 = (Stack<Integer>) temp.clone();
			while (temp.size() > 0) {
				AB.push(temp.pop());
			}
			System.out.println(temp2);
			isNotSorted = checkSorted(temp2);
		}
	}

	private static boolean checkSorted(Stack<Integer> temp) {
		boolean isNotSorted = true;
		while (temp.size() > 0) {
			int a = temp.pop();
			int b = 0;
			if(temp.size() > 0) {
				b = temp.pop();
			} else {
				temp.push(a);
				break;
			}
			if(a < b) {
				temp.push(b);
				isNotSorted = false;
			} else {
				isNotSorted = true;
				return isNotSorted;
			}
		}
		return isNotSorted;		
	}

}
