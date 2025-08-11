package graph;

import java.util.HashSet;
import java.util.Set;

public class ConnectionChecker<V> {
	private GraphInterface<V> g;

	public ConnectionChecker(GraphInterface<V> g) {
		this.g = g;
	}

	public boolean check(V v1, V v2) {
		// The method calls dfs() to check if there is a path between v1 and v2 in the graph
		return dfs(v1, v2, new HashSet<>());
	}

	private boolean dfs(V v1, V v2, Set<V> visited) {
		// This recursive method implements dfs scan, it returns true if there is a path
		// between v1 to v2, the set of visited holds the vertexes of the graph that were
		// visited in the recursion
		if (v1.equals(v2)) // If the start(v1) and the target(v2) are equal then there is a path, it returns true
			return true;
		visited.add(v1); // Adds the start vertex to the visited list
		for (V neighbor : g.neighbours(v1)) { // It will run the dfs on the neighbors of v1 recursively
			if (!visited.contains(neighbor) && dfs(neighbor, v2, visited))
				return true; // If the dfs got true then there is a path
		}
		return false;
	}
}
