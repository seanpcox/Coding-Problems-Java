// @author: seanpcox

package ch12_arraysAndStrings2;

public class LetterRotation {

	// Check if a string A contains the same letters as another string B. For example, "atbobc" contains the same letters as "bobcat".
	
	// Will it only be lowercase?
	// Is it only a-z characters?
	// Can there be duplicate characters?
	// What if one of the words is null?
	// What if both words are null? Are they equal?
	// What about two empty strings? Are they equal?
	
	public static void main(String[] args) {
		String a = "abbtoc";
		String b = "bobcat";
		System.out.println(letterStringMix(a, b));
	}
	
	public static boolean letterStringMix(String a, String b) {
		if(a == null || b == null || a.length() != b.length()) {
			return false;
		}
		
		int[] alpha = new int[26];
		
		for(int i = 0; i < a.length(); i++) {
			alpha[a.charAt(i) - 'a']++;
			alpha[b.charAt(i) - 'a']--;
		}
		
		for(int c : alpha) {
			if(c != 0) {
				return false;
			}
		}
		
		return true;
	}
	
}
