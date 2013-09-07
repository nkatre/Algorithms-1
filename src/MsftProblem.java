
/**
 * I will use a priority queue (BINARY HEAP implementation)
 * for this use case. If we use binary heap,
 * 
 * pop-min() will be O(1) since pop-min() the root of the heap will be constant work
 * insert will be O(1) as well.
 */

public class MsftProblemPriorityQueue {
	
	private Queue<Integer> priorityQueue;
	
	// constructor
	public MsftProblem() {
		priorityQueue = new PriorityQueue<Integer>();
	}
	
	void push(int key) {
		priorityQueue.add(key);
	}
	
	int popMin() {
		int key = priorityQueue.remove();
		return key;
	}
}
