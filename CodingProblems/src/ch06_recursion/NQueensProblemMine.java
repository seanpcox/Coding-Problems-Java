// @author: seanpcox

package ch06_recursion;

import java.util.Arrays;

public class NQueensProblemMine {
	
	// Print every combination for a board n*n where n queens can be placed without attacking each other
	// 
	// Solution
	// You can only have one queen in each row and each column
	// You only need to check for downwards diagonal if doing rows first
	// For each row try every position
	// Break back if can't place one in a row
	// y2 - y1 = x2 - x1
	// y2 - y1 = x1 - x2
	
	public static void main(String[] args) {
		int n = 6;
		nQueensProblem(n);
	}

	private static void nQueensProblem(int n) {
		int[] queens = new int[n];
		Arrays.fill(queens, -1);
		nQueensProblem(queens, 0);
	}
	
	private static void nQueensProblem(int[] queens, int i) {
		if(i == queens.length) {
			printResult(queens);
			return;
		}
		
		for(int kj = 0; kj < queens.length; kj++) {
			if(isValid(queens, i, kj)) {
				queens[i] = kj;
				
				nQueensProblem(queens, i+1);
				
				queens[i] = -1;
			}
		}
	}
	
	private static boolean isValid(int[] queens, int i, int j) {
		for(int ki = 0; ki < queens.length; ki++) {
			int kj = queens[ki];
			
			if(kj >= 0) {
				if(kj == j) {
					return false;
				}
				
				if(kj - j == ki - i) {
					return false;
				}
				
				if(kj - j == i - ki) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	private static void printResult(int[] queens) {
		for(int i = 0; i < queens.length; i++) {
			for(int j = 0; j < queens.length; j++) {
				if(queens[i] == j) {
					System.out.print("Q ");
				} else {
					System.out.print(". ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
}
