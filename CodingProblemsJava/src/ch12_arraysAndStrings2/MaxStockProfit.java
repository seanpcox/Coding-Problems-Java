// @author: seanpcox

package ch12_arraysAndStrings2;

public class MaxStockProfit {

	// 1. (Level: Medium) Given a list of stock prices for a company, find the maximum amount of money you could have made with one trade (one buy/sell). 
	// For example, if A = [2,3,1,4,5,7,5,4], the max money with a single trade is 6, if you buy at 1 and sell at 7.
	// [1,-2,3,1,2,-2,-1]
	
	public static void main(String[] args) {
		int[] a = {2,3,1,4,5,7,5,4};
		System.out.println(getMax(a));
		System.out.println(getMax2(a));
		a = new int[]{8,14,2,5,7,3,9,5};
		System.out.println(getMax(a));
		System.out.println(getMax2(a));
		a = new int[]{7,6,5,4,3,2,1};
		System.out.println(getMax2(a));
	}

	private static int getMax2(int[] a) {
		if(a == null || a.length < 2) {
			throw new RuntimeException("Invalid stock input");
		}
		
		int minSoFar = a[0];
		int result = Integer.MIN_VALUE;
		
		for(int i = 1; i < a.length; i++) {
			minSoFar = Math.min(minSoFar, a[i]);
			result = Math.max(a[i] - minSoFar , result);
		}
		
		return result;
	}
	
	private static int getMax(int[] a) {
		if(a == null || a.length < 2) {
			throw new RuntimeException("Invalid stock input");
		}
		
		int[] diff = new int[a.length -1];
		
		for(int i = 1; i < a.length; i++) {
			diff[i-1] = a[i] - a[i-1];
		}
		
		int result = diff[0];
		int maxAtI = diff[0];
		
		for(int i = 1; i < diff.length; i++) {
			maxAtI = Math.max(diff[i], diff[i] + maxAtI);
			result = Math.max(maxAtI, result);
		}
		
		return result;
	}
	
}
