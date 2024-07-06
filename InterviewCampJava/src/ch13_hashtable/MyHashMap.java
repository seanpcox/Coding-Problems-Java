// @author: seanpcox

package ch13_hashtable;

import java.util.Iterator;
import java.util.LinkedList;

public class MyHashMap {
	
	public static void main(String[] args) {
		SimpleHashMap map = new SimpleHashMap(4);
		map.put("a", 1);
		map.put("b", 2);
		map.put("c", 3);
		map.put("d", 4);
		map.put("e", 5);
		map.put("ff", 6);
		map.put("ggg", 7);
		map.put("hhhh", 8);
		map.put("ahahah", 8);
		map.put("aaaaahh", 8);
		
		System.out.println(map.get("a"));
		System.out.println(map.get("b"));
		System.out.println(map.get("c"));
		System.out.println(map.get("d"));
		System.out.println(map.get("e"));
		System.out.println(map.get("ff"));
		System.out.println(map.get("ggg"));
		System.out.println(map.get("hhhh"));
	}
	
}

class SimpleHashMap {
	
	private final LinkedList<SimpleHashMapEntry>[] entries;
	
	@SuppressWarnings("unchecked")
	public SimpleHashMap(int capacity) {
		entries = (LinkedList<SimpleHashMapEntry>[]) new LinkedList<?>[capacity];
	}
	
	public void put(String key, Integer value) {
		SimpleHashMapEntry entry = new SimpleHashMapEntry(key, value);
		int hashKey = hash(key);
		LinkedList<SimpleHashMapEntry> list = entries[hashKey];
		
		if(list == null) {
			list = new LinkedList<SimpleHashMapEntry>();
			entries[hashKey] = list;
		}
		
		list.add(entry);
	}

	public Integer get(String key) {
		int hashKey = hash(key);
		LinkedList<SimpleHashMapEntry> list = entries[hashKey];
		
		if(list == null) {
			return null;
		}
		
		if(list.size() == 1) {
			return list.peek().getValue();
		}
		
		Iterator<SimpleHashMapEntry> listIterator = list.iterator();
		
		while(listIterator.hasNext()) {
			SimpleHashMapEntry entry = listIterator.next();
			if(entry.getKey().equals(key)) {
				return entry.getValue();
			}
		}
		
		return null;
	}
	
	public int hash(String str) {    
		int hash = 0, x = 31;    
		for (int i = 0; i < str.length(); i++) {        
			hash = hash * x + str.charAt(i);    
		}    
		return Math.abs(hash) % entries.length;
	}
	
}

class SimpleHashMapEntry {
	private String key;
	private Integer value;
	
	public SimpleHashMapEntry(String key, Integer value) {
		this.key = key;
		this.value = value;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	
	
	
}
