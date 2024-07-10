// @author: seanpcox

package ch01_arraysAndStrings1;

public class MoveZerosToStartArray {

	public static void main(String[] args) {
		int[] input = {4,2,0,1,0,3,0};
		
		moveZerosToStartArray(input);
		
		for(int i = 0; i < input.length; i++) {
			System.out.println(input[i]);
		}
	}
	
	public static void moveZerosToStartArray(int[] input) {
		int boundary = 0;
		
		for(int i = 0; i < input.length; i++) {
			if(input[i] == 0) {
				input[i] = input[boundary];
				input[boundary]= 0;
				boundary++;
			}
		}
	}
	
}
