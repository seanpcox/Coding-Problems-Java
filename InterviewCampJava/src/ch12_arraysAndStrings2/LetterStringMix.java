// @author: seanpcox

package ch12_arraysAndStrings2;

public class LetterStringMix {

	// Check if a string A is a rotation of another string B. For example, "atbobc" is a rotation of "bobcat".
	
	// Will it only be lowercase?
	// Is it only a-z characters?
	// Can there be duplicate characters?
	// What if one of the words is null?
	// What if both words are null? Are they equal?
	// What about two empty strings? Are they equal?
	
	public static void main(String[] args) {
		String a = "atbobc";
		String b = "bobcat";
		System.out.println(letterRotation(a, b));
	}
	
	public static boolean letterRotation(String a, String b) {
		if(a == null || b == null || a.length() != b.length()) {
			return false;
		}
		
		a += a;
		
		return a.contains(b);
	}
	
}
