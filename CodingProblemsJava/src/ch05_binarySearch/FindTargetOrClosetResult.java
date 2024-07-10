// @author: seanpcox

package ch05_binarySearch;

public class FindTargetOrClosetResult {

	public static void main(String[] args) {
		int[] input = {10,20,30,40};
		int target = 23;
		int result = binarySearchFindTargetOrClosetResult(input, target);
		System.out.println(result);
		result = binarySearchFindTargetIndexOrClosetIndex(input, target);
		System.out.println(result);
	}
	
	public static int binarySearchFindTargetOrClosetResult(int[] input, int target) {
		if(input == null || input.length <= 0) {
			throw new RuntimeException("Invalid Input");
		}
		
		int sp = 0;
		int ep = input.length - 1;
		int result = input[0];
	
		while(sp <= ep) {
			int mid = sp + ((ep-sp)/2);
			
			if(Math.abs(target - input[mid]) < Math.abs(target - result)) {
				result = input[mid];
			}
			
			if(input[mid] > target) {
				ep = mid - 1;
			} else if(input[mid] < target) {
				sp = mid + 1;
			} else {
				return input[mid];
			}
		}
		
		return result;
	}
	
	public static int binarySearchFindTargetIndexOrClosetIndex(int[] input, int target) {
		if(input == null || input.length <= 0) {
			throw new RuntimeException("Invalid Input");
		}
		
		int sp = 0;
		int ep = input.length - 1;
		int index = 0;
	
		while(sp <= ep) {
			int mid = sp + ((ep-sp)/2);
			
			if(Math.abs(target - input[mid]) < Math.abs(target - input[index])) {
				index = mid;
			}
			
			if(input[mid] > target) {
				ep = mid - 1;
			} else if(input[mid] < target) {
				sp = mid + 1;
			} else {
				return mid;
			}
		}
		
		return index;
	}
	
}
