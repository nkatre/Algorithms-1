package com.shubham.sorting;

public class Quicksort {
	
	private int partition(int arr[], int p, int r) {
		int x = arr[r];
		int i = p - 1;
		
		for(int j = p; j<r; j++) {
			if(arr[j] < x) {
				i = i + 1;
				swap(arr, i, j);
			}
		}
		swap(A, i+1, r);
		return i+1;
	}
	
	void sort(int A[], int p, int r) {
		if(p < r) {
			int q = partition(A, p, r);
			sort(A, p, q - 1);
			sort(A, q + 1, r);
		}
	}
}
