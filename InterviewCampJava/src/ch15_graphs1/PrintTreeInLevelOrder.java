// @author: seanpcox

package ch15_graphs1;

import java.util.*;

public class PrintTreeInLevelOrder {
	
	// We want each level to be printed on its own line
	
	public static void main(String[] args) {
		new PrintTreeInLevelOrder();
	}
	
	public PrintTreeInLevelOrder() {
		// Top is best way
		Node root = generateTree();
		printTreeInLevelOrderMarker(root);
		root = generateTree();
		printTreeInLevelOrderTwoQueues(root);
		root = generateTree();
		printTreeInLevelOrderMine(root);
	}

	private void printTreeInLevelOrderMarker(Node root) {
		Queue<Node> q = new LinkedList<>();
		root.setState(NodeState.VISITING);
		q.add(root);
		q.add(null);
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			
			if(node == null) {
				if(!q.isEmpty()) {
					q.add(null);
				}
				
				System.out.println();
				continue;
			}
			
			System.out.print(node.getData() + " ");
			
			for(Node neighbour : node.getNeighbours()) {
				if(NodeState.UNVISITED == neighbour.getState()) {
					neighbour.setState(NodeState.VISITING);
					q.add(neighbour);
				}
			}
			
			node.setState(NodeState.VISITED);
		}
	}
	
	private void printTreeInLevelOrderTwoQueues(Node root) {
		Queue<Node> cq = new LinkedList<>();
		Queue<Node> nq = new LinkedList<>();
		root.setState(NodeState.VISITING);
		cq.add(root);
		
		while(!cq.isEmpty()) {
			Node current = cq.poll();
			
			System.out.print(current.getData() + " ");
			
			for(Node neighbour : current.getNeighbours()) {
				if(NodeState.UNVISITED == neighbour.getState()) {
					neighbour.setState(NodeState.VISITING);
					nq.add(neighbour);
				}
			}
			
			current.setState(NodeState.VISITED);
			
			if(cq.isEmpty()) {
				cq = nq;
				nq = new LinkedList<>();
				System.out.println();
			}
		}
	}
	
	private void printTreeInLevelOrderMine(Node root) {
		Queue<Node> q = new LinkedList<>();
		root.setState(NodeState.VISITING);
		q.add(root);
		
		int level = 1;
		root.setLevel(level);
		
		while(!q.isEmpty()) {
			Node current = q.poll();
			
			if(current.getLevel() > level) {
				System.out.println();
				level++;
			}
			
			System.out.print(current.getData() + " ");
			
			for(Node neighbour : current.getNeighbours()) {
				if(NodeState.UNVISITED == neighbour.getState()) {
					neighbour.setState(NodeState.VISITING);
					neighbour.setLevel(current.getLevel() + 1);
					q.add(neighbour);
				}
			}
			
			current.setState(NodeState.VISITED);
		}
	}

	private Node generateTree() {
		Node root = new Node(1);
		
		createTree(root, 4, 2);
		
		return root;
	}
	
	private void createTree(Node node, int max, int level) {
		if(level > max) {
			return;
		}
		
		Node node1 = new Node(level);
		Node node2 = new Node(level);
		node.addNeighbour(node1);
		node.addNeighbour(node2);
		
		createTree(node1, max, level+1);
		createTree(node2, max, level+1);
	}

	class Node {
		private int data;
		private List<Node> neighbours = new LinkedList<>();
		private NodeState state = NodeState.UNVISITED;
		private int level;
		
		public Node(int data) {
			this.data = data;
		}
		
		public int getData() {
			return data;
		}
		
		public List<Node> getNeighbours() {
			return neighbours;
		}
		
		public boolean addNeighbour(Node node) {
			return neighbours.add(node);
		}

		public NodeState getState() {
			return state;
		}

		public void setState(NodeState state) {
			this.state = state;
		}

		public int getLevel() {
			return level;
		}

		public void setLevel(int level) {
			this.level = level;
		}
		
	}
	
	enum NodeState {
		UNVISITED,
		VISITING,
		VISITED
	}
	
}
