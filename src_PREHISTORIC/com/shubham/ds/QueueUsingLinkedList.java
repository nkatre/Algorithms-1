package com.shubham.ds;

class Node {
	int info;
	Node nextNode;
	
	public Node(int info, Node nextNode) {
		this.info = info;
		this.nextNode = nextNode;
	}
	
	public int getInfo() {
		return info;
	}
	
	public Node getNextNode() {
		return nextNode;
	}
	
	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}
}

class QueueUsingLinkedList {
	Node front;
	Node rear;
	
	public QueueUsingLinkedList() {
		front = rear = null;
	}
	
	void enqueue(int info) {
		if(isEmpty()) {
			front = rear = new Node(info, null);
		} else {
			rear.nextNode = new Node(info, null);
			rear = rear.getNextNode();
		}
	}
	
	public Node dequeue() throws Exception {
		if(front == null) {
			throw new Exception("Underflow!");
		}
		Node result = front;
		front = front.getNextNode();
		return result;
	}
	
	public boolean isEmpty() {
		return front == null;
	}
}

