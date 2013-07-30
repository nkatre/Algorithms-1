class Node {
	
	private int data;
	private Node nextNode;
	
	public Node(int data) {
		this.data = data;
		this.nextNode = null;
	}
	
	public void setData(int data) {
		this.data = data;
	}
	public int getData() {
		return data;
	}
	
	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}
	public Node getNextNode() {
		return nextNode;
	}
}

public class QueueUsingList {
	
	private Node front;
	private Node rear;
	
	public QueueUsingList() {
		front = null;
		rear = null;
	}
	
	void enqueue(int key) {
		Node node = new Node(key);
		
		if(isEmpty()) {
		front = rear = node;
		} else {
			rear.setNextNode(node);
			rear = node;
		}
	}
	
	int dequeue() throws Exception {
		if(isEmpty()) {
			throw new Exception("underflow!");
		}
		int numberBeingDequeued = front.getData();
		front = front.getNextNode();
		return numberBeingDequeued;
		
	}
	
	public boolean isEmpty() {
		return front == null;
	}
}
