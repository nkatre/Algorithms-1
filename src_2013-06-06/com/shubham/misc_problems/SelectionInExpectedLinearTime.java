package com.shubham.misc_problems;

/**
 * Find the i-th smallest element using selection-in-expected-linear-time
 * @author shubham
 */
public class SelectionInExpectedLinearTime {
	private int select(int[] arr, int p, int r, int i) {
		if(p == r) {
			return arr[p];
		}
		int q = randomizedPartition(arr, p, r);
		int k = q - p + 1;
		if(k == i) {
			return arr[k];
		} else if(i < k) {
			select(arr, p, q - 1, i);
		} else {
			select(arr, q + 1, r, i - k);
		}
	}
}
