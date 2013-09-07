/**
 * Given an array of integers, find all sub-arrays whose elements sum zero.
 * 1.-1,4,-4 has 3 such arrays 1 to -1, 1 to -4 and 4 to -4
 * 
 * @author shubham
 *
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
 
/**
* Given an array of integers, find all sub-arrays whose elements sum zero.
* 1.-1,4,-4 has 3 such arrays 1 to -1, 1 to -4 and 4 to -4
*
* @author shubham
*
*/
public class SubSetSum {
	
	/**
	 * Java implementation by Shubham Shukla. 
	 */
	int[][] setZeroForRowsAndColumns(int[][] arr) {
		// get rows and columns of the array
		int m = arr.length;
		int n = arr[0].length;
		
		/* 
		 * Keep two arrays to identify what rows and columns need to be set to zero
		 * If value of a bit field is 'true': the corresponding row/column should be zeroed out
		 * By default the value is set to false. 
		 */
		boolean[] rowBitMap = new boolean[m];
		boolean[] colBitMap = new boolean[n];
		
		// iterate through the array to set the bit maps appropriately
		for(int r = 0; r<m; r++) {
			for(int c=0; c<n; c++) {
				if(arr[r][c] == 0) {
					rowBitMap[r] = true;
					colBitMap[c] = true;
					
					/* 
					 * if we have set the bit map for this row and column, just move on to the next row
					 * starting from 0-th column
					 */
					break;
				}
			}
		}
		
		// now use the bit maps to set the array values to zero appropriately
		for(int r = 0; r<m;r++) {
			if(rowBitMap[r]) {
				for(int c=0; c<n; c++) {
					arr[r][c] = 0;
				}
			}
		}
		for(int c = 0; c<n;c++) {
			if(colBitMap[c]) {
				for(int r=0; r<m; r++) {
					arr[r][c] = 0;
				}
			}
		}
		
		return arr;
	}
 
    public static void subset(String prefix, String string) {
        if(string.length() == 0) {
            System.out.println(prefix);
            return;
        }
 
        subset(prefix + string.charAt(0), string.substring(1));
        subset(prefix, string.substring(1));
    }
 
    public static void main(String[] args) {
    	/*
    	SubSetSum.countSubsetSum2(new int[] {1,2, 3, 4, 5, 6, 7, 8, 9, 10}, 10, 3);
        System.out.println(count);
        */
    	SubSetSum ss = new SubSetSum();
    	int arr0[][] = {
    			{1, 2, 3, 0},
    			{5, 0, 7, 8},
    			{9, 10, 11, 12}
    	};

    	int[][] arr = ss.setZeroForRowsAndColumns(arr0);
    	for(int i=0;i<arr.length;i++) {
    		for(int j=0; j<arr[0].length; j++) {
    			System.out.print(arr[i][j] + "\t");
    		}
    		System.out.println();
    	}
    }
 
    /**
     * method to return if a set contains a list which sums to a particular value
     **/
    public static boolean countSubsetSum(int arr[], int k, int sum) {
        if(sum == 0) {
            return true;
        }
        if(sum != 0 && k == 0) {
            return false;
        }
        if(sum < arr[k - 1]) {
            countSubsetSum(arr, k-1, sum);
        }
        return countSubsetSum(arr, k-1, sum - arr[k-1]) || countSubsetSum(arr, k-1, sum);
    }
 
    /**
     * method to return number of sets with a given sum.
     **/
    public static int count = 0;
    public static void countSubsetSum2(int arr[], int k, int sum) {
        if(sum == 0) {
            //return true;
            count++;
            return;
        }
        if(sum != 0 && k == 0) {
            //return false;
            return;
        }
        if(sum < arr[k - 1]) {
            countSubsetSum2(arr, k-1, sum);
        }
        //return countSubsetSum(arr, k-1, sum - arr[k-1]) || countSubsetSum(arr, k-1, sum);
        countSubsetSum2(arr, k-1, sum - arr[k-1]);
        countSubsetSum2(arr, k-1, sum);
    }
 
    /**
     * method to return  all sets with a given sum.
     **/
    public static List<List<Integer>> lists = new ArrayList();
    public static List<Integer> list = new ArrayList<Integer>();
    public static void countSubsetSum3(int arr[], int k, int sum) {
        if(sum == 0) {
            //count++;
            System.out.println(arr[k-1]);
            return;
        }
        if(sum != 0 && k == 0) {
            //return false;
            return;
        }
        if(sum < arr[k - 1]) {
            countSubsetSum3(arr, k-1, sum);
        }
        //return countSubsetSum(arr, k-1, sum - arr[k-1]) || countSubsetSum(arr, k-1, sum);
        countSubsetSum3(arr, k-1, sum - arr[k-1]);
        countSubsetSum3(arr, k-1, sum);
    }
}