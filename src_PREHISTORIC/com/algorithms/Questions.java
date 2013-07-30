package com.algorithms;

public class Questions {
	/**
	 * Set all nodes in a Binary Tree to null
	 */
	public static void setToNull(Node head) {
		if(head != null) {
			setToNull(head.left);
			setToNull(head.right);
			head = null;
		}
	}

}
