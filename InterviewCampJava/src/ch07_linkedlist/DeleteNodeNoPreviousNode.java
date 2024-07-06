// @author: seanpcox

package ch07_linkedlist;

public class DeleteNodeNoPreviousNode {

	// Special trick where just update current node so it is it's next node
	// Note: Does not work for tail node!
	
	public static void main(String[] args) {
		Node node = new Node(1);
		
		LinkedList list = new LinkedList();
		list.append(node);
		list.append(new Node(0));
		list.append(new Node(2));
		list.append(new Node(1));
		list.append(new Node(2));
		list.append(new Node(1));
		System.out.println(list);
		
		list.delete(node);
		System.out.println(list);
	}
	
}
