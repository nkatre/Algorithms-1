package com.algorithms;

public class ReverseNumber {
	
	public static void main(String[] args) {
		System.out.println(reverseTheNumber(321));
	}
	
	public static int reverseTheNumber(int number) {
		int reverse = 0;
		while(number > 0) {
			reverse = (reverse * 10) + (number % 10);
			number = number/10;
		}
		return reverse;
	}
	
}
