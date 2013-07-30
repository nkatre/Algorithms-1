package com.shubham.DoublyLinkedList;

class Node {
	Node left;
	int data;
	Node right;
	
	public Node(Node left, int data, Node right) {
		this.left = left;
		this.data = data;
		this.right = right;
	}
}

public class DoublyLinkedList {
	Node header;
	
	public DoublyLinkedList() {
		header = null;
	}
	
	/*
	 * append the node to the doubly linked list and return the pointer to the node just appended to the list.
	 */
	public Node append(int data) {
		Node newNode = new Node(null, data, null);
		if(header == null) {
			header = newNode;
			newNode.left = newNode;
			newNode.right = newNode;
		} else {
			Node lastElement = header.left;
			Node firstElement = header;
			newNode.right = firstElement;
			newNode.left = lastElement;
			lastElement.right = newNode;
			firstElement.left = newNode;
		}
		return newNode;
	}
	
	/**
	 * Delete an element from a doubly linked list refered by pointer 'nodeToDelete'
	 */
	public void deleteNode(Node nodeToDelete) {
		Node leftNode = nodeToDelete.left;
		Node rightNode = nodeToDelete.right;
		
		leftNode.right = rightNode;
		rightNode.left = leftNode;
		nodeToDelete = null;
	}
	
	/**
	 * insert a key 'key' to the right of the node 'targetNode'
	 */
	public void insertRight(Node targetNode, int key) {
		Node newNode = new Node(null, key, null);
		
		Node leftNode = targetNode;
		Node rightNode = targetNode.right;
		
		leftNode.right = newNode;
		newNode.left = leftNode;
		newNode.right = rightNode;
		rightNode.left = newNode;
	}
	
	public void printList() {
		Node currentNode = header;
		Node lastNode = header.left;
		while(!currentNode.equals(lastNode)) {
			System.out.print(currentNode.data + " <--> ");
			currentNode = currentNode.right;
		}
		System.out.println(currentNode.data);
	}
	
	public static void main(String[] args) {
		DoublyLinkedList dll = new DoublyLinkedList();
		dll.append(1);
		Node insertRight = dll.append(2);
		Node nodeToDelete = dll.append(3);
		dll.append(4);
		dll.append(5);
		
		dll.deleteNode(nodeToDelete);
		dll.insertRight(insertRight, 3);
		dll.printList();
	}
	
}
