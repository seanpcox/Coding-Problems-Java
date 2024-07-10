// @author: seanpcox

package ch05_binarySearch;

public class SimpleSearch {
	
	// O(logn) time
	// No duplicates allowed
	
	public static void main(String[] args) {
		int[] input = {1,2,3,4,5,6,7};
		int target = 3;
		int result = binarySearch(input, target);
		System.out.println(result);
	}

	public static int binarySearch(int[] input, int target) throws RuntimeException {
		if(input == null || input.length <= 0) {
			throw new RuntimeException("Invalid Input");
		}
		
		int sp = 0;
		int ep = input.length - 1;
		
		while(sp <= ep) {
			int mp = sp + ((ep-sp)/2);
			
			if(input[mp] > target) {
				ep = mp-1;
			} else if(input[mp] < target) {
				sp = mp+1;
			} else {
				return mp;
			}
		}
		
		return -1;
	}
}
