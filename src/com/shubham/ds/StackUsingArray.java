package com.shubham.ds;

class Stack{
	private static final int MAX_SIZE = 8;
	
	private int arr[];
	private int top;
	
	public Stack() {
		arr = new int[MAX_SIZE];
		top = -1;
	}
	
	public void push(int key) throws Exception {
		if(top == MAX_SIZE - 1) {
			throw new Exception("Overflow!");
		}
		arr[++top] = key;
	}
	
	public int pop() throws Exception {
		if(top == -1) {
			throw new Exception("Underflow!");
		}
		return arr[top--];
	}
	
	public int peek() throws Exception {
		if(top == -1) {
			throw new Exception("Underflow!");
		}
		return arr[top];
	}
	
	public void traverseElements() {
		for(int index = 0; index <= top; index++) {
			System.out.print(arr[index] + "\t");
		}
		System.out.println();
	}
}

public class StackUsingArray {
	public static void main(String[] args) throws Exception {
		Stack stack = new Stack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.traverseElements();
		stack.pop();
		stack.pop();
		stack.traverseElements();
	}
}