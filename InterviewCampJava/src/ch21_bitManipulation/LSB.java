// @author: seanpcox

package ch21_bitManipulation;

public class LSB {

	// X & (X - 1) 
	// Gives us X without the Least Significant Bit (LSB)
	
	// Q: Given an integer, count the number of bits in its binary representation.
	
	public static void main(String[] args) {
		unoptimized(56); // 111000 -> 3
		optimized(56);
	}

	// Has to go through every bit
	private static void unoptimized(int n) {
		int count = 0;
		int loops = 0;
		
		while(n != 0) {
			count += n & 1;
			n = n >> 1;
			
			loops++;
		}
		
		System.out.println(count + " : " + loops);
	}

	// Only goes through bits set to 1
	private static void optimized(int n) {
		int count = 0;
		int loops = 0;
		
		while(n != 0) {
			count++;
			loops++;
			n = n & (n - 1);
		}
		
		System.out.println(count + " : " + loops);
	}
}
