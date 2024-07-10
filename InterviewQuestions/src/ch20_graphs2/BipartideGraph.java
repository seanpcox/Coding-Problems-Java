// @author: seanpcox

package ch20_graphs2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BipartideGraph {

	// Will not work for graphs with odd cycles
	// Can work for graphs with even cycles (though not sure always, need to check)
	// Generally asked only for un-directed graphs
	// We use BFS for this
	// We group nodes based on whether they are an odd or even distance away from the root node (we are assuming graph IS bipartide here)
	// To tell we keep track of what level each node is from root, if we find that a node's neighbour is at the same
	// level as it is, then it cannot be bipartide
	// BFS uses a Queue
	
	public static void main(String[] args) {
		Graph graph = generateGraph();
		bfsBipartide(graph);
	}
	
	private static void bfsBipartide(Graph graph) {
		if(graph == null || graph.getNodes() == null || graph.getNodes().isEmpty()) {
			throw new RuntimeException("Invalid graph");
		}
		
		for(Node node : graph.getNodes()) {
			if (node.getState() == NodeState.UNVISITED) {
				bfsBipartide(node);
			}
		}
	}

	private static void bfsBipartide(Node node) {
		Queue<Node> q = new LinkedList<>();
		node.setLevel(0);
		node.setState(NodeState.VISITING);
		q.add(node);
		
		List<Node> even = new ArrayList<>();
		List<Node> odd = new ArrayList<>();
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			
			if(n.getLevel() % 2 == 0) {
				even.add(n);
			} else {
				odd.add(n);
			}

			for(Node kid : n.getNeighbours()) {
				if(NodeState.UNVISITED == kid.getState()) {
					kid.setState(NodeState.VISITING);
					kid.setLevel(n.getLevel() + 1);
					q.add(kid);
				} else if(n.getLevel() == kid.getLevel()) {
					throw new RuntimeException("Invalid bipartide graph");
				}
			}
			
			n.setState(NodeState.VISITED);
		}
	}

	private static Graph generateGraph() {
		Graph graph = new Graph();
		Node one = new Node(1);
		graph.addNode(one);
		Node two = new Node(2);
		graph.addNode(two);
		Node three = new Node(3);
		graph.addNode(three);
		Node four = new Node(4);
		graph.addNode(four);
		
		// Bipartide graph, 4 nodes, square, undirected
		one.addNeighbour(two);
		one.addNeighbour(three);
		two.addNeighbour(one);
		two.addNeighbour(four);
		three.addNeighbour(one);
		three.addNeighbour(four);
		four.addNeighbour(two);
		four.addNeighbour(three);
		
		return graph;
	}
	
	static class Graph {
		private List<Node> nodes = new LinkedList<>();

		public List<Node> getNodes() {
			return nodes;
		}
		
		public boolean addNode(Node node) {
			return nodes.add(node);
		}
		
	}
	
	static class Node {
		private int data;
		private List<Node> neighbours = new LinkedList<>();
		private NodeState state = NodeState.UNVISITED;
		private int level = 0;
		
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
