// @author: seanpcox

package ch22_binaryTree;

import java.util.Stack;

public class BinaryTree {

	/*
	 	Key Concepts:
	 	
		In a binary tree, each node can have at most 2 nodes.
		
		The depth of a node N is the number of nodes on the search path from root to N, not including N.
		It's the number of edges between a node and it's root, so tree below has max depth or height of 2, think of zero index
		
		The height of a binary tree is the maximum depth of any node in that tree
		
		Concepts like complete binary tree, full binary tree, perfect binary tree are good to know but not generally important for interviews.
		
		A binary tree with height h can have a maximum of 2^(h+1) - 1 nodes. This will happen if all nodes have 2 nodes.
		
		Binary Search Trees (BST) will be covered in the next section. This section goes through Binary Tree problems without the BST component.
	 */
	
	/*
	 *  Traversal
	 *  
	 *  IN ORDER:   Visit LEFT, Process CURRENT, Visit RIGHT for each node
	 *  
	 *  PRE ORDER:  Process CURRENT, Visit LEFT, Visit RIGHT for each node
	 *  
	 *  POST ORDER: Visit LEFT, Visit RIGHT, Process CURRENT for each node
	 *  
	 *  
	 * 				4
	 * 			2		6
	 * 		1	  3   5		7
	 * 
	 * 
	 *	IN ORDER:   1, 2, 3, 4, 5, 6, 7
	 *  
	 *  PRE ORDER:  4, 2, 1, 3, 6, 5, 7
	 *  
	 *  POST ORDER: 1, 3, 2, 5, 7, 6, 4
	 */
	
	/*
	 *  Non-Recursive Implementation - Think STACKS
	 *  
	 *  Use a marker to mark if already visited
	 *  If already visited process it and don't re-add
	 *  
	 *  If not add in this order...
	 *  
	 *  INORDER: Right, Current, Left
	 *  
	 *  PREODER: More complex
	*/
	
	
	public static void main(String[] args) {
		printInOrder(generateBinaryTree());
		System.out.println();
		
		printPreOrder(generateBinaryTree());
		System.out.println();
		
		printPostOrder(generateBinaryTree());
		System.out.println();
		
		printInOrderWithStack(generateBinaryTree());
		System.out.println();
		
		printPreOrderWithStack(generateBinaryTree());
		System.out.println();
		
		printPostOrderWithStack(generateBinaryTree());
		System.out.println();
		
		printInOrderWithStackWithoutMarker(generateBinaryTree());
		System.out.println();
	}

	private static void printInOrderWithStack(Node binaryTreeRoot) {
		Stack<Node> stack = new Stack<>();
		stack.add(binaryTreeRoot);
		
		while(!stack.isEmpty()) {
			Node node = stack.pop();
			
			if(node.isVisited()) {
				System.out.print(node.getData() + " ");
			} else {
				node.setVisited(true);
				
				// Right
				if(node.getRight() != null) {
					stack.add(node.getRight());
				}
				
				// Current
				stack.add(node);
				
				// Left
				if(node.getLeft() != null) {
					stack.add(node.getLeft());
				}
			}
		}
	}

	// Don't need visited check since we process the node as soon as we get it
	private static void printPreOrderWithStack(Node binaryTreeRoot) {
		Stack<Node> stack = new Stack<>();
		stack.add(binaryTreeRoot);
		
		while(!stack.isEmpty()) {
			Node node = stack.pop();
			
			System.out.print(node.getData() + " ");

			// Right
			if(node.getRight() != null) {
				stack.add(node.getRight());
			}
			
			// Left
			if(node.getLeft() != null) {
				stack.add(node.getLeft());
			}
		}
	}
	
	// This is more complex, we need to rearrange the nodes I think
	private static void printPostOrderWithStack(Node binaryTreeRoot) {
	}
	
	private static void printInOrderWithStackWithoutMarker(Node node) {
		Stack<Node> stack = new Stack<>();
		
		while(node != null || !stack.isEmpty()) {
			if(node != null) {
				stack.push(node);
				node = node.getLeft();
			} else {
				node = stack.pop();
				System.out.print(node.getData());
				node = node.getRight();
			}
		}
	}
	
	private static void printInOrder(Node node) {
		if(node == null) {
			return;
		}
		
		printInOrder(node.getLeft());
		System.out.print(node.getData() + " ");
		printInOrder(node.getRight());
	}

	private static void printPreOrder(Node node) {
		if(node == null) {
			return;
		}
		
		System.out.print(node.getData() + " ");
		printPreOrder(node.getLeft());
		printPreOrder(node.getRight());
	}
	
	private static void printPostOrder(Node node) {
		if(node == null) {
			return;
		}
		
		printPostOrder(node.getLeft());
		printPostOrder(node.getRight());
		System.out.print(node.getData() + " ");
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
