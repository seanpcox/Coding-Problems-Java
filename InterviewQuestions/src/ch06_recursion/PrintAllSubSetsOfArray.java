// @author: seanpcox

package ch06_recursion;

public class PrintAllSubSetsOfArray {

	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6,7};
		printAllSubSets(a);
	}

	public static void printAllSubSets(int[] a) {
		if(a == null || a.length == 0) {
			return;
		}
		
		int[] b = new int[a.length];
		
		printAllSubSetsHelper(a, b, 0, 0);
	}

	private static void printAllSubSetsHelper(int[] a, int[] b, int ai, int bi) {
		// Same algorithm as fixed length print except we print ALL entries as we pass through, we need to mark the index to print to though
		// Remember we reuse the buffer so don't want old values appearing for smaller subsets
		printBuffer(b, bi);
		
		// 1. Base cases
		if(bi == b.length) {
			return;
		}
		if(ai == a.length) {
			return;
		}
		
		// 2. Get candidates
		for(int i = ai; i < a.length; i++) {
			// 3. Add to buffer
			b[bi] = a[i];
			
			// 4. Recurse to next index
			printAllSubSetsHelper(a, b, i+1, bi+1);
		}
	}
	
	private static void printBuffer(int[] b, int bi) {
		for(int i = 0; i < bi; i++) {
			System.out.print(b[i] + " ");
		}
		System.out.println();
	}
}
