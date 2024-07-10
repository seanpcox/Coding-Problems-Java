// @author: seanpcox

package ch12_arraysAndStrings2;

import ch06_recursion.Print2DArray;

public class Rotate2DArray {

	public static void main(String[] args) {
		int[][] a =
			{
				{1,2,3,4,5},
				{6,7,8,9,10},
				{11,12,13,14,15},
				{16,17,18,19,20},
				{21,22,23,24,25}
			};
		
		/*
		 	0,1	>	1,4
		 	
		 	^		
		 	3,0	<	4,3
		 */
		
		Print2DArray.print(a, 2);
		
		System.out.println();
		
		rotate90CW(a);
		
		Print2DArray.print(a, 2);
		
		System.out.println();
		
		rotate90ACW(a);
		
		Print2DArray.print(a, 2);
		
		System.out.println();
		
		rotate180(a);
		
		Print2DArray.print(a, 2);
	}

	private static void rotate90CW(int[][] a) {
		if(a == null || a.length <= 0 || a.length != a[0].length) {
			throw new RuntimeException("Invalid array");
		}
		
		int n = a.length;
		
		for(int i = 0; i < n/2; i++) {
			
			int io = n - i - 1;
			
			for(int j = i; j < io; j++) {
				
				int jo = n - j - 1;
				
				// i = 0, j = 1, io = 4, jo = 3
				
				int temp = a[i][j];
				
				a[i][j] = a[jo][i];
				
				a[jo][i] = a[io][jo];
				
				a[io][jo] = a[j][io];
				
				a[j][io] = temp;
			}
		}
	}
	
	private static void rotate90ACW(int[][] a) {
		if(a == null || a.length <= 0 || a.length != a[0].length) {
			throw new RuntimeException("Invalid array");
		}
		
		int n = a.length;
		
		for(int i = 0; i < n/2; i++) {
			
			int io = n - i - 1;
			
			for(int j = i; j < io; j++) {
				
				int jo = n - j - 1;
				
				// i = 0; j = 1; io = 4, jo = 3
				/*
			 		0,1		1,4
			 	
			 				
			 		3,0		4,3
				 */
				
				int temp = a[i][j];
				
				a[i][j] = a[j][io];
				
				a[j][io] = a[io][jo];
				
				a[io][jo] = a[jo][i];
				
				a[jo][i] = temp;
			}
			
		}
	}
	
	private static void rotate180(int[][] a) {
		if(a == null || a.length <= 0 || a.length != a[0].length) {
			throw new RuntimeException("Invalid array");
		}
		
		int n = a.length;
		
		for(int i = 0; i < n/2; i++) {
			
			int io = n - i - 1;
			
			for(int j = i; j < io; j++) {
				
				int jo = n - j - 1;
				
				/*
				 	0,1		1,4
				 	
				 	3,0		4,3
				 	
				 	
				 	i=0, j=1, io=4, jo=3
				 */
				
				int temp = a[i][j];
				
				a[i][j] = a[io][jo];
				
				a[io][jo] = temp;
				
				temp = a[j][io];
				
				a[j][io] = a[jo][i];
				
				a[jo][i] = temp;
			}
			
		}
	}
	
}
