// @author: seanpcox

package ch15_graphs1;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CloneAGraph {

	// Clone a Graph: Given an directed graph, make a copy.
	
	// Can use either DFS or BFS
	
	public static void main(String[] args) {
		new CloneAGraph();
	}
	
	public CloneAGraph() {
		Node rootNode = generateGraphGetFirstNode();
		Node cloneNode = cloneGraph(rootNode);
		System.out.println(cloneNode.getData());
	}
	
	private Node cloneGraph(Node rootNode) {
		Map<Node,Node> map = new HashMap<>();
		Node cloneNode = new Node(rootNode.getData());
		map.put(rootNode, cloneNode);
		
		dfs(rootNode, map);
		
		return cloneNode;
	}

	private void dfs(Node node, Map<Node,Node> map) {
		if(NodeState.UNVISITED == node.getState()) {
			node.setState(NodeState.VISITING);
			
			processNode(node);
			
			for(Node neighbour : node.getNeighbours()) {
				
				if(!map.containsKey(neighbour)) {
					map.put(neighbour, new Node(neighbour.getData()));
				}
				
				Node cloneParent = map.get(node);
				Node cloneNode = map.get(neighbour);
				cloneParent.addNeighbour(cloneNode);
				
				dfs(neighbour, map);
			}
			
			node.setState(NodeState.VISITED);
		}
	}

	private void processNode(Node node) {
		System.out.println(node.getData());
	}

	private Node generateGraphGetFirstNode() {
		Graph graph = new Graph();
		Node one = new Node(1);
		graph.addNode(one);
		Node two = new Node(2);
		graph.addNode(two);
		Node three = new Node(3);
		graph.addNode(three);
		
		// One island
		one.addNeighbour(two);
		two.addNeighbour(three);
		three.addNeighbour(one);
		
		return one;
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
