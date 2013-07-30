package com.shubham.ds;

public class Tester {
	public static void main(String[] args) throws Exception {
		
		System.out.println("--------------------------");
		BinarySearch bs = new BinarySearch();
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
		int index = bs.search(arr, 0, arr.length, 2);
		System.out.println("Key found at index " + index);
		
		System.out.println("--------------------------");
		QueueUsingArray q = new QueueUsingArray();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.enqueue(8);
		q.printQueue();
		
		System.out.println("\n--------------------------");
		LinkedList linkedList = new LinkedList();
		linkedList.append(1);
		linkedList.append(2);
		linkedList.append(3);
		linkedList.append(4);
		linkedList.append(5);
		
		System.out.print("List: ");
		linkedList.printList(linkedList.getHead());
		
		System.out.println();
		linkedList.deleteNode(3);
		linkedList.printList(linkedList.getHead());
		
		System.out.println();
		linkedList.insertAfter(2, 3);
		linkedList.printList(linkedList.getHead());
		
		System.out.println("\n---------\n");
		Node newHead = linkedList.reverse(linkedList.getHead());
		linkedList.printList(newHead);
				
	}
	
	
}
