// @author: seanpcox

package ch15_graphs1;

import java.util.*;

public class DepthFirstSearch {

	public static void main(String[] args) {
		//new DepthFirstSearch();
		new DepthFirstSearch(3);
	}
	
	public DepthFirstSearch() {
		Graph graph = generateGraph();
		dfs(graph.getNodes());
	}
	
	public DepthFirstSearch(int target) {
		Graph graph = generateGraph();
		
		for(Node node : graph.getNodes()) {
			dfs(node, target);
		}
	}
	
	private void dfs(Node node, int target) {
		if(NodeState.UNVISITED == node.getState()) {
			node.setState(NodeState.VISITING);
			
			if(target == node.getData()) {
				System.out.println(node.getData());
				return;
			}
			
			for(Node neighbour : node.getNeighbours()) {
				dfs(neighbour, target);
			}
			
			node.setState(NodeState.VISITED);
		}
	}
	
	private void dfs(List<Node> nodes) {
		for(Node node : nodes) {
			if(NodeState.UNVISITED == node.getState()) {
				node.setState(NodeState.VISITING);
				processNode(node);
				dfs(node.getNeighbours());
				node.setState(NodeState.VISITED);
			}
		}
	}

	private void processNode(Node node) {
		System.out.println(node.getData());
	}

	private Graph generateGraph() {
		Graph graph = new Graph();
		Node one = new Node(1);
		graph.addNode(one);
		Node two = new Node(2);
		graph.addNode(two);
		Node three = new Node(3);
		graph.addNode(three);
		Node four = new Node(4);
		graph.addNode(four);
		Node five = new Node(5);
		graph.addNode(five);
		Node six = new Node(6);
		graph.addNode(six);
		Node seven = new Node(7);
		graph.addNode(seven);
		Node eight = new Node(8);
		graph.addNode(eight);
		
		// One island
		one.addNeighbour(two);
		one.addNeighbour(three);
		two.addNeighbour(four);
		four.addNeighbour(six);
		three.addNeighbour(four);
		three.addNeighbour(five);
		five.addNeighbour(six);
		
		// One island
		seven.addNeighbour(eight);
		
		return graph;
	}
	
	class Graph {
		private List<Node> nodes = new LinkedList<>();

		public List<Node> getNodes() {
			return nodes;
		}
		
		public boolean addNode(Node node) {
			return nodes.add(node);
		}
		
	}
	
	class Node {
		private int data;
		private List<Node> neighbours = new LinkedList<>();
		private NodeState state = NodeState.UNVISITED;
		
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
		
	}
	
	enum NodeState {
		UNVISITED,
		VISITING,
		VISITED
	}
	
}
