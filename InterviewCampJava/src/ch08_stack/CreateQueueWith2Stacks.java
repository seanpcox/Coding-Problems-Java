// @author: seanpcox

package ch08_stack;

import java.util.Stack;

public class CreateQueueWith2Stacks {

	// Stack is L.I.F.O
	// Queue is F.I.F.O
	
	public static void main(String[] args) {
		StackQueue<Integer> queue = new StackQueue<>();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		
		System.out.println(queue.poll());
		queue.enqueue(4);

		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		
		System.out.println(queue.poll());
		
		StackQueue2<Integer> queue2 = new StackQueue2<>();
		queue2.enqueue(1);
		queue2.enqueue(2);
		queue2.enqueue(3);
		
		System.out.println(queue2.poll());
		queue2.enqueue(4);

		System.out.println(queue2.dequeue());
		System.out.println(queue2.dequeue());
		System.out.println(queue2.dequeue());
		System.out.println(queue2.dequeue());
		
		System.out.println(queue2.poll());
	}
	
	
}

class StackQueue<T> {
	// O(1) to queue
	// O(n) to dequeue
	
	private Stack<T> input = new Stack<>();
	private Stack<T> output = new Stack<>();
	
	public void enqueue(T item) {
		input.push(item);
	}
	
	public T dequeue() {
		if(output.isEmpty()) {
			flush();
		}
		
		if(output.isEmpty()) {
			return null;
		} else {
			return output.pop();
		}
	}
	
	public T poll() {
		if(output.isEmpty()) {
			flush();
		}
		
		if(output.isEmpty()) {
			return null;
		} else {
			return output.peek();
		}
	}
	
	private void flush() {
		while(!input.isEmpty()) {
			output.push(input.pop());
		}
	}
}

class StackQueue2<T> {
	// O(n) to queue
	// O(1) to dequeue
	
	private Stack<T> input = new Stack<>();
	private Stack<T> output = new Stack<>();
	
	public void enqueue(T item) {
		flush1();
		output.push(item);
		flush2();
	}
	
	public T dequeue() {
		if(output.isEmpty()) {
			return null;
		} else {
			return output.pop();
		}
	}
	
	public T poll() {
		if(output.isEmpty()) {
			return null;
		} else {
			return output.peek();
		}
	}
	
	private void flush1() {
		while(!output.isEmpty()) {
			input.push(output.pop());
		}
	}
	
	private void flush2() {
		while(!input.isEmpty()) {
			output.push(input.pop());
		}
	}
}
