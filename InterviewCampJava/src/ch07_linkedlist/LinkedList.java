// @author: seanpcox

package ch07_linkedlist;

public class LinkedList {

	private Node head;
	private Node tail;
	
	public LinkedList(Node head, Node tail) {
		this.head = head;
		this.tail = tail;
	}
	
	public LinkedList() {
	}

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public Node getTail() {
		return tail;
	}

	public void setTail(Node tail) {
		this.tail = tail;
	}
	
	public Node get(int index) {
		if(index < 0) {
			throw new IndexOutOfBoundsException("No node exists at index: " + index);
		}
		
		Node node = head;
		
		for(int i = 0; i < index; i++) {
			if(node == null) {
				throw new IndexOutOfBoundsException("No node exists at index: " + index);
			}
			
			node = node.getNext();
		}
		
		if(node == null) {
			throw new IndexOutOfBoundsException("No node exists at index: " + index);
		}
		
		return node;
	}
	
	public void append(Node node) {
		if(node == null) {
			return;
		}
		
		if(head == null) {
			head = node;
		} else {
			tail.setNext(node);
		}
		
		tail = node;
	}
	
	public void delete(Node node, Node previousNode) {
		if(node == null) {
			return;
		}
		// Node to delete is head
		if(node == head) {
			setHead(node.getNext());
		}
		// Node is tail
		if(node == tail) {
			setTail(previousNode);
		}
		// Normal case
		if(previousNode != null) {
			previousNode.setNext(node.getNext());
		}
	}
	
	public void delete(Node node) {
		if(node == null) {
			return;
		}
		// Node is tail
		if(node == tail) {
			throw new RuntimeException("Cannot delete tail in this case");
		}
		// Normal case
		Node nextNode = node.getNext();
		node.setData(nextNode.getData());
		node.setNext(nextNode.getNext());
	}
	
	public void appendList(LinkedList list) {
		if(list == null || list.getHead() == null) {
			return;
		}
		
		append(list.getHead());
		setTail(list.getTail());
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node node = head;
		
		while(node != null) {
			sb.append(node.getData() + " " );
			node = node.getNext();
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		Node tail = new Node(2, null);
		Node n2 = new Node(1, tail);
		Node head = new Node(0, n2);
		
		LinkedList list = new LinkedList(head, tail);
		System.out.println(list);
		System.out.println(list.get(2).getData());
	}
	
}
