package com.shubham.ds;

class Node {
	private int info;
	private Node nextNode;

	public Node(int info) {
		this.info = info;
		this.nextNode = null;
	}

	public void setInfo(int info) {
		this.info = info;
	}

	public int getInfo() {
		return info;
	}

	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}

	public Node getNextNode() {
		return nextNode;
	}
}

class MyQueue {
	private Node front;
	private Node rear;

	public MyQueue() {
		front = rear = null;
	}

	void enqueue(int key) {
		Node newNode = new Node(key);
		if(rear == null) {
			front = rear = newNode;
		} else {
			rear.setNextNode(newNode);
			rear = newNode;
		}
	}

	void dequeue() throws Exception {
		if(front == null) {
			throw new Exception("underflow!");
		}
		front = front.getNextNode();
	}

	void traverseQueue() {
		Node current = front;
		while(current != null) {
			System.out.print(current.getInfo() + " ---> ");
			current = current.getNextNode();
		}
		System.out.println();
	}
}

public class QueueUsingLinkedList {
	public static void main(String[] args) throws Exception {
		MyQueue queue = new MyQueue();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		queue.traverseQueue();
		queue.dequeue();
		queue.traverseQueue();
	}
}
