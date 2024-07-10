// @author: seanpcox

package ch12_arraysAndStrings2;

import java.util.Arrays;

public class RotateArrayXSpots {

	// Rotate an array A by X items. For example,
	// A = [1,2,3,4,5,6] and X = 2, Result = [5,6,1,2,3,4]
	// Can reverse array, then reverse first x items (rem -1 for 0 index) then reverse the rest
	
	
	/*
	 	{1,2,3,4,5,6}
	 	{3,2,1,4,5,6}
	 	{3,4,1,2,5,6}
	 	{3,}
	 */
	
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6};
		int x = 3;
		System.out.println(Arrays.toString(rotateArrayXSpots(a, x)));
//		int[] b = {1,2,3,4,5,6};
//		System.out.println(Arrays.toString(rotateArrayXSpotsMine(b, x)));
	}
	
	private static int[] rotateArrayXSpots(int[] a, int x) {
		if(a == null || a.length <= 1 || x % a.length == 0) {
			return a;
		}
		
		x = x % a.length;
		
		reverse(a, 0, a.length - 1);
		
		reverse(a, 0, x-1);
		
		reverse(a, x, a.length - 1);
		
		return a;
	}



	private static void reverse(int[] a, int s, int e) {
		while(s < e) {
			int temp = a[s];
			a[s] = a[e];
			a[e] = temp;
			s++;
			e--;
		}
	}
	
}
