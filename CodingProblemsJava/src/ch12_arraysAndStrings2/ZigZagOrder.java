// @author: seanpcox

package ch12_arraysAndStrings2;

public class ZigZagOrder {

	public static void main(String[] args) {		
		int[][] a =
			{
				{1,   2,  6,  7, 15},
				{3,   5,  8, 14, 16},
				{4 ,  9, 13, 17, 22},
				{10, 12, 18, 21, 23},
				{11, 19, 20, 24, 25}
			};
		
		printZigZagOrder(a);
		System.out.println();
		
		int[][] b =
			{
				{1, 2, 6,  7},
				{3, 5, 8,  11},
				{4, 9, 10, 12}
			};
		
		printZigZagOrder(b);
		System.out.println();
		
		int[][] c =
			{
				{1, 2, 3, 4, 5}
			};
		
		printZigZagOrder(c);
		System.out.println();
		
		int[][] d =
		{
			{1},{2},{3},{4},{5}
		};
		
		printZigZagOrder(d);
		System.out.println();
		
		int[][] e =
		{
			{1}
		};
		
		printZigZagOrder(e);
		System.out.println();
		
		int[][] f =
		{
			{}
		};
		
		printZigZagOrder(f);
		System.out.println();
	}

	public static void printZigZagOrder(int[][] a) {
		// Invalid input
		if(a == null || a.length == 0 || a[0].length == 0) {
			return;
		}
		
		// Print first element
		System.out.print(a[0][0] + " ");
		
		// Start recursion
		printZigZagOrder(a, a.length - 1, a[0].length - 1, 0, 0, true);
	}
	
	private static void printZigZagOrder(int[][] a, int h, int w, int i, int j, boolean down) {
		// Last Element, exit condition
		if(i == h && j == w) {
			return;
		}
		
		// Try to go right
		if(j < w) {
			j++;
			print(a[i][j]);
		}
		// Else try to go down
		else if(i < h) {
			i++;
			print(a[i][j]);
		} 
		
		// Go diagonal down
		if(down) {
			while(j > 0 && i < h) {
				j--;
				i++;
				print(a[i][j]);
			}
		}
		// Else go diagonal down up
		else {
			while(i > 0 && j < w) {
				i--;
				j++;
				print(a[i][j]);
			}
		}
		
		// Call recursion
		printZigZagOrder(a, h, w, i, j, !down);
	}
	
	private static void print(int n) {
		// Print helper method
		System.out.print(n + " ");
	}
	
	@SuppressWarnings("unused")
	private static void printZigZagOrderFirst(int[][] a, int i, int j) {
		int h = a.length - 1;
		int w = a[0].length - 1;
		
		if(i == 0 && j == 0) {
			System.out.print(a[i][j] + " ");
		}
		
		if(i == h && j == w) {
			return;
		}
		
		// Try to go right
		if(j < w) {
			j++;
			System.out.print(a[i][j] + " ");
		}
		// Try to go down
		else if(i < h) {
			i++;
			System.out.print(a[i][j] + " ");
		} 
		
		// Go diagonal down
		while(j > 0 && i < h) {
			j--;
			i++;
			System.out.print(a[i][j] + " ");
		}
		
		// Try to go down
		if(i < h) {
			i++;
			System.out.print(a[i][j] + " ");
		} 
		// Try to go right
		else if(j < w) {
			j++;
			System.out.print(a[i][j] + " ");
		}
		
		// Go diagonal up
		while(i > 0 && j < w) {
			i--;
			j++;
			System.out.print(a[i][j] + " ");
		}
		
		printZigZagOrderFirst(a, i, j);
	}

}
