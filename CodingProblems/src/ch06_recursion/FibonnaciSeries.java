// @author: seanpcox

package ch06_recursion;

import java.util.HashMap;
import java.util.Map;

public class FibonnaciSeries {

	// Fibonacci series - 1,1,2,3,5,8
	
	public static void main(String[] args) {
		int n = 50;
		
		System.out.println(fibonnaciSeriesMine(n));
		System.out.println(fibonnaciSeriesRecursion(n));
		Map<Integer,Integer> memoization = new HashMap<Integer, Integer>();
		System.out.println(fibonnaciSeriesRecursionMemoization(n, memoization));
	}
	
	// O(n) time, O(n) space due to all the functions on the stack
	public static int fibonnaciSeriesRecursionMemoization(int n, Map<Integer,Integer> map) {
		if(n == 1 || n == 2) {
			return 1;
		}
		
		if(map.containsKey(n)) {
			return map.get(n);
		}
		
		int nValue = fibonnaciSeriesRecursionMemoization(n-1, map) + fibonnaciSeriesRecursionMemoization(n-2, map);
		
		map.put(n, nValue);
		
		return nValue;
	}
	
	// Exponential Time O(2​n​), O(n) space
	public static int fibonnaciSeriesRecursion(int n) {
		if(n == 1 || n == 2) {
			return 1;
		}
		
		return fibonnaciSeriesRecursion(n-1) + fibonnaciSeriesRecursion(n-2);
	}
	
	public static int fibonnaciSeriesMine(int n) {
		int[] fib = {0,1};
		
		for(int i = 1; i < n; i++) {
			int value = fib[0] + fib[1];
			fib[0] = fib[1];
			fib[1] = value;
		}
		
		return fib[1];
	}
	
}
