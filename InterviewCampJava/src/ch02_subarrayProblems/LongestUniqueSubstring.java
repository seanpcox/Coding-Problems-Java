// @author: seanpcox

package ch02_subarrayProblems;

import java.util.HashMap;
import java.util.Map;

public class LongestUniqueSubstring {
	
	public static void main(String[] args) {
		String input = "HAAHG";
		int[] result = longestUniqueSubstring(input);
		System.out.println(result[0] + " " + result[1]);
	}
	
	public static int[] longestUniqueSubstring(String input) throws RuntimeException {
		if(input == null || input.length() <= 0) {
			throw new RuntimeException("Invalid Input");
		}
		
		int[] result = {0, 0};
		int sp = 0;
		int ep = 0;
		int max = 1;
		Map<Character, Integer> map = new HashMap<>();
		map.put(input.charAt(0), 0);
		
		while(ep < input.length() - 1) {
			ep++;
			
			char toAdd = input.charAt(ep);
			
			// >= needed to stop sp being set to an earlier value
			if(map.containsKey(toAdd) && map.get(toAdd) >= sp) {
				sp = map.get(toAdd) + 1;
			}
			
			map.put(toAdd, ep);
			
			if(ep - sp + 1 > max) {
				max = ep - sp + 1;
				result[0] = sp;
				result[1] = ep;
			}
		}
		
		return result;
	}

}
