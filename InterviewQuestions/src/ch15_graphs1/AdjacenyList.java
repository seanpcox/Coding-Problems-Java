// @author: seanpcox

package ch15_graphs1;

import java.util.LinkedList;
import java.util.List;

public class AdjacenyList {
	// Space Complexity​: O(V + E)
	// Here,​V​ is the number of vertices (nodes) and ​E​ is the number of edges in the graph. 
	// This is common notation.
	// The concept is simple: every Node stores a list of neighboring nodes.
	// Remember:A graph can have several components that are not connected to each other.
	// To access the entire graph, you either need a node in each connected component, 
	// or have a Graph class with a list of all the nodes.
}

class AdjacenyGraph {
	private List<AdjacenyNode> nodes;

	public boolean addNode(AdjacenyNode node) {
		if(nodes == null) {
			nodes = new LinkedList<>();
		}
		
		return nodes.add(node);
	}
	
	public boolean removeNode(AdjacenyNode node) {
		if(nodes == null) {
			return false;
		}
		
		return nodes.remove(node);
	}
	
	public List<AdjacenyNode> getNodes() {
		return nodes;
	}

	public void setNodes(List<AdjacenyNode> nodes) {
		this.nodes = nodes;
	}
	
	
}

class AdjacenyNode {
	private int data;
	private List<AdjacenyNode> neighbours;
	
	public int getData() {
		return data;
	}
	
	public void setData(int data) {
		this.data = data;
	}
	
	public List<AdjacenyNode> getNeighbours() {
		return neighbours;
	}
	
	public void setNeighbours(List<AdjacenyNode> neighbours) {
		this.neighbours = neighbours;
	}
	
	public boolean addNeighbour(AdjacenyNode neighbour) {
		if(neighbours == null) {
			neighbours = new LinkedList<>();
		}
		
		return neighbours.add(neighbour);
	}
	
	public boolean removeNeighbour(AdjacenyNode neighbour) {
		if(neighbours == null) {
			return false;
		}
		
		return neighbours.remove(neighbour);
	}
}