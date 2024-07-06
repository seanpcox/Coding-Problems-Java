// @author: seanpcox

package ch15_graphs1;

import java.util.LinkedList;
import java.util.List;

public class AdjacenyMatrix {
	
	// n this implementation, you keep a 2D matrix. 
	// This matrix tells you which nodes have edges between them.
	
	/*
	 	The main benefit of this approach - you can quickly check if two nodes are neighbors. 
	 	You can do it inO(1) time.
	 	However, if you want to find neighbors of a node, you have to go through all nodes, 
	 	which takes O(N)time (where N is the number of nodes in the graph).
	 	Most algorithms we use (like Breadth First and Depth First Search) rely on quickly 
	 	finding the neighbors of a node, which is why adjacency list is more common.
	 	Another downside - adjacency matrix takes O(V​2​) space regardless of how many edges there are.
	 */
	
}

class AdjacenyMatrixGraph {
	private List<AdjacenyMatrixNode> nodes;
	private boolean[][] matrix;
	
	public AdjacenyMatrixGraph(int size) {
		matrix = new boolean[size][size];
	}
	
	public boolean addNode(AdjacenyMatrixNode node) {
		if(nodes == null) {
			nodes = new LinkedList<>();
		}
		
		return nodes.add(node);
	}
	
	public boolean removeNode(AdjacenyMatrixNode node) {
		if(nodes == null) {
			return false;
		}
		
		return nodes.remove(node);
	}
	
	public void addConnection() {
		// TODO
	}
	
	public void removeConnection() {
		// TODO
	}
	
	public List<AdjacenyMatrixNode> getNodes() {
		return nodes;
	}
	
	public void setNodes(List<AdjacenyMatrixNode> nodes) {
		this.nodes = nodes;
	}
	
	public boolean[][] getMatrix() {
		return matrix;
	}
	
	public void setMatrix(boolean[][] matrix) {
		this.matrix = matrix;
	}
	
}

class AdjacenyMatrixNode {
	private int data;

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
}