// @author: seanpcox

package ch06_recursion;

public class PrintAllPermutationsArrayOfLength {

	// This time we are looking for permutations vs combos so 123 is NOT the same as 312
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6,7};
		int l = 3;
		printPermutations(a, l);
	}

	private static void printPermutations(int[] a, int l) {
		if(a == null || a.length == 0) {
			return;
		}
		
		int[] b = new int[l];
		boolean[] inb = new boolean[a.length];
		
		printPermutationsHelper(a, b, 0, inb);
	}

	private static void printPermutationsHelper(int[] a, int[] b, int bi, boolean[] inb) {
		// 1. Base cases
		if(bi == b.length) {
			printBuffer(b);
			return;
		}
		
		// 2. Find all candidates
		for(int i = 0; i < a.length; i++) {
			if(!inb[i]) {
				// 3. Add to buffer
				b[bi] = a[i];
				
				inb[i] = true;
				
				// 4. Recurse to next step
				printPermutationsHelper(a, b, bi+1, inb);
				
				inb[i] = false;
			}
		}
	}
	

	private static void printBuffer(int[] b) {
		for(int bv : b) {
			System.out.print(bv + " ");
		}
		System.out.println();
	}
	
}
