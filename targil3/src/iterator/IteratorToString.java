package iterator;

public class IteratorToString {
	// The class has only one method, it's a static method which returns a string
	// that puts all the values of the iterator in []
	public static String toString(MyIterator it) {
		// The method returns a string that puts all the values of the iterator in []
		// using StringBuilder class
		boolean flag = true; // A boolean set to true if the current iterator is empty
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		while (it.hasNext()) {
			// Adds each of the values of the iterator until there are no more values and
			// space between each of the values
			flag = false; // Since there is a next value, then the iterator isn't null
			sb.append(it.next());
			sb.append(" ");
		}
		if (!flag)
			// Removes the last space (works only for non empty iterators)
			sb.delete(sb.length() - 1, sb.length());
		sb.append("]");
		return sb.toString();
	}
}
