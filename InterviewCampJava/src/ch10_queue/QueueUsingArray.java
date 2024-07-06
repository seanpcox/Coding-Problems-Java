// @author: seanpcox

package ch10_queue;

public class QueueUsingArray {

	public static void main(String[] args) {
		QueueArray a = new QueueArray();
		a.enqueue(1);
		a.enqueue(2);
		a.enqueue(3);
		a.enqueue(4);
		a.dequeue();
		a.enqueue(5);
		a.dequeue();
		a.enqueue(3);
		a.dequeue();
		a.dequeue();
		a.dequeue();
		a.dequeue();
		a.enqueue(7);
		a.dequeue();
		a.enqueue(7);
		a.dequeue();
		a.enqueue(7);
		a.dequeue();
		a.enqueue(7);
	}
	
}
/*
5 2 3 4
^ ^ ^ ^
    f b
*/

class QueueArray2 {
	int[] a = new int[4];
	int sp = 0;
	int ep = 0;
	int length = 0;
	
	public void enqueue(int item) {
		if(length == a.length) {
			throw new RuntimeException("Queue is full");
		}
		
		a[ep] = item;
		
		length++;
		ep = (ep + 1) % a.length;
	}
	
	public int dequeue() {
		if(length == 0) {
			throw new RuntimeException("Queue is empty");
		}
		
		int item = a[sp];
		
		length--;
		sp = (sp + 1) % a.length;
		
		return item;
	}
	
}

class QueueArray {
	int[] a = new int[4];
	int sp = 0;
	int ep = 0;
	
	public void enqueue(int item) {
		if(ep - sp >= a.length) {
			throw new RuntimeException("Queue is full");
		}
		
		a[ep%a.length] = item;
		
		ep++;
		
		print();
	}
	
	public int dequeue() {
		if(ep == sp) {
			throw new RuntimeException("Queue is empty");
		}
		
		int item = a[sp%a.length];
		
		sp++;
		
		print();
		
		return item;
	}
	
	public void print() {
		for(int i = sp; i < ep; i++) {
			System.out.print(a[i%a.length]);
		}
		System.out.println();
	}
	
}
