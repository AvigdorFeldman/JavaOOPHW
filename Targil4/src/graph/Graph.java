package graph;

import java.util.*;

public class Graph<V> {
	// The class represents a graph and has methods that manage it, it has a set of
	// vertices and a map of edges. It has methods that addVertex, addEdge, hasEdge,
	// connected, and a private method dfs
	private Set<V> vertices = new HashSet<>();
	private Map<V, Set<V>> edges = new HashMap<>();

	public void addVertex(V v) throws GraphException {
		// The method adds a vertex to the graph, if the vertex is already in the graph
		// it throws a GraphException
		if (vertices.contains(v))
			throw new GraphException("vertix is already in the graph");
		else {
			vertices.add(v);
			// It also creates a new entry in the edge map
			edges.put(v, new HashSet<>());
		}
	}

	public boolean hasEdge(V v1, V v2) {
		// The method checks if v1 and v2 have an edge between them
		return edges.get(v1).contains(v2) && edges.get(v2).contains(v1);
	}

	public void addEdge(V v1, V v2) throws GraphException {
		// The method adds Edge between v1 and v2 only if v1 and v2 are in the graph and
		// there is no edge between them, otherwise it will throw GraphException
		if (!vertices.contains(v1) || !vertices.contains(v2))
			throw new GraphException("at least one of the vertices is not in the graph");
		else if (hasEdge(v1, v2))
			throw new GraphException("edge is already in the graph");
		else {
			// Since the graph is an undirected graph we add edges to both v1 and v2
			edges.get(v1).add(v2);
			edges.get(v2).add(v1);
		}

	}

	public boolean connected(V v1, V v2) throws GraphException {
		// The method checks if v1 and v2 are connected, in other words: there is a path
		// between v1 to v2, if the vertices aren't in the graph it will throw
		// GraphException. It checks if there is a path using dfs()
		if (!vertices.contains(v1) || !vertices.contains(v2))
			throw new GraphException("at least one of the vertices is not in the graph");
		return dfs(v1, v2, new HashSet<>());
	}

	private boolean dfs(V v1, V v2, Set<V> visited) {
		// This recursive method implements dfs scan, it returns true if there is a path
		// between v1 to v2, the set of visited holds the vertexes of the graph that
		// were
		// visited in the recursion
		if (v1.equals(v2) || edges.get(v1).contains(v2)) // If the start(v1) and the target(v2) are equal then there is
															// a path or v2 is in its edges set, it returns true
			return true;
		visited.add(v1); // Adds the start vertex to the visited list
		for (V neighbor : edges.get(v1)) { // It will run the dfs on the neighbors of v1 recursively
			if (!visited.contains(neighbor) && dfs(neighbor, v2, visited))
				return true; // If the dfs got true then there is a path
		}
		return false;

	}
}
