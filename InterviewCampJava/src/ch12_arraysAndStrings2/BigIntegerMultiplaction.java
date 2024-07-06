// @author: seanpcox

package ch12_arraysAndStrings2;

import java.util.Arrays;

public class BigIntegerMultiplaction {

	public static void main(String[] args) {
		// Max length is 2 lengths added together + 1 ( we may end up with empty space)
		int[] a = {3,2};
		int[] b = {3,2};

		/*
		    0
		 4950
		39600
		-----
		44550
		*/
		
		System.out.println(Arrays.toString(bigIntegerMultiplaction(a,b)));
	}

	private static int[] bigIntegerMultiplaction(int[] a, int[] b) {
		if(a == null || b == null || a.length == 0 || b.length == 0) {
			return null;
		}
		
		int carry = 0;
		
		int[][] adds = new int[b.length][b.length + a.length];
		
		for(int i = 0; i < b.length; i++) {
			int n1 = b[b.length - 1 - i];
			int j;
			for(j = 0; j < a.length; j++) {
				int n2 = a[a.length - 1 - j];
				int v = (n1 * n2) + carry;
				carry = v / 10;
				adds[i][adds[0].length - 1 - i - j] = v % 10;
			}
			adds[i][adds[0].length - 1 - i - j] = carry;
			carry = 0;
		}
		
		int[] result = new int[b.length + a.length];
		
		for(int i = adds[0].length-1; i >= 0; i--) {
			int n = 0;
			for(int j = 0; j < adds.length; j++) {
				n += adds[j][i];
			}
			int v = n + carry;
			carry = v/10;
			result[i] = v % 10;
		}
		
		if(result[0] == 0) {
			result = Arrays.copyOfRange(result, 1, result.length);
		}
		
		return result;
	}
	
}
