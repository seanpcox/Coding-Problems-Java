// @author: seanpcox

package ch12_arraysAndStrings2;

public class Max2StockProfit {

	public static void main(String[] args) {
		int[] a = {2,3,1,4,2,8,9,4};
		System.out.println(getMax2(a));
		a = new int[]{1,9,3,6,1,0,9};
		System.out.println(getMax2(a));
		a = new int[]{1,2,3,4,5,6,7};
		System.out.println(getMax2(a));
		a = new int[]{3,2,1};
		System.out.println(getMax2(a));
	}
	
	private static int getMax2(int[] a) {
		if(a == null || a.length < 2) {
			throw new RuntimeException("Invalid stock input");
		}
		
		int[] bestTillI = new int[a.length];
		int minSoFar = Integer.MAX_VALUE;
		int maxDiff = 0;
		
		for(int i = 0; i < a.length; i++) {
			minSoFar = Math.min(minSoFar, a[i]);
			maxDiff = Math.max(maxDiff, a[i] - minSoFar);
			bestTillI[i] = maxDiff;
		}
		
		int[] bestFromI = new int[a.length];
		int maxSoFar = Integer.MIN_VALUE;
		maxDiff = 0;
		
		for(int i = a.length-1; i >= 0; i--) {
			maxSoFar = Math.max(maxSoFar, a[i]);
			maxDiff = Math.max(maxDiff, maxSoFar - a[i]);
			bestFromI[i] = maxDiff;
		}
		
		int max2Trades = 0;
		
		for(int i = 0; i < a.length; i++) {
			int max2ndTrade = (i < a.length - 1) ? bestFromI[i] : 0;
			max2Trades = Math.max(max2Trades, bestTillI[i] + max2ndTrade);
		}
		
		return max2Trades;
	}
	
}
