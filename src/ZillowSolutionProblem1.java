
/**
 * Solution to Problem 1.
 * @author shubham
 *
 */
public class ZillowSolutionProblem1 {
	
	/**
	 * PROBLEM 1:
	 * Given a string, write a routine that converts the string to a long, without using the
	 * built in functions that would do this.  Describe what (if any) limitations the code has.
	 * 
	 * Limitations of the code:
	 * 1. Does not work for cases where the string representation of the long integer exceeds the MAX value for long.
	 * 2. Does not support exponential representation of numbers. E.g. 1.4e10 etc.
	 */
	static long stringToLong(String string) throws NumberFormatException {
		final int ZERO_CHARACTER = 48;
		
		// Handle edge case - string size is <= 0
		if(string.length() <= 0) {
			throw new NumberFormatException("Parameter length cannot be less than 1");
		}
		
		// result to be returned
		long result = 0L;
		boolean isNegativeNumber = isNegativeNumber(string);
		
		/*
		 * If it is a negative number (e.g. "-345"), then only calculate the corresponding
		 * long value of "345", and add the sign later before returning the 'result'.
		 * This does have the limitation that there should not be any extra spaces between the 
		 * negative sign (-) and the number. E.g. "- 345" - will not work.
		 */
		if(isNegativeNumber) {
			string = string.substring(1);
		}
		
		// get the length of the string
		int size = string.length();
		
		/*
		 * Go one character at a time while building up the corresponding 'long' integer...
		 */
		int currentIndex = size - 1;
		int multiplier = 1;
		while(currentIndex >= 0) {
			result += (string.charAt(currentIndex) - ZERO_CHARACTER) * multiplier;
			multiplier *= 10;
			currentIndex--;
		}
		
		// get the sign back in...
		if(isNegativeNumber) {
			result *= -1;
		}
		
		return result;
	}
	
	private static boolean isNegativeNumber(String number) {
		return number.charAt(0) == '-';
	}
}
