// @author: seanpcox

package ch11_dp;

import java.util.Arrays;

public class NumberOfStepsBottomUp {

	public static void main(String[] args) {
		int ns = 8;
		int[] ps = {1,3,5};
		System.out.println(numberOfStepsBottomUp(ns, ps));
	}

	// Time: O(3N) -> O(N) (3N is the number of possible step counts to start)
	// Space: O(N) for new array
	
	// So we calculate how many routes from each path, starting at 0 before taking any steps
	// We then move onto the next step and calculate the same
	// We add the number of ways to get to that step to the next step we make to find the numbers of way to there
	// Ex: a[i+3] = a[i] + a[i+3]
	private static int numberOfStepsBottomUp(int ns, int[] ps) {
		int[] stepsToI = new int[ns + 1]; // We include 0 as a point, when we have not started
		stepsToI[0] = 1; // There is only one way to get to the start
		
		for(int i = 0; i <= ns; i++) {
			for(int j = 0; j < ps.length; j++) {
				if(i + ps[j] < stepsToI.length) {
					stepsToI[i + ps[j]] += stepsToI[i];
				}
			}
		}
		
		System.out.println(Arrays.toString(stepsToI));
		return stepsToI[stepsToI.length-1]; // 19
	}
	
}
