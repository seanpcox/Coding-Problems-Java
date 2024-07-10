// @author: seanpcox

package ch08_stack;

import java.util.Stack;

public class InfixExpressionWithParenthesis {

	public static void main(String[] args) {
		String exp1 = "1+2/1+3*2";
		String exp2 = "(1+2)/(1+3*2)";
		String exp3 = "1+2/1+(3*2)";
		String exp4 = "1+2/(1+3*2)";
		
		System.out.println(solve(exp1));
		System.out.println(solve(exp2));
		System.out.println(solve(exp3));
		System.out.println(solve(exp4));
	}

	private static int solve(String exp) {
		Stack<Integer> operands = new Stack<>();
		Stack<Character> operators = new Stack<>();
		
		for(char ch : exp.toCharArray()) {
			if(isOperand(ch)) {
				operands.push(ch - '0');
			} else if(isOperator(ch)) {
				while(!operators.isEmpty() && (getPrecedence(operators.peek()) >= getPrecedence(ch))) {
					process(operands, operators);
				}
				operators.push(ch);
			} else if(ch == '(') {
				operators.push(ch);
			} else if(ch == ')') {
				while(operators.peek() != '(') {
					process(operands, operators);
				}
				operators.pop();
			} else {
				throw new RuntimeException("Invalid character: " + ch);
			}
		}
		
		while(!operators.isEmpty()) {
			process(operands, operators); 
		}
		
		return operands.pop();
	}

	private static void process(Stack<Integer> operands, Stack<Character> operators) {
		int operand2 = operands.pop();
		int operand1 = operands.pop();
		char operator = operators.pop();
		
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
		
		operands.push(result);
	}

	private static int getPrecedence(char ch) {
		switch(ch) {
		case '/':
		case '*':
			return 2;
		case '+':
		case '-':
			return 1;
		case '(':
		case ')':
			return 0;
		}
		
		throw new RuntimeException("Invalid operator: " + ch);
	}
	
	private static boolean isOperator(char ch) {
		return ch == '+' || ch == '-' || ch == '*' || ch == '/';
	}

	private static boolean isOperand(char ch) {
		return (ch >= '0' && ch <= '9');
	}
	
}
