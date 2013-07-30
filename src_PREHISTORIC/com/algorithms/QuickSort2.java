package com.algorithms;

public class QuickSort2 {

	private int partition(int arr[], int p, int r) {
		int i = p - 1;
		int key = arr[r];
		for(int j=p; j<r; j++) {
			if(arr[j] <= key) {
				i = i + 1;
				//swap(arr, i, j);
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
			}
		}
		//swap(arr, i+1, r-1);
		int tmp = arr[i+1];
		arr[i+1] = arr[r];
		arr[r] = tmp;
		return i+1;
	}
	
	private void sort(int[] arr, int p, int r) {
		if(p < r) {
			int q = partition(arr, p, r);
			sort(arr, p, q - 1);
			sort(arr, q + 1, r);
		}
	}
	
	public static void main(String[] args) {
		int arr[] = {4,3,5,6,2,1,7};
		QuickSort2 q = new QuickSort2();
		q.sort(arr, 0, 6);
		
		for(int i=0;i<7; i++) {
			System.out.print(arr[i] + "\t");
		}
	}

}
