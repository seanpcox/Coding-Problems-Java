// @author: seanpcox

package ch22_binaryTree;

public class LowestCommonAncestorLCAWithoutParent {

	public static void main(String[] args) {
		Node[] nodes = generateBinaryTree();
		System.out.println(findLCA(nodes[0], nodes[1], nodes[2]));
	}
	
	private static int findLCA(Node root, Node a, Node b) {
		if(root.getData() == a.getData() || root.getData() == b.getData()) {
			return root.getData();
		}
		
		return findLCAMethod(root, a, b).getData();
	}

	private static Node findLCAMethod(Node n, Node a, Node b) {
		if(n == null) {
			return null;
		}
		if(n.getData() == a.getData()) {
			return n;
		}
		if(n.getData() == b.getData()) {
			return n;
		}
		
		Node lN = findLCAMethod(n.getLeft(), a, b);
		
		Node rN = findLCAMethod(n.getRight(), a, b);

		if(lN != null && rN != null) {
			return n;
		}
		
		return lN != null ? lN : rN;
	}

	public static Node[] generateBinaryTree() {
		Node nine = new Node(9, null, null);
		Node eight = new Node(8, nine, null);
		
		Node one = new Node(1, null, null);
		Node three = new Node(3, null, null);
		Node five = new Node(5, null, null);
		Node seven = new Node(7, null, eight);
		
		Node two = new Node(2, one, three);
		Node six = new Node(6, five, seven);
		
		Node four = new Node(4, two, six);
		
		return new Node[] {four, one, three};
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
