package graph;

import java.util.ArrayList;
import java.util.Collection;

public class Maze implements GraphInterface<Place> {
	// The class holds a maze, it has a matrix of Place and has start and end
	// fields. The maze also has walls so there is a method addWall, to check if the
	// method is solvable there is a method called isSolvable. The class implements
	// GraphInterface so it implements also neighbours()
	private Place[][] maze;
	private Place start;
	private Place end;

	public Maze(int size, int startx, int starty, int endx, int endy) {
		// Constructor of the class
		maze = new Place[size][size];
		try {
			// Throws an IllegalArgumentException if adding start to the maze failed
			this.start = new Place(startx, starty, size);
			maze[startx][starty] = start;
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException();
		}
		try {
			// Throws an IllegalArgumentException if adding end to the maze failed
			this.end = new Place(endx, endy, size);
			maze[endx][endy] = end;
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException();
		}
		// For the other places in the maze it fills them with a place according to
		// their transposed placement in the maze
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze.length; j++) {
				if (maze[i][j] == null)
					maze[i][j] = new Place(i, j, size);
			}
		}

	}

	public boolean addWall(int x, int y) {
		// The method makes a wall in coordinates (x,y) in the maze (by making it null),
		// it throws an IllegalArgumentException if the x,y that were given surpass the
		// bounds
		try {
			if ((y == start.getX() && x == start.getY()) || (y == end.getX() && x == end.getY())) {
				return false; // Can't add a wall at the start or end
			}else if (x < 0 || x >= maze.length || y < 0 || y >= maze.length) {
	            return false; // Out of bounds check
	        }
			else if (maze[y][x] == null) {
				return false; // Already a wall
			}else {
				maze[y][x] = null;
				return true;
			}
		} catch (IllegalArgumentException e) {
			return false;
		}

	}

	@Override
	public String toString() {
		// This returns the maze as a string:
		// @ indicates a wall in the maze
		// S indicates the start in the maze
		// E indicates the end in the maze
		// . indicates a free space in the maze
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze.length; j++) {
				if (maze[i][j] == null) {// Its a Wall
					sb.append("@");
				} else if (maze[i][j].equals(start)) {
					sb.append("S");
				} else if (maze[i][j].equals(end)) {
					sb.append("E");
				} else {
					sb.append(".");
				}

			}
			sb.append("\n");
		}
		return sb.toString();
	}
	
	public boolean isSolvable() {
		// The method puts the all the non-walls elements in a Graph and if there isn't
		// a wall between the neighbor elements it adds an edge. After it did that it
		// uses the method from Graph, connected(v1,v2) which checks if there is a path
		// between v1 and v2, in this case we will use it to determine if there is a
		// path between start to end
		Graph<Place> g = new Graph<>(); // Creates a graph
		try {
			// Adds all the non-Walls to the graph as vertices
			for (int i = 0; i < maze.length; i++) {
				for (int j = 0; j < maze.length; j++) {
					if (maze[i][j] != null) // Checks that it's not a wall
						g.addVertex(maze[i][j]);

				}
			}
		} catch (GraphException e) {
			e.printStackTrace();
			return false;
		}
		try {
			for (int i = 0; i < maze.length; i++) {
				for (int j = 0; j < maze.length; j++) {
					if (maze[i][j] != null) {
						// Check and add edges in all four directions: down, up, right, left
	                    if (i + 1 < maze.length && maze[i + 1][j] != null) {
	                        // Check if edge already exists to avoid duplication
	                        if (!g.hasEdge(maze[i][j], maze[i + 1][j])) {
	                            g.addEdge(maze[i][j], maze[i + 1][j]);
	                        }
	                    }
	                    if (i > 0 && maze[i - 1][j] != null) {
	                        // Check if edge already exists to avoid duplication
	                        if (!g.hasEdge(maze[i][j], maze[i - 1][j])) {
	                            g.addEdge(maze[i][j], maze[i - 1][j]);
	                        }
	                    }
	                    if (j + 1 < maze.length && maze[i][j + 1] != null) {
	                        // Check if edge already exists to avoid duplication
	                        if (!g.hasEdge(maze[i][j], maze[i][j + 1])) {
	                            g.addEdge(maze[i][j], maze[i][j + 1]);
	                        }
	                    }
	                    if (j > 0 && maze[i][j - 1] != null) {
	                        // Check if edge already exists to avoid duplication
	                        if (!g.hasEdge(maze[i][j], maze[i][j - 1])) {
	                            g.addEdge(maze[i][j], maze[i][j - 1]);
	                        }
	                    }
					}
				}
			}
		} catch (GraphException e) {
			e.printStackTrace();
			return false;
		}
		try {
			// Returns if there is a path between start and end
			return g.connected(start, end);
		} catch (GraphException e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public Collection<Place> neighbours(Place v) {
		// The method implements neighbours from GraphInterface, it creates a list of neighbours of v
		Collection<Place> neighbours = new ArrayList<>();
		int x = v.getX();
		int y = v.getY();
		if (y < maze.length - 1 && maze[x][y+1] != null) { // Checks down from v
			neighbours.add(new Place(x, y+1, maze.length));
		}
		if (y > 0 && maze[x][y-1] != null) { // Checks up from v
			neighbours.add(new Place(x, y-1, maze.length));
		}
		if (x > 0 && maze[x-1][y] != null) { // Checks left from v
			neighbours.add(new Place(x-1, y, maze.length));
		}
		if (x < maze.length - 1 && maze[x+1][y] != null) { // Checks right from v
			neighbours.add(new Place(x+1, y, maze.length));
		}
		return neighbours;
	}
}
