package com.test.codecraft;

import java.util.ArrayList;
import java.util.Stack;

public class Challenge9 {

	/**
	 * Given a STACK of integers, check whether each successive pair of numbers in
	 * the stack is consecutive or not. If the stack has an odd number of elements
	 * the element at the top is left out
	 * 
	 * For e.g. Stack consecutiveIntegers = à Bottom {4,5,10,11,20,19,30,31,67,66,
	 * 33} Output : True : the pairs {4,5}, {10,11}, {20,19},{30,31},{67,66} have
	 * consecutive values
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		Stack<Integer> inpStack = new Stack<>();
		inpStack.push(4);
		inpStack.push(5);
		inpStack.push(10);
		inpStack.push(11);
		inpStack.push(20);
		inpStack.push(19);
		inpStack.push(30);
		inpStack.push(31);
		inpStack.push(67);
		inpStack.push(66);
		inpStack.push(33);
		System.out.println(inpStack);
		if(inpStack.size()%2 == 1) {
			inpStack.pop();
		} 
		Stack<ArrayList<Integer>> outputStack = new Stack<>();
		boolean isConsecutivePairs = true;
		while(inpStack.size() > 0) {
			ArrayList<Integer> AL = new ArrayList<>();
			int a = inpStack.pop();
			int b = inpStack.pop();
			if(a-b == 1 || b-a == 1) {
				AL.add(b);
				AL.add(a);
				isConsecutivePairs = true;
			} else {
				isConsecutivePairs = false;
				break;
			}
			outputStack.push(AL);
		}
		if(isConsecutivePairs) {
			System.out.print("True : the pairs ");
			while (outputStack.size() > 0) {
				System.out.print(outputStack.pop());
			}
			System.out.println(" have consecutive values");
		} else {
			System.out.println("Stack do not have consecutive pairs");
		}
	}

}
