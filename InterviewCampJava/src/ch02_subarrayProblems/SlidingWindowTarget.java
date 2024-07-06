// @author: seanpcox

package ch02_subarrayProblems;

public class SlidingWindowTarget {
	
	public static void main(String[] args) {
		int[] input = {1,2,3,5,2};
		int target = 8;
		int[] result = slidingWindowTarget(input, target);
		System.out.println(result[0] + " " + result[1]);
	}
	
	public static int[] slidingWindowTarget(int[] input, int target) throws RuntimeException {
		if(input == null || input.length <= 0) {
			throw new RuntimeException("Invalid Input");
		}
		
		int sp = 0;
		int ep = 0;
		int sum = input[0];
		
		int[] result = {-1,-1};
		
		while(sp < input.length) {
			if(sp > ep) {
				ep = sp;
				sum = input[sp];
			}
			
			if(sum < target) {
				if(ep == input.length - 1) {
					break;
				}
				
				ep++;
				sum += input[ep];
			} else if(sum > target) {
				sum -= input[sp];
				sp++;
			} else {
				result[0] = sp;
				result[1] = ep;
				return result;
			}
		}
		
		return result;
	}

}
