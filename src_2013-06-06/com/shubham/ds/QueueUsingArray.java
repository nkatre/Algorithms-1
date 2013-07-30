package com.shubham.ds;

class Queue {

	private static final int MAX_SIZE = 8;
	private int[] arr;
	private int front;
	private int rear;
	private int queueSize;

	public Queue() {
		arr = new int[MAX_SIZE];
		front = 0;
		rear = 0;
		queueSize = 0;
	}

	void insert(int key) throws Exception {
		if(queueSize > MAX_SIZE) {
			throw new Exception("Overflow!");
		}

		arr[rear] = key;
		rear = (rear + 1) % MAX_SIZE;
		queueSize++;
	}

	void delete() throws Exception {
		if(queueSize < 1) {
			throw new Exception("Underflow!");
		}
		front = (front + 1) % MAX_SIZE;
		queueSize--;
	}

	void traverseQueue() {
		for(int index = 0; index < queueSize; index++) {
			int effectiveIndex = (index + front) % MAX_SIZE;
			System.out.print(arr[effectiveIndex] + "\t");
		}
		System.out.println();
	}
}

public class QueueUsingArray {
	public static void main(String[] args) throws Exception {
		Queue queue = new Queue();
		queue.insert(1);
		queue.insert(2);
		queue.insert(3);
		queue.insert(4);
		queue.insert(5);
		queue.traverseQueue();
		queue.delete();
		queue.delete();
		queue.traverseQueue();
	}
}
