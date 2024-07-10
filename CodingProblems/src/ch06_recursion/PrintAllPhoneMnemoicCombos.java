// @author: seanpcox

package ch06_recursion;

public class PrintAllPhoneMnemoicCombos {

	public static void main(String[] args) {
		printAllCombos(new int[] {2,3,9});
	}
	
	public static void printAllCombos(int[] phoneNumber) {
		if(phoneNumber == null || phoneNumber.length <= 0) {
			return;
		}
		
		char[] buffer = new char[phoneNumber.length];
		
		printAllCombosHelper(phoneNumber, buffer, 0, 0);
	}
	
	private static void printAllCombosHelper(int[] n, char[] b, int ni, int bi) {
		// 1. Termination case, the second case deals with cases where there are no letters for a number
		if(bi == b.length || ni >= n.length) {
			printBuffer(b);
			return;
		}
		
		// 2. Get candidates
		char[] letters = getLetters(n[ni]);
		
		// Here we deal with cases where we get a number with no letters, we increase n index but not b index
		if(letters == null) {
			printAllCombosHelper(n, b, ni+1, bi);
		}
		
		for(char c : letters) {
			// 3. But item in buffer
			b[bi] = c;
			
			// 4. Recurse to next index
			printAllCombosHelper(n, b, ni+1, bi+1);
		}
	}
	
	private static char[] getLetters(int n) {
		if(n == 2) {
			return new char[] {'a','b','c'};
		} else if(n == 3) {
			return new char[] {'d','e','f'};
		} else if(n == 4) {
			return new char[] {'g','h','j'};
		} else if(n == 5) {
			return new char[] {'k','l','m'};
		} else if(n == 6) {
			return new char[] {'n','m','o'};
		} else if(n == 7) {
			return new char[] {'p','q','r','s'};
		} else if(n == 8) {
			return new char[] {'t','u','v'};
		} else if(n == 9) {
			return new char[] {'w','x','y','z'};
		}
		
		return null;
	}
	
	private static void printBuffer(char[] b) {
		for(char bv : b) {
			System.out.print(bv + " ");
		}
		System.out.println();
	}
	
}
