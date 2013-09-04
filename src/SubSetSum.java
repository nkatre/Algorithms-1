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
	
	public static void main(String[] args) {
		SubSetSum.subset("", "abc");
	}

	public static boolean countSubsetSum(int arr[], int k, int sum) {
		if(sum == 0) {
			return true;
		}
		
		
		
	}
	
}



