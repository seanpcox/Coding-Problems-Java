// @author: seanpcox

package ch23_binarySearchTree;

public class BSTLCA {

	// Simpler than LCA for binary tree
	
	// 1. if node value is greater than a and b, go left
	// 2. if node value is less than a and b, go right
	// 3. else we have found the LCA
	//    	This works if one of the nodes is the parent of the other
	//		Or if the two nodes are on either side of the parent
	
	/*
	 * 				4
	 * 			2		 6
	 * 		1	  3   5		 7
	 */
	
	// Assume both nodes in tree
	
	public static void main(String[] args) {
		int a = 4;
		int b = 5;
		Node root = generateBinaryTree();
		
		Node result = findLCA(root, a, b);
		
		if(result != null) {
			System.out.println(result.getData());
		} else {
			System.out.println("No result");
		}
	}
	
	private static Node findLCA(Node node, int a, int b) {
		while(node != null) {
			if(node.getData() > a && node.getData() > b) {
				node = node.getLeft();
			}
			else if(node.getData() < a && node.getData() < b) {
				node = node.getRight();
			} else {
				return node;
			}
		}
		
		return null;
	}

	public static Node generateBinaryTree() {
		Node one = new Node(1, null, null);
		Node three = new Node(3, null, null);
		Node five = new Node(5, null, null);
		Node seven = new Node(7, null, null);
		
		Node two = new Node(2, one, three);
		Node six = new Node(6, five, seven);
		
		Node four = new Node(4, two, six);
		
		return four;
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
	}
}
