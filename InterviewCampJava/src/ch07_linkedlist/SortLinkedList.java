// @author: seanpcox

package ch07_linkedlist;

public class SortLinkedList {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.append(new Node(1));
		list.append(new Node(0));
		list.append(new Node(2));
		list.append(new Node(1));
		list.append(new Node(2));
		list.append(new Node(1));
		System.out.println(list);
		
		list = sortLinkedList(list);
		System.out.println(list);
	}

	private static LinkedList sortLinkedList(LinkedList list) {
		LinkedList list0 = new LinkedList();
		LinkedList list1 = new LinkedList();
		LinkedList list2 = new LinkedList();
		
		Node node = list.getHead();
		
		while(node != null) {
			if(node.getData() == 0) {
				list0.append(node);
			} else if(node.getData() == 1) {
				list1.append(node);
			} else if(node.getData() == 2) {
				list2.append(node);
			}
			
			node = node.getNext();
		}
		
		if(list0.getTail() != null) {
			list0.getTail().setNext(null);
		}
		if(list1.getTail() != null) {
			list1.getTail().setNext(null);
		}
		if(list2.getTail() != null) {
			list2.getTail().setNext(null);
		}
		
		LinkedList result = new LinkedList();
		result.appendList(list0);
		result.appendList(list1);
		result.appendList(list2);
		
		return result;
	}
	
}
