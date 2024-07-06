// @author: seanpcox

package ch01_arraysAndStrings1;

public class ReverseArrayOrder {
	
	public static void main(String[] args) {
		int[] input = {1,2,3,4,5};
		
		for(int i = 0; i < input.length/2; i++) {
			int temp = input[i];
			input[i] = input[input.length - i - 1];
			input[input.length - i - 1] = temp;
		}
		
		for(int i = 0; i < input.length; i++) {
			System.out.println(input[i]);
		}
	}

}
