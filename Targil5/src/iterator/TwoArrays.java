package iterator;

import java.util.Iterator;

public class TwoArrays implements Iterable<Integer> {
	// The class implements iterator() for Integer 2 iterables
	// in the following order:
	// first,second,first,second
	private int[] a1;
	private int[] a2;

	public TwoArrays(int[] a1, int[] a2) {
		this.a1 = a1;
		this.a2 = a2;
	}

	@Override
	public Iterator<Integer> iterator() {
		return new ArrayIterator();
	}

	private class ArrayIterator implements Iterator<Integer> {
		// Private class, implements iterator() on Integer
		private int j = 0;
		private int i = 0;
		private int k = 0;

		@Override
		public boolean hasNext() {
			return i < a1.length || j < a2.length;
		}

		public boolean hasNext1() { // Helper method hasNext of a1
			return i < a1.length;
		}

		public boolean hasNext2() { // Helper method hasNext of a2
			return j < a2.length;
		}

		@Override
		public Integer next() {
			if (k % 2 == 0) {
				k++;
				if (hasNext1()) {
					return a1[i++];
				}
				return next();
			} else {
				k++;
				if (hasNext2()) {
					return a2[j++];
				}
				return next();
			}
		}

	}
}
