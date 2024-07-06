// @author: seanpcox

package ch12_arraysAndStrings2;

public class ReverseSentence {

	// Reverse the words in a sentence. For example,

	// "what is your name" => "name your is what"
	// Can there be spaces before or after?
	// Will there only be one space in between each word?
	// Any punctuation?

	public static void main(String[] args) {
		String a = "what is your name";
		System.out.println(reverse(a));
		char[] chars = {'w','h','a','t',' ','i','s',' ','y','o','u','r',' ','n','a','m','e'};
		System.out.println(reverse(chars));
	}

	// Reverse the String then reverse each word
	// Strings are immutable in Java so use char array
	public static char[] reverse(char[] chars) {
		if(chars == null || chars.length <= 1) {
			return chars;
		}
		
		reverseChars(chars, 0, chars.length - 1);
		
		int start = 0;
		for(int i = 0; i < chars.length; i++) {
			if(chars[i] == ' ') {
				reverseChars(chars, start, i-1);
				start = i+1;
			}
		}
		
		reverseChars(chars, start, chars.length - 1);
		
		return chars;
	}
	
	private static void reverseChars(char[] chars, int s, int e) {
		while(s < e) {
			char temp = chars[s];
			chars[s] = chars[e];
			chars[e] = temp;
			s++;
			e--;
		}
	}

	public static String reverse(String a) {
		String[] s = a.split(" ");
		
		StringBuilder b = new StringBuilder();
		
		for(int i = s.length - 1; i >= 0; i--) {
			b.append(s[i]);
			
			if(i > 0) {
				b.append(" ");
			}
		}
		
		return b.toString();
	}
	
}
