// @author: seanpcox

package ch07_linkedlist;

public class FindNLastNode {

	// Use slow pointer fast pointer
	// This time they both move at the same speed, but one starts n times before the next starts
	
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
		
		System.out.println(findNLastNode(list, 9));
	}

	private static int findNLastNode(LinkedList list, int nLast) {
		if(list == null || list.getHead() == null) {
			throw new RuntimeException("Invalid list");
		}
		
		Node fp = list.getHead();
		
		for(int i = 0; i < nLast; i++) {
			if(fp == null) {
				throw new RuntimeException("List does not have enough nodes");
			}
			
			fp = fp.getNext();
		}
		
		Node sp = list.getHead();
		
		while(fp != null) {
			fp = fp.getNext();
			sp = sp.getNext();
		}
		
		return sp.getData();
	}
	
}
