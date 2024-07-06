// @author: seanpcox

package ch20_graphs2;

import java.util.LinkedList;
import java.util.List;

public class DetectCycle {

	// We use a modified DFS for this
	// If we encounter a node that is in VISITING state then we have found a cycle
	
	public static void main(String[] args) {
		Graph graph = generateGraph();
		System.out.println(isCycle(graph));
	}
	
	private static boolean isCycle(Graph graph) {
		for(Node node : graph.getNodes()) {
			if(dfsCycle(node)) {
				return true;
			}
		}
		
		return false;
	}
	
	private static boolean dfsCycle(Node node) {
		if(NodeState.UNVISITED == node.getState()) {
			node.setState(NodeState.VISITING);
			
			for(Node kid : node.getNeighbours()) {
				if(NodeState.VISITING == kid.getState()) {
					return true;
				}
				
				if(dfsCycle(kid)) {
					return true;
				}
			}
			
			node.setState(NodeState.VISITED);
		}
		
		return false;
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
		
		// One island
		one.addNeighbour(two);
		one.addNeighbour(three);
		two.addNeighbour(four);
		two.addNeighbour(one);
		four.addNeighbour(six);
		three.addNeighbour(four);
		three.addNeighbour(five);
		five.addNeighbour(six);
		
		// One island
		seven.addNeighbour(eight);
		
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
