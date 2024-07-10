// @author: seanpcox

package ch05_binarySearch;

public class FindLowestCyclicArray {

	public static void main(String[] args) {
		int[] input = {7,8,1,2,4,6};
		int result = binarySearchFindLowestCyclicArray(input);
		System.out.println(result);
	}
	
	// Use last element as the pivot, if less than we are on right side of cycle, if greater we are left side
	// Note we may have a normal sorted array i.e. has a cycle of 0
	
	public static int binarySearchFindLowestCyclicArray(int[] input) {
		if(input == null || input.length <= 0) {
			throw new RuntimeException("Invalid Input");
		}
		
		int sp = 0;
		int ep = input.length - 1;
		int pivot = input[input.length - 1];
		
		while(sp <= ep) {
			int mid = sp + ((ep-sp)/2);
			
			if(input[mid] <= pivot && 
					(mid == 0 || input[mid] < input[mid - 1])) {
				return mid;
			} else if(input[mid] > pivot) {
				sp = mid + 1;
			} else {
				ep = mid - 1;
			}
		}
		
		return - 1;
	}
	
}
