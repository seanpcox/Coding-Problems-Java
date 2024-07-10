// @author: seanpcox

package ch01_arraysAndStrings1;

public class ReverseWordsInSentance {
	
	/*
	 * Given a sentence, reverse the words of the sentence.
	 * For example,"i live in a house" becomes "house a in live i"
	 */
	
	// Examples & Questions
	
	// Ex: "my name is sean" -> "sean is name my"
	// Ex: " my  " -> "  my "
	// Does case matter? (assume lower case)
	// What about punctuation and special symbols? (assume none)
	// What about an empty string or null string? (return as is)
	// What about all spaces? (assume yes, but only one)
	// Can there be spaces at the start or end? (assume yes)
	// Can there be more than one space between words? (assume no)
	// OK is I allocate a new String for the result? (tbh have to since Strings are immutable)
	
	// Solution
	
	// Create a new StringBuilder (not concurrent so StringBuffer not needed)
	// Normal String needs concatenation (though compiler probably optimizes it behind the scenes)
	// Create variables to mark the start and end point of a word
	// Start at the end of the sentence and traverse through
	// If a space is found, and no end point is listed copy the space to the output
	// If a space is found, or we have reached the end of input, copy the space and mark
	// If an endPoint is listed add index to end point subString to output add to output and continue
	
	// Test Cases
	
	// null (c) -> null
	// "" (c) -> ""
	// " " (c) -> " "
	// " hi " (c) -> " hi "
	// "hi" (b) -> "hi"
	// "hi sean" (b) -> "sean hi"
	// "how are you sean" (r) -> "sean you are how"
	
	// Solution
	
	public static void main(String[] args) {
		String s = "how are you sean";
		
		System.out.println(s);
		
		s = reverseSentence(s);
		
		System.out.println(s);
	}
	
	public static String reverseSentence(String input) {
		if(input == null || input.length() <= 1) {
			return input;
		}
		
		StringBuilder output = new StringBuilder();
		int endPoint = -1;
		
		for(int i = input.length() - 1; i >= 0; i--) {
			if(input.charAt(i) == ' ') {
				output.append(' ');
				continue;
			}
			
			if(endPoint == -1) {
				endPoint = i;
			}
			
			if(i == 0 || input.charAt(i-1) == ' ') {
				output.append(input.substring(i, endPoint+1));
				endPoint = -1;
			}
		}
		
		return output.toString();
	}
	
}
