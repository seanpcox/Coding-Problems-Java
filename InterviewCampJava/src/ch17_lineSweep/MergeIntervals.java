// @author: seanpcox

package ch17_lineSweep;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeIntervals {

	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(1,3));
		intervals.add(new Interval(3,5));
		intervals.add(new Interval(6,8));
		intervals.add(new Interval(7,9));
		
		MergeIntervals merge = new MergeIntervals(intervals);
		System.out.println(merge.merge());
	}
	
	private List<Point> points;
	
	public MergeIntervals(List<Interval> intervals) {
		if(intervals == null || intervals.size() == 0) {
			throw new RuntimeException("No intervals supplied");
		}
		
		points = generatePoints(intervals);
		
		System.out.println(points);
	}
	
	public List<Interval> merge() {
		List<Interval> merged = new ArrayList<>();
		
		int count = 0;
		int start = 0;
		
		for(Point point: points) {
			if(point.isStart()) {
				if(count == 0) {
					start = point.getTime();
				}
				
				count++;
			} else {
				count--;
			}
			
			if(count == 0) {
				merged.add(new Interval(start, point.getTime()));
			}
		}
		
		return merged;
	}
	
	private List<Point> generatePoints(List<Interval> intervals) {
		List<Point> points = new ArrayList<>();
		
		for(Interval interval : intervals) {
			points.add(new Point(interval.getStart(), true));
			points.add(new Point(interval.getEnd(), false));
		}
		
		Collections.sort(points);
		
		return points;
	}

	static class Interval {
		
		private final int start;
		private final int end;
		
		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}

		public int getStart() {
			return start;
		}

		public int getEnd() {
			return end;
		}
		
		public String toString() {
			return "[" + getStart() + ", " + getEnd() + "]";
		}
	}
	
	class Point implements Comparable<Point> {
		private final int time;
		private final boolean isStart;
		
		public Point(int time, boolean isStart) {
			super();
			this.time = time;
			this.isStart = isStart;
		}

		public int getTime() {
			return time;
		}

		public boolean isStart() {
			return isStart;
		}

		public String toString() {
			return getTime() + ": " + isStart();
		}
		
		public int compareTo(Point o) {
			if(this.getTime() == o.getTime()) {
				if(this.isStart() == o.isStart()) {
					return 0;
				}
				
				return this.isStart() ? -1 : 1;
			}
			
			return this.getTime() < o.getTime() ? -1 : 1;
		}
	}
	
}
