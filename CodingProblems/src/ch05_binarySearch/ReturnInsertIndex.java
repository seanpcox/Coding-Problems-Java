// @author: seanpcox

package ch05_binarySearch;

public class ReturnInsertIndex {

	public static void main(String[] args) {
		int[] input = {1,2,4,5,7,8,9};
		int target = 6;
		int result = binarySearchReturnInsertIndex(input, target);
		System.out.println(result);
	}
	
	// Same as find last target with dups. 
	// But if target is the same or greater than last entry found we need to increase it
	
	public static int binarySearchReturnInsertIndex(int[] input, int target) {
		if(input == null || input.length <= 0) {
			throw new RuntimeException("Invalid Input");
		}
		
		int mid = 0;
		int sp = 0;
		int ep = input.length - 1;
		
		while(sp <= ep) {
			mid = sp + ((ep-sp) / 2);
			
			if(input[mid] > target) {
				ep = mid - 1;
			} else if(input[mid] < target || (mid < input.length -1 && input[mid+1] == target)) {
				sp = mid + 1;
			} else {
				break;
			}
		}
		
		if(target >= input[mid]) {
			mid++;
		}
		
		return mid;
	}
	
}
