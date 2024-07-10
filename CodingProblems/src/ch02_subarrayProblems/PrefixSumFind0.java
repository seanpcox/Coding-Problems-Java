// @author: seanpcox

package ch02_subarrayProblems;

import java.util.HashMap;
import java.util.Map;

public class PrefixSumFind0 {
	
	public static void main(String[] args) {
		int[] input = {2,4,-2,1,-3,5,-3};
		Pair pair = prefixSumFind0(input);
		System.out.println(pair);
	}
	
	// Prefix sum is getting the sum at each point and storing it
	
	public static Pair prefixSumFind0(int[] input) throws RuntimeException {
		if(input == null || input.length <= 0) {
			throw new RuntimeException("Invalid Input");
		}
		
		int sum = 0;
		Map<Integer, Integer> prefixValues = new HashMap<>();
		
		for(int i = 0; i < input.length; i++) {
			sum += input[i];
			
			// First condition, if prefix sum is zero is means at some 
			// point we get to zero from the start of the array
			if(sum == 0) {
				return new Pair(0, i);
			}
			
			// If we have already seen a prefix sum before it means the values
			// in between did not alter the value and this must equal zero.
			if(prefixValues.containsKey(sum)) {
				return new Pair(prefixValues.get(sum) + 1, i);
			}
			
			prefixValues.put(sum, i);
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
