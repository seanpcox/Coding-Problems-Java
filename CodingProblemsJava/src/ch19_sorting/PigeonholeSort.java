// @author: seanpcox

package ch19_sorting;

import java.util.Arrays;

public class PigeonholeSort {

	// This can sort a limited range of elements in O(n) or rather O(n + N) time, where N is the range of possible values
	// Say you wanted to sort integers that can only be between 0-9
	
	public static void main(String[] args) {
		int[] a = {1,1,0,5,8,7,4,4,8,4};
		
		int[] p = new int[10];
		
		for(int av : a) {
			p[av] = p[av] + 1;
		}
		
		int j = 0;
		
		for(int i = 0; i < p.length; i++) {
			while(p[i] > 0) {
				a[j] = i;
				p[i] = p[i] - 1;
				j++;
			}
		}
		
		System.out.println(Arrays.toString(a));
	}
	
}
