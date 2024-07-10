// @author: seanpcox

package ch16_heaps;

import java.util.Collections;
import java.util.PriorityQueue;

// We could solve this by sorting the array O(logn) time O(1) space
// We could use a min heap but that will take ​O(Nlog(N))​ time because 
// we insert ​N​ elements into the Heap.It will also take ​O(N)​ space because we 
// store ​N​ nodes in the Heap. Not very efficient.
// As a comparison, sorting also takes ​O(Nlog(N))​ time and can take ​O(1)​ space.
// Instead we could use a max heap and limit its size to K. We will also keep
// note of the max property of the heap.
// Notice that we always restrict the sizeof the Heap to ​K​. 
// This algorithm hence takes ​O(K)​ space and ​O(NlogK)​ time.
// // In Java, the PriorityQueue class is a heap.
// ​PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
// PriorityQueue by orders by natural collection order, so for int smallest will be
// on top. We want to reverse this. So use Collections.reverseOrder().

public class FindSmallestXElementsInArray {

	public static void main(String[] args) {
		int[] a = {6,3,6,6,2,2,4,1};
		int n = 4;
		PriorityQueue<Integer> q = findSmallestXElementsInArray(a, n);
		System.out.println(q);
	}

	private static PriorityQueue<Integer> findSmallestXElementsInArray(int[] a, int n) {
		if(n > a.length) {
			return null;
		}
		
		PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int e : a) {
			if(q.size() < n) {
				q.add(e);
			} else if(q.peek() > e) {
				q.poll();
				q.add(e);
			}
		}
		
		return q;
	}
	
}
