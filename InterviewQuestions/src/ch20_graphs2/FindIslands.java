// @author: seanpcox

package ch20_graphs2;

public class FindIslands {

	/*
	 * Find Islands: You are given a 2d array of 1s and 0s. 
	 * 1 denotes land and 0 denotes water. 
	 * Land can be connected diagonally or on either 4 ends. 
	 * You want to find the number of islands in the array. Here is an example:
	 */
	
	public static void main(String[] args) {
		System.out.println(findIslands(getMap()));
	}
	
	private static int findIslands(int[][] map) {
		int islands = 0;
		
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[0].length; j++) {
				if(map[i][j] == 1) {
					islands++;
					performSearch(map, i, j);
				}
			}
		}
		
		return islands;
	}

	private static void performSearch(int[][] map, int i, int j) {
		if(i < 0 || i >= map.length || j < 0 || j >= map[0].length || map[i][j] != 1) {
			return;
		}
		
		map[i][j] = -1;
		
		performSearch(map, i-1, j-1);
		performSearch(map, i-1, j);
		performSearch(map, i-1, j+1);
		performSearch(map, i, j+1);
		performSearch(map, i+1, j+1);
		performSearch(map, i+1, j);
		performSearch(map, i+1, j-1);
		performSearch(map, i, j-1);
	}

	private static int[][] getMap() {
		int[][] map = 
			{
				{1,0,1,0,1},
				{1,1,0,0,0},
				{0,1,0,1,1},
				{0,0,0,0,0},
				{1,0,1,1,1},
			};
		
		return map;
	}
	
}
