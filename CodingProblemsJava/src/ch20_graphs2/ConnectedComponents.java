// @author: seanpcox

package ch20_graphs2;

import java.util.LinkedList;
import java.util.List;

public class ConnectedComponents {

	// Color all connected nodes different colors
	// Remember graphs can have unconnected nodes
	// Can use with BFS or DFS for this
	// Usually asked for undirected graphs
	
	public static void main(String[] args) {
		colorNodeGroups();
	}
	
	private static void colorNodeGroups() {
		Graph graph = generateGraph();
		
		int level = 1;
		
		for(Node node : graph.getNodes()) {
			if(NodeState.UNVISITED == node.getState()) {
				dfs(node, level);
				level++;
			}
		}
		
		System.out.println(graph);
	}

	private static void dfs(Node node, int level) {
		node.setState(NodeState.VISITING);
		
		node.setLevel(level);
		
		for(Node kid : node.getNeighbours()) {
			if(NodeState.UNVISITED == kid.getState()) {
				dfs(kid, level);
			}
		}
		
		node.setState(NodeState.VISITED);
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
		Node five = new Node(5);
		graph.addNode(five);
		Node six = new Node(6);
		graph.addNode(six);
		Node seven = new Node(7);
		graph.addNode(seven);
		Node eight = new Node(8);
		graph.addNode(eight);
		Node nine = new Node(9);
		graph.addNode(nine);
		Node ten = new Node(10);
		graph.addNode(ten);
		
		// One island
		one.addNeighbour(two);
		one.addNeighbour(three);
		two.addNeighbour(one);
		two.addNeighbour(four);
		four.addNeighbour(six);
		four.addNeighbour(two);
		four.addNeighbour(three);
		three.addNeighbour(one);
		three.addNeighbour(four);
		three.addNeighbour(five);
		five.addNeighbour(six);
		five.addNeighbour(three);
		six.addNeighbour(five);
		six.addNeighbour(four);
		
		// One island
		seven.addNeighbour(eight);
		eight.addNeighbour(seven);
		
		// One island
		nine.addNeighbour(ten);
		ten.addNeighbour(nine);
		
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
