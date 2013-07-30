package com.algorithms;

public class MergeSort {

	private static void mergesort(int[] arr, int p, int r) {
		if(p < r) {
			int q = (p + r)/2;
			mergesort(arr, p, q);
			mergesort(arr, q+1, r);
			merge(arr, p, q, r);
		}
	}
	
	private static void merge(int[] arr, int p, int q, int r) {
		int n1 = q - p + 1;
		int n2 = r - q;
		int[] left = new int[n1];
		int[] right = new int[n2];
		
		for(int i=0; i<n1; i++) {
			left[i] = arr[p + i];
		}
		
		for(int j=0; j<n2; j++) {
			right[j] = arr[q + 1 + j];
		}
		
		int leftIndex = 0;
		int rightIndex = 0;
		int index = 0;
		while(leftIndex != n1 && rightIndex != n2) {
			if(left[leftIndex] < right[rightIndex]) {
				arr[index++] = left[leftIndex++];
			} else {
				arr[index++] = right[rightIndex++];
			}
		}
		
		if(leftIndex == n1) {
			for(int i=rightIndex; i<n2; i++) {
				arr[index++] = right[i];
			}
		} else {
			for(int i=leftIndex; i<n1; i++) {
				arr[index++] = left[i];
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2, 5, 8, 0, 3 , 7};
		mergesort(arr, 0, 7);
		
		for(int i=0; i< 7; i++) {
			System.out.println(arr[i]);
		}
		
	}
}


