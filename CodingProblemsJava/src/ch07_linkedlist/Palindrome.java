// @author: seanpcox

package ch07_linkedlist;

public class Palindrome {

	public static void main(String[] args) {
		PNode tail = new PNode('k');
		PNode middle3 = new PNode('a', tail);
		PNode middle2 = new PNode('y', middle3);
		PNode middle1 = new PNode('a', middle2);
		PNode head = new PNode('k', middle1);

		printList(head);
		
		System.out.println(isPalindrome(head));
	}
	
	private static boolean isPalindrome(PNode head) {
		PNode sp = head;
		PNode fp = head;
		
		while(fp != null) {
			fp = fp.getNext();
			
			if(fp == null) {
				break;
			}
			
			fp = fp.getNext();
			sp = sp.getNext();
		}
		
		System.out.println(sp.getData());
		
		PNode curr = head;
		PNode prev = null;
		
		while(curr != sp) {
			PNode next = curr.getNext();
			curr.setNext(prev);
			prev = curr;
			curr = next;
		}
		
		sp = sp.getNext();
		
		while(sp != null) {
			if(sp.getData() != prev.getData()) {
				return false;
			}
			
			sp = sp.getNext();
			prev = prev.getNext();
		}
		
		return true;
	}

	private static void printList(PNode node) {
		while(node != null) {
			System.out.print(node.getData() + " ");
			node = node.getNext();
		}
		System.out.println();
	}	
	
}

class PNode {
	char data;
	PNode next;
	
	public PNode(char data) {
		this.data = data;
	}
	
	public PNode(char data, PNode next) {
		this.data = data;
		this.next = next;
	}

	public char getData() {
		return data;
	}

	public void setData(char data) {
		this.data = data;
	}

	public PNode getNext() {
		return next;
	}

	public void setNext(PNode next) {
		this.next = next;
	}
	
}