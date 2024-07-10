// @author: seanpcox

package ch19_sorting;

import java.util.Arrays;

public class Merge2SortedArrays {

	public static void main(String[] args) {
		int[] a = {1,2,4,7,8};
		int[] b = {2,3,5};
		
		int[] r = flushMerge(a, b);
		System.out.println(Arrays.toString(r));
		
		int[] c = {1,2,4,7,8};
		int[] d = {2,3,5};
		
		int[] r2 = merge(c, d);
		System.out.println(Arrays.toString(r2));
	}

	private static int[] merge(int[] a, int[] b) {
		int rSize = a.length + b.length;
		int[] r = new int[rSize];
		
		int aP = 0;
		int bP = 0;
		
		for(int i = 0; i < rSize; i++) {
			if(aP >= a.length) {
				r[i] = b[bP++];
			} else if(bP >= b.length) {
				r[i] = a[aP++];
			} else if(a[aP] < b[bP]){
				r[i] = a[aP++];
			} else {
				r[i] = b[bP++];
			}
		}
		
		return r;
	}
	
	private static int[] flushMerge(int[] a, int[] b) {
		int[] r = new int[a.length + b.length];
		
		int i = 0;
		int aI = 0;
		int bI = 0;
		
		while(aI < a.length && bI < b.length) {
			if(a[aI] < b[bI]) {
				r[i++] = a[aI++];
			} else {
				r[i++] = b[bI++];
			}
		}
		
		while(aI < a.length) {
			r[i++] = a[aI++];
		}
		
		while(bI < b.length) {
			r[i++] = b[bI++];
		}
		
		return r;
	}
	
}
