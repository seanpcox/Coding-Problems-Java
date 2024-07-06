// @author: seanpcox

package ch08_stack;

import java.util.Stack;

public class FindNInStack {

	// return true if a specified number is in a stack
	// leave original stack unchanged
	// O(n) time
	// Solve using temp stack
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.add(4);
		stack.add(3);
		stack.add(2);
		stack.add(1);
		
		System.out.println(stack);
		System.out.println(containsN(stack, 3));
		System.out.println(stack);
	}

	private static boolean containsN(Stack<Integer> stack, int n) {
		Stack<Integer> temp = new Stack<>();
		boolean isFound = false;
		
		while(!stack.isEmpty()) {
			if(stack.peek() == n) {
				isFound = true;
				break;
			}
			
			temp.push(stack.pop());
		}
		
		while(!temp.isEmpty()) {
			stack.push(temp.pop());
		}
		
		
		return isFound;
	}
	
}
