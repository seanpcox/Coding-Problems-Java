// @author: seanpcox

package ch12_arraysAndStrings2;

public class LongestPalindrome {

	// Note we need to check for both even and odd length palindromes
	// O(n^2)
	// Space - O(1) if given an array of chars, else O(n) as new String to store result
	
	public static void main(String[] args) {
		String a = "zsxkayakcvvwwracecarabcababadtattarrattatef";
		System.out.println(longestPalindromeMine(a));
	}
	
	public static String longestPalindromeMine(String s) {
		if(s == null || s.length() <= 1) {
			return s;
		}
		
		char[] chars = s.toCharArray();
		
		String result = "";
		
		for(int i = 0; i < chars.length; i++) {
			// Odd
			result = getPalindrome(result, chars, i, i);
			// Even
			result = getPalindrome(result, chars, i, i+1);
		}
		
		return result;
	}
	
	private static String getPalindrome(String result, char[] chars, int start, int end) {
		String temp = "";
		
		while(start >= 0 && end < chars.length) {
			if(chars[start] == chars[end]) {
				if(start == end) {
					temp += chars[start];
				} else {
					temp = chars[start] + temp + chars[start];
				}
			} else {
				break;
			}
			start--;
			end++;
		}
		
		if(temp.length() > result.length()) {
			result = temp;
		}
		
		return result;
	}
	
}
