package graph;

import java.util.Collection;

public interface GraphInterface<V> {
	// Interface that has neighbors method, will be implemented by the classes that
	// implement this interface
	public Collection<V> neighbours(V v);
}
