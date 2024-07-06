// @author: seanpcox

package ch17_lineSweep;

import java.util.Arrays;

public class FindAnyTimeOverlaps {

	// Given a list of time periods find if any overlap
	
	// What if we start at the same time something ends, is that an overlap? yes
	
	public static void main(String[] args) {
		int[][] timePeriods = {{5,7},{5,7},{5,7},{6,9},{8,9},{8,9},{8,9}};
		FindAnyTimeOverlaps overlaps = new FindAnyTimeOverlaps(timePeriods);
		System.out.println(overlaps.isOverlap());
		System.out.println(overlaps.maxOverlap());
	}
	
	private Point[] timePoints;
	
	public FindAnyTimeOverlaps(int[][] timePeriods) {
		timePoints = generatePoints(timePeriods);
		Arrays.sort(timePoints);
		System.out.println(Arrays.toString(timePoints));
	}
	
	public boolean isOverlap() {
		int count = 0;
		
		for(Point timePoint : timePoints) {
			if(timePoint.isStart()) {
				count++;
			} else {
				count--;
			}
			
			if(count == 2) {
				return true;
			}
		}
		
		return false;
	}
	
	public int maxOverlap() {
		int count = 0;
		int maxCount = 0;
		
		for(Point timePoint : timePoints) {			
			if(timePoint.isStart()) {
				count++;
			} else {
				count--;
			}
			
			if(count > 1) {
				maxCount = Math.max(maxCount, count);
			}
		}
		
		return maxCount;
	}
	
	private Point[] generatePoints(int[][] timePeriods) {
		if(timePeriods == null || timePeriods.length == 0) {
			throw new RuntimeException("No time periods supplied");
		}
		
		Point[] points = new Point[timePeriods.length * 2];
		
		int i = 0;
		
		for(int[] timePeriod : timePeriods) {
			points[i] = new Point(true, timePeriod[0]);
			i++;
			points[i] = new Point(false, timePeriod[1]);
			i++;
		}
		
		return points;
	}

	class Point implements Comparable<Point> {
		private boolean isStart;
		private int time;
		
		public Point(boolean isStart, int time) {
			this.isStart = isStart;
			this.time = time;
		}

		public boolean isStart() {
			return isStart;
		}

		public int getTime() {
			return time;
		}

		public String toString() {
			return getTime() + ": " + isStart();
		}
		
		@Override
		public int compareTo(Point o) {
			if(this.getTime() > o.getTime()) {
				return 1;
			} else if(this.getTime() < o.getTime()) {
				return -1;
			} else {
				// This part will identify when a period ends same time as one starts
				// In this case we count this as an overlap
				// If we don't want to we can do the opposite
				if(this.isStart() == o.isStart()) {
					return 0;
				} else if(this.isStart()) {
					return -1;
				} else {
					return 1;
				}
			}
		}
		
	}
	
}
