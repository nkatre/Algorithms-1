package com.shubham.misc_problems;

import com.shubham.ds.DNode;
import com.shubham.ds.DoublyLinkedList;
import com.shubham.ds.StackUsingLinkedList;

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
public class NumberArithmetic {
	public static void main(String[] args) {
		DoublyLinkedList number1 = new DoublyLinkedList();
		number1.append(3);
		number1.append(524);
		number1.append(21978);
		number1.append(49762);
		DNode header1 = number1.getHead();

		DoublyLinkedList number2 = new DoublyLinkedList();
		number2.append(2);
		number2.append(6);
		number2.append(76941);
		DNode header2 = number2.getHead();
		
		if(header1.getInfo() * header2.getInfo() > 0) {
			// if both signs are same, add the absolute values and take the sign later
			add(header1, header2);
		} else {
			// subtract(header1, header2);
		}
	}
	
	static void add(DNode header1, DNode header2) {
		StackUsingLinkedList stack = new StackUsingLinkedList();
		int nodeCount1 = Math.abs(header1.getInfo());
		int nodeCount2 = Math.abs(header2.getInfo());
		int hopCount = Math.min(nodeCount1, nodeCount2);
		DNode currentNode1 = header1.getLeft();
		DNode currentNode2 = header2.getLeft();
		int carry = 0;
		for(int i = 0; i< hopCount; i++) {
			int sum = currentNode1.getInfo() + currentNode2.getInfo() + carry;
			carry = sum / 100000;
			if(carry == 1) {
				sum = sum - 100000;
			}
			currentNode1 = currentNode1.getLeft();
			currentNode2 = currentNode2.getLeft();
		}
		if(nodeCount1 > hopCount) {
			for(int i = 0; i<(nodeCount1 - hopCount); i++) {
				System.out.println("::: " + currentNode1.getInfo());
				currentNode1 = currentNode1.getLeft();
			}
		}
		
		if(nodeCount2 > hopCount) {
			for(int i = 0; i<(nodeCount2 - hopCount); i++) {
				System.out.println("::: " + currentNode2.getInfo());
				currentNode1 = currentNode1.getLeft();
			}
		}
		
	}
	
	/* Returns:
	 * -1: 1st number is -ve and 2nd is +ve
	 *  0: Both are equal
	 *  1: 1st number is +ve and 2nd is -ve
	 */
	private void compareAbsoluteValues(DNode header1, DNode header2) {
		//if 
		
	}
	
}