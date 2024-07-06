// @author: seanpcox

package ch23_binarySearchTree;

public class BuildBSTSortedLinkedList {

	// O(nlogn) time
	// O(n) space for new tree
	
	// Finding the median takes ​O(n)​ time and we divide the task by 2 every time.
	
	/*
	 * 				4
	 * 			2		 6
	 * 		1	  3  5		 7
	 */
	
	public static void main(String[] args) {
		Node seven = new Node(7, null);
		Node six = new Node(6, seven);
		Node five = new Node(5, six);
		Node four = new Node(4, five);
		Node three = new Node(3, four);
		Node two = new Node(2, three);
		Node one = new Node(1, two);
		
		BSTNode root = createBST(one, seven);
		System.out.println(root.getData());
	}
	
	
	
	private static BSTNode createBST(Node start, Node end) {
		if(start == null || end == null || end.getRight() == start) {
			return null;
		}
		
		Node[] medianAndPrevious = findMedianAndPrevious(start, end);
		
		BSTNode bstNode = new BSTNode(medianAndPrevious[0].getData(), null, null);
		bstNode.setLeft(createBST(start, medianAndPrevious[1]));
		bstNode.setRight(createBST(medianAndPrevious[0].getRight(), end));
	
		return bstNode;
	}



	private static Node[] findMedianAndPrevious(Node start, Node end) {
		if(start == null || end == null) {
			return null;
		}
		
		Node spPrev = null;
		Node sp = start;
		Node fp = start;
		
		while(fp != end) {
			fp = fp.getRight();
			
			if(fp == end) {
				return new Node[] {sp, spPrev};
			}
			
			spPrev = sp;
			sp = sp.getRight();
			
			fp = fp.getRight();
		}
		
		return new Node[] {sp, spPrev};
	}

	static class BSTNode {
		private final double data;
		private BSTNode left;
		private BSTNode right;
		
		public BSTNode(double data, BSTNode left, BSTNode right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
		
		public double getData() {
			return data;
		}
		
		public void setLeft(BSTNode left) {
			this.left = left;
		}

		public void setRight(BSTNode right) {
			this.right = right;
		}

		public BSTNode getLeft() {
			return left;
		}
		
		public BSTNode getRight() {
			return right;
		}
	}
	
	static class Node {
		private final double data;
		private Node right;
		
		public Node(double data, Node right) {
			this.data = data;
			this.right = right;
		}
		
		public double getData() {
			return data;
		}

		public void setRight(Node right) {
			this.right = right;
		}
		
		public Node getRight() {
			return right;
		}
	}
	
}
