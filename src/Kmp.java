
/**
 * Reference:
 * http://www.youtube.com/watch?v=rfisBOOLN9M
 * http://www.geeksforgeeks.org/searching-for-patterns-set-2-kmp-algorithm/
 * 
 * @author shubham
 *
 */
public class Kmp {

	void search(int[] pattern, int[] text) throws Exception {
		int[] overlap = getOverlap(pattern);
		int m = pattern.length;
		int n = text.length;

		int i = 0;
		int j = 0;
		while(i < n) {
			if(text[i] == pattern[j]) {
				i++;
				j++;
			}
			if(j == m) {
				System.out.println("Found text at index: " + (i - j));
				j = overlap[j - 1];
			} else if(pattern[j] != text[i]) {
				if(j != 0) {
					j = overlap[j - 1];
				} else {
					i++;
				}
			}
		}
	}

	int[] getOverlap(int[] pattern) throws Exception {
		int patternSize = pattern.length;
		if(patternSize <= 0) {
			throw new Exception("pattern size is <= 0");
		}
		int[] overlap = new int[patternSize];

		overlap[0] = 0;
		for(int k = 0; k < patternSize - 1; k++) {
			int c = pattern[k + 1];
			int v = overlap[k];
			while(pattern[v] != c && v != 0) {
				v = overlap[v];
			}

			if(pattern[v] == c ) {
				overlap[k + 1] = v + 1;
			} else {
				overlap[k + 1] = 0;
			}
		}
		return overlap;
	}

	public static void main(String[] args) throws Exception {
		Kmp kmp = new Kmp();
		int[] text = new int[] {'A', 'T', 'T', 'A', 'T', 'A', 'C', 'A'};
		int[] pattern = new int[] {'T', 'A', 'T'};
		kmp.search(pattern, text);

	}
}
