// @author: seanpcox

package ch01_arraysAndStrings1;

import java.util.*;

public class TwoSumProblemUnsorted {

	// Can it contain duplicates?
	// Can there be more than one result? If so which do we return?
	// What to return in case of a null, empty, or single value array
	
	public static void main(String[] args) {
		int x = 8;
		int[] input = {2,5,3,7,1,4,8,4};
		
		int[] output = twoSumProblemUnsorted(x, input);
		
		for(int i = 0; i < output.length; i++) {
			System.out.println(output[i]);
		}
	}
	
	public static int[] twoSumProblemUnsorted(int target, int[] input) {
		Set<Integer> set = new HashSet<>();
		
		set.add(target - input[0]);
		
		for(int i = 1; i < input.length; i++) {
			if(set.contains(input[i])) {
				return new int[] {target - input[i], input[i]};
			}
			
			set.add(target - input[i]);
		}
		
		return new int[] {-1,-1};
	}
	
}
