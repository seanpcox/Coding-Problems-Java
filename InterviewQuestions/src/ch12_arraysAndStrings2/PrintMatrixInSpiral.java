// @author: seanpcox

package ch12_arraysAndStrings2;

public class PrintMatrixInSpiral {

	/*
	 	1  2  3  4
	 	10 11 12 5
	 	9  8  7  6
	 */
	
	public static void main(String[] args) {
		int[][] a =
			{
				{1,  2,  3,  4},
				{10, 11, 12, 5},
				{9,  8,  7,  6}
			};
		
		printSpiral(a);
		System.out.println();
		
		int[][] b =
			{
				{1,2,3,4,5},
				{6,7,8,9,10},
				{11,12,13,14,15},
				{16,17,18,19,20},
				{21,22,23,24,25}
			};
		
		printSpiral(b);
		System.out.println();
		
		int[][] d =
			{
				{1,2},
				{3,4}
			};
		
		printSpiral(d);
		System.out.println();
		
		int[][] e =
			{
				{1,2,3},
				{4,5,6},
				{7,8,9}
			};
		
		printSpiral(e);
		System.out.println();
		
		int[][] c =
			{
				{1,2,3,4,5}
			};
		
		printSpiral(c);
		System.out.println();
		
		int[][] ce =
			{
				{1},{2},{3},{4},{5}
			};
		
		printSpiral(ce);
		System.out.println();
		
		int[][] cd =
			{
				{0,1,2,3,4,5,6,7,8,9},
				{10,11,12,13,14,15,16,17,18,19}
			};
		
		printSpiral(cd);
		System.out.println();
	}



	
	public static void printSpiral(int[][] a) {
		if(a == null || a.length == 0 || a[0].length == 0) {
			return;
		}

		int h = a.length-1;
		int w = a[0].length-1;
		
		int i = 0;
		int j = 0;
		
		printSpiral(a, h, w, i, j);
	}
	
	private static void printSpiral(int[][] a, int h, int w, int is, int js) {
		if(endCase(a, h, w, is, js)) {
			return;
		}
		
		int i = is;
		int j = js;
		
		while(j < w) {
			System.out.print(a[i][j] + " ");
			j++;
		}
		
		while(i < h) {
			System.out.print(a[i][j] + " ");
			i++;
		}
		
		while(j > js) {
			System.out.print(a[i][j] + " ");
			j--;
		}
		
		while(i > is) {
			System.out.print(a[i][j] + " ");
			i--;
		}
		
		printSpiral(a, h-1, w-1, is+1, js+1);
	}

	private static boolean endCase(int[][] a, int h, int w, int is, int js) {
		// Exit case
		if(h < is || w < js) {
			return true;
		} 
		
		// Middle layer, single number
		else if(js == w && is == h) {
			System.out.print(a[is][js]);
			return true;
		} 
		
		// Single row case
		else if(h == 0) { 			
			for(int j = js; j <= w; j++) {
				System.out.print(a[is][j] + " ");
			}
			return true;
		} 
		
		// Single column case
		else if(w == 0) {
			for(int i = is; i <= h; i++) {
				System.out.print(a[i][js] + " ");
			}
			return true;
		}
		
		return false;
	}
	
}
