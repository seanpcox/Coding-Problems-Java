// @author: seanpcox

package ch06_recursion;

public class FindMazeExit {

	public static void main(String[] args) {
		int[][] maze = 
			{
			  {0, 0, 0, 1, 1}, 
			  {0, 1, 0, 0, 0},
			  {0, 0, 1, 1, 0},
			  {0, 0, 0, 1, 0}
			};
		
		System.out.println(isExit(maze));
	}

	public static boolean isExit(int[][] maze) {
		if(maze == null || maze.length == 0) {
			return false;
		}
		
		State[][] memo = new State[maze.length][maze[0].length];
		
		for(int i = 0; i < memo.length; i++) {
			for(int j = 0; j < memo[1].length; j++) {
				memo[i][j] = State.UNVISITED;
			}
		}
		
		return isExitHelper(maze, 0, 0, memo);
	}
	
	private static boolean isExitHelper(int[][] maze, int i, int j, State[][] memo) {
		if(oob(maze, i, j)) {
			return false;
		}
		if(end(maze, i, j)) {
			return true;
		}
		if(wall(maze, i, j)) {
			return false;
		}
		if(visited(memo, i, j)) {
			return false;
		}
		
		memo[i][j] = State.VISITING;
		
		int[][] points = {{i+1, j}, {i-1, j}, {i, j+1}, {i, j-1}};
		
		for(int[] point : points) {
			if(isExitHelper(maze, point[0], point[1], memo)) {
				return true;
			}
		}
		
		memo[i][j] = State.BLOCKED;
		
		return false;
	}

	private static boolean wall(int[][] maze, int i, int j) {
		if(maze[i][j] == 1) {
			return true;
		}
		
		return false;
	}

	private static boolean end(int[][] maze, int i, int j) {
		if(i == maze.length - 1 && j == maze[0].length - 1) {
			return true;
		}
		
		return false;
	}
	
	private static boolean oob(int[][] maze, int i, int j) {
		if(i < 0 || i >= maze.length) {
			return true;
		}
		if(j < 0 || j >= maze[0].length) {
			return true;
		}
		
		return false;
	}
	
	private static boolean visited(State[][] memo, int i, int j) {
		if(memo[i][j] == State.VISITING || memo[i][j] == State.BLOCKED) {
			return true;
		}
		
		return false;
	}

	enum State {
		UNVISITED,
		VISITING,
		BLOCKED;
	}
	
}
