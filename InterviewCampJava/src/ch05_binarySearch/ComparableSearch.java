// @author: seanpcox

package ch05_binarySearch;

public class ComparableSearch {

	// O(logn) time
	// No duplicates allowed
	
	public static void main(String[] args) {
		//Double[] input = {1d,2d,3d,4d,5d,6d,7d};
		//Double target = 3d;
		Character[] input = {'a','b','c','d','e','f','g'};
		Character target = 'c';
		int result = binarySearch(input, target);
		System.out.println(result);
	}

	public static <A extends Comparable<A>> int binarySearch(A[] input, A target) throws RuntimeException {
		if(input == null || input.length <= 0) {
			throw new RuntimeException("Invalid Input");
		}
		
		int sp = 0;
		int ep = input.length - 1;
		
		while(sp <= ep) {
			int mp = sp + ((ep-sp)/2);
			
			if(input[mp].compareTo(target) > 0) {
				ep = mp-1;
			} else if(input[mp].compareTo(target) < 0) {
				sp = mp+1;
			} else {
				return mp;
			}
		}
		
		return -1;
	}
	
}
