// @author: seanpcox

package ch11_dp;

public class LongestIncreasingSubSequence {

	/*
	 	Longest Increasing Subsequence: Given an array of integers, find the length of the longest increasing subsequence.
		For e.g, in [1, 3, 2, 5, 3, 0, 5, 6, 4], the longest increasing subsequence is [1, 2, 3, 5, 6] of length 5.
	 */
	
	// O(n^2) time
	// O(n) space
	
	public static void main(String[] args) {
		int[] a = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
		//        [1, 2, 2,  3, 2,  3, 3,  4, 2, 4, 3,  5, 3,  5, 4,  6]
		System.out.println(longestIncreasingSubsequence(a));
	}

	private static int longestIncreasingSubsequence(int[] a) {
		if(a == null || a.length == 0) {
			return 0;
		}
		
		// If we know the longest subsequence from i-1 we can know longest from i, either another option if <= i-1 or +1 otherwise
		
		// We always have a sequence of at least length 1
		int[] r = new int[a.length];
		int result = 1;
		
		for(int i = 0; i < a.length; i++) {
			r[i] = 1;
			
			// We need to go through each value to see where the highest lower value is
			for(int j = 0; j < i; j++) {
				if(a[j] < a[i]) {
					r[i] = Math.max(r[i], r[j] + 1);
				}
			}
			
			result = Math.max(result, r[i]);
		}
		
		return r[r.length - 1];
	}
}
