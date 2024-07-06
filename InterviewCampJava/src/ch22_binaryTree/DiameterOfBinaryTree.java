// @author: seanpcox

package ch22_binaryTree;

public class DiameterOfBinaryTree {

	// The diameter/width of a tree is defined as the number of nodes on the longest path between two end nodes.
	// It does not necessarily need to go through the root node
	
	// In this method we need two results, the height and the max path
	
	// Diameter is the number of nodes, not number of edges like height
	
	/*
	 * 	 
	 * 				4
	 * 			2		6
	 * 		1	  3   5		7
	 * 
	 *  = 5
	 *  
	 * 				4
	 * 			2		6
	 * 		1	  3   5		7
	 *                			8
	 *                		  9
	 *                
	 *  = 7              
	 */
	
	public static void main(String[] args) {
		System.out.println(getDiameter());
	}
	
	public static int getDiameter() {
		return getDiameter(generateBinaryTree()).getLongestPath();
	}
	
	public static Result getDiameter(Node node) {
		if(node == null) {
			return null;
		}
		
		Result left = getDiameter(node.getLeft());
		
		if(left == null) {
			left = new Result(0, 0);
		}
		
		Result right = getDiameter(node.getRight());
		
		if(right == null) {
			right = new Result(0, 0);
		}
		
		int longestPathForNode = left.getHeight() + right.getHeight() + 1;
		
		int longestPathThisSubTree = Math.max(left.getLongestPath(), right.getLongestPath());
		
		longestPathThisSubTree = Math.max(longestPathForNode, longestPathThisSubTree);
				
		int height = Math.max(left.getHeight(), right.getHeight()) + 1;
		
		return new Result(height, longestPathThisSubTree);
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
		int longestPath;
		
		public Result(int height, int longestPath) {
			this.height = height;
			this.longestPath = longestPath;
		}
		
		public int getHeight() {
			return height;
		}
		public void setHeight(int height) {
			this.height = height;
		}
		public int getLongestPath() {
			return longestPath;
		}
		public void setLongestPath(int longestPath) {
			this.longestPath = longestPath;
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
