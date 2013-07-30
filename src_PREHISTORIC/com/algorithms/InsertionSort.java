package com.algorithms;

public class InsertionSort {
	
	public static void main(String[] args) {
		int[] arr = new int[] {3,2,4,1,7};
		insertionSort(arr);
		for(int i = 0; i<arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
		
	}
	
	private static void insertionSort(int arr[]) {
		for(int i = 1; i<arr.length; i++) {
			int key = arr[i];
			int j = i - 1;
			while(j >= 0 && arr[j] > key) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = key;
		}
	}
	
}
