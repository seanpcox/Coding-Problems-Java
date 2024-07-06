// @author: seanpcox

package ch01_arraysAndStrings1;

public class DutchNationalFlagProblem {
	
	
	public static void main(String[] args) {
		int[] input = {1,0,1,2,1,0,1,2};
		int pivot = 1;
		
		
		dutchNationalFlagProblem(input, pivot);
		
		for(int i = 0; i < input.length; i++) {
			System.out.println(input[i]);
		}
	}

	public static void dutchNationalFlagProblem(int[] input, int pivot) {
		
		if(input == null || input.length < 2) {
			return;
		}
		
		int sB = 0;
		int eB = input.length - 1;
		int i = 0;
		
		while(i <= eB) {
			if(input[i] < pivot) {
				int temp = input[sB];
				input[sB] = input[i];
				input[i] = temp;
				sB++;
				i++;
			} else if(input[i] > pivot) {
				int temp = input[eB];
				input[eB] = input[i];
				input[i] = temp;
				eB--;
			} else {
				i++;
			}
		}
	}
	
	
}
