// @author: seanpcox

package ch11_dp;

public class NumberOfStepsTopDown {

	public static void main(String[] args) {
		int ns = 8;
		int[] ps = {1,3,5};
		System.out.println(numberOfStepsTownDownRecur(ns, ps));
		System.out.println(numberOfStepsTownDownTabulation(ns, ps));
	}

	// Space O(n)
	// Time O(3n)
	private static int numberOfStepsTownDownTabulation(int ns, int[] ps) {
		int[] s = new int[ns + 1];
		s[0] = 1;
		
		for(int i = 1; i < s.length; i ++) {
			for(int j = 0; j < ps.length; j++) {
				if(i-ps[j] < 0) {
					continue;
				}
				s[i] += s[i-ps[j]];
			}
		}
		
		return s[s.length-1];
	}

	// Space O(1)
	// So the number of steps to get to n would be in this case the number of steps to get to n-5 + n-3 + n-1
	private static int numberOfStepsTownDownRecur(int ns, int[] ps) {
		// We can't go before the start point
		if(ns < 0) {
			return 0;
		}
		// There is one way to get to the start
		if(ns == 0) {
			return 1;
		}
		
		int p = 0;
		
		// ns(p) = ns(p - 5) + ns(p - 3) + ns (p - 1)
		for(int s : ps) {
			p += numberOfStepsTownDownRecur(ns - s, ps);
		}
		
		return p;
	}
	
}
