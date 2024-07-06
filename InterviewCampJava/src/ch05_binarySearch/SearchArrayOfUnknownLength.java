// @author: seanpcox

package ch05_binarySearch;

public class SearchArrayOfUnknownLength {

	public static void main(String[] args) {
		int[] input = {1,2,3,4,5,6,7,8,9};
		int target = 8;
		int result = searchArrayOfUnknownLengthTwoSteps(input, target);
		System.out.println(result);
	}
	
	// We can catch Exceptions here to find the value
	
	public static int searchArrayOfUnknownLengthTwoSteps(int[] input, int target) {
		if(input == null || input.length <= 0) {
			throw new RuntimeException("Invalid Input");
		}
		
		int power2Length = 1;
		
		// First find the highest ^2 length - O(logn) time
		try {
			while(true) {
				@SuppressWarnings("unused")
				int usedToThrowException = input[power2Length];
				power2Length *= 2;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			// Do Nothing
		}
		
		// Second do binary search catching exceptions and update ep as needed - O(logn) time
		int sp = 0;
		int ep = power2Length;
		
		// Third do binary search
		while(sp <= ep) {
			int mid = sp + ((ep - sp)/2);
			
			try {
				if(input[mid] > target) {
					ep = mid - 1;
				} else if(input[mid] < target) {
					sp = mid + 1;
				} else {
					return mid;
				}
			} catch(ArrayIndexOutOfBoundsException e) {
				ep = mid - 1;
			}
		}
		
		return -1;
	}
	
	// We can catch Exceptions here to find the value
	
	public static int searchArrayOfUnknownLengthThreeSteps(int[] input, int target) {
		if(input == null || input.length <= 0) {
			throw new RuntimeException("Invalid Input");
		}
		
		int power2Length = 1;
		int lastPower2NoException = 1;
		
		// First find the highest ^2 length - O(logn) time
		try {
			while(true) {
				@SuppressWarnings("unused")
				int usedToThrowException = input[power2Length];
				lastPower2NoException = power2Length;
				power2Length *= 2;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			// Do Nothing
		}
		
		// Second find the exact length
		int sp = lastPower2NoException;
		int ep = power2Length;
		int mid = 0;
		
		while(sp <= ep) {
			mid = sp + ((ep - sp)/2);
			
			try {
				@SuppressWarnings("unused")
				int usedToThrowException = input[mid];
				sp = mid + 1;
			} catch(ArrayIndexOutOfBoundsException e) {
				ep = mid -1;
			}
		}
		
		sp = 0;
		ep = mid - 1;
		
		// Third do binary search
		while(sp <= ep) {
			mid = sp + ((ep - sp)/2);
			
			if(input[mid] > target) {
				ep = mid - 1;
			} else if(input[mid] < target) {
				sp = mid + 1;
			} else {
				return mid;
			}
		}
		
		return -1;
	}
	
}
