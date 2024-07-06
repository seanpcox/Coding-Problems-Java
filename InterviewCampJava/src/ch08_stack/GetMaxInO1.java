// @author: seanpcox

package ch08_stack;

import java.util.Stack;

public class GetMaxInO1 {

	// Two ways to do this
	// Both involve extra storage
	// The 1st is always O(n), we store max with each value
	// The 2nd can be less than O(n) as we don't always store every value, but we can in worst case
	
	public static void main(String[] args) {
		StackMaxO1_1 stack1 = new StackMaxO1_1();
		stack1.push(3);
		stack1.push(1);
		stack1.push(4);
		stack1.push(4);
		
		System.out.println(stack1.max());
		stack1.pop();
		System.out.println(stack1.max());
		stack1.pop();
		System.out.println(stack1.max());
		stack1.push(7);
		System.out.println(stack1.max());
		
		StackMaxO1_2 stack2 = new StackMaxO1_2();
		stack2.push(3);
		stack2.push(1);
		stack2.push(4);
		stack2.push(4);
		
		System.out.println(stack2.max());
		stack2.pop();
		System.out.println(stack2.max());
		stack2.pop();
		System.out.println(stack2.max());
		stack2.push(7);
		System.out.println(stack2.max());
	}
	
}

class StackMaxO1_1 {
	Stack<Integer[]> stack = new Stack<>();
	int currentMax = Integer.MIN_VALUE;
	
	public void push(Integer item) {
		if(item > currentMax) {
			currentMax = item;
		}
		
		Integer[] itemMax = {item, currentMax};
		stack.push(itemMax);
	}
	
	public Integer pop() {
		Integer[] item = stack.pop();
		
		return item[0];
	}
	
	public Integer max() {
		Integer[] item = stack.peek();
		
		return item[1];
	}
	
}

class StackMaxO1_2 {
	Stack<Integer> stack = new Stack<>();
	Stack<Integer> maxstack = new Stack<>();
	
	public void push(Integer item) {
		if(maxstack.isEmpty() || item >= maxstack.peek()) {
			maxstack.push(item);
		}
		
		stack.push(item);
	}
	
	public Integer pop() {
		Integer item = stack.pop();
		
		if(!maxstack.isEmpty() && maxstack.peek() == item) {
			maxstack.pop();
		}
		
		return item;
	}
	
	public Integer max() {
		return maxstack.peek();
	}
	
}
