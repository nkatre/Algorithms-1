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

    public static void subset(String prefix, String string) {
        if(string.length() == 0) {
            System.out.println(prefix);
            return;
        }

        subset(prefix + string.charAt(0), string.substring(1));
        subset(prefix, string.substring(1));
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

   
    public static List<List<Integer>> lists = new ArrayList<List<Integer>>();
    public static void getSubsetCountThatSumToTargetValue(int[] arr, int k, int targetSum, List<Integer> list) {
        if(targetSum == 0) {
            lists.add(list);
            return;
        }
       
        if(k <= 0) {
            return;
        }
       
        getSubsetCountThatSumToTargetValue(arr, k - 1, targetSum, list);
       
        List<Integer> appendedlist = new ArrayList<Integer>();
        appendedlist.addAll(list);
        appendedlist.add(arr[k - 1]);
        getSubsetCountThatSumToTargetValue(arr, k - 1, targetSum - arr[k - 1], appendedlist);
    }
    
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(SubSetSum.countSubsetSum(arr, 5, 8));
        
        SubSetSum.getSubsetCountThatSumToTargetValue(arr, 5, 9, new ArrayList<Integer>());
        System.out.println("lists: " + lists);
        
    }
    
    public static void findMaxSubarray(int[] a) {
        // check arguments
        if(a == null || a.length == 0) throw new NullPointerException(" :((((((((((((((((((");
        
        int max = a[0], tmp_max = a[0];
        for(int i=0; i<a.length; i++) {
            if(tmp_max < 0) {
                tmp_max = a[i];
            } else {
                tmp_max += a[i];
            }
            max = tmp_max > max ? tmp_max : max;
        }
        System.out.println(max);
    }
    
    static void getMaxSum(int[] arr) {
        int size = arr.length;
        int[] s = new int[size];
        
        s[0] = arr[0];
        for(int index = 1; index<size; index++) {
            // applying the logic just discussed
            if(s[index-1] > 0) {
                s[index] = s[index-1] + arr[index];
            } else {
                s[index] = arr[index];
            }
        }
        
        // is we are here - we have created the array s[0...size-1]
        // We will have to pass through it once to retrieve the maximum value
        int maxValue = -9999;
        for(int i=0; i<size; i++) {
            maxValue = Math.max(maxValue, s[i]);
        }
        
        for(int i=0; i< size; i++) {
        	System.out.print(s[i] + "\t");
        }
    }
}