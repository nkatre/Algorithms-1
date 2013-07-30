package com.algorithms;

class HeapSort {
	int[] arr = new int[10];
	int heapSize = 0;
	
	int getParentIndex(int i) {
		return i/2;
	}
	
	int getLeftChildIndex(int i) {
		return 2*1 + 1;
	}
	
	int getRightChildIndex(int i) {
		return 2*1 + 2;
	}
	
	// implement heapsort
	void sort(int[] arr) {
		buildMaxHeap(arr);
		for(int i=heapSize; i>0; i--) {
			// swap arr[0] & arr[i]
			int tmp = arr[0];
			arr[0] = arr[i];
			arr[i] = tmp;
			System.out.println(arr[heapSize]);
			
			heapSize--;
			maxHeapify(arr, 0);
		}
	}
	
	void buildMaxHeap(int[] arr) {
		heapSize = arr.length;
		for(int i=heapSize/2; i>=0; i--) {
			maxHeapify(arr, i);
		}
	}
	
	void maxHeapify(int[] arr, int i) {
		int leftChildIndex = getLeftChildIndex(i);
		int rightChildIndex = getRightChildIndex(i);
		
		int largest = i;
		if(arr[leftChildIndex] > arr[i] && leftChildIndex < heapSize) {
			largest = leftChildIndex;
		} else if(arr[rightChildIndex] > arr[i] && rightChildIndex < heapSize) {
			largest = rightChildIndex;
		}
		if(largest != i) {
			int tmp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = tmp;
			maxHeapify(arr, largest);
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {2, 1, 6, 4};
		HeapSort hs = new HeapSort();
		hs.sort(arr);
	}
}