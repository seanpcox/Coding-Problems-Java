// @author: seanpcox

package ch07_linkedlist;

public class FindCycleStartNode {
	// First find cycle length
	// Then find Nth last node, or rather where the nodes meet rather than fp going to null
	
	public static void main(String[] args) {
		Node cycleStartNode = new Node(6);
		
		LinkedList list = new LinkedList();
		list.append(new Node(1));
		list.append(new Node(2));
		list.append(new Node(3));
		list.append(new Node(4));
		list.append(new Node(5));
		list.append(cycleStartNode);
		list.append(new Node(7));
		list.append(new Node(8));
		list.append(new Node(9, cycleStartNode));
		
		System.out.println(findCycleStartNode(list));
	}

	private static int findCycleStartNode(LinkedList list) {
		if(list == null || list.getHead() == null) {
			return -1;
		}
		
		// 1st find a node in the cycle using sp fp
		Node fp = list.getHead();
		Node sp = list.getHead();
		
		while(fp != null) {
			fp = fp.getNext();
			
			if(sp == fp) {
				break;
			}
			
			fp = fp.getNext();
			
			if(sp == fp) {
				break;
			}
			
			sp = sp.getNext();
		}
		
		// So both fp and sp are now equal, lets find list length
		
		int count = 1;
		while(fp != null) {
			fp = fp.getNext();
			if(fp == sp) {
				break;
			}
			count++;
		}
		
		// So now we get the start node using the count value;
		fp = list.getHead();
		sp = list.getHead();
		
		for(int i = 0; i < count; i++) {
			fp = fp.getNext();
		}
		
		while(fp != null) {
			if(fp == sp) {
				break;
			}
			
			fp = fp.getNext();
			sp = sp.getNext();
		}
		
		return sp.getData();
	}
	
}
