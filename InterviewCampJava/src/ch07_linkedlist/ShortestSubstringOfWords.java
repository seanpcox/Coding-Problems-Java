// @author: seanpcox

package ch07_linkedlist;

import java.util.HashSet;
import java.util.Set;

public class ShortestSubstringOfWords {

	public static void main(String[] args) {
		String doc = "a set of words that is complete in itself, typically containing a subject and predicate, conveying a statement, question, exclamation, or command, and consisting of a main clause and sometimes one or more subordinate clauses";
		Set<String> targets = new HashSet<String>();
		targets.add("and");
		targets.add("of");
		targets.add("one");
		System.out.println(shortestSubstringOfWords(doc, targets));
	}

	private static int shortestSubstringOfWords(String doc, Set<String> targets) {
		LRUCache<String, Integer> cache = new LRUCache<>(3);
		
		String[] words = doc.split(" ");
		
		int position = 0;
		int shortest = Integer.MAX_VALUE;
		
		for(String word : words) {
			if(targets.contains(word)) {
				cache.write(word, position);
				
				if(cache.size() == 3) {
					int size = (cache.getTail().getValue() + cache.getTail().getKey().length()) - cache.getHead().getValue();
					if(size < shortest) {
						shortest = size;
					}
				}
			}
			position += word.length() + 1;
		}
		
		return shortest;
	}
	
}
