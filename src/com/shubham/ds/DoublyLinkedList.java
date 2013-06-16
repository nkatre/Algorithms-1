package com.shubham.ds;

public class DNode {
	
	private DNode left;
	private int info;
	private DNode right;
	
	public DNode(DNode left, int info, DNode right) {
		this.setLeft(null);
		this.setInfo(info);
		this.setRight(null);
	}

	public void setRight(DNode right) {
		this.right = right;
	}
	public DNode getRight() {
		return right;
	}

	public void setLeft(DNode left) {
		this.left = left;
	}
	public DNode getLeft() {
		return left;
	}

	public void setInfo(int info) {
		this.info = info;
	}
	public int getInfo() {
		return info;
	}
}

public class DoublyLinkedList {
	DNode head;
	
	public DoublyLinkedList() {
		head = null;
	}
	
	// append a 'key' to a doubly linked list
	public DNode append(int key) {
		DNode newNode = new DNode(null, key, null);
		if(head == null) {
			head = newNode;
			head.setLeft(newNode);
			head.setRight(newNode);
		} else {
			DNode nextNode = head.getRight();
			head.setRight(newNode);
			newNode.setLeft(head);
			newNode.setRight(nextNode);
			nextNode.setLeft(newNode);
		}
		return newNode;
	}
	
	public void deleteNode(DNode nodeToDelete) throws Exception {
		if(head == null) {
			throw new Exception("Cannot delete node from an empty list");
		}
		
		DNode previousNode = nodeToDelete.getLeft();
		DNode nextNode = nodeToDelete.getRight();
		
		previousNode.setRight(nextNode);
		nextNode.setLeft(previousNode);
	}
	
	public DNode getHead() {
		return head;
	}
}


