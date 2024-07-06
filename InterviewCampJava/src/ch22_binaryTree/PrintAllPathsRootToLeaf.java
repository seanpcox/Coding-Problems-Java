// @author: seanpcox

package ch22_binaryTree;

import java.util.Stack;

public class PrintAllPathsRootToLeaf {

	/*
	 *  
	 * 				4
	 * 			2		6
	 * 		1	  3   5		7
	 * 
	 * 
	 */
	
	public static void main(String[] args) {
		Node root = generateBinaryTree();
		printAllPaths(root, "");
		
		printAllPaths(root, new Stack<Node>());
	}
	
	private static void printAllPaths(Node node, String path) {
		if(node == null) {
			return;
		}
		
		path += node.getData() + " ";
		
		if(node.getLeft() == null && node.getRight() == null) {
			System.out.println(path);
		}
		
		printAllPaths(node.getLeft(), path);
		printAllPaths(node.getRight(), path);
	}

	private static void printAllPaths(Node node, Stack<Node> stack) {
		if(node == null) {
			return;
		}
		
		stack.add(node);
		
		if(node.getLeft() == null && node.getRight() == null) {
			System.out.println(stack);
		}
		
		printAllPaths(node.getLeft(), stack);
		printAllPaths(node.getRight(), stack);
		
		stack.pop();
	}
	
	public static Node generateBinaryTree() {
		Node ten = new Node(10, null, null);
		Node nine = new Node(9, null, null);
		Node eight = new Node(8, nine, ten);
		
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
		
		public String toString() {
			return "" + data;
		}
	}
	
}
