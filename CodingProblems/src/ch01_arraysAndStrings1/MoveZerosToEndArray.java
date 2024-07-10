// @author: seanpcox

package ch01_arraysAndStrings1;

public class MoveZerosToEndArray {
	
	public static void main(String[] args) {
		int[] input = {4,2,0,1,0,3,0};
		
		moveZerosToEndArray(input);
		
		for(int i = 0; i < input.length; i++) {
			System.out.println(input[i]);
		}
	}
	
	public static void moveZerosToEndArray(int[] input) {
		int boundary = input.length-1;
		
		for(int i = input.length-1; i >= 0; i--) {
			if(input[i] == 0) {
				input[i] = input[boundary];
				input[boundary]= 0;
				boundary--;
			}
		}
	}

}
