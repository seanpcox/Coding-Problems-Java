// @author: seanpcox

package ch13_hashtable;

public class StringSearchWithHash {

	// String Search: Find the index where the larger string A contains a target string T.
	
	// orl -> ox^2 + rx + l
	// to remove first letter and add new letter, minus ox^2 from it, * rest by x, then add new letter
	
	private static int x = 31;
	
	public static void main(String[] args) {
		String s = "hello world in java";
		String f = "orl";
		System.out.println(findStartIndexOfSubString(s, f));
	}
	
	public static int findStartIndexOfSubString(String s, String f) {
		int offset = f.length()-1;
		
		int findHash = hash(f, 0, offset);
		
		int currentHash = hash(s, 0, offset);
		
		if(currentHash == findHash) {
			return 0;
		}
		
		for(int i = 1; i < s.length() - offset; i++) {
			currentHash = updateHash(currentHash, s, i-1, i + offset, offset);
			
			if(currentHash == findHash) {
				return i;
			}
		}
		
		return -1;
	}
	
	public static int hash(String s, int st, int ed) {
		int hash = 0;
		
		for(int i = st; i <= ed; i++) {
			hash = hash * x + s.charAt(i);
		}
		
		return hash;
	}
	
	// ax^2 + bx + c
	public static int updateHash(int hash, String s, int r, int a, int offset) {
		int diff = a - r - 1;
		
		int rx = s.charAt(r);
		
		// remove last letter, by the power it was raised
		for(int i = 0; i < diff; i++) {
			rx *= x;
		}
		hash = hash - rx;
		hash = hash * x; // move the rest up  one power
		hash = hash + s.charAt(a); // add the new letter
		
		return hash;
	}
	
	public static int simpleHash(char one, char two, char three) {
		return  (one * x * x) + (two * x) + three;
	}
	
	public static int updateSimpleHash(int hash, char remove, char add) {
		hash = hash - (remove * x * x);
		hash = hash * x;
		hash = hash + add;
		return hash;
	}
	
}
