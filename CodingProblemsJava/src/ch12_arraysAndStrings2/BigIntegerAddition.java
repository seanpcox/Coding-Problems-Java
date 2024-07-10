// @author: seanpcox

package ch12_arraysAndStrings2;

import java.util.Arrays;

public class BigIntegerAddition {

	/* [1,1,1,1] + [2,2,3,3] = [3,3,4,4]
	 	Add the arrays like they were numbers

	 	BigInteger Addition: You are given a number in the form of an array. 
	 	Each digit in the array represents a digit in the number. For example, 100 -> [1,0,0]. 
	 	Perform addition of 2 such number arrays. For example,

		[1,1,1,1] + [2,2,3,3] = [3,3,4,4]
		[9,9] + [1] = [1,0,0]
		
		A use of this may be if 2 integers are too large to add normally, 
		hence can't just convert to normal number and do it.
		
		Do it old school way, from school literally
	 */
	
	public static void main(String[] args) {
		int[] a = {9,1,1,1};
		int[] b = {9,9,2,4};
		System.out.println(Arrays.toString(bigIntegerAddition(a, b)));
	}

	private static int[] bigIntegerAddition(int[] a, int[] b) {
		if(a == null || b == null || a.length == 0 || b.length == 0) {
			return new int[0];
		}
		
		// Create result array, at most it needs to be one size bigger in case of final carry
		int maxLength = (a.length > b.length) ? a.length : b.length;
		maxLength++;

		int[] c = new int[maxLength];
		
		int carry = 0;
		for(int i = 0; i < maxLength; i++) {
			int av = (a.length - 1 - i >= 0) ? a[a.length - 1 - i] : 0;
			int bv = (b.length - 1 - i >= 0) ? b[b.length - 1 - i] : 0;
			int v = av + bv + carry;
			c[c.length - i - 1] = v % 10;
			carry = v / 10;
		}
		
		// Remove first zero if there
		if(c[0] == 0) {
			c = Arrays.copyOfRange(c, 1, c.length);
		}
		
		return c;
	}
	
	
}
