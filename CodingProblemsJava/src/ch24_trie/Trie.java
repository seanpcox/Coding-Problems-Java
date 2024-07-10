// @author: seanpcox

package ch24_trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trie {

	Map<Character, Node> rootNodes = new HashMap<>();
	
	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("e");
		trie.insert("dog");
		trie.insert("dot");
		trie.insert("do");
		trie.insert("cat");
		trie.insert("cage");
		trie.insert("caged");
		
		System.out.println(trie.get("caged"));
		
		trie.delete("e");
		trie.delete("dot");
		
		System.out.println(trie.get("do"));
	}
	
	public void insert(String word) {
		if(word == null || word.length() == 0) {
			return;
		}
		
		char c = word.charAt(0);
		
		Node rootNode = rootNodes.get(c);
				
		if(rootNode == null) {
			rootNode = new Node(c, word.length() == 1);
			rootNodes.put(c, rootNode);
		}
		
		for(int i = 1; i < word.length(); i++) {
			c = word.charAt(i);
			Node node = rootNode.getNextNodes().get(c);
			
			if(node == null) {
				node = new Node(c, word.length() == i + 1);
				rootNode.addNode(c, node);
			} else if(word.length() == i + 1) {
				node.setWord(true);
			}
			
			rootNode = node;
		}
	}
	
	public List<String> get(String path) {
		List<String> words = new ArrayList<>();
		
		if(path == null || path.length() == 0) {
			return words;
		}
		
		char c = path.charAt(0);
		
		Node rootNode = rootNodes.get(c);
		
		for(int i = 1; i < path.length(); i++) {
			if(rootNode == null) {
				return words;
			}
			
			rootNode = rootNode.getNextNodes().get(path.charAt(i));
		}
		
		if(rootNode == null) {
			return words;
		}
		
		populateWords(rootNode, path, words);
		
		return words;
	}
	
	private void populateWords(Node node, String path, List<String> words) {
		if(node == null) {
			return;
		}
		
		if(node.isWord()) {
			words.add(path);
		}
		
		Map<Character, Node> children = node.getNextNodes();
		
		for(char c : children.keySet()) {
			Node child = children.get(c);
			populateWords(child, path + child.getC(), words);
		}
	}
	
	public void delete(final String word) {
		if(word == null || word.length() == 0) {
			return;
		}
		
		char c = word.charAt(0);
		
		Node rootNode = rootNodes.get(c);
		
		// Special case where we delete the root node from map
		if(delete(word, "" + c, 1, rootNode)) {
			rootNodes.remove(c);
		}
	}
	
	public boolean delete(final String oPath, String tPath, int i, Node node) {
		// If node has children we can't delete just mark it as not as word
		// If node does not have children we can delete up to the next word or until we encounter a node with more than one child
		
		if(node == null) {
			return false;
		}
		
		if(oPath.equals(tPath)) {
			node.setWord(false);
			
			if(node.getNextNodes().isEmpty()) {
				return true;
			} else {
				return false;
			}
		}
		
		Node child = node.getNextNodes().get(oPath.charAt(i));
		
		if(child == null) {
			return false;
		}
		
		if(delete(oPath, tPath + child.getC(), i + 1, child)) {
			if(node.isWord() || node.getNextNodes().size() > 1) {
				return false;
			} else {
				node.getNextNodes().remove(child.getC());
				return true;
			}
		}
		
		return false;
	}
	
	class Node {
		private final char c;
		
		private boolean isWord;
		private Map<Character, Node> nextNodes = new HashMap<>();
		
		public Node(char c, boolean isWord) {
			this.c = c;
			this.isWord = isWord;
		}

		public boolean isWord() {
			return isWord;
		}

		public void setWord(boolean isWord) {
			this.isWord = isWord;
		}

		public void addNode(char c, Node node) {
			nextNodes.put(c, node);
		}
		
		public Map<Character, Node> getNextNodes() {
			return nextNodes;
		}

		public char getC() {
			return c;
		}
		
	}
}
