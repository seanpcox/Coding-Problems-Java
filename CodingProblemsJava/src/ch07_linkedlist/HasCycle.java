// @author: seanpcox

package ch07_linkedlist;

public class HasCycle {

	// Does a supplied linked list have a cycle?
	// Use fast and slow pointer technique
	// Linked List can only have one cycle
	// Cycle can start at any node
	// Minimum cycle length is 1 i.e. node points to itself
	// Time complexity is O(n), 
	// This is because it takes at most 2 cycles for fast pointer to catch up with slow pointer
	// So O(2n) -> O(n)
	
	public static void main(String[] args) {
		Node cycleStart = new Node(3);
		
		LinkedList list = new LinkedList();
		list.append(new Node(1));
		list.append(new Node(2));
		list.append(cycleStart);
		list.append(new Node(4));
		list.append(new Node(5));
		list.append(new Node(6));
		list.append(new Node(7, cycleStart));
		
		// Cannot print as will loop until OOM
		//System.out.println(list);
		
		System.out.println(hasCycle(list));
	}

	private static boolean hasCycle(LinkedList list) {
		if(list == null || list.getHead() == null) {
			return false;
		}
		
		Node fastP = list.getHead();
		Node slowP = list.getHead();
		
		while(fastP != null) {
			fastP = fastP.getNext();
			
			if(fastP == slowP) {
				return true;
			}
			
			if(fastP == null) {
				return false;
			}
			
			fastP = fastP.getNext();
			
			if(fastP == slowP) {
				return true;
			}
			
			slowP = slowP.getNext();
		}
		
		return false;
	}
}
