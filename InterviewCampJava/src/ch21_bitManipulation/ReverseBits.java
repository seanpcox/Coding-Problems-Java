// @author: seanpcox

package ch21_bitManipulation;

public class ReverseBits {

	// Given an integer N, reverse the order of its bits. For example,
	// So 1100 will become 0011
	
	// We can use our swap function for this and use two pointers either side and converge them
	// This is the simple case, without optimization
	
	public static void main(String[] args) {
		int n = 56; // 111000
		System.out.println(swapBits(n)); // 7 000111
	}

	private static int swapBits(int n) {
		int i = 0;
		int j = Integer.toBinaryString(n).length() - 1;
		
		while(i < j) {
			n = swapBits(n, i, j);
			i++;
			j--;
		}
		
		return n;
	}
	
	private static int swapBits(int n, int i, int j) {
		// First find the values of two bits
		int iV = (n >> i) & 1;
		int jV = (n >> j) & 1;
		
		if(iV == jV) {
			return n;
		}
		
		int mask = (1 << i) | (1 << j);
		
		return n ^ mask;
	}
	
}
