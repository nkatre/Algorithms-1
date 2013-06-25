package com.shubham.ds;

// http://www.cs.duke.edu/~ola/courses/cps108/fall96/joggle/trie/Trie.java
class Trie {

	private Trie[] myLinks;
	private boolean isMyWord; 
	
	public Trie() {
		myLinks = new Trie[26];
		isMyWord = false;
	}
	
	void addString(String string) {
		Trie t = this;
		for(int k=0;k<string.length(); k++) {
			int index = string.charAt(k) - 'a';
			if(t.myLinks[index] == null) {
				t.myLinks[index]  = new Trie();
			}
			t = t.myLinks[index];
		}
		t.isMyWord = true;
	}
	
	boolean search(Trie t, String s) {
		for(int i=0;i<s.length(); i++) {
			int index = s.charAt(i) - 'a';
			if(t.myLinks[index] == null) return false;
			t = t.myLinks[index];
		}
		return t.isMyWord;
	}
	
}