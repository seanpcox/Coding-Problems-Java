// @author: seanpcox

package ch07_linkedlist;

public class ReverseInPlace {

	public static void main(String[] args) {
		CNode tail = new CNode(3);
		CNode middle = new CNode(2, tail);
		CNode head = new CNode(1, middle);

		printList(head);
		
		reverseList(head);
		
		printList(tail);
	}
	
	private static void reverseList(CNode head) {
		CNode prevNode = null;
		CNode currentNode = head;
		
		while(currentNode != null) {
			CNode next = currentNode.getNext();
			currentNode.setNext(prevNode);
			prevNode = currentNode;
			currentNode = next;
		}
	}

	private static void printList(CNode node) {
		while(node != null) {
			System.out.print(node.getData() + " ");
			node = node.getNext();
		}
		System.out.println();
	}	
}

class CNode {
	int data;
	CNode next;
	
	public CNode(int data) {
		this.data = data;
	}
	
	public CNode(int data, CNode next) {
		this.data = data;
		this.next = next;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public CNode getNext() {
		return next;
	}

	public void setNext(CNode next) {
		this.next = next;
	}
	
}