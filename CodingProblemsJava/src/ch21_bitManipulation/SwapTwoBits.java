// @author: seanpcox

package ch21_bitManipulation;

public class SwapTwoBits {

	// Given a number N, swap bits i and j.
	
	public static void main(String[] args) {
		int n = 5; // 0101
		int i = 0;
		int j = 2;
		System.out.println(swapBits(n, i, j)); // 5 0101, bits were the same, no need to swap
		
		i = 2;
		j = 3;
		System.out.println(swapBits(n, i, j)); // 9 1001, bits were not the same, so needed to swap
		
	}
	
	public static int swapBits(int n, int i, int j) {
		// If the two bits are equal value we don't need to do anything, but we need to find this out first
		
		int iV = (n >> i) & 1;
		System.out.println(iV);
		
		int jV = (n >> j) & 1;
		System.out.println(jV);
		
		if(iV == jV) {
			return n;
		}
		
		// So if they are not the same then we simply need to flip both bits
		// We can use a mask and XOR | for this
		int mask = (1 << i) | (1 << j);
		
		
		return n ^ mask;
	}
	
}
