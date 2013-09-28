package com.shubham.misc_problems;

import java.util.List;

public class PermutationssOfString {
	void permute(String prefix, String str) {
		if(str.length() == 0) {
			System.out.println(prefix);
		} else {
			for(int i=0; i<str.length(); i++) {
				permute(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, str.length()));
			}
		}
	}
	
	public static void main(String[] args) {
		PermutationssOfString obj = new PermutationssOfString();
		obj.permute("", "ABCD");
	}
}
