// @author: seanpcox

package ch15_graphs1;

import java.util.*;

public class WordLadder {

	private DictionaryThreeLetters dict;
	
	private int lc = 0;
	
	public static void main(String[] args) {
		WordLadder ladder = new WordLadder();
		Node node = ladder.generateGraph("cab", "let");
		
		while(node != null) {
			System.out.println(node.getData());
			node = node.getParent();
		}
	}
	
	public WordLadder() {
		dict = new DictionaryThreeLetters();
	}
	
	public Node generateGraphMine(String root, String target) {
		Set<String> checkedWords = new HashSet<String>();
		
		Queue<Node> q = new LinkedList<>();
		Node node = new Node(root);
		q.add(node);
		char a = 'a';
		int wc = 1;
		checkedWords.add(root);
		
		while(!q.isEmpty()) {
			Node current = q.poll();
			
			if(target.equals(current.getData())) {
				System.out.println(wc);
				return current;
			}
			
			char[] chars = current.getData().toCharArray();
			for(int j = 0; j < 3; j++ ) {
				for(int i = 0; i < 26; i++) {
					wc++;
					char[] newChars = {chars[0], chars[1], chars[2]};
					if(chars[j] != a + i) {
						newChars[j] = (char) (a + i);
						String newString = new String(newChars);
						
						if(checkedWords.contains(newString)) {
							continue;
						}
						
						if(dict.contains(newString)) {
							Node newNode = new Node(newString);
							newNode.setParent(current);
							current.addNeighbour(newNode);
							q.add(newNode);
							checkedWords.add(newString);
						}
					}
				}
			}
		}
		
		return null;
	}
	
	public Node generateGraph(String root, String target) {
		processDictionary();
		
		Set<String> checkedWords = new HashSet<String>();
		
		Queue<Node> q = new LinkedList<>();
		Node node = new Node(root);
		q.add(node);
		checkedWords.add(root);
		
		while(!q.isEmpty()) {
			Node current = q.poll();
			
			if(target.equals(current.getData())) {
				System.out.println(lc);
				return current;
			}
			
			for(int i = 0; i < 3; i++) {
				String pattern = current.getData().substring(0, i) + "*" + current.getData().substring(i+1);
				
				List<String> neighbours = getNeighbours(pattern);
				
				if(neighbours == null) {
					continue;
				}
				
				for(String neighbour : neighbours) {
					lc++;
					if(checkedWords.contains(neighbour)) {
						continue;
					}
					
					Node newNode = new Node(neighbour);
					newNode.setParent(current);
					current.addNeighbour(newNode);
					q.add(newNode);
					checkedWords.add(neighbour);
				}
			}
		}
		
		return null;
	}
	
	private Map<String, ArrayList<String>> processedWords = new HashMap<>();
	
	public List<String> getNeighbours(String pattern) {
		return processedWords.get(pattern);
	}
	
	public void processDictionary() {
		for(String word : dict.getAllWords()) {
			for(int i = 0; i < 3; i++) {
				lc++;
				
				String pattern = word.substring(0, i) + "*" + word.substring(i+1);
				
				if(!processedWords.containsKey(pattern)) {
					processedWords.put(pattern, new ArrayList<String>());
				}
				
				processedWords.get(pattern).add(word);
			}
		}
	}
	
	public List<String> getNeighbours(String word, Set<String> checkedWords) {
		List<String> neighbours = new ArrayList<>();
		
		char[] chars = word.toCharArray();
		for(int j = 0; j < 3; j++ ) {
			for(int i = 0; i < 26; i++) {
				char[] newChars = {chars[0], chars[1], chars[2]};
				if(chars[j] != 'a' + i) {
					newChars[j] = (char) ('a' + i);
					String newString = new String(newChars);
					
					if(checkedWords.contains(newString)) {
						continue;
					}
					
					if(dict.contains(newString)) {
						checkedWords.add(newString);
						neighbours.add(newString);
					}
				}
			}
		}
		
		return neighbours;
	}
	
	class Node {
		private String data;
		private List<Node> neighbours = new LinkedList<>();
		private NodeState state = NodeState.UNVISITED;
		private Node parent;
		
		public Node getParent() {
			return parent;
		}

		public void setParent(Node parent) {
			this.parent = parent;
		}

		public Node(String data) {
			this.data = data;
		}
		
		public String getData() {
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
