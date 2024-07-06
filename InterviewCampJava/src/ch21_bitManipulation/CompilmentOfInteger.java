// @author: seanpcox

package ch21_bitManipulation;

public class CompilmentOfInteger {

	// Find the complement of an integer. A complement has the number's bits flipped, starting from the most significant 1. For example,

    // A => 00010001, Complement => 00001110 
    // A => 00000111, Complement => 00000000
	
	// We first need to find the most significant bit MSB
	// Then we need to create a mask to flip all bits up to the MSB
	// Then we XOR the value
	
	// To get the MSB we can Log2 and take the floor integer value, as bits represents power of 2
	
	// In java we have natural and log 10, but can get log2 like this...
	// log2(x) = log(x)/log(2)
	
	// We then need to create number that is all 1s up to the MSB to mask XOR with it
	// We can do this my minus 1 from the power one above what our log2 floor gives
	
	public static void main(String[] args) {
		int i = 10; // 5 : 1010 -> 0101
		getCompliment(i);
	}
	
	private static void getCompliment(int n) {
		System.out.println(Integer.toBinaryString(n));
		
		int l2f = log2Floor(n);
		System.out.println(l2f);
		
		int mask = (1 << (l2f + 1)) - 1;
		System.out.println(Integer.toBinaryString(mask));
		
		int compliment = n ^ mask;
		System.out.println(compliment);
		System.out.println(Integer.toBinaryString(compliment));
	}
	
	private static int log2Floor(int n) {
		return (int) Math.floor(log2(n));
	}
	
	private static double log2(int n) {
		return Math.log(n) / Math.log(2);
	}
	
}
