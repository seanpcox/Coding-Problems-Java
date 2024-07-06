// @author: seanpcox

package ch07_linkedlist;

public class FindMedianNode {

	// Use slow pointer fast pointer
	// Once fast reaches end slow will be in the middle
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.append(new Node(1));
		list.append(new Node(2));
		list.append(new Node(3));
		list.append(new Node(4));
		list.append(new Node(5));
		list.append(new Node(6));
		list.append(new Node(7));
		list.append(new Node(8));
		list.append(new Node(9));
		
		System.out.println(findMedian(list));
	}

	private static int findMedian(LinkedList list) {
		if(list == null || list.getHead() == null) {
			throw new RuntimeException("Invalid list");
		}
		
		Node sp = list.getHead();
		Node fp = list.getHead();
		
		while(fp != null) {
			fp = fp.getNext();
			
			if(fp == null) {
				break;
			}
			
			fp = fp.getNext();
			

			sp = sp.getNext();
		}
		
		return sp.getData();
	}
	
	
	
}
