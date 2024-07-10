// @author: seanpcox

package ch21_bitManipulation;

public class RemoveDuplicates {

	// Given an array with all numbers in [1, 2, 3, ... , n] except one number, find the missing number. For example:

	// A = [1,2,5,4] and n = 5, Missing Number => 3 
	// A = [7,3,5,4,1,2] and n = 7, Missing Number => 6
	
	// Few ways to do this...
	
	// Could use a hash map to store all values then cycle through 1 -> n and see which is missing: O(n) time O(n) space
	
	// Could sort the array and then cycle through it to see which number is missing: O(nlogn) time O(1) space
	
	// One optimized way is to find the SUM of 1-n and then subtract all array numbers from it: O(n) time and O(1) space
	// There is a formula to get this SUM: (n(n+1))/2
	
	// Another way is to use XOR
	// When you XOR a number with itself you get zero, you can use this property to find a missing number
	// First find the XOR result of 1->N, then XOR it with each number in the array
	// You will be left with the missing number, as there was only one of them
	
	public static void main(String[] args) {
		int[] a = {7,3,5,4,1,2}; // 6 missing
		int n = 7;
		
		findMissingNumberSum(a, n);
		findMissingNumberXOR(a, n);
		
		a = new int[]{1,2,5,4}; // 3 missing 
		n = 5;
		
		findMissingNumberSum(a, n);
		findMissingNumberXOR(a, n);
	}

	private static void findMissingNumberSum(int[] a, int n) {
		int sum1N = (n * (n+1)) / 2;
		
		for(int v : a) {
			sum1N -= v;
		}
		
		System.out.println(sum1N);
	}
	
	private static void findMissingNumberXOR(int[] a, int n) {
		int xor1N = 0;
		
		for(int i = 1; i <= n; i++) {
			xor1N = xor1N ^ i;
		}
		
		for(int v : a) {
			xor1N = xor1N ^ v;
		}
		
		System.out.println(xor1N);
	}
	
}
