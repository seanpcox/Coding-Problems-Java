// @author: seanpcox

package ch10_queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SlidingWindowSum {

	// Given an array of integers A, find the sum of each sliding window of size K.
	// O(n) time
	// O(windowsize) space
	
	public static void main(String[] args) {
		int[] a = {1,4,3,2,5};
		int w = 3;
		int[] result = slidingWindowSum(a, w);
		System.out.println(Arrays.toString(result));
		result = slidingWindowSumLL(a, w);
		System.out.println(Arrays.toString(result));
	}

	private static int[] slidingWindowSum(int[] a, int w) {
		if(a == null || a.length == 0 || w <= 0 || w > a.length) {
			return null;
		}
		
		ArrayDeque<Integer> q = new ArrayDeque<>(); 
		int[] result = new int[a.length - w + 1];
		
		int sum = 0;
		
		for(int i = 0; i < a.length; i++) {
			int v = a[i];
			sum += v;
			q.add(v);
			
			if(q.size() == w) {
				result[i - w + 1] = sum;
				sum -= q.removeFirst();
			}
		}
		
		return result;
	}
	
	private static int[] slidingWindowSumLL(int[] a, int w) {
		if(a == null || a.length == 0 || w <= 0 || w > a.length) {
			return null;
		}
		
		Queue<Integer> q = new LinkedList<>(); 
		int[] result = new int[a.length - w + 1];
		
		int sum = 0;
		
		for(int i = 0; i < a.length; i++) {
			int v = a[i];
			sum += v;
			q.add(v); // adds to the end of the queue
			
			if(q.size() == w) {
				result[i - w + 1] = sum;
				sum -= q.remove(); // removes first added
			}
		}
		
		return result;
	}
	
}
