package ch22_binaryTree;

//@author: seanpcox

public class IsTreeBalanced {

	// A binary tree is balanced if there is no more than 1 in height difference between a nodes left and right node
	
	public static void main(String[] args) {
		Node root = generateBinaryTree();
		System.out.println(isBalancedOrNot(root));
		System.out.println(isBalancedMine(root));
	}
	
	private static boolean isBalancedOrNot(Node node) {
		if(isBalanced(node) == -1) {
			return false;
		}
		
		return true;
	}
	
	private static int isBalanced(Node node) {
		if(node == null) {
			return 0;
		}
		
		int left = isBalanced(node.getLeft());
		int right = isBalanced(node.getRight());
		
		if(left == -1 || right == -1) {
			return -1;
		}
		
		if(Math.abs(left - right) > 1) {
			return -1;
		}
		
		return Math.max(left, right) + 1;
	}
	
	private static int isBalancedMine(Node node) {
		if(node == null) {
			return -1;
		}
		
		int left = isBalanced(node.getLeft()) + 1;
		int right = isBalanced(node.getRight()) + 1;
		
		if(Math.abs(left - right) > 1) {
			throw new RuntimeException("Inbalanced Tree");
		}
		
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
		
		// Used for non-recursive stack implementation
		private boolean isVisited;
		
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

		public boolean isVisited() {
			return isVisited;
		}

		public void setVisited(boolean isVisited) {
			this.isVisited = isVisited;
		}
	}
}
