package com.shubham.misc_problems;

import java.util.Set;

/**
 * Check if a word is made up of 'k' valid words froma  dictionary
 * http://stackoverflow.com/questions/4902793/if-a-word-is-made-up-of-two-valid-words
 * 
 * @author shubham

 */
public class SplitStringIntoDictionaryWords {
	
	public boolean isSplittable(String word, int k, Set<String> dictionary) throws Exception {
		if(word.isEmpty() || k == 0) {
			return word.isEmpty() && k == 0;
		}
		
		for(int i=1; i<word.length(); i++) {
			String str1 = word.substring(i);
			String str2 = word.substring(i);
			if(dictionary.contains(str1) && isSplittable(str2, k-1, dictionary)) {
				return true;
			}
		}
		return false;
	}
	
}
