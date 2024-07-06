// @author: seanpcox

package ch21_bitManipulation;

public class BitManipulation {

	/*
	 * &  AND
	 * |  OR
	 * ~  NOT
	 * ^  XOR
	 * >> Right Shift
	 * << Left Shift
	 */

	public static void main(String[] args) {
		and();
		or();
		not();
		xor();
		rightShift();
		leftShift();
		simpleQuestion();
		divideByTwo();
		multiplyByTwo();
		flipAllIntegerBits();
		flipOnlyCertainBits();
		getABitsValue();
		setASpecificBit();
	}

	private static void and() {
		int a = 10; // 1010
		int b = 12; // 1100
		
		int c = a & b;
		System.out.println(c); // 8 1000
		// Both bits have to be one for a one result
	}
	
	private static void or() {
		int a = 10; // 1010
		int b = 12; // 1100
		
		int c = a | b;
		System.out.println(c); // 14 1110
		// Either or both bits can be one for a one result
	}
	
	private static void not() {
		// Unary operator, operates on one number only
		// Flips every bit, so 1 to 0, and 0 to 1
		// Note this one is weird, as we use 2s complement it will flip
		// positive to negative and sometimes vice versa
		
		byte a = 10; // 1010
		//System.out.println(Integer.toBinaryString(a));
		
		byte c = (byte) ~a;
		System.out.println(Integer.toBinaryString(c));
		System.out.println(c); // -11 0101 - would have thought 5 but no cause more bits
	}
	
	private static void xor() {
		// We get 1 if odd numbers of 1, else even
		
		int a = 10; // 1010
		int b = 12; // 1100
		
		int c = a ^ b;
		System.out.println(c); // 6 0110
		
		int d = 10; // 1010
		int e = 12; // 1100
		int f = 5;  // 0101
		
		int g = d ^ e ^ f;
		System.out.println(g); // 3 0011
	}
	
	private static void rightShift() {
		// >> Shift all bits right by one or whatever number we specify, lowest bits get thrown away
		
		int a = 10; // 1010
		
		int c = a >> 1; // 5 101
		System.out.println(c);
		
		int d = a >> 2; // 2 10
		System.out.println(d);
	}
	
	private static void leftShift() {
		// << Shift all bits left by one or whatever number we specify
		// Zero will be added to the end
		// If there is no space to store the highest bits in our primitive they will be thrown away
		
		int a = 10; // 1010
		
		int c = a << 1; // 20 10100
		System.out.println(c);
		
		int d = a << 2; // 40 101000
		System.out.println(d);
		
		int e = Integer.MAX_VALUE << 1;
		System.out.println(e); // Weird one, guess we lose the positive bit or something
	}
	
	private static void simpleQuestion() {
		int a = (1 << 2 | 0 << 3) & 1;
		// 1 << 2 : 4  100
		// 0 << 3 : 0 0000
		// |      : 4 0100
		// & 1    : 0001 & 0100 -> 0
		
		System.out.println(a);
	}
	
	private static void divideByTwo() {
		// Can use >> 1 to divide by 2
		int a = 4 / 2;
		int b = 4 >> 1;
		System.out.println(a + " " + b);
		
		// Note odd numbers will be floored like usual for ints
		int c = 3 / 2;
		int d = 3 >> 1;
		System.out.println(c + " " + d);
	}
	
	private static void multiplyByTwo() {
		// Can use << 1 to multiply by 2
		int a = 4 * 2;
		int b = 4 << 1;
		System.out.println(a + " " + b);
	}
	
	private static void flipAllIntegerBits() {
		int a = 10; // 1010
		
		// We can use XOR ^ for this, if we ^ 1 with a bit it will flip it
		// If we want to flip all bits then we need a number with all 1s
		// We can create that by using NOT zero ~0, which will make an all 1s bits
		
		int c = a ^ (~0);
		System.out.println(c); // -11 as it flips all bits including 2's complement the negative one
		
		int d = 15; // 1111
		int e = a ^ d;
		System.out.println(e); // 5 0101
	}
	
	private static void flipOnlyCertainBits() {
		// Given an integer, flip its bits at index 0 and index 5.
		int a = 32; // 100000
		int mask = 1 << 5 | 1; // 100001 // Create the mask here
		int c = a ^ mask;
		System.out.println(c); // 1 000001
	}
	
	private static void getABitsValue() {
		// Get the bit value at index 4
		int a = 48; // 110000
		// Value at index 4 is 1
		
		// So we can shift the number over to the bit we want, then last number will be 0 or 1
		// Then we can just & with 1, which will give us 1 if last bit is 1 or 0 otherwise
		
		int c = (a >> 4) & 1; // 11 & 01 -> 1
		System.out.println(c); // 1
	}
	
	private static void setASpecificBit() {
		int n = 48; // 110000
		int i = 5;
		boolean setAsO = true;
		System.out.println(setASpecificBit(n ,i, setAsO)); // 16 010000
		
		i = 3;
		setAsO = false;
		System.out.println(setASpecificBit(n ,i, setAsO)); // 56 111000
	}

	private static int setASpecificBit(int n, int i, boolean setAsO) {
		// If we want to set a bit to 0 then think of & AND
		// We create a mask to set all bits to 1 except the bit in question
		
		if(setAsO) {
			int mask = ~(1 << i);
			return n & mask;
		}
		
		// If we want to set a bit to 1 then think of | OR
		// We create a mask to set all bits to 0 except the bit in question
		
		else {
			int mask = 1 << i;
			return n | mask;
		}
	}
	
}
