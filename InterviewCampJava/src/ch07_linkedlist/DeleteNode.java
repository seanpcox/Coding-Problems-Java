// @author: seanpcox

package ch07_linkedlist;

public class DeleteNode {

	public static void main(String[] args) {
		Node prevNode = new Node(2);
		Node node = new Node(1);
		
		LinkedList list = new LinkedList();
		list.append(new Node(1));
		list.append(new Node(0));
		list.append(new Node(2));
		list.append(new Node(1));
		list.append(prevNode);
		list.append(node);
		System.out.println(list);
		
		list.delete(node, prevNode);
		System.out.println(list);
	}
	
}
