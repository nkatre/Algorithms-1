package com.shubham.misc_problems;

public class Josephus {
	int solveJosephus(int n, int k) {
		if(n == 1) {
			return 1;
		}
		
		return (solveJosephus(n-1, k) + (k-1)) % (n + 1);
	}
	
	public static void main(String[] args) {
		Josephus instance = new Josephus();
		int result = instance.solveJosephus(14, 2);
		System.out.println("Result: " + result);
	}
}
