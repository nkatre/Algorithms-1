package com.shubham.sorting;

public class HeapSort {
	private static final int MAX_SIZE = 1024;
	
	private int heapSize;
	private int A[];
	
	public void maxHeapify(int[] A, int i) {
		int left = getLeftChild(i);
		int right = getRightChild(i);
		
		int largest = -9999;
		if(left <= heapSize && A[left] > A[i]) {
			largest = left;
		}
		if(right <= heapSize && A[right] > A[i]) {
			largest = right;
		}
		
		if(largest != i) {
			swap(A, largest, i);
			maxHeapify(A, largest);
		}
	}
	
	public void buildMaxHeap(int[] A) {
		heapSize = A.length;
		for(int i=(A.length/2); i>=0; i--) {
			maxHeapify(A, i);
		}
	}
	
	public void heapSort(int[] A) {
		buildMaxHeap(A);
		for(int i=heapSize; i>=1; i++) {
			swap(A, i, 1);
			heapSize = heapSize - 1;
			maxHeapify(A, 1);
		}
	}
	
	
	
	
	private int getParent(int i) {
		return (i - 1)/2;
	}
	
	private int getLeftChild(int i) {
		return (2*1 + 1);
	}
	
	private int getRightChild(int i) {
		return (2*1 + 2);
	}
	
}
