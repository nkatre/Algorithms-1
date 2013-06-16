package com.shubham.search;

public class BinarySearch {
	void search(int key, int arr[], int low, int high) {
		if(low <= high) {
			int mid = (low + high)/2;
			if(key == arr[mid]) {
				System.out.println("found it at index: " + mid);
			}
			if(key < arr[mid]) {
				search(key, arr, low, mid - 1);
			} else {
				search(key, arr, mid + 1, high);
			}
		}
	}
	
	
	public static void main(String[] args) {
		BinarySearch bs = new BinarySearch();
		bs.search(2, new int[] {1, 2, 3, 4, 5}, 0, 4);
	}
}
