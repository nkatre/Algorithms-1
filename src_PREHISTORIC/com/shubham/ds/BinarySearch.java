package com.shubham.ds;

public class BinarySearch {
	public static int search(int arr[], int low, int high, int key) throws Exception {
		if(low > high) {
			throw new Exception("Did not find the requested key");
		}
		int mid = (low + high)/2;
		if (arr[mid] == key) {
			return mid;
		}
		if(arr[mid] > key) {
			System.out.println("searching between " + low + ", " + (mid - 1));
			return search(arr, low, mid - 1, key);
		} else {
			System.out.println("searching between " + (mid + 1) + ", " + high);
			return search(arr, mid + 1, high, key);
		}
		
	}
}
