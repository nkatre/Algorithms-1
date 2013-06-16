package com.shubham.ds;

public class StackUsingLinkedList {
	private Node top;
	
	public StackUsingLinkedList() {
		top = null;
	}
	
	void push(int key) {
		if(top == null) {
			top = new Node(key);
		} else {
			Node newNode = new Node(key);
			
			Node nextNode = top.getNextNode();
			top.setNextNode(newNode);
			newNode.setNextNode(nextNode);
		}
	}
	
	void pop() throws Exception {
		if(top == null) {
			throw new Exception("Underflow!");
		} else {
			top = top.getNextNode();
		}
	}
	
}
