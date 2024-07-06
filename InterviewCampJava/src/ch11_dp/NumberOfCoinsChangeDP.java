// @author: seanpcox

package ch11_dp;

public class NumberOfCoinsChangeDP {

	// Coin Change - Print Count: Given a set of coin denominations, print out the number of 
	// ways you can make a target amount. You can use as many coins of each denomination as you like.

	// For example: If coins are [1,2,5] and the target is 5, the different ways are: 4
	
	// a[i] = a[i] + a[i - coin]
	
	public static void main(String[] args) {
		int n = 30;
		int[] c = {1,2,5}; // I'm assuming sorted order here, lowest first
		
		System.out.println(getCoinComboCount(n, c));
	}

	public static int getCoinComboCount(int n, int[] coins) {
		int[] combos = new int[n+1];
		combos[0] = 1;
		
		for(int coin : coins) {
			for(int i = coin; i < combos.length; i++) {
				combos[i] = combos[i] + combos[i-coin];
			}
		}
		
		return combos[combos.length - 1];
	}

	// 1111111111
	// 211111111
	// 22111111
	// 2221111
	// 222211
	// 22222
	// 55
	// 5221
	// 52111
	// 511111
	
}
