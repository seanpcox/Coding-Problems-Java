// @author: seanpcox

package ch17_lineSweep;

import java.util.*;

public class SkyLine {

	public static void main(String[] args) {
		List<Building> buildings = new ArrayList<>();
		buildings.add(new Building(1, 0, 5, 5));
		buildings.add(new Building(2, 2, 7, 4));
		buildings.add(new Building(3, 4, 10, 8));
		buildings.add(new Building(4, 12, 16, 6));
		buildings.add(new Building(5, 15, 27, 2));
		buildings.add(new Building(6, 20, 23, 10));
		buildings.add(new Building(7, 24, 30, 8));
		buildings.add(new Building(8, 25, 29, 3));
		System.out.println(buildings);
	
		SkyLine skyline = new SkyLine(buildings);
		System.out.println(skyline.getSkyline());
	}
	
	private final List<Building> buildings;
	
	public SkyLine(List<Building> buildings) {
		if(buildings == null || buildings.size() == 0) {
			throw new RuntimeException("No buildings have been supplied");
		}
		
		this.buildings = buildings;
	}
	
	public List<Interval> getSkyline() {
		List<Interval> skyLine = new ArrayList<>();
		
		List<Point> points = generatePoints();
		
		Collections.sort(points);
		
		System.out.println(points);
		
		// It’s delete() function takes O(N) time
		// Can be improved upon with custom heap / hashmap implementation, see course
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		
		Interval interval = new Interval();
		
		for(Point point : points) {
			if(point.isStart()) {
				if(maxHeap.isEmpty()) {
					interval.setStart(point.getPosition());
					interval.setHeight(point.getHeight());
				} else if(point.getHeight() > maxHeap.peek()) {
					interval.setEnd(point.getPosition());
					skyLine.add(interval);
					interval = new Interval();
					interval.setStart(point.getPosition());
					interval.setHeight(point.getHeight());
				}
				
				maxHeap.add(point.getHeight());
			} else {
				if(point.getHeight() == maxHeap.peek()) {
					interval.setEnd(point.getPosition());
					skyLine.add(interval);
					interval = new Interval();
					interval.setStart(point.getPosition());
					
					maxHeap.remove(point.getHeight());
					
					interval.setHeight(maxHeap.isEmpty() ? 0 : maxHeap.peek());
				} else {
					maxHeap.remove(point.getHeight());
				}
			}
		}
		
		return skyLine;
	}
	
	private List<Point> generatePoints() {
		List<Point> points = new ArrayList<>();
		
		for(Building building : buildings) {
			points.add(new Point(building.getId(), building.getStart(), building.getHeight(), true));
			points.add(new Point(building.getId(), building.getEnd(), building.getHeight(), false));
		}
		
		return points;
	}

	class Interval {
		private int start;
		private int end;
		private int height;
		
		public void setStart(int start) {
			this.start = start;
		}
		public void setEnd(int end) {
			this.end = end;
		}
		public void setHeight(int height) {
			this.height = height;
		}
		
		public String toString() {
			return start + ":" + end + ":" + height;
		}
	}
	
	class Point implements Comparable<Point> {
		int id; 
		int position; 
		int height; 
		boolean isStart;
		
		public Point(int id, int position, int height, boolean isStart) {
			this.id = id;
			this.position = position;
			this.height = height;
			this.isStart = isStart;
		}

		public int getId() {
			return id;
		}

		public int getPosition() {
			return position;
		}

		public int getHeight() {
			return height;
		}

		public boolean isStart() {
			return isStart;
		}
		
		public int compareTo(Point o) {
			if(this.getPosition() == o.getPosition()) {
				if(this.isStart() == o.isStart()) {
					return 0;
				}
				
				return this.isStart() ? -1 : 1;
			}
			
			return this.getPosition() < o.getPosition() ? -1 : 1;
		}
		
		public String toString() {
			return getPosition() + ":" + getHeight() + ":" + getId() + ":" + isStart();
		}
		
	}
	
	static class Building {
		private final int id;
		private final int start;
		private final int end;
		private final int height;
		
		public Building(int id, int start, int end, int height) {
			this.id = id;
			this.start = start;
			this.end = end;
			this.height = height;
		}

		public int getId() {
			return id;
		}

		public int getStart() {
			return start;
		}

		public int getEnd() {
			return end;
		}

		public int getHeight() {
			return height;
		}
		
		@Override
		public String toString() {
			return "#" + id + ", s:" + start + ", e:" + end + ", h:" + height;
		}
		
	}
	
}
