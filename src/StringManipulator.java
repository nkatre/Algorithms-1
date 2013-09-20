/**
 * Problem statement:
 * String manipulator takes a sentence in english language which does not have spaces in between the
 * words, and returns the sentence with the spaces inserted.
 * 
 * Approach/Data structure:
 * We use recursive backtracking to solve this problem. We divide the string into prefix and suffix of various sizes and 
 * if the prefix exists in the dictionary, we check if the suffix exists as well. If it does, we append the prefix
 * while inserting a space(" ") in between the two.
 * 
 * We also use a trie data structure to maintain the dictionary. For the sake of this implementation,
 * I have only implemented the isWord() method in trie which checks if a given string is a word in the dictionary
 * or not.
 *
 * @author shubham
 *
 */
public class StringManipulator {
	
	/**
	 * 
	 * @param string
	 * 		string sentence without spaces in between each word
	 * @param dictionary
	 * 		dictionary of words - implemented using trie
	 * @return
	 * 		sentence with spaces inserted between each word
	 */
	public String getSentenceFromString(String string, Trie dictionary) {
		
		// Termination condition for recursion
		if(dictionary.isWord(string)) {
			return string;
		}
		
		// get length of string
		int l = string.length();
		
		/**
		 * Divide the string into prefix and suffix such that
		 * the original string = prefix + suffix If prefix is a word in the dictionary, 
		 * then recursively check if the suffix is also a word in the dicionary and append it to the prefix
		 * while adding white spaces appropriately.
		 * 
		 */
		for(int i=1; i<string.length(); i++) {
			String prefix = string.substring(0, i);
			if(dictionary.isWord(prefix)) {
				String suffix = string.substring(i, l);
				String spaceSeparatedSentenceFromSuffix = getSentenceFromString(suffix, dictionary);
				
				if(spaceSeparatedSentenceFromSuffix != null) {
					return prefix + " " + spaceSeparatedSentenceFromSuffix;
				}
			}
		}
		
		// if none of this worked, this string is not in the dictionary
		return null;
	}
}

/**
 * Helper class for maintaining a dictionary. This is being used by StringManipulator
 * @author shubham
 *
 */
class Trie {
	
	private static final int ALPHABETS_IN_LANGUAGE = 26; // assuming there are only english alphabets
	Trie[] links;
	boolean isWord;
	
	// constructor
	public Trie() {
		links = new Trie[ALPHABETS_IN_LANGUAGE];
		isWord = false;
	}
	
	/**
	 * Checks is a given string is a word in the dictionary
	 * @param str
	 * 		candidate string
	 * @return
	 * 		true if the string is a word in the dictionary, false otherwise
	 */
	public boolean isWord(String str) {
		Trie t = this;
		// get length of string
		int l = str.length();
		
		for(int i=0; i<l; i++) {
			// assuming all the characters are lower case
			int indexInTrie = str.charAt(i) - 'a';
			
			if(t.links[indexInTrie] == null) { 
				// it is not a word
				return false;
			}
			t = t.links[indexInTrie];
		}
		
		// if isWord is true, then it is a word, otherwise it is not
		return t.isWord;
	}
	
	// getters and setters go here...
	// ...
	
}
