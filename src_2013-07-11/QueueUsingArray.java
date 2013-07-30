

public class QueueUsingArray {
	private static int maxSize;
	
	private int front;
	private int rear;
	private int queueSize;
	private int[] arr;
	
	public QueueUsingArray(int maxSize) {
		front = 0;
		rear = -1;
		queueSize = 0;
		arr = new int[maxSize];
	}
	
	void enqueue(int key) throws Exception {
		if(queueSize == maxSize) {
			throw new Exception("Overflow!!!");
		}
		// insert...
		arr[rear] = key;
		rear = (rear + 1) % maxSize;
		queueSize++;
	}
	
	int dequeue() throws Exception {
		if(queueSize == 0) {
			throw new Exception("underflow!!");
		}
		int integerBeingDequeued = arr[front];
		front = (front - 1) % maxSize;
		queueSize--;
		return integerBeingDequeued;
	}
}
