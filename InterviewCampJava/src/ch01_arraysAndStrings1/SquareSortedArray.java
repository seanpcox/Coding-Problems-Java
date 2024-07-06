// @author: seanpcox

package ch01_arraysAndStrings1;

public class SquareSortedArray {
	
	public static void main(String[] args) {
		int[] input = {-4,-2,-1,0,3,5};
		
		int[] output = squareArraySortedFirstAttempt(input);
		
		for(int i = 0; i < output.length; i++) {
			System.out.println(output[i]);
		}
	}
	
	public static int[] squareArraySorted(int[] input) {
		int[] output = new int[input.length];
		int start =0, end=input.length-1;
		int i = 0;
		
		while(start < end) {
			if(Math.abs(input[start]) < Math.abs(input[end])) {
				output[i] = Math.abs(input[start]) * Math.abs(input[start]);
				start++;
			} else {
				output[i] = Math.abs(input[end]) * Math.abs(input[end]);
				end--;
			}
			
			i++;
		}
		
		return output;
	}
	
	public static int[] squareArraySortedFirstAttempt(int[] input) {
		int[] output = new int[input.length];
		
		int pI = input.length;
		int nI = -1;
		int oI = 0;
		
		for(int i=0;i<input.length;i++) {
			if(input[i] >= 0) {
				pI = i;
				break;
			}
		}
		
		nI = pI - 1;
		
		while(pI < input.length || nI >= 0) {
			if(nI < 0) {
				output[oI] = input[pI] * input[pI];
				pI++;
			} else if(pI >= input.length) {
				output[oI] = Math.abs(input[nI]) * Math.abs(input[nI]);
				nI--;
			} else if(input[pI] < Math.abs(input[nI])) {
				output[oI] = input[pI] * input[pI];
				pI++;
			} else {
				output[oI] = Math.abs(input[nI]) * Math.abs(input[nI]);
				nI--;
			}
			
			oI++;
		}
		
		return output;
	}

}
