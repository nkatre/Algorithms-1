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

   
    public static int counter = 0;
    public static List<List<Integer>> lists = new ArrayList<List<Integer>>();
    public static void getSubsetCountThatSumToTargetValue(int[] arr, int k, int targetSum, List<Integer> list) {
        if(targetSum == 0) {
            counter++;
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

        SubSetSum.subset("", "ABCD");
       
        int[] arr = {1, 2, 3, 4, 5};
        SubSetSum.getSubsetCountThatSumToTargetValue(arr, 5, 9, new ArrayList<Integer>());
        System.out.println("Result: " + counter);
        System.out.println("lists: " + lists);

    }
}