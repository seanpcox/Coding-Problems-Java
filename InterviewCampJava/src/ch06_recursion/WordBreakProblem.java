// @author: seanpcox

package ch06_recursion;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class WordBreakProblem {

	// ilikemangotango
	// Find one combinations of valid words
	
	static Set<String> dictionary = new HashSet<>();
	static { 
		dictionary.add("man"); 
		dictionary.add("go");
		dictionary.add("mango");
		//dictionary.add("gob");
	};
	
	static int loop1 = 0;
	static int loop2 = 0;
	
	// Start first char, check every continuous subset to see if valid word
	// For every valid word found recur starting at end of valid word
	// If reach the end with a valid word return true
	// Else return false
	
	public static void main(String[] args) {
		String string = "mangoman";
		//String string = "mangobman";
		
		wordBreak(string, dictionary);
		System.out.println(loop1);
		wordBreak2(string, dictionary);
		System.out.println(loop2);
	}
	
	public static void wordBreak2(String s, Set<String> dictionary) {
		if(s== null || s.isEmpty()) {
			return;
		}
		
		Stack<String> result = new Stack<String>();
		
		boolean[] memo = new boolean[s.length()];
		
		if(wordBreak2(s, 0, result, memo, dictionary)) {
			printStack(result);
		}
	}
	
	private static boolean wordBreak2(String s, int start, Stack<String> result, boolean[] memo,
			Set<String> dictionary) {
		if(start == s.length()) {
			return true;
		}
		
		if(memo[start]) {
			return false;
		}
		
		for(int i = start; i < s.length(); i++) {
			loop2++;
			String candidate = s.substring(start, i+1);
			
			if(dictionary.contains(candidate)) {
				result.push(candidate);
				
				if(wordBreak2(s, i + 1, result, memo, dictionary)) {
					return true;
				} else {
					memo[i+1] = true;
					result.pop();
				}
			}
		}
		
		return false;
	}

	public static void wordBreak(String s, Set<String> dictionary) {
		if(s == null || s.isEmpty()) {
			return;
		}
		
		Stack<String> result = new Stack<String>();
		
		if(wordBreak(s, 0, result, dictionary)) {
			printStack(result);
		}
	}
	
	private static boolean wordBreak(String s, int start, Stack<String> result, Set<String> dictionary) {
		if(start == s.length()) {
			return true;
		}
		
		for(int i = start; i < s.length(); i++) {
			loop1++;
			String sub = s.substring(start, i+1);
			
			if(dictionary.contains(sub)) {
				result.push(sub);
				
				if(wordBreak(s, i+1, result, dictionary)) {
					return true;
				} else {
					result.pop();
				}
			}
		}
		
		return false;
	}
	
	private static void printStack(Stack<String> s) {
		for(String sv : s) {
			System.out.print(sv + " ");
		}
		System.out.println();
	}
	
}
