// @author: seanpcox

package ch01_arraysAndStrings1;

public class TwoSumProblemSorted {
	
	// Can it contain duplicates?
	// Can there be more than one result? If so which do we return?
	// What to return in case of a null, empty, or single value array
	
	public static void main(String[] args) {
		int[] input = {1,2,4,5,3,5,6,7};
		
		int[] output = twoSumProblemUnsorted(input);
		
		for(int i = 0; i < output.length; i++) {
			System.out.println(output[i]);
		}
	}
	
	public static int[] twoSumProblemUnsorted(int[] input) {
		int startValue = -1;
		int endValue = -1;
		int[] output = {-1,-1};

		
		for(int i = 0; i < input.length-1; i++) {
			if(input[i] > input[i+1]) {
				startValue = input[i+1];
				break;
			}	
		}
		
		for(int i = input.length-1; i >0; i--) {
			if(input[i] < input[i-1]) {
				endValue = input[i-1];
				break;
			}	
		}
		
		for(int i = 0; i < input.length-1; i++) {
			if(input[i] > startValue) {
				output[0] = i;
				break;
			}
		}
		
		for(int i = input.length-1; i >0; i--) {
			if(input[i] < endValue) {
				output[1] = i;
				break;
			}	
		}
		
		return output;
	}

}
