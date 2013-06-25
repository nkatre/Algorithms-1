package com.shubham.misc_problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * http://stackoverflow.com/questions/2344496/how-can-i-print-out-all-possible-letter-combinations-a-given-phone-number-can-re
 * 
 * Find all possible permutations of a string from a number input from a keyboard
 * E.g. 234 should return:
 * [adg, adh, adi, aeg, aeh, aei, afg, afh, afi, bdg, bdh, bdi, beg, beh, bei, bfg, bfh, bfi, cdg, cdh, cdi, ceg, ceh, cei, cfg, cfh, cfi]
 */
public class AllPermutationsFromT9 {
	List<String> getAllPermutations(String digitsPressed) {
		
		Map<Character, String> map = new HashMap<Character, String>() {{
			put('2', "abc");
			put('3', "def");
			put('4', "ghi");
			put('5', "jkl");
			
		}};
		
		List<String> results = new ArrayList<String>();
		results.add("");
		
		List<String> preResult = new ArrayList<String>();
		
		// if "234" is pressed
		for(int i = 0; i<digitsPressed.length(); i++) { // "2" 
			String letters = map.get(digitsPressed.charAt(i)); // "abc"
			for(int j=0; j<letters.length(); j++) { // 3
				for(String result : results) {
					preResult.add(result + letters.charAt(j));
				}
			}
			results = preResult;
			preResult = new ArrayList<String>();
		}
		return results;
	}
	
	public static void main(String[] args) {
		AllPermutationsFromT9 obj = new AllPermutationsFromT9();
		List<String> output = obj.getAllPermutations("23");
		System.out.println(output);
	}
}
