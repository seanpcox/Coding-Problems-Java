// @author: seanpcox

package ch22_binaryTree;

public class HeightTopToBottom {

	/* 	  			4
	 * 			2		6
	 * 		1	  3   5		7
	 */
	
	// Find the height of a binary tree.

	// Remember: The Height of a binary tree is the Depth of the deepest node in the tree.
	
	// Top - Bottom approach so we pass a value down to the children nodes
	
	public static void main(String[] args) {
		Result result = new Result(-1, -1);
		Node root = generateBinaryTree();
		result = maxDepth(root, result);
		System.out.println(result.getMaxDepth());
	}
	
	private static Result maxDepth(Node node, Result result) {
		if(node == null) {
			return result;
		}
		
		int height = result.getHeight() + 1;
		int maxDepth = Math.max(height, result.getMaxDepth());
		
		Result left = maxDepth(node.getLeft(), new Result(height, maxDepth));
		Result right = maxDepth(node.getRight(), new Result(height, maxDepth));
		
		if(left.getMaxDepth() > right.getMaxDepth()) {
			return left;
		} else {
			return right;
		}
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
	
	static class Result {
		int height;
		int maxDepth;
		public Result(int height, int maxDepth) {
			super();
			this.height = height;
			this.maxDepth = maxDepth;
		}
		public int getHeight() {
			return height;
		}
		public int getMaxDepth() {
			return maxDepth;
		}
		public void setHeight(int height) {
			this.height = height;
		}
		public void setMaxDepth(int maxDepth) {
			this.maxDepth = maxDepth;
		}
		
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
