package com.shubham.ds;

public class MyLinkedList {
	
	Node head;
	
	public MyLinkedList() {
		head = null;
	}
	
	void append(int key) {
		Node newNode = new Node(key);
		if(head == null) {
			head = newNode;
		} else {
			Node currentNode = head;
			while(currentNode.getNextNode() != null) {
				currentNode = currentNode.getNextNode();
			}
			currentNode.setNextNode(newNode);
		}
	}
	
	// insert a key after a particular node 
	void insertAfter(int toInsert, int after) throws Exception {
		if(head == null) {
			throw new Exception("cannot insert into an empty linked list");
		}
		
		Node newNode = new Node(toInsert);
		Node currentNode = head;
		while(currentNode.getInfo() != after && currentNode != null) {
			currentNode = currentNode.getNextNode();
		}
		if(currentNode == null) {
			throw new Exception("could not find the node after which the new node has to be inserted");
		}
		
		Node nextNode = currentNode.getNextNode();
		currentNode.setNextNode(newNode);
		newNode.setNextNode(nextNode);
	}
	
	// delete node with key k
	void deleteNode(int key) throws Exception {
		if(head == null) {
			throw new Exception("cannot delete from an empty linked list");
		}
		if(head.getInfo() == key) {
			head = null;
		} else {
			Node previous = null;
			Node current = head;
			while(current.getInfo() != key && current != null) {
				previous = current;
				current = current.getNextNode();
				
			}
			if(current == null) {
				throw new Exception("could not find the node to be deleted");
			}
			previous.setNextNode(current.getNextNode());
		}
	}
	
	// insert into a list sorted in ascending order
	void insertIntoASortedList(int key) {
		Node newNode = new Node(key);
		if(head == null) {
			head = newNode;
		}
		
		Node previousNode = null;
		Node currentNode = head;
		while(currentNode.getInfo() < key) {
			previousNode = currentNode;
			currentNode = currentNode.getNextNode();
		}
		previousNode.setNextNode(newNode);
		newNode.setNextNode(currentNode);
	}
	
	void traverseList() {
		Node currentNode = head;
		while(currentNode != null) {
			System.out.print(currentNode.getInfo() + " ---> ");
			currentNode = currentNode.getNextNode();
		}
		System.out.println();
	}
	
	
	public static void main(String[] args) throws Exception {
		MyLinkedList list = new MyLinkedList();
		list.append(1);
		list.append(2);
		list.append(5);
		list.traverseList();
		
		list.insertIntoASortedList(3);
		list.traverseList();
		
		list.insertAfter(4, 3);
		list.traverseList();
	}
	
}
