// @author: seanpcox

package ch22_binaryTree;

import java.util.HashMap;
import java.util.Map;

public class BinaryTreeReconstruction {

	// To reconstruct a binary tree from a set of traversals there are a few things to keep in mind
	
	// You always need the InOrder traversal, to work out what nodes are to the left and those to the right
	// You need either the pre-order or post-order traversal to find the roots, either first or last node
	
	// You cannot reconstruct if given just the pre-order or post-order traversal
	
	// This will only work if there are no duplicate node values, otherwise we can't work out the root
	
	/* 	  			4
	 * 			2		6
	 * 		1	  3   5		7
	 */
	
	// In-Order:   1, 2, 3, 4, 5, 6, 7
	// Pre-Order:  4, 2, 1, 3, 6, 5, 7
	// Post-Order: 1, 3, 2, 5, 7, 6, 4
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		int[] inOrder = generateInOrder();
		int[] preOrder = generatePreOrder();
		int[] postOrder = generatePostOrder();
		
		Node rootPre = generatePreTree(inOrder, preOrder);
		Node rootPost = generatePostTree(inOrder, postOrder);
	}
	
	private static Node generatePostTree(int[] inOrder, int[] postOrder) {
		Map<Integer, Integer> inOrderMap = new HashMap<>();
		
		for(int i = 0; i < inOrder.length; i++) {
			inOrderMap.put(inOrder[i], i);
		}
		
		return generatePostTree(inOrder, postOrder, 0, inOrder.length - 1, 0, postOrder.length - 1, inOrderMap);
	}
	
	private static Node generatePostTree(int[] inOrder, int[] preOrder, int iStart, int iEnd, int pStart, int pEnd, Map<Integer, Integer> inOrderMap) {
		if(iStart > iEnd || pStart > pEnd) {
			return null;
		}
		
		int rootN = preOrder[pEnd];
		
		int inOrderIndex = inOrderMap.get(rootN);
		
		Node root = new Node(rootN);
		
		// Need to learn these formulas
		
		Node left = generatePostTree(inOrder, preOrder, iStart, inOrderIndex - 1, pStart, pStart + (inOrderIndex - iStart) - 1, inOrderMap);

		Node right = generatePostTree(inOrder, preOrder, inOrderIndex + 1, iEnd, pStart + (inOrderIndex - iStart), pEnd - 1, inOrderMap);
		
		root.setLeft(left);
		root.setRight(right);
		
		return root;
	}
	
	private static Node generatePreTree(int[] inOrder, int[] preOrder) {
		Map<Integer, Integer> inOrderMap = new HashMap<>();
		
		for(int i = 0; i < inOrder.length; i++) {
			inOrderMap.put(inOrder[i], i);
		}
		
		return generatePreTree(inOrder, preOrder, 0, inOrder.length - 1, 0, preOrder.length - 1, inOrderMap);
	}
	
	private static Node generatePreTree(int[] inOrder, int[] preOrder, int iStart, int iEnd, int pStart, int pEnd, Map<Integer, Integer> inOrderMap) {
		if(iStart > iEnd || pStart > pEnd) {
			return null;
		}
		
		int rootN = preOrder[pStart];
		
		int inOrderIndex = inOrderMap.get(rootN);
		
		Node root = new Node(rootN);
		
		// Need to learn these formulas
		
		Node left = generatePreTree(inOrder, preOrder, iStart, inOrderIndex - 1, pStart + 1, pStart + (inOrderIndex - iStart), inOrderMap);

		Node right = generatePreTree(inOrder, preOrder, inOrderIndex + 1, iEnd, pStart + (inOrderIndex - iStart) + 1, pEnd, inOrderMap);
		
		root.setLeft(left);
		root.setRight(right);
		
		return root;
	}
	
	
	/*
	 * // add  left and right subtrees to root node    
	 * root.left  = construct(preorder, preStart+1, preStart+(k-inStart), inorder, inStart, k-1, inorderMap);
     * root.right = construct(preorder, preStart+(k-inStart)+1, preEnd, inorder, k+1, inEnd, inorderMap);
	 */
	
	private static int[] generateInOrder() {
		return new int[] {1, 2, 3, 4, 5, 6, 7};
	}
	
	private static int[] generatePreOrder() {
		return new int[] {4, 2, 1, 3, 6, 5, 7};
	}
	
	private static int[] generatePostOrder() {
		return new int[] {1, 3, 2, 5, 7, 6, 4};
	}
	
	static class Node {
		private final int data;
		private Node left;
		private Node right;
		
		public Node(int data) {
			this.data = data;
		}
		
		public int getData() {
			return data;
		}
		
		public void setLeft(Node left) {
			this.left = left;
		}

		public void setRight(Node right) {
			this.right = right;
		}

		public Node getLeft() {
			return left;
		}
		
		public Node getRight() {
			return right;
		}
	}
	
}
