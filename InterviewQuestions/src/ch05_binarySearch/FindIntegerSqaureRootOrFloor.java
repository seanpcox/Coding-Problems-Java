// @author: seanpcox

package ch05_binarySearch;

public class FindIntegerSqaureRootOrFloor {

	public static void main(String[] args) {
		int number = 2000;
		int result = findIntegerSqaureRootOrFloorByMathAndCast(number);
		System.out.println(result);
		result = findIntegerSqaureRootOrFloorNoMathOrCast(number);
		System.out.println(result);
	}

	private static int findIntegerSqaureRootOrFloorNoMathOrCast(int number) {
		if(number <= 1) { // 0 words below but 1 does not, also quicker
			return number;
		}
		
		int sp = 0;
		int ep = number; // Can /2 for Optimization, though only by 1, roots are never more than half except 1
		int mid = 0;
		
		while(sp <= ep) {
			mid = sp +((ep-sp)/2);
			
			if(mid*mid > number) {
				ep = mid - 1;
			} else if(mid*mid < number) {
				sp = mid + 1;
			} else {
				break;
			}
		}
		
		if(mid*mid > number) {
			mid--;
		}
		
		return mid;
	}
	
	private static int findIntegerSqaureRootOrFloorByMathAndCast(int number) {
		int result = (int) Math.sqrt(number);
		return result;
	}
	
}
