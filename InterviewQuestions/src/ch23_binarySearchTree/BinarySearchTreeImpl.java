// @author: seanpcox

package ch23_binarySearchTree;

public class BinarySearchTreeImpl {

	/*
	 *   
	 * 				4
	 * 			2		 6
	 * 		1	  3   5		 7
	 *                 5.5
	 */
	
	public static void main(String[] args) {
		BinarySearchTreeImpl tree = new BinarySearchTreeImpl(4);
		tree.add(2);
		tree.add(6);
		tree.add(1);
		tree.add(3);
		tree.add(5);
		tree.add(7);
		tree.add(5.5);
		
		System.out.println(tree.contains(5));
		
		tree.delete(4);
	}
	
	private Node rootNode;
	
	public BinarySearchTreeImpl(int rootData) {
		rootNode = new Node(rootData, null, null);
	}
	
	public void add(double data) {
		Node node = rootNode;
		
		while(node != null) {
			if(data < node.getData()) {
				Node leftNode = node.getLeft();
				
				if(leftNode == null) {
					leftNode = new Node(data, null, null);
					node.setLeft(leftNode);
					node = null;
				} else {
					node = leftNode;
				}
			} else if(data > node.getData()) {
				Node rightNode = node.getRight();
				
				if(rightNode == null) {
					rightNode = new Node(data, null, null);
					node.setRight(rightNode);
					node = null;
				} else {
					node = rightNode;
				}
			} else {
				// Duplicate value, we will not support here
				node = null;
			}
		}
	}
	
	private Node[] getAndParent(int data) {
		Node parentNode = null;
		Node node = rootNode;
		
		while(node != null) {
			if(data == node.getData()) {
				return new Node[] {node, parentNode};
			}
			else if(data > node.getData()) {
				parentNode = node;
				node = node.getRight();
			} 
			else if(data < node.getData()) {
				parentNode = node;
				node = node.getLeft();
			}
		}
		
		return null;
	}
	
	public Node get(int data) {
		Node[] childAndParent = getAndParent(data);
		
		return childAndParent == null ? null : childAndParent[0];
	}
	
	public boolean contains(int data) {
		Node node = get(data);
		
		return node == null ? false : true;
	}

	public void delete(int data) {
		Node[] childAndParent = getAndParent(data);
		
		if(childAndParent == null) {
			return;
		}
		
		delete(childAndParent[0], childAndParent[1]);
	}
	
	/*
	 * Delete is a more complex case, there are a few scenarios
	 * 
	 * 1. If a root node we can simply remove its parents reference to it
	 * 2. If it has one child, then remove it and make its child its successor to the parent node
	 * 3. If it has two children...
	 *    a. It's successor will be its right child's left most node
	 *    b. If this left most node has no right child we can simply swap values and then delete the child
	 *    c. If this left most node has a right child then we swap values but we also need to link its right child also (like in 2)
	 */
	private void delete(Node node, Node parent) {
		// 1. It's a leaf node, just remove it from its parent
		if(node.getLeft() == null && node.getRight() == null) {
			replaceNode(parent, node, null);
		} 
		// 2. It only has one child, so just make that child its successor for its parent, put on the correct side
		else if(node.getLeft() == null) {
			replaceNode(parent, node, node.getRight());
		}
		else if(node.getRight() == null) {
			replaceNode(parent, node, node.getLeft());
		}
		// 3. More complex, two kids, get its right node and find its leftmost child, that will be successor, 
		// then we need to recall delete to link its children to node above
		else {
			Node successorParent = node;
			Node successor = node.getRight(); // Get right child of node
			
			while(successor.getLeft() != null) { // Next find its leftmost child
				successorParent = successor;
				successor = successor.getLeft();
			}
			
			node.setData(successor.getData()); // Update node to successor's value, essentially copying over it
			
			delete(successor, successorParent); // Now we need to call recursively to delete the old node we copied from and relink it
		}
	}
	
	private void replaceNode(Node parent, Node oldChild, Node newChild) {
		if(parent == null) { // Root Node
			rootNode = newChild;
		} else if(parent.getLeft().equals(oldChild)) {
			parent.setLeft(newChild);
		} else if(parent.getRight().equals(oldChild)) {
			parent.setRight(newChild);
		} else {
			throw new RuntimeException("Invalid parent child swap!");
		}
	}
	
	class Node {
		private double data;
		private Node left;
		private Node right;
		
		public Node(double data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
		
		public void setData(double data) {
			this.data = data;
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
