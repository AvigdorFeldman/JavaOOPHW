package iterator;

import java.util.Iterator;

public class Combined<E> implements Iterable<E> {
	// The class implements iterator() of 2 iterables in the following order:
	// first,second,first,second
	private Iterable<E> first;
	private Iterable<E> second;

	public Combined(Iterable<E> first, Iterable<E> second) {
		this.first = first;
		this.second = second;
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<>() {
			/* Anonymic class Iterator, implements hasnext() and next() */
			private Iterator<E> firstIt = first.iterator();
			private Iterator<E> secondIt = second.iterator();
			private int k = 0;

			@Override
			public boolean hasNext() {
				return firstIt.hasNext() || secondIt.hasNext();
			}

			@Override
			public E next() {
				if (k % 2 == 0) {
					k++;
					if (firstIt.hasNext()) {
						return firstIt.next();
					}
					return next();
				} else {
					k++;
					if (secondIt.hasNext()) {

						return secondIt.next();
					}
					return next();

				}
			}
		};
	}
}
