// @author: seanpcox

package ch10_queue;

import java.util.*;

public class QueueLookupMaxO1 {

	// Implement a Queue with O(1) lookup of the maximum element in the Queue.
	// We use two queues for this
	public static void main(String[] args) {
		QueueMax q = new QueueMax();
		q.add(7);
		System.out.println(q.getMax());
		q.add(11);
		System.out.println(q.getMax());
		q.add(8);
		q.add(8);
		System.out.println(q.getMax());
		q.poll();
		q.poll();
		System.out.println(q.getMax());
		q.poll();
		System.out.println(q.getMax());
		q.add(12);
		q.add(4);
		q.add(15);
		System.out.println(q.getMax());
	}
}

class QueueMax {
	private final Queue<Integer> q;
	private final Deque<Integer> mq;
	
	public QueueMax() {
		q = new LinkedList<>();
		mq = new LinkedList<>();
	}
	
	public void add(Integer i) {
		q.add(i);
		
		while(!mq.isEmpty() && mq.getLast() < i) {
			mq.removeLast();
		}
		
		mq.add(i);
	}
	
	public int getMax() {
		return mq.peek();
	}
	
	public int poll() {
		int v = q.poll();
		
		if(mq.peek() == v) {
			mq.poll();
		}
		
		return v;
	}
}
