// @author: seanpcox

package ch25_majoritySearch;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MajorityKSearch {

	// A generalization of Majority Search, here we want to find if a number occurs more than 1 / K times
	// Ex 1/3, 1/6
	
	// To do this we will need a HashMap of size K (not N)
	
	// If we encounter a new candidate we add it to the hashmap with count of 1
	// If existing candidate we update it's count
	// If map size reaches k then we delete all counts by 1
	// We remove any items whose counts get to zer0
	// At the end items left in our HashMap will be the candidates
	// We will need to loop through array again and do a count for those
	// If one is > 1/k then that is our candidate
	
	// [1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4]
	
	public static void main(String[] args) {
		int[] a = {1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 4};
		double k = 3; // Needs to be double else end up with 1/k being zero for int!!!
		System.out.println(majorityKSearch(a, k));
	}

	private static Integer majorityKSearch(int[] a, double k) {
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int v : a) {
			System.out.println(map);
			if(map.containsKey(v)) {
				int count = map.get(v) + 1;
				map.put(v, count);
			} else {
				map.put(v, 1);
			}
			
			if(map.size() >= k) {
				Iterator<Integer> keys = map.keySet().iterator();
				while(keys.hasNext()) {
					int key = keys.next();
					
					int count = map.get(key) - 1;
					
					if(count > 0) {
						map.put(key, count);
					} else {
						// NOTE: We need to remove key using this else we get ConcurrentModificationException!!!
						keys.remove();
					}
				}
			}
		}
		
		// Now our candidates are left in the map, lets set counts to zero
		for(int key : map.keySet()) {
			map.put(key, 0);
		}
		
		// Lets loop through and do a proper count now
		for(int v : a) {
			if(map.containsKey(v)) {
				map.put(v, map.get(v) + 1);
			}
		}
		
		System.out.println(map);
		
		// Now see if any are > 1/k, if more than one can return both
		for(int key : map.keySet()) {
			System.out.println(1/k * a.length);
			if(map.get(key) > (1/k * a.length)) {
				return key;
			}
		}
		
		return null;
	}
}
