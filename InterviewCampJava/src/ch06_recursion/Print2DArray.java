// @author: seanpcox

package ch06_recursion;

public class Print2DArray {

	public static void main(String[] args) {
		int[][] a =
			{{1,2,3,4},
			 {1,2,3,4},
			 {1,2,3,4},
			 {1,2,3,4}
			};
		
		print(a);
	}
	
	public static void print(int[][] a) {
		if(a == null || a.length == 0) {
			return;
		}
		
		print2DArray(a, 0, 0);
	}

	private static void print2DArray(int[][] a, int i, int j) {
		if(j == a[0].length) {
			i += 1;
			j = 0;
			System.out.println();
		}
		
		if(i == a.length) {
			return;
		}
		
		System.out.print(a[i][j] + " ");
		
		print2DArray(a, i, j+1);
	}
	
	public static void print(int[][] a, int maxValueLength) {
		if(a == null || a.length == 0) {
			return;
		}
		
		print2DArray(a, 0, 0, maxValueLength);
	}
	
	private static void print2DArray(int[][] a, int i, int j, int maxValueLength) {
		if(j == a[0].length) {
			i += 1;
			j = 0;
			System.out.println();
		}
		
		if(i == a.length) {
			return;
		}
		
		String value = a[i][j] + " ";
		
		System.out.print(value);
		
		for(int k = 0; k <= maxValueLength - value.length(); k++) {
			System.out.print(" ");
		}
		
		print2DArray(a, i, j+1, maxValueLength);
	}

	public static void printN(int[][] a) {
		if(a == null || a.length == 0) {
			return;
		}
		
		print2DArrayN(a, 0, 0);
	}

	private static void print2DArrayN(int[][] a, int i, int j) {
		if(j == a[0].length) {
			i += 1;
			j = 0;
			System.out.println();
		}
		
		if(i == a.length) {
			return;
		}
		
		if(a[i][j] >= 0) {
			System.out.print(" ");
		}
		
		System.out.print(a[i][j]);
		
		System.out.print(" ");
		
		print2DArrayN(a, i, j+1);
	}
	
	public static void printAbs(int[][] a) {
		if(a == null || a.length == 0) {
			return;
		}
		
		print2DArrayAbs(a, 0, 0);
	}

	private static void print2DArrayAbs(int[][] a, int i, int j) {
		if(j == a[0].length) {
			i += 1;
			j = 0;
			System.out.println();
		}
		
		if(i == a.length) {
			return;
		}
		
		System.out.print(Math.abs(a[i][j]) + " ");
		
		print2DArrayAbs(a, i, j+1);
	}
	
	public static void print(boolean[][] a) {
		if(a == null || a.length == 0) {
			return;
		}
		
		print2DArray(a, 0, 0);
	}

	private static void print2DArray(boolean[][] a, int i, int j) {
		if(j == a[0].length) {
			i += 1;
			j = 0;
			System.out.println();
		}
		
		if(i == a.length) {
			return;
		}
		
		System.out.print(a[i][j] + " ");
		
		print2DArray(a, i, j+1);
	}
	
}
