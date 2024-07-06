// @author: seanpcox

package ch21_bitManipulation;

public class FindUniqueElement {

	// Given an array of integers where each element appears twice except one, find the element which appears once.

	// For example: A = [3,7,3,5,5], Result = 7
	
	// We can use XORs ability to get rid of duplicates for this as well, just loop through and XOR all numbers
	
	public static void main(String[] args) {
		int[] a = {3,7,3,5,5}; // 7 is unique
		
		int xor = 0;
		
		for(int v : a) {
			xor = xor ^ v;
		}
		
		System.out.println(xor);
	}
	
}
