// @author: seanpcox

package ch05_binarySearch;

public class FindAPeakInArray {
	
	// if first element assume one before is - infinity
	// If last element assume one after is -infinity
	
	public static void main(String[] args) {
		int[] input = {7,6,5,1,2,3,4,0};
		int result = findAPeakInArrayMine(input);
		System.out.println(result);
		result = findAPeakInArray(input);
		System.out.println(result);
		// Is there only one peak?
		// Are numbers all positive?
		// How do you want it returned?
		// What if an empty array?
		
		// Trick here is if we sample any element it will eventually lead us to a peak
		// There are no duplicates allowed, else there could be a case where these is no peak
	}

	private static int findAPeakInArray(int[] input) {
		if(input == null || input.length <= 0) {
			throw new RuntimeException("Invalid Input");
		}
		
		int sp = 0;
		int ep = input.length - 1;
		int mid = 0;
		
		while(sp <= ep) {
			mid = sp + ((ep-sp)/2);
			
			int left = mid == 0 ? Integer.MIN_VALUE : input[mid-1];
			int right = mid == input.length - 1 ? Integer.MIN_VALUE : input[mid+1];
			
			if(input[mid] > left && input[mid] < right) {
				sp = mid + 1; // Slope going right
			} else if(input[mid] < left && input[mid] > right) {
				ep = mid - 1; // Slope going left
			} else if(input[mid] < left && input[mid] < right) {
				sp = mid + 1; // Valley floor, slopes both ways
				//ep = mid - 1; // Doesn't matter which way we go, we are in a valley
			} else {
				return mid; // We are at a peak
			}
		}
		
		return mid;
	}
	
	private static int findAPeakInArrayMine(int[] input) {
		if(input == null || input.length <= 0) {
			throw new RuntimeException("Invalid Input");
		}
		
		int sp = 0;
		int ep = input.length - 1;
		int mid = 0;
		
		while(sp <= ep) {
			mid = sp + ((ep-sp)/2);
			
			if(mid == 0 && input[mid] > input[mid+1]) {
				break; // At first element and next is lower
			} else if(mid == input.length -1 && input[mid] > input[mid-1]) {
				break; // At last element and previous is lower
			} else if(input[mid] > input[mid-1] && input[mid] > input[mid+1]) {
				break;
			} else if(input[mid] > input[mid-1] && input[mid] < input[mid+1]) {
				sp = mid + 1; // Slope going right
			} else if(input[mid] < input[mid-1] && input[mid] > input[mid+1]) {
				ep = mid - 1; // Slope going left
			} else if(input[mid] < input[mid-1] && input[mid] < input[mid+1]) {
				sp = mid + 1; // Valley floor, slopes both ways
				//ep = mid - 1; // Doesn't matter which way we go, we are in a valley
			}
		}
		
		return mid;
	}

}
