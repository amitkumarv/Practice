package com.test.codecraft;

public class TestSample {

	public void finalize() {
		System.out.println("finalize called");
	}

	public static void main(String[] args) {
		TestSample f1 = new TestSample();
		TestSample f2 = new TestSample();
		f1 = null;
		f2 = null;
		System.gc();
	}

}
