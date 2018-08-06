package com.test.codecraft;

import java.util.Stack;

public class Challenge8 {

	/**
	 * Reverse numbers in a stack using only stack operations (push and pop) e.g
	 * Input : Stack numberStack = {1,7,36,20,42} Output : Stack reverseStack =
	 * {42,20,36,7,1}
	 * 
	 * @param args
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Stack<Integer> inpStack = new Stack<>();
		inpStack.push(1);
		inpStack.push(7);
		inpStack.push(36);
		inpStack.push(20);
		inpStack.push(42);
		System.out.println("Original input stack: " + inpStack);
		Stack<Integer> tempStack = new Stack<>();
		while (inpStack.size() > 0) {
			tempStack.push(inpStack.pop());
		}
		inpStack = (Stack<Integer>) tempStack.clone();
		System.out.println("Output stack: " + inpStack);
	}

}
