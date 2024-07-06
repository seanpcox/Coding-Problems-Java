// @author: seanpcox

package ch08_stack;

public class ArrayImplement2Stacks {

	public static void main(String[] args) {
		IntegerArrayStack stacks = new IntegerArrayStack();
		stacks.pushS1(1);
		stacks.pushS1(2);
		stacks.pushS1(3);
		stacks.pushS1(4);
		stacks.pushS1(5);
		stacks.pushS2(6);
		stacks.pushS2(7);
		stacks.pushS2(8);
		System.out.println(stacks.popS1());
		stacks.pushS2(9);
		System.out.println(stacks.peekS1());
		System.out.println(stacks.popS2());
		stacks.pushS1(10);
		System.out.println(stacks.peekS1());
	}
	
}

class IntegerArrayStack {

	private Integer[] array = new Integer[8];
	private int p1 = -1;
	private int p2 = array.length;
	
	public void pushS1(Integer item) {
		if(p1 + 1 == p2) {
			throw new StackOverflowError("No capacity left in Stack 1");
		}
		
		p1 += 1;
		array[p1] = item;
	}
	
	public void pushS2(Integer item) {
		if(p2 - 1 == p1) {
			throw new StackOverflowError("No capacity left in Stack 2");
		}
		
		p2 -= 1;
		array[p2] = item;
	}
	
	public Integer peekS1() {
		if(p1 < 0) {
			throw new StackOverflowError("Stack 1 is empty");
		}
		
		return array[p1];
	}
	
	public Integer peekS2() {
		if(p2 >= array.length) {
			throw new StackOverflowError("Stack 2 is empty");
		}
		
		return array[p2];
	}
	
	public Integer popS1() {
		if(p1 < 0) {
			throw new StackOverflowError("Stack 1 is empty");
		}
		
		Integer item = array[p1];
		
		p1 -= 1;
		
		return item;
	}
	
	public Integer popS2() {
		if(p2 >= array.length) {
			throw new StackOverflowError("Stack 2 is empty");
		}
		
		Integer item = array[p2];
		
		p2 += 1;
		
		return item;
	}
	
}
