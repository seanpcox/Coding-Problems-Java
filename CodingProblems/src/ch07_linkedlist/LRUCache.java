// @author: seanpcox

package ch07_linkedlist;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K,V> {

	// Need to implement a linked hash map
	// Implement read and write methods
	// Need a doubly linked list for this
	
	private final Map<K, DNode<K,V>> map;
	
	private final int capacity;
	
	private DNode<K,V> head;
	
	private DNode<K,V> tail;
	
	public LRUCache(int capacity) {
		this.map = new HashMap<K, DNode<K,V>>();
		this.capacity = capacity;
	}
	
	public void write(K key, V value) {
		if(map.size() == capacity) {
			remove(head.getKey());
		}
		
		add(key, value);
	}

	public V read(K key) {
		DNode<K,V> node = map.get(key);
		
		if(node == null) {
			return null;
		}
		
		remove(key);
		
		add(key, node.getValue());
		
		return node.getValue();
	}
	
	private void add(K key, V value) {
		DNode<K,V> node = new DNode<>(key, value);
		
		addToList(node);
		
		map.put(key, node);
	}

	private void remove(K key) {
		if(!map.containsKey(key)) {
			return;
		}
		
		DNode<K,V> node = map.get(key);
		
		removeFromList(node);
		
		map.remove(key);
	}

	private void addToList(DNode<K,V> node) {
		if(head == null) {
			head = node;
		} else {
			tail.setNext(node);
			node.setPrev(tail);
		}
		
		tail = node;
	}
	
	private void removeFromList(DNode<K, V> node) {
		if(node.getPrev() != null) {
			node.getPrev().setNext(node.getNext());
		}
		
		if(node.getNext() != null) {
			node.getNext().setPrev(node.getPrev());
		}
		
		if(node == head) {
			head = node.getNext();
		}
		
		if(node == tail) {
			tail = node.getPrev();
		}
	}

	public int size() {
		return map.size();
	}
	
	public DNode<K,V> getHead() {
		return head;
	}
	
	public DNode<K,V> getTail() {
		return tail;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		DNode<K,V> node = head;
		
		while(node != null) {
			builder.append(node.getKey() + "=" + node.getValue() + ", ");
			node = node.getNext();
		}
		
		return builder.toString();
	}
	
	public static void main(String[] args) {
		LRUCache<String, Integer> cache = new LRUCache<>(3);
		cache.write("a", 1);
		cache.write("b", 2);
		cache.write("c", 3);
		System.out.println(cache);
		cache.write("d", 4);
		System.out.println(cache);
		System.out.println(cache.read("c"));
		System.out.println(cache);
	}
	
}


class DNode<K,V> {
	private K key;
	private V value;
	private DNode<K,V> prev;
	private DNode<K,V> next;
	
	public DNode(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}
	
	public V getValue() {
		return value;
	}

	public DNode<K,V> getPrev() {
		return prev;
	}

	public void setPrev(DNode<K,V> prev) {
		this.prev = prev;
	}

	public DNode<K,V> getNext() {
		return next;
	}

	public void setNext(DNode<K,V> next) {
		this.next = next;
	}
	
}
