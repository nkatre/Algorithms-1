
public class MedianCalculator {
	
	/**
	 * Find median of two sorted arrays.
	 * http://ocw.alfaisal.edu/NR/rdonlyres/Electrical-Engineering-and-Computer-Science/6-046JFall-2005/30C68118-E436-4FE3-8C79-6BAFBB07D935/0/ps9sol.pdf
	 * 
	 */
	public static int calculateMedian(int[] a, int[] b, int left, int right) {
		int l = a.length; 	// length of a
		int m = b.length; 	// length of b
		int n = l + m; 		// length of a and b combined
		
		if(left >= right) {
			System.out.println("left: " + left);
			System.out.println("right: " + right);
			return calculateMedian(b, a, 0, m-1);
		}
		
		int i = (left + right)/2;
		int j = (n/2) - i - 1; // element on the j-th index should be less than a[i]
		
		if( (j < 0 || a[i] > b[j]) && (j>=(m-1) || a[i] < b[j+1]) ) {
			return a[i];
		} else if( (j < 0 || a[i] > b[j]) && j<(m-1) && a[i] > b[j+1] ) {
			return calculateMedian(a, b, left, i-1);
		} else {
			return calculateMedian(a, b, i+1, right);
		}
	}
	
	public static void main(String[] args) {
		int[] a = {11, 33, 44, 77, 88, 99};
		int[] b = {22, 55, 66};
		int result = MedianCalculator.calculateMedian(a, b, 0, 5);
		System.out.println("result: " + result);
	}
}
