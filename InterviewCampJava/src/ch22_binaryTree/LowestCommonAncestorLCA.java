// @author: seanpcox

package ch22_binaryTree;

public class LowestCommonAncestorLCA {

	// Given two nodes find their lowest ancestor
	// We can assume a parent pointer here
	// In this we can use a hashmap to record one nodes ancestors
	// Then when going up the next nodes path we can check for the first ancestor it has also in our map
	
	/*
	 *  
	 * 				4
	 * 			2		6
	 * 		1	  3   5		7
	 * 
	 * 
	 */
	
	// O(h) runtime, h is height of tree
	// Takes O(h) space as storing results
	
	// A more space efficient method O(1) is to find the depth of both nodes
	// The move the deepest node up to the same level as the shallower node
	// Then we can move them both up by one iteratively, until we meet a common parent
	// Special case: One node is the ancestor of another, then the LCA will be the shallower node
	
	// There is also a Bottom to Top approach to solve this without a parent pointer
	
	// Given 2 nodes of a tree, find their lowest common ancestor (LCA). Assume that each node has a parent pointer.
	
	public static void main(String[] args) {
		Node[] nodes = generateBinaryTree();
		System.out.println(findLCA(nodes[0], nodes[1]));
	}
	
	public static int findLCA(Node a, Node b) {
		int aDepth = getNodeDepth(a);
		int bDepth = getNodeDepth(b);
		
		while(aDepth > bDepth) {
			a = a.getParent();
			aDepth--;
		}
		
		while(bDepth > aDepth) {
			b = b.getParent();
			bDepth--;
		}
		
		while(a != null && b != null) {
			if(a.getData() == b.getData()) {
				return a.getData();
			}
			
			a = a.getParent();
			b = b.getParent();
		}
		
		return 0;
	}
	
	public static int getNodeDepth(Node n) {
		int depth = 0;
		
		while(n.getParent() != null) {
			n = n.getParent();
			depth++;
		}
		
		return depth;
	}
	
	public static Node[] generateBinaryTree() {
		Node one = new Node(1, null, null);
		Node three = new Node(3, null, null);
		Node five = new Node(5, null, null);
		Node seven = new Node(7, null, null);
		
		Node two = new Node(2, one, three);
		Node six = new Node(6, five, seven);
		
		one.setParent(two);
		three.setParent(two);
		
		five.setParent(six);
		seven.setParent(six);
		
		Node four = new Node(4, two, six);
		
		two.setParent(four);
		six.setParent(four);
		
		return new Node[] {six, four};
	}
	
	static class Node {
		private final int data;
		private final Node left;
		private final Node right;
		
		private Node parent;
	
		
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

		public Node getParent() {
			return parent;
		}

		public void setParent(Node parent) {
			this.parent = parent;
		}
	}
	
}
