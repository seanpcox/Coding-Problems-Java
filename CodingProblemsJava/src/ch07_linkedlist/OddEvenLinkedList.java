// @author: seanpcox

package ch07_linkedlist;

public class OddEvenLinkedList {

	/*
	 * Given a Linked List L, separate it into 2 Linked Lists. 
	 * One contains L's odd nodes and the other contains L's even nodes.
	 * 1 -> 2 -> 3 -> 4 -> 5
	 * 
	 * Q. Is the first node considered to have value of 1 or 0?
	 * A. The first node will be 1, so it will be in the odd list.
	 * 
	 * Q. What if we have an empty input list, or only 1 node in the input list. 
	 * What do we return for the 2 results?
	 * A. If you have an empty input list, return 2 empty lists. 
	 * If you have 1 node in the input list, return an odd list with the node and an empty even list.
	 * 
	 * Q. Should the result contain new nodes, or should I reuse nodes from the input list?
	 * A. Rearrange the nodes from the input list. At the end of your program, the input list 
	 * will be empty.
	 */
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.append(new Node(1));
		list.append(new Node(2));
		list.append(new Node(3));
		list.append(new Node(4));
		list.append(new Node(5));
		System.out.println(list);
		
		LinkedList[] output = oddAndEvenList(list);
		System.out.println(output[0]);
		System.out.println(output[1]);
	}

	private static LinkedList[] oddAndEvenList(LinkedList list) {
		LinkedList oddList = new LinkedList();
		LinkedList evenList = new LinkedList();
		
		LinkedList[] result = {oddList, evenList};
		
		if(list == null || list.getHead() == null) {
			return result;
		}
		
		Node node = list.getHead();
		boolean odd = true;
		
		while(node != null) {
			if(odd) {
				oddList.append(node);
			} else {
				evenList.append(node);
			}
			
			odd = !odd;
			node = node.getNext();
		}
		
		if(oddList.getTail() != null) {
			oddList.getTail().setNext(null);
		}
		if(evenList.getTail() != null) {
			evenList.getTail().setNext(null);
		}
		
		return result;
	}
	
}
