
public class PriorityQueue {
	
	void int extractMinimum(int arr) {
		if(heapSize == 0) {
			throw new Exception("overflow!");
		}
		int result = arr[0];
		swap(A[heapSize], A[0]);
		heapSize--;
		minHeapify(arr, 0);
		return result;
	}
	
	void decreaseKey(int[] arr, int i, int key) {
		if(arr[i] < key) {
			throw new Exception("new key is less than the current key");
		}
		A[i] = k;
		while(i > 0 && A[(i-1)/2] < A[i]) {
			swap(A[(i-1)/2], A[i]);
			i = (i - 1)/2;
		}
	}
	
	void insert(int arr, int key) {
		heapSize++;
		arr[heapSize] = Double.POSITIVE_INFINITY;
		decreateKey(arr, heapSize, key);
	}
}
