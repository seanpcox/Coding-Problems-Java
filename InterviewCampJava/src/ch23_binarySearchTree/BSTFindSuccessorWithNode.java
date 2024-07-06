// @author: seanpcox

package ch23_binarySearchTree;

public class BSTFindSuccessorWithNode {

	// Find the in-order successor of a given node in a BST.
	
	// Successor is NEXT LARGEST ITEM
	
	// Find Successor: Given a Node N in a BST, find the node with the next largest value, 
	// also known as the successor of the node.
	
	// If this is the last node in the tree, i.e. that largest number, then there is no successor
	
	/*
	 * 				4
	 * 			2		 6
	 * 		1	  3   5		 7
	 */
	
	// We can break this down into 3 cases:
	
	// 1. ​If the node has a right child​: 
	//		The successor will be the ​leftmost​ node of the right subtree.
	//
	//    	So for 4, the successor will be 5
	
	// 2. ​If there is no right child​: 
	//		The successor is the first parent to the right.  
	//
	//		o(h) time to find it
	//      To find that, perform a search for the node. 
	//		We traverse the tree from root to the node and find the ancestor to the right of the node. 
	//		This is very similar to the Record and Move On technique.
	//		So for 3, the successor will be 4
	
	// 3. If there is no right child or no parent on the right​: this is the last node of the tree, there is no successor.
	//
	//      So for 7, there is no successor
	
	
	public static void main(String[] args) {
		Node[] childAndRoot = generateBinaryTree();
		
		Node successor = findSuccessor(childAndRoot[0], childAndRoot[1]);
		
		if(successor != null) {
			System.out.println(successor.getData());
		} else {
			System.out.println("No successor!");
		}
	}
	
	// O(h) time
	private static Node findSuccessor(Node node, Node root) {
		// 1. Leftmost​ node of the right subtree
		if(node.getRight() != null) {
			node = node.getRight();
			
			while(node.getLeft() != null) {
				node = node.getLeft();
			}
			
			return node;
		}
		else {
			Node successor = null;
			Node current = root;
			
			// 2. First parent to the right
			while(current != null) {
				if(current == node) {
					return successor;
				}
				else if(current.getData() > node.getData()) {
					successor = current;
					current = current.getLeft();
				} else {
					current = current.getRight();
				}
			}
			
			// 3. No successor if no right parent or right child
			return null;
		}
	}

	public static Node[] generateBinaryTree() {
		Node one = new Node(1, null, null);
		Node three = new Node(3, null, null);
		Node five = new Node(5, null, null);
		Node seven = new Node(7, null, null);
		
		Node two = new Node(2, one, three);
		Node six = new Node(6, five, seven);
		
		Node four = new Node(4, two, six);
		
		return new Node[] {three, four};
	}
	
	static class Node {
		private final double data;
		private final Node left;
		private final Node right;
		
		public Node(double data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
		
		public double getData() {
			return data;
		}
		
		public Node getLeft() {
			return left;
		}
		
		public Node getRight() {
			return right;
		}
		
		public String toString() {
			return "" + data;
		}
	}
	
}
