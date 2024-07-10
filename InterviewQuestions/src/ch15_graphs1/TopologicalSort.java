// @author: seanpcox

package ch15_graphs1;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TopologicalSort {

	// Sort a graph topologically
	public static void main(String[] args) {
		TopologicalSort ts = new TopologicalSort();
		Node root = ts.generateRootNode();
		Stack<Node> tg = new Stack<>();
		ts.dfsVisit(root, tg);
		System.out.println(tg);
		System.out.println(ts.getNumberOfSemesters(tg));
		
		Graph graph = ts.generateGraph();
		Stack<Node> gg = new Stack<>();
		ts.dfsVisit(graph, gg);
		System.out.println(gg);
		System.out.println(ts.getNumberOfSemesters(gg));
	}

	private int getNumberOfSemesters(Stack<Node> stack) {
		int maxSemester = 0;
		
		while(!stack.isEmpty()) {
			Node node = stack.pop();
			
			if(node.getSemester() == 0) {
				node.setSemester(1);
			}
			
			int currentSemester = node.getSemester();
			
			for(Node neighbour : node.getNeighbours()) {
				int neighbourSemester = Math.max(neighbour.getSemester(), currentSemester + 1);
				neighbour.setSemester(neighbourSemester);
			}
			
			if(currentSemester > maxSemester) {
				maxSemester = currentSemester;
			}
		}
		
		return maxSemester;
	}

	public void dfsVisit(Graph graph, Stack<Node> stack) {
		for(Node node : graph.getNodes()) {
			if(NodeState.UNVISITED == node.getState()) {
				dfsVisit(node, stack);
			}
		}
	}
	
	public void dfsVisit(Node node, Stack<Node> stack) {    
		node.setState(NodeState.VISITING);    
		
		for (Node neighbor: node.getNeighbours()) {        
			if (NodeState.UNVISITED == neighbor.getState())  {          
				dfsVisit(neighbor, stack);  
			}
		}    
		
		node.setState(NodeState.VISITED);    
		
		stack.push(node);
	}
	
	private Node generateRootNode() {
		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		Node five = new Node(5);
		
		one.addNeighbour(two);
		one.addNeighbour(four);
		two.addNeighbour(four);
		two.addNeighbour(three);
		two.addNeighbour(five);
		three.addNeighbour(five);
		
		return one;
	}
	
	private Graph generateGraph() {
		Graph graph = new Graph();
		
		Node one = new Node(104);
		graph.addNode(one);
		Node two = new Node(107);
		graph.addNode(two);
		Node three = new Node(202);
		graph.addNode(three);
		Node four = new Node(210);
		graph.addNode(four);
		Node five = new Node(300);
		graph.addNode(five);
		
		one.addNeighbour(three);
		
		two.addNeighbour(three);
		two.addNeighbour(four);
		
		three.addNeighbour(five);
		
		four.addNeighbour(five);
		
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

		public int getSemester() {
			return level;
		}

		public void setSemester(int level) {
			this.level = level;
		}
		
		public String toString() {
			return String.valueOf(data);
		}
		
	}
	
	enum NodeState {
		UNVISITED,
		VISITING,
		VISITED
	}
	
}
