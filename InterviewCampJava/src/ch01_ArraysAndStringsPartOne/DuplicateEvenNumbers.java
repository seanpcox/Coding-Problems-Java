// @author: seanpcox

package ch01_ArraysAndStringsPartOne;

import java.util.Arrays;

/*

Question
--------
Given an array of numbers, replace each even number with two of the same number.

Example
-------
[1,2,5,6,8] -> [1,2,2,5,6,6,8,8]

*/

public class DuplicateEvenNumbers {

	// Method To Duplicate Even Numbers In Place In Array
	public static int[] duplicateEvenNumbers(int[] array) {
		// End pointer is where the next number will be placed
		int endPointer = array.length - 1;
		// Start pointer is the last positive integer in the array
		int startPointer = getLastNumberIndex(array);
		
		// For empty arrays return now
		if(startPointer < 0) {
			return array;
		}
		
		// Iterate backwards through each number in the array
		for(int i = startPointer; i >= 0; i--) {
			// Regardless even or odd we need to copy the value once 
			array[endPointer] = array[i];
			endPointer--;
			
			// If even we need to copy the value a second time
			if(array[i] % 2 == 0) {
				array[endPointer] = array[i];
				endPointer--;
			}
		}
		
		
		return array;
	}
	
	// Helper method to find last number in array i.e. not -1
	public static int getLastNumberIndex(int[] array) {
		for(int i = array.length - 1; i >= 0; i--) {
			if(array[i] >= 0) {
				return i;
			}
		}
		
		return -1;
	}
	
	// Run our code
	public static void main(String[] args) {
		// Our test cases
		int[][] testCases = 
			{
	            {},
	            {-1},
	            {1},
	            {2,-1},
	            {1,2,5,6,8,-1,-1,-1}
			};
		
		// Run our test cases
		for(int[] testCase : testCases) {
			System.out.println(String.format("%s -> %s", Arrays.toString(testCase), Arrays.toString(testCase)));
		}
	}
	
}

/*

Clarifications
--------------
* Should this be done in-place? Yes
* Will the existing array contain enough space to accommodate the duplicates? Yes
* Can we assume a valid array type will be input? Yes
* What should be returned in the case of an empty array or no even numbers? Return input as-is
* How will empty spaces in the array be represented? -1
* Can we assume all positive integers? Yes

Test Cases
----------
* [] -> []
* [-1] -> [-1]
* [1] -> [1]
* [2,-1] -> [2,2]
* [1,2,5,6,8,-1,-1,-1] -> [1,2,2,5,6,6,8,8]

Solution
--------
* We will use reverse array traversal for this problem
* We will use an end pointer to keep track of where to write the next value/values
* Initially this end pointer will be the length of the array
* We will start from the last number in the array (the first value not equal to -1 in this case) and iterate until we reach the first number
* If we encounter an even number we will copy it twice to the end of the array and subtract 2 from the end pointer
* If we encounter an odd number we will copy it once to the end of the array and subtract 1 from the end pointer
* Return the array

*/