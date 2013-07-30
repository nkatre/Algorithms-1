package com.shubham.ds;

public class QueueUsingArray {
	private static final int MAX_QUEUE_SIZE = 5;
	
	int[] arr;
	int front;
	int rear;
	int queueSize;
	
	public QueueUsingArray() {
		arr = new int[MAX_QUEUE_SIZE];
		front = 0;
		rear = 0;
		queueSize = 0;
	}
	
	public void enqueue(int data) throws Exception {
		if(queueSize == MAX_QUEUE_SIZE) {
			throw new Exception("Overflow!");
		} else {
			queueSize++;
			arr[rear] = data;
			rear = (rear + 1) % MAX_QUEUE_SIZE;
		}
	}
	
	public int dequeue() throws Exception {
		if(queueSize == 0) {
			throw new Exception("Underflow!");
		} else {
			int frontValue = arr[front];
			arr[front] = -999;
			front = (front+1) % MAX_QUEUE_SIZE;
			return frontValue;
		}
	}
	
	public void printQueue() {
		for(int i=0; i< arr.length; i++) {
			System.out.print(arr[i]+"\t");
		}
	}
}
