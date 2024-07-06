// @author: seanpcox

package ch10_queue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class StockMaxPricesLastKDays {

	public static void main(String[] args) {
		// First entry price, second entry day
		Price[] a = {new Price(1,2),new Price(4,4),new Price(7,7),
				new Price(2,9),new Price(5,11)};
		int dw = 4; // 4 days window
		printMaxPrice(a,dw);
		
		StockPriceOverTime spot = new StockPriceOverTime(dw);
		spot.add(new Price(1,2));
		System.out.println(spot.getMax());
		spot.add(new Price(4,4));
		System.out.println(spot.getMax());
		spot.add(new Price(7,7));
		System.out.println(spot.getMax());
		spot.add(new Price(2,9));
		System.out.println(spot.getMax());
		spot.add(new Price(5,11));
		System.out.println(spot.getMax());
	}

	// Functional method
	private static void printMaxPrice(Price[] a, int dw) {
		Queue<Price> q = new LinkedList<>();
		
		for(int i = 0; i < a.length; i++) {
			int d = a[i].getDay();
			q.add(a[i]);
			
			// It is +1 as we include the current day in the days, so for 11 we want 8,9,10,11, not 7
			while(!q.isEmpty() && q.peek().getDay() < d - dw + 1) {
				q.remove();
			}
			
			int max = 0;
			Iterator<Price> es = q.iterator();
			while(es.hasNext()) {
				int p = es.next().getPrice();
				if(p > max) {
					max = p;
				}
			}
			
			System.out.println(max);
		}
	}
}

class StockPriceOverTime {
	private final Queue<Price> q;
	private final int dw;
	
	public StockPriceOverTime(int dw) {
		this.q = new LinkedList<>();
		this.dw = dw;
	}
	
	public void add(Price p) {
		int day = p.getDay();
		
		// It is +1 as we include the current day in the days, so for 11 we want 8,9,10,11, not 7
		while(!q.isEmpty() && q.peek().getDay() < day - dw + 1) {
			q.remove();
		}
		
		q.add(p);
	}
	
	public int getMax() {
		int max = 0;
		Iterator<Price> es = q.iterator();
		
		while(es.hasNext()) {
			int p = es.next().getPrice();
			if(p > max) {
				max = p;
			}
		}
		
		return max;
	}
}

class Price {
	private int price;
	private int day;
	
	public Price(int price, int day) {
		super();
		this.price = price;
		this.day = day;
	}

	public int getPrice() {
		return price;
	}

	public int getDay() {
		return day;
	}
}