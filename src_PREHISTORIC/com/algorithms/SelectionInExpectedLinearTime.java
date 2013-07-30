package com.algorithms;

/**
 * Find the i-th largest element in an array
 * [Selection in expected linear time]
 * @author shubham
 *
 */
public class SelectionInExpectedLinearTime {
	private int randomizedSelect(int[] arr, int p, int r, int i) {
		if(p == r) {
			return arr[p];
		}
		int q = randomizedPartition(arr, p, r);
		int k = q - p + 1;
		if(k == i) {
			return arr[k];
		} else if(i < k) {
			return randomizedSelect(arr, p, q - 1, i);
		} else {
			return randomizedSelect(arr, q + 1, r, i - k);
		}
	}
	
	
	
}
