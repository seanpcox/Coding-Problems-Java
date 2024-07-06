// @author: seanpcox

package ch23_binarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class BSTRangeQuery {
	
	// Given a Binary Search Tree, find all the elements in the range [A..B], both A and B inclusive. 
	
	// For example, if we are looking for nodes in the range [2,5] in the following tree:
	// We would return [2,3,4,5]
	
	// 
	
	/*
	 * 				4
	 * 			2		 6
	 * 		1	  3   5		 7
	 */
	
	// Solution: Find A, or A's successor if A is not in the tree. Then keep finding successors until you exceed B.

	public static void main(String[] args) {
		int[] range = {0,7};
		Node root = generateBinaryTree();
		List<Node> results = getNodesInRange(root, range);
		
		for(Node node : results) {
			System.out.println(node.getData());
		}
	}
	
	private static List<Node> getNodesInRange(Node root, int[] range) {
		List<Node> results = new ArrayList<>();
		
		getNodesInRange(root, range, results);
		
		return results;
	}

	private static void getNodesInRange(Node root, int[] range, List<Node> results) {
		Node result = getSuccessorOrNode(root, null, range[0], true);
		
		while(result != null) {
			if(result.getData() > range[1]) {
				break;
			}
			
			results.add(result);
			result = getSuccessorOrNode(root, null, result.getData(), false);
		}
	}

	private static Node getSuccessorOrNode(Node node, Node rightParent, int n, boolean getNode) {
		if(node == null) {
			return null;
		}
		
		if(node.getData() == n) {
			if(getNode) {
				return node;
			}
			
			// 1. Left most child in right tree
			if(node.getRight() != null) {
				node = node.getRight();
				
				while(node.getLeft() != null) {
					node = node.getLeft();
				}
				
				return node;
			}
			// 2. First parent to the right
			else if(rightParent != null) {
				return rightParent;
			}
			// 3. No parent to the right or right child 
			else {
				return null;
			}
		} else if(node.getData() > n) {
			Node result = getSuccessorOrNode(node.getLeft(), node, n, getNode);
			
			if(result != null) {
				return result;
			} else if(getNode) {
				return node;
			} else {
				return null;
			}
		} else {
			Node result = getSuccessorOrNode(node.getRight(), rightParent, n, getNode);
			
			if(result != null) {
				return result;
			} else if(getNode) {
				return node;
			} else {
				return null;
			}
		}
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
