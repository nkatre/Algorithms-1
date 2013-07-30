package com.shubham.DoublyLinkedList;

import com.shubham.ds.Stack;

/**
 * NOTE: Just wrote code for ADDING two numbers - subtracting is not completed for lack of time.
 * Evaluate: - 524 21978 49762
 * 			 + 		   6 76941
 * 
 *  Represented as:
 *  
 *  -3 <-> 524 <-> 21978 <-> 49762
 *  		+2 <-> 	 6 <-> 76941
 * 
 * @author shubham
 *
 */
public class AdditionOfLargeNumbers {
	public static void main(String[] args) {
		DoublyLinkedList number1 = new DoublyLinkedList();
		number1.append(3);
		number1.append(524);
		number1.append(21978);
		number1.append(49762);
		Node header1 = number1.header;

		DoublyLinkedList number2 = new DoublyLinkedList();
		number2.append(2);
		number2.append(6);
		number2.append(76941);
		Node header2 = number2.header;
		
		if(header1.data * header2.data > 0) {
			// if both signs are same, add the absolute values and take the sign later
			add(header1, header2);
		} else {
			// subtract(header1, header2);
		}
	}
	
	static void add(Node header1, Node header2) {
		Stack stack = new Stack();
		int nodeCount1 = Math.abs(header1.data);
		int nodeCount2 = Math.abs(header2.data);
		int hopCount = Math.min(nodeCount1, nodeCount2);
		Node currentNode1 = header1.left;
		Node currentNode2 = header2.left;
		int carry = 0;
		for(int i = 0; i< hopCount; i++) {
			int sum = currentNode1.data + currentNode2.data + carry;
			carry = sum / 100000;
			if(carry == 1) {
				sum = sum - 100000;
			}
			currentNode1 = currentNode1.left;
			currentNode2 = currentNode2.left;
		}
		if(nodeCount1 > hopCount) {
			for(int i = 0; i<(nodeCount1 - hopCount); i++) {
				System.out.println("::: " + currentNode1.data);
				currentNode1 = currentNode1.left;
			}
		}
		
		if(nodeCount2 > hopCount) {
			for(int i = 0; i<(nodeCount2 - hopCount); i++) {
				System.out.println("::: " + currentNode2.data);
				currentNode1 = currentNode1.left;
			}
		}
		
	}
	
	/* Returns:
	 * -1: 1st number is -ve and 2nd is +ve
	 *  0: Both are equal
	 *  1: 1st number is +ve and 2nd is -ve
	 */
	private void compareAbsoluteValues(Node header1, Node header2) {
		//if 
		
	}
	
}
