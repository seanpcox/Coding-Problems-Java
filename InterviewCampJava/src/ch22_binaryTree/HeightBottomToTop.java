// @author: seanpcox

package ch22_binaryTree;

public class HeightBottomToTop {

	// Find the height of a binary tree, which is the max depth
	// We start at the bottom and go up
	// At each level the max height is the max(left, right) + 1
	
	// Is this postorder traversal?
	
	public static void main(String[] args) {
		Node root = generateBinaryTree();
		System.out.println(getHeight(root, -1));
		System.out.println(getHeight(root));
	}
	
	public static int getHeight(Node node) {
		if(node == null) {
			return -1;
		}
		
		return Math.max(getHeight(node.getLeft()), getHeight(node.getRight())) + 1;
	}
	
	public static int getHeight(Node node, int count) {
		if(node == null) {
			return count;
		}
		
		count++;
		int left = getHeight(node.getLeft(), count);
		int right = getHeight(node.getRight(), count);
		return Math.max(left, right);
	}
	
	public static Node generateBinaryTree() {
		Node nine = new Node(9, null, null);
		Node eight = new Node(8, nine, null);
		
		Node one = new Node(1, null, null);
		Node three = new Node(3, null, null);
		Node five = new Node(5, null, null);
		Node seven = new Node(7, null, eight);
		
		Node two = new Node(2, one, three);
		Node six = new Node(6, five, seven);
		
		Node four = new Node(4, two, six);
		
		return four;
	}
	
	static class Node {
		private final int data;
		private final Node left;
		private final Node right;
		
		// Used for height
		private int height;
		
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

		public int getHeight() {
			return height;
		}

		public void setHeight(int height) {
			this.height = height;
		}
	}
	
}
