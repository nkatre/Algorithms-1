package com.algorithms;

import java.util.Random;

public class QuickSort {
	
	public void sort1(int[] arr, int p, int r) {
		int pivot = (int)(Math.random() * arr.length);
		while(p<r) {
			while(arr[p] < arr[pivot]) {
				p++;
			}
			while(arr[r] > arr[pivot]) {
				r--;
			}
			int tmp = arr[p];
			arr[p] = arr[r];
			arr[r] = tmp;
			sort(arr, p, pivot);
			sort(arr, pivot + 1, r);
		}
	}
	
	public static void main(String[] args) {
		QuickSort qs = new QuickSort();
		int[] arr = {3, 2, 5, 4, 1};
		qs.sort(arr, 0, 4);
		
		for(int i=0;i<5;i++) {
			System.out.print(arr[i] + "\t");
		}
	}
	
}
