
public class PriorityQueue {
	
	public static List<Integer> merge(List<List<Integer>> data) {
		
		// Find the total number of elements in the 3 arrays
        int totalSize = 0;
        for (List<Integer> l : data)
            totalSize = totalSize + l.size();

        // ArrayList to store the merged array
        List<Integer> result = new ArrayList<Integer>();

        /*
         * Create a priority queue such that the list with the smallest first element, is places earlier.
         * We will use this to extract the first element from the priority queue, then remove that element
         * from the original list and repeat this till there is no more elements let in any of the arrays
         */
        Queue<List<Integer>> q = new PriorityQueue<List<Integer>>(data.size(),
                new Comparator<List<Integer>>() {
                    public int compare(List<Integer> l1, List<Integer> l2) {
                        return l1.get(0).compareTo(l2.get(0));

                    }
                });
        
        List<Integer> min = null;

        // till we exhaust all the elements in the 3 lists...
        while (result.size() < totalSize) {
            min = null;
            for (List<Integer> tmp : data) {
                q.add(tmp);
            }
            // get minimum element
            min = q.poll();
            // add it to the result list and remove it from the original list
            result.add(min.remove(0));
            if (min != null && min.size() > 0)
                q.add(min);
        }
        return result;
    }

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
