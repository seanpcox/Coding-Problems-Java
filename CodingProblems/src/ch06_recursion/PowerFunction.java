// @author: seanpcox

package ch06_recursion;

public class PowerFunction {

	// Power Function: Implement a function to calculate x^n. 
	// Both x and n can be positive/negative and overflow doesn't happen. 
	// Try doing it in O(log(n)) time.
	
	public static void main(String[] args) {
		int n = -2;
		int p = -3;
		System.out.println(powerFuntion(n,p));
	}
	
	public static double powerFuntion(int n, int p) {
		double result = powerFunctionRecur(Math.abs(n), Math.abs(p));
		
		if(p < 0) {
			result = 1 / result;
		}
		
		if(n < 0) {
			result = -1 * result;
		}
		
		return result;	
	}
	
	public static double powerFunctionRecur(double n, int p) {
		if(p == 0) {
			return 1;
		}
		if(p == 1) {
			return n;
		}
		
		double halfPower = powerFunctionRecur(n, p/2);
		
		if(p % 2 == 0) {
			return halfPower * halfPower;
		} else {
			return n * halfPower * halfPower;
		}
	}
	
}
