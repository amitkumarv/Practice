package com.test.codecraft;

import java.util.Stack;

public class Challenge10 {

	/**
	 * Write a program to evaluate the answer for the answer for the following
	 * expression AB*CD+-E+ Where A = 6, B = 2 , C = 4, D=3 and E = 7 Answer = 12
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String inpExpression = Integer.toString(6) + Integer.toString(2) + "*" + Integer.toString(4)
				+ Integer.toString(3) + "+-" + Integer.toString(7) + "+";
		System.out.println(inpExpression);
		
		char[] expElemArray = inpExpression.toCharArray();
		
		Stack<String> outStack = new Stack<>();
		
		for (int i = 0; i < expElemArray.length; i++) {
			if(Character.toString(expElemArray[i]).matches("[0-9]")) {
				outStack.push(Character.toString(expElemArray[i]));
			} else {
				int a = Integer.parseInt(outStack.pop());
				int b = Integer.parseInt(outStack.pop());
				switch (Character.toString(expElemArray[i])) {
				case "*":
					outStack.push(Integer.toString(a*b));
					break;
				case "+":
					outStack.push(Integer.toString(a+b));
					break;
				case "-":
					outStack.push(Integer.toString(b-a));
					break;
				default:
					break;
				}
			}
		}
		System.out.println(outStack);
	}

}
