// @author: seanpcox

package ch06_recursion;

public class Suduko {

	// TODO: Hard Level
	// Memoization doesn't help here
	// Backtracking problem
	// Recursion problem
	// Time: O(9^​n​) -> O(1) since n is constant (number of squares on board) O(9^81) -> O(1)
	// Space: O(n), number of squares on board and also used for stack
	
	public static boolean[][] rows = new boolean[9][9];
	public static boolean[][] columns = new boolean[9][9];
	public static boolean[][] squares = new boolean[9][9];
	
	public static void main(String[] args) {
		int[][] suduko =
			{
				{5,3,0,0,7,0,0,0,0},
				{6,0,0,1,9,5,0,0,0},
				{0,9,8,0,0,0,0,6,0},
				{8,0,0,0,6,0,0,0,3},
				{4,0,0,8,0,3,0,0,1},
				{7,0,0,0,2,0,0,0,6},
				{0,6,0,0,0,0,2,8,0},
				{0,0,0,4,1,9,0,0,5},
				{0,0,0,0,8,0,0,7,9}
			};
		
		Print2DArray.printAbs(suduko);
		
		System.out.println();
		
		System.out.println(solve(suduko));
		
		System.out.println();
		
		Print2DArray.printAbs(suduko);
	}

	public static boolean solve(int[][] suduko) {
		if(suduko == null || suduko.length != 9 || suduko[0].length != 9) {
			throw new RuntimeException("Invalid Suduko puzzle");
		}
		
		prepare(suduko);
		
		return solve(suduko, 0, 0);
	}

	private static boolean solve(int[][] suduko, int i, int j) {
		// Reached the end of the row
		if(j == 9) {
			j = 0;
			i += 1;
		}
		
		// Reached end of puzzle
		if(i == 9) {
			return true;
		}
		
		if(suduko[i][j] >= 0) {
			for(int c = 1; c <= 9; c++) {
				if(isValid(c, i, j)) {
					
					suduko[i][j] = c;
					setUsedState(c, i, j, true);
					
					if(solve(suduko, i, j+1)) {
						return true;
					} else {
						setUsedState(c, i, j, false);
						suduko[i][j] = 0;
					}
					
				}
			}
		} else {
			return solve(suduko, i, j+1);
		}
		
		return false;
	}
	
	private static boolean isValid(int c, int i, int j) {
		// Get zero index
		c = c - 1;
		
		if(rows[i][c]) {
			return false;
		}
		
		if(columns[j][c]) {
			return false;
		}
		
		if(squares[getSquare(i,j)][c]) {
			return false;
		}
		
		return true;
	}
	
	private static void setUsedState(int c, int i, int j, boolean state) {
		// Get zero index
		c = c - 1;
		
		// Set the candidates that can or cannot be used in the row
		rows[i][c] = state;
		
		// Set the candidates that can or cannot be used in the column
		columns[j][c] = state;
		
		// Set the candidates that can or cannot be used in that square
		squares[getSquare(i,j)][c] = state;
	}

	private static void prepare(int[][] suduko) {
		for(int i = 0; i < suduko.length; i++) {
			for(int j = 0; j < suduko[0].length; j++) {
				int c = suduko[i][j];
				
				if(c > 0) {
					// Set the fixed numbers to -ve so we know not to touch them
					suduko[i][j] = -1 * c;
					
					// Set permanent invalid values
					setUsedState(c, i, j, true);
				}
			}
		}
	}
	
	private static int getSquare(int i, int j) {
		if(i < 3) {
			if(j < 3) {
				return 0;
			} else if(j < 6) {
				return 1;
			} else {
				return 2;
			}
		} else if(i < 6) {
			if(j < 3) {
				return 3;
			} else if(j < 6) {
				return 4;
			} else {
				return 5;
			}
		} else {
			if(j < 3) {
				return 6;
			} else if(j < 6) {
				return 7;
			} else {
				return 8;
			}
		}
	}
	
}
