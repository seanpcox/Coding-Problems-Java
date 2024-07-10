// @author: seanpcox

package ch06_recursion;

public class PrintCombosInArrayOfLength {

	/*
		1. Define termination conditions / base cases
		2. Find candidates that go into buffer
		3. Place each candidate into the buffer
		4. Recurse to next buffer index
	*/
	
	public static void main(String[] args) {
		// Note in combinations the order doesn't matter (though confirm with interviewer)
		// i.e. 123 is the same as 321 so no need to print both
		int[] a = {1,2,3,4,5,6,7};
		printAllCombos(a, 3);
	}
	
	
	public static void printAllCombos(int[] a, int x) {
		int[] b = new int[x];
		printAllCombosHelper(a, b, 0, 0);
	}
	
	public static void printAllCombosHelper(int[] a, int[] buffer, int startIndex, int bufferIndex) {
		// 1. Termination conditions
		if(bufferIndex == buffer.length) {
			printBuffer(buffer);
			return;
		}
		if(startIndex == a.length) {
			return;
		}
		
		// 2. Find all candidates
		for(int i = startIndex; i < a.length; i++) {
			
			// 3. Place item into buffer
			buffer[bufferIndex] = a[i];
			
			// 4. Recurse to next index
			printAllCombosHelper(a, buffer, i + 1, bufferIndex + 1);
		}
	}

	private static void printBuffer(int[] b) {
		for(int bv : b) {
			System.out.print(bv + " ");
		}
		System.out.println();
	}
}
