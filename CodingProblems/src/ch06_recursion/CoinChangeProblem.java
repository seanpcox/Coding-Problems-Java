// @author: seanpcox

package ch06_recursion;

import java.util.Stack;

public class CoinChangeProblem {

	// Given a set of coin denominations, print out the 
	// different ways you can make a target amount. 
	// You can use as many coins of each denomination as you like.
	
	// Time complexity: Factorial Complexity
	// Space complexity: O(target)
	
	public static void main(String[] args) {
		int[] d = {1,2,5,10,20};
		int t = 5;
		
		printCoins(d, t);
		printCoinsStack(d, t);
	}
	
	private static void printCoinsStack(int[] d, int t) {
		Stack<Integer> stack = new Stack<>();
		printCoinsStackHelper(d,stack,t,0,0);
	}
	
	private static void printCoinsStackHelper(int[] d, Stack<Integer> stack, int t, int s, int di) {
		// 1. Base conditions
		if(s == t) {
			printCoinsList(stack);
			return;
		}
		if(s > t) {
			return;
		}
		
		// 2. Get candidates
		for(int i = di; i < d.length; i++) {
			// Add to buffer
			stack.push(d[i]);
			
			// Call recursion
			printCoinsStackHelper(d, stack, t, s + d[i], i);
			
			// Remove from buffer
			stack.pop();
		}
	}

	private static void printCoins(int[] d, int t) {
		int[] b = new int[t];
		printCoinsHelper(d,b,t,0,0,0);
	}
	
	private static void printCoinsHelper(int[] d, int[] b, int t, int s, int bi, int di) {
		// 1. Base conditions
		// Hit target - print and return
		// Target greater - return
		// Reached end of buffer - return (Actually don't think this will happen, since target buffer is equal to amount
		// Reached end of denominations - return (Actually don't think this will happen, since we are not increasing di for recursion call
		if(s == t) {
			printCoinsList(b, bi);
			return;
		}
		if(s > t) {
			return;
		}
//		if(bi == b.length) {
//			return;
//		}
//		if(di == d.length) {
//			return;
//		}
		
		// 2. Find all candidates
		for(int i = di; i < d.length; i++) {
			// 3. Add to buffer
			b[bi] = d[i];
			
			// Increase the sum
			s += d[i];
			
			// 4. Recurse to next step
			// We do not increase di as we can use same number across buffer
			printCoinsHelper(d, b, t, s, bi+1, i);
			
			// Decrease sum for next try
			s -= d[i];
		}
	}
	
	private static void printCoinsList(int[] b, int bi) {
		for(int i=0; i< bi; i++) {
			System.out.print(b[i] + " ");
		}
		System.out.println();
	}
	
	private static void printCoinsList(Stack<Integer> stack) {
		for(int sv : stack) {
			System.out.print(sv + " ");
		}
		System.out.println();
	}
	
}
