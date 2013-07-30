package com.shubham.ds;

/*
 * Priority Queue operations:
 * 1. Extract max
 * 2. Increase key
 * 3. Insert new element with key k
 */
public class PriorityQueue {
	
	private int extractMax(int[] A) {
		return A[0];
	}
	
	private void increaseKey(int[] A, int i, int key) {
		if(i < key) {
			System.out.println("new key is smaller than current key");
		}
		
		A[i] = key;
		while(i>0 && A[i] > A[getParent(i)]) {
			swap(A, i, getParent(i));
			i = getParent(i);
		}
	}
	
	private void insertNewElement(int[] A, int key) {
		A[++heapSize] = -9999;
		increaseKey(A, i, key);
	}
	
}
