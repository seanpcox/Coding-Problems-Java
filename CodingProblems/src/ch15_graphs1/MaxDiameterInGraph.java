// @author: seanpcox

package ch15_graphs1;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class MaxDiameterInGraph {

	int lc1 = 0;
	int lc2 = 0;
	
	public static void main(String[] args) {
		new MaxDiameterInGraph();
	}
	
	public MaxDiameterInGraph() {
		// Less Optimistic Way
		Graph graph = generateGraph();
		System.out.println(getMaxDiameterMine(graph));
		System.out.println(lc1);
		
		// Better Way
		graph = generateGraph();
		Stack<Node> stack = new Stack<>();
		getTopologicalStack(graph, stack);
		System.out.println(getMaxDiameter(stack));
		System.out.println(lc2);
	}
	
	private int getMaxDiameter(Stack<Node> stack) {
		int max = 1;
		
		while(!stack.isEmpty()) {
			Node node = stack.pop();
			
			max = Math.max(max, node.getLongestPath());
			
			for(Node neighbour : node.getNeighbours()) {
				lc2++;
				int neighbourPath = Math.max(neighbour.getLongestPath(), node.getLongestPath() + 1);
				neighbour.setLongestPath(neighbourPath);
			}
		}
		
		return max;
	}

	private void getTopologicalStack(Graph graph, Stack<Node> stack) {
		for(Node node : graph.getNodes()) {
			if(NodeState.UNVISITED == node.getState()) {
				dfs(node, stack);
			}
		}
	}
	
	private void dfs(Node node, Stack<Node> stack) {
		node.setState(NodeState.VISITING);
		
		for(Node neighbour : node.getNeighbours()) {
			lc2++;
			if(NodeState.UNVISITED == neighbour.getState()) {
				dfs(neighbour, stack);
			}
		}
		
		node.setState(NodeState.VISITED);
		
		stack.push(node);
	}
	
	private int getMaxDiameterMine(Graph graph) {
		int result = 0;
		
		for(Node node : graph.getNodes()) {
			result = Math.max(dfs(node, 1, 1), result);
		}
		
		return result;
	}

	private int dfs(Node node, int count, int max) {
		if(node.getNeighbours().isEmpty()) {
			return count;
		}
		
		for(Node neighbours : node.getNeighbours()) {
			lc1++;
			max = Math.max(max, dfs(neighbours, count + 1, max));
		}
		
		return max;
	}

	private Graph generateGraph() {
		Graph graph = new Graph();
		
		Node a = new Node('a');
		graph.addNode(a);
		Node b = new Node('b');
		graph.addNode(b);
		Node c = new Node('c');
		graph.addNode(c);
		Node d = new Node('d');
		graph.addNode(d);
		Node e = new Node('e');
		graph.addNode(e);
		Node f = new Node('f');
		graph.addNode(f);
		Node g = new Node('g');
		graph.addNode(g);
		Node h = new Node('h');
		graph.addNode(h);
		Node i = new Node('i');
		graph.addNode(i);
		
		a.addNeighbour(e);
		b.addNeighbour(c);
		b.addNeighbour(f);
		d.addNeighbour(a);
		d.addNeighbour(b);
		e.addNeighbour(i);
		f.addNeighbour(g);
		f.addNeighbour(h);
		h.addNeighbour(i);
		
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
		private char data;
		private List<Node> neighbours = new LinkedList<>();
		private NodeState state = NodeState.UNVISITED;
		private int longestPath = 1;
		
		public Node(char data) {
			this.data = data;
		}
		
		public char getData() {
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
		
		public String toString() {
			return String.valueOf(data);
		}

		public int getLongestPath() {
			return longestPath;
		}

		public void setLongestPath(int longestPath) {
			this.longestPath = longestPath;
		}
		
	}
	
	enum NodeState {
		UNVISITED,
		VISITING,
		VISITED
	}
	
}
