// @author: seanpcox

package ch23_binarySearchTree;

public class BuildBSTSortedArray {

	// O(n) time
	// O(n) space for new tree
	
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		Node root = buildBST(a, 0, a.length-1);
		System.out.println(root.getData());
	}
	
	private static Node buildBST(int[] a, int s, int e) {
		if(s > e) {
			return null;
		}
		
		int mid = ((e - s) / 2) + s;
		
		Node node = new Node(a[mid], null, null);
		
		node.setLeft(buildBST(a, s, mid-1));
		node.setRight(buildBST(a, mid+1, e));
		
		return node;
	}

	static class Node {
		private final double data;
		private Node left;
		private Node right;
		
		public Node(double data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
		
		public double getData() {
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
