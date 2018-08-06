package com.test.codecraft;

import java.util.ArrayDeque;
import java.util.Stack;

public class Challenge11 {

	/**
	 * Given an integer k and a queue of integers, reverse the order of the first k
	 * elements of the queue, leaving the other elements in the same relative order?
	 * e.g. Input k=4 queue = [10,20,30,40,50,60,70,80] Output queue =
	 * [40,30,20,10,50,60,70,80]
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int k = 4;
		ArrayDeque<Integer> inputQ = new ArrayDeque<>();
		inputQ.add(10);
		inputQ.add(20);
		inputQ.add(30);
		inputQ.add(40);
		inputQ.add(50);
		inputQ.add(60);
		inputQ.add(70);
		inputQ.add(80);
		System.out.println(inputQ);
		Stack<Integer> temp = new Stack<>();
		for (int i = 0; i < k; i++) {
			temp.push(inputQ.poll());
		}
		while (temp.size() > 0) {
			try {
				inputQ.offer(temp.pop());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		for (int i = 1; i <= inputQ.size()-k; i++) {
			inputQ.offer(inputQ.poll());
		}
		System.out.println(inputQ);
	}

}
