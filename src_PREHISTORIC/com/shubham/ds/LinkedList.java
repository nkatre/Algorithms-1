package com.shubham.ds;

public class LinkedList {
	Node head;
	
	public Node getHead() {
		return head;
	}
	
	public LinkedList() {
		head = null;
	}
	
	/**
	 * Insert a new node right after the node with info 'info'
	 * @param info
	 * @throws Exception 
	 */
	void insertAfter(int info, int newInfo) throws Exception {
		if (head == null) {
			// if there are no nodes, just make this the head node
			head = new Node(newInfo, null);
		} else {
			Node currentNode = head;
			while(currentNode.getInfo() != info && currentNode != null) {
				currentNode = currentNode.getNextNode();
			}
			if(currentNode == null) {
				throw new Exception("The node after which we need to insert, is not present");
			} else {
				Node nextNode = currentNode.getNextNode();
				currentNode.setNextNode(new Node(newInfo, nextNode));
			}
		}
	}
	
	/**
	 * Detect a loop in a linked list
	 */
	static boolean hasLoop(Node head) {
		Node slow = head;
		Node fast = head;
		while(slow != null && fast != null && fast.getNextNode() != null) {
			slow = slow.getNextNode();
			fast = fast.getNextNode().getNextNode();
			if(slow == fast) {
				// it's a cycle
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Detect a loop in a linked list and remove it
	 */
	static boolean detectAndRemoveCycle(Node head) {
		Node slow = head;
		Node fast = head;
		while(slow != null && fast != null && fast.getNextNode() != null) {
			slow = slow.getNextNode();
			fast = fast.getNextNode().getNextNode();
			if(slow == fast) {
				removeCycle(head, slow);
				return true;
			}
		}
		System.out.println("There are no cycles to be removed");
		return false;
	}
	
	private static void removeCycle(Node head, Node slow) {
		// count the number of nodes in the cycle
		Node currentNode = slow;
		int cycleSize = 0;
		do {
			currentNode = currentNode.getNextNode();
			cycleSize++;
		} while(currentNode != slow);
		
		// get two nodes, one at the head and the other at (head+cycleSize)
		Node node1 = head;
		Node node2 = head;
		for(int i=0; i<cycleSize; i++) {
			node2 = node2.getNextNode();
		}
		
		while(node1 != node2) {
			node1 = node1.getNextNode();
			node2 = node2.getNextNode();
		}
		
		//Get the first node of the cycle and set the pointer to the next node from the last element to null.
		currentNode = node1;
		for(int i=0; i<cycleSize; i++) {
			currentNode = currentNode.getNextNode();
		}
		
		currentNode.setNextNode(null);
		
	}
	
	/**
	 * reverse a linked list
	 */
	Node reverse(Node head) {
		if(head == null) {
			return head;
		}
		
		Node current = head;
		Node previous = null;
		while(current != null) {
			Node next = current.getNextNode();
			current.setNextNode(previous);
			previous = current;
			current = next;
		}
		return previous;
	}
	
	/**
	 * Add an element to the end of the linked list.
	 * @param info
	 */
	void append(int info) {
		if(head == null) {
			head = new Node(info, null);
		} else {
			Node currentNode = head;
			while(currentNode.getNextNode() != null) {
				currentNode = currentNode.getNextNode();
			}
			currentNode.setNextNode(new Node(info, null));
		}
	}
	
	/**
	 * remove even numbers from a linked list
	 */
	void removeEvenNumbers() {
		if(head == null) {
			return;
		}
		
		while(head.info % 2 == 0 && head != null) {
			head = head.nextNode;
		}
		Node previous = null;
		Node current = head;
		while(current != null) {
			if(current.info % 2 == 0) {
				previous.nextNode = current.nextNode;
			}
			previous = current;
			current = current.nextNode;
		}
	}
	
	/**
	 * Insert a key in a sorted linked list
	 * LOGIC: http://www.geeksforgeeks.org/given-a-linked-list-which-is-sorted-how-will-you-insert-in-sorted-way/
	 */
	void insertInSortedList(int key) {
		Node newNode = new Node(key, null);
		if(head == null) {
			this.head = newNode;
		} else if(head.info > key) {
			Node tmp = head;
			head = newNode;
			newNode.nextNode = tmp;
		} else {
			Node current = head;
			Node previous = null;
			while(current.info < key && current != null) {
				previous = current;
				current = current.getNextNode();
			}
			previous.nextNode = newNode;
			newNode.nextNode = current;
		}
	}
	
	/**
	 * Delete the node with the key 'key'.
	 * @param key
	 * @throws Exception 
	 */
	void deleteNode(int key) throws Exception {
		Node previous = null;
		Node current = head;
		while(current.getInfo() != key && current != null) {
			previous = current;
			current = current.getNextNode();
		}
		if(current ==  null) {
			throw new Exception("Item to be deleted not found in the list");
		} else {
			previous.setNextNode(current.getNextNode());
		}
	}
	
	void printList(Node head) {
		while(head != null) {
			System.out.print(head.getInfo() + "\t");
			head = head.getNextNode();
		}
	}
}
