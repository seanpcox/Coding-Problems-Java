// @author: seanpcox

package ch23_binarySearchTree;

public class BSTRecordAndMoveOn {

	// Given a BST that can contain duplicate elements, find the first occurrence of a number N.
	// Assume an InOrder traversal
	
	// So we record an occurrence of N if find it, then keep searching left of that node if we do
	// Assuming that duplicates go on the left side of a tree
	
	/*
	 * 				4
	 * 			2		 6
	 * 		1	  4*  5		 7
	 */
	
	// So for InOrder the 4* would be the first occurrence
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		int n = 4;
		Node root = generateBinaryTree();
		Node first = findFirstInOrder(root, n);
	}
	
	private static Node findFirstInOrder(Node node, int n) {
		Node result = null;
		
		while(node != null) {
			if(node.getData() > n) {
				node = node.getLeft();
			} else if(node.getData() < n) {
				node = node.getRight();
			} else {
				result = node; // Record result, and keep searching, go left as duplicates will be left in this tree
				node = node.getLeft();
			}
		}
		
		return result;
	}

	public static Node generateBinaryTree() {
		Node one = new Node(1, null, null);
		Node fourStar = new Node(4, null, null);
		Node five = new Node(5, null, null);
		Node seven = new Node(7, null, null);
		
		Node two = new Node(2, one, fourStar);
		Node six = new Node(6, five, seven);
		
		Node four = new Node(4, two, six);
		
		return four;
	}
	
	static class Node {
		private final int data;
		private final Node left;
		private final Node right;
		
		public Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
		
		public int getData() {
			return data;
		}
		
		public Node getLeft() {
			return left;
		}
		
		public Node getRight() {
			return right;
		}
	}
	
}
