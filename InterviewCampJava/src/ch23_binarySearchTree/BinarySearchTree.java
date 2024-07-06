package ch23_binarySearchTree;

//@author: seanpcox

public class BinarySearchTree {

	// Determine if a tree is a binary search tree
	
	/*
	
	A Binary Search Tree (BST) is a Binary Tree where given a node N, all nodes in N’s left tree have values less than N, and all nodes in N’s right subtree have values greater than N.

	In practice, values can be duplicates. In that case it is up to the implementor to decide the rule. For example, nodes in the left subtree can be less than or equal.
	
	Balanced BSTs guarantee that the height of the tree will be log(n), where n is the number of nodes of the tree.

	There are two main balancing techniques you should be aware of - Red Black Trees and AVL Trees. It is good to know how one of these works. Their implementations are pretty complex and outside the scope of interviews.

	Searching a balanced BST is O(logn), where n is the number of nodes.

	Searching a unbalanced BST is O(n), since in the worse case the tree can be like a linked list.

	In general, when we talk about BST, unless specified, we are talking about balanced BSTs.

	Deletions are O(logn)

	Adding a new element is also O(logn)

	 */
	
	/*
	 *  
	 * 				4
	 * 			2		6
	 * 		1	  3   5		7
	 * 
	 * 
	 */
	
	// NOTE: LEARN THIS, HAD ISSUES!
	
	public static void main(String[] args) {
		Node root = generateBinaryTree();
		System.out.println(isBST(root));
	}
	
	public static MinMax isBST(Node node) {
		if(node == null) { // leaf nodes always balanced
			return new MinMax(Double.MAX_VALUE, Double.MIN_VALUE);
		}
		
		MinMax left = isBST(node.getLeft());
		MinMax right = isBST(node.getRight());
		
		if(left == null || right == null) {
			return null;
		}
		
		double nodeValue = node.getData();
		
		if(nodeValue < left.getMax() || nodeValue > right.getMin()) {
			System.out.println("Not BST: " + left.getMax() + " : " + right.getMin());
			return null;
		}
		
		double min = node.getLeft() == null ? nodeValue : left.getMin();
		double max = node.getRight() == null ? nodeValue : right.getMax();
		
		return new MinMax(min, max);
	}
	
	public static Node generateBinaryTree() {
		//Node threePointFive = new Node(3.5, null, null);
		
		Node one = new Node(1, null, null);
		Node three = new Node(3, null, null);
		
		// Not BST
		//Node five = new Node(5, threePointFive, null);
		
		// BST
		Node five = new Node(5, null, null);
		
		
		Node seven = new Node(7, null, null);
		
		Node two = new Node(2, one, three);
		Node six = new Node(6, five, seven);
		
		Node four = new Node(4, two, six);
		
		return four;
	}
	
	static class MinMax {
		private Double min, max;

		public MinMax(Double min, Double max) {
			this.min = min;
			this.max = max;
		}

		public Double getMin() {
			return min;
		}
		
		public Double getMax() {
			return max;
		}
		
		public String toString() {
			return min + " : " + max;
		}
		
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
