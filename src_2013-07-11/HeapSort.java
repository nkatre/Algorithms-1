
public class HeapSort {
	private int[] a;
	
	public HeapSort(int arrayLength) {
		a = new int[arrayLength];
	}
	
	void maxHeapify(int heapSize, int i) {
		int left = (2*i + 1);
		int right = (2*i + 2);
		int largest = i;
		if(left < heapSize && a[i] < a[left]) {
			largest = left;
		}
		if(right < heapSize && a[i] < a[right]) {
			largest = right;
		}
		
		if(largest != i) {
			swap(A[i], A[largest]);
			maxHeapify(heapSize, largest);
		}
	}
	
	void buildMaxHeap(int[] a) {
		for(int i = a.length - 1; i>=0; i--) {
			maxHeapify(a.length, i);
		}
	}
	
	void sort(int[] a) {
		buildMaxHeap(a);
		for(int i=a.length-1; i>0; i--) {
			swap(A[0], A[i]);
			heapSize--;
			maxHeapify(heapSize, 0);
		}
	}
	
}
