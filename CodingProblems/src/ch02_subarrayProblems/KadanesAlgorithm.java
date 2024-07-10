// @author: seanpcox

package ch02_subarrayProblems;

public class KadanesAlgorithm {
	
	// Given an array find the subarray with the maximum sum.
	
	// Examples and Clarify
	// What type of elements are in the array? Integers
	// Can the result be an empty array i.e. this would mean zero? No
	// Can the array have both positive and negative numbers? Yes
	// How do you want the result returned? Return the max sum
	// By subarray do we mean contingous/continous subarray? Yes
	// What is the input is empty or null? throw Exception
	// Is the array sorted? No
	// What if more than one result?
	
	public static void main(String[] args) {
		int[] input = {1,2,-1,2,-3,2,-5};
		int result = kadanesAlgorithm(input);
		System.out.println(result);
	}
	
	public static int kadanesAlgorithm(int[] input) throws RuntimeException {
		if(input == null || input.length <= 0) {
			throw new RuntimeException("Invalid Input");
		}
		
		int result = input[0];
		int maxAtI = input[0];
		
		for(int i = 1; i < input.length - 1; i++) {
			maxAtI = Math.max(input[i], input[i] + maxAtI);
			result = Math.max(maxAtI, result);
		}
		
		return result;
	}

}
