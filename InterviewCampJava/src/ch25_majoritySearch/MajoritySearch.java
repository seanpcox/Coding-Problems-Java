// @author: seanpcox

package ch25_majoritySearch;

public class MajoritySearch {

	// Given an array of integers, find if there is an integer that occurs greater than 50% of the time.

	// Note: Do it in O(n) time.
	
	// We could use a HashMap but it will take O(n) space, we can do better with O(1) space
	
	// Boyer-Moore's​​ Voting​​ Algorithm or Majority Search
	
	// We cancel out different numbers in the array, until we are left with a candidate
	
	// We then double check that candidate has the majority, in case there is no majority in array
	
	public static void main(String[] args) {
		int[] a = {2,2,4,4,4,2,2,1,2};
		
		int candidate = a[0];
		int count = 1;
		
		for(int i = 1; i < a.length; i++) {
			if(a[i] == candidate) {
				count++;
			} else if(count > 0) {
				count = 0;
			} else {
				candidate = a[i];
				count = 1;
			}
		}
		
		int finalCount = 0;
		
		for(int v : a) {
			if(v == candidate) {
				finalCount++;
			}
		}
		
		System.out.println(finalCount > a.length/2);
	}
	
}
