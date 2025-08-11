package equiv;

import java.util.*;

public class Equiv<E> {
	// A list of sets, where each set represents an equivalence class. The class
	// manages the list in terms of add equivalence relation, and checking if two
	// elements are in the same equivalence class
	private List<Set<E>> equivalenceList = null;

	public void add(E e1, E e2) {
		// Adds a pair of elements (e1, e2) to the equivalence relation. If e1 and e2
		// are not already in any equivalence class, they are added to the same one. If
		// they are in different equivalence classes, their classes do union
		if (equivalenceList == null) { // Initializes the list if empty
			equivalenceList = new ArrayList<>();
		}
		Set<E> set1 = null; // equivalence class for e1
		Set<E> set2 = null; // equivalence class for e2
		for (Set<E> set : equivalenceList) { // Search for the equivalence classes containing e1 and e2.
			if (set.contains(e1))
				set1 = set;
			if (set.contains(e2))
				set2 = set;
		}
		if (set1 == null) { // If no equivalence class contains e1, create a new one
			set1 = new HashSet<>();
			set1.add(e1);
			equivalenceList.add(set1);
		}
		if (set2 == null) { // If no equivalence class contains e2, create a new one
			set2 = new HashSet<>();
			set2.add(e2);
			equivalenceList.add(set2);
		}
		if (!set1.equals(set2)) { // If e1 and e2 are in different equivalence classes, it does union
			if (set2 != null) {
				set1.addAll(set2);
				equivalenceList.remove(set2);
			}
		}
	}

	public boolean are(E e1, E e2) {
		// The method Checks if two elements are in the same equivalence class
		// If the elements are the same, they are equivalent.
		if(!equivalenceList.isEmpty()) {	
			if (e1.equals(e2))
				return true;
			for (Set<E> set : equivalenceList) { // Check if e1 and e2 belong to the same equivalence class.
				if (set.contains(e1) && set.contains(e2)) {
					return true;
				}
			}
		}
		return false;
	}
}
