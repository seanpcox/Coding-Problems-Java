// @author: seanpcox

package ch16_heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedian {

	// To solve this we can use two heaps
	// One max heap to store the lower half of the numbers
	// One min heap to store the higher half of the numbers
	// If both heaps the same size the median is the difference btw their two top elements
	// If one heap is larger the median is the top element of the larger one
	
	// How do we determine which numbers go into which heap?
	
	// So when we add a new element, we ensure:
	// 1.The heaps are equal in size, or
	// 2.high​ is one larger than ​low​.
	
	// We may have to move the top element from the low heap to the high heap in cases
	
	/*
	 * Insert: O(logn)
	 * Median Lookup: O(1)
	 * Space Complexity: O(n)
	 */
	
	public static void main(String[] args) {
		FindMedian heap = new FindMedian();
		heap.insert(1);
		heap.insert(2);
		heap.insert(0);
		heap.insert(-1);
		System.out.println(heap.getMedian());
	}
	
	private final PriorityQueue<Double> lowHeap;
	private final PriorityQueue<Double> highHeap;
	
	public FindMedian() {
		this.lowHeap = new PriorityQueue<>(Collections.reverseOrder());
		this.highHeap = new PriorityQueue<>();
	}
	
	// High heap should equal low heap size or have one more element
	public void insert(double e) {
		if(highHeap.isEmpty()) {
			highHeap.add(e);
			return;
		}
		
		if(lowHeap.size() == highHeap.size()) {
			if(e < lowHeap.peek()) {
				highHeap.add(lowHeap.poll());
				lowHeap.add(e);
			} else {
				highHeap.add(e);
			}
		} else {
			if(e > highHeap.peek()) {
				lowHeap.add(highHeap.poll());
				highHeap.add(e);
			} else {
				lowHeap.add(e);
			}
		}
	}
	
	public double getMedian() {
		if(lowHeap.isEmpty()) {
			throw new RuntimeException("No elements to return");
		}
		
		if(lowHeap.size() > highHeap.size()) {
			return lowHeap.peek();
		} else {
			return (lowHeap.peek() + highHeap.peek()) / 2;
		}
	}
	
}
