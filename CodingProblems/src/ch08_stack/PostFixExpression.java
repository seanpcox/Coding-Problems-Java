// @author: seanpcox

package ch08_stack;

import java.util.Stack;

public class PostFixExpression {

	public static void main(String[] args) {
		String exp = "15+2-";
		
		System.out.println(solve(exp));
		
		// 2 + 3 * 4 + 5 = 19
		// 234*+5+ = 19
		String exp2 = "234*+5+";
		System.out.println(solve(exp2));
		
		String exp3 = "4^2";
		System.out.println(solve(exp3));
	}

	private static int solve(String exp) {
		Stack<Integer> stack = new Stack<>();
		
		for(char ch : exp.toCharArray()) {
			if(isOperand(ch)) {
				stack.push(Integer.valueOf(ch - '0'));
			} else if(isOperator(ch)) {
				process(stack, ch);
			} else {
				throw new RuntimeException("Invalid character: " + ch);
			}
		}
		
		return stack.pop();
	}
	
	private static boolean isOperand(char ch) {
		return (ch >= '0' && ch <= '9');
	}
	
	private static boolean isOperator(char ch) {
		return (ch == '+' || ch <= '-' || ch == '*' || ch == '/');
	}
	
	private static void process(Stack<Integer> stack, char operator) {
		int operand2 = stack.pop();
		int operand1 = stack.pop();
		int result = 0;
		
		switch(operator) {
		case '+':
			result = operand1 + operand2;
			break;
		case '-':
			result = operand1 - operand2;
			break;
		case '*':
			result = operand1 * operand2;
			break;	
		case '/':
			result = operand1 / operand2;
			break;	
		}
		
		stack.push(result);
	}
	
}
