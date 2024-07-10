// @author: seanpcox

package ch11_dp;

import java.util.HashMap;
import java.util.Map;

public class Fibonnaci {

	public static void main(String[] args) {
		int n = 10;
		
		System.out.println(fr(n));
		System.out.println(frm(n, new HashMap<Integer,Integer>()));
		System.out.println(frt(10));
	}

	private static int fr(int n) {
		if(n == 1 || n == 2) {
			return 1;
		}
		
		return fr(n-1) + fr(n-2);
	}
	
	private static int frm(int n, Map<Integer,Integer> m) {
		if(m.containsKey(n)) {
			return m.get(n);
		}
		
		if(n == 1 || n == 2) {
			m.put(n, 1);
			return 1;
		}
		
		int value = fr(n-1) + fr(n-2);
		m.put(n, value);
		return value;
	}
	
	private static int frt(int n) {
		int[] f = {1,1};
		
		for(int i = 3; i <= n; i++) {
			int v = f[0] + f[1];
			f[0] = f[1];
			f[1] = v;
		}
		
		return f[1];
	}
	
}
