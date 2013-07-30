package com.shubham.ds;

public class Stack {
	public static Node top;

	public Stack() {
		top = null;
	}

	public void push(String info) {
		top = new Node(info, top);
	}
	
	public Node pop() throws Exception {
		if(top != null) {
			Node currentTop = top;
			top = top.getNextNode();
			return currentTop;
		} else {
			// throw underflow exception and log
			throw new Exception("Underflow");
		}
	}
	
	public boolean isEmpty() {
		return top == null;
	}
}


