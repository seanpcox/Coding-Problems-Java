// @author: seanpcox

package ch02_subarrayProblems;

import java.util.HashMap;
import java.util.Map;

public class PrefixSumFindTarget {
	
	public static void main(String[] args) {
		int[] input = {2, 2,4,-2,1,-3,5,-3};
		//             2, 4,8, 6,7, 4,9, 6
		int target = -4;
		Pair pair = prefixSumFindTarget(input, target);
		System.out.println(pair);
	}
	
	// Prefix sum is getting the sum at each point and storing it
	
	public static Pair prefixSumFindTarget(int[] input, int target) throws RuntimeException {
		if(input == null || input.length <= 0) {
			throw new RuntimeException("Invalid Input");
		}
		
		int sum = 0;
		Map<Integer, Integer> prefixSums = new HashMap<>();
		
		for(int i = 0; i < input.length; i++) {
			sum += input[i];
			
			// First condition, if prefix sum is zero is means at some 
			// point we get to zero from the start of the array.
			if(sum == target) {
				return new Pair(0, i);
			}
			
			// If we have already seen a prefix sum before whose value is
			// the current sum subtracted by the target that means the numbers
			// in-between make the target.
			if(prefixSums.containsKey(sum - target)) {
				return new Pair(prefixSums.get(sum - target) + 1, i);
			}
			
			prefixSums.put(sum, i);
		}
		
		return null;
	}

	static class Pair {
		private Integer first;
		private Integer second;
		
		public Pair(Integer first, Integer second) {
			this.first = first;
			this.second = second;
		}
		
		public String toString() {
			return first + " " + second;
		}
	}
	
}
