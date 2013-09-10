/**
 * Given a N * M matrix, you have to rotate it by 90 degree. 
 * 
 * @author shubham
 *
 */

public class RotateArray {

	public static void run(int[][] arr) {
		int n = arr.length;

		for(int r=0; r<arr.length; r++) {
			for(int c=0; c<arr[0].length; c++) {
				arr[r][c] = arr[n - 1- c][n - 1 - r];
			}
		}

		for(int r=0; r<arr.length; r++) {
			for(int c=0; c<arr[0].length; c++) {
				System.out.print(arr[r][c] + "\t");
			}
			System.out.println();
		}

	}
	
	public static void main(String[] args) {
		int arr[][] = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}
		};
		RotateArray.run(arr);
	}

}
