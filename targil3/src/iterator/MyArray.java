package iterator;

import java.util.NoSuchElementException;

public class MyArray implements MyIterator {
	// The class implements MyIterator, it implements the methods from MyIterator on
	// an integer array
	private int[] array;
	private int i; // indicates the last index of the array that has a value

	public MyArray(int[] array) {
		// Constructor of the class
		this.array = array;
		this.i = 0;
	}

	@Override
	public boolean hasNext() {
		// Implemented method from MyIterator. returns if the last index is legal
		// (smaller then the size of the array)
		return i < array.length;
	}

	@Override
	public int next() throws NoSuchElementException {
		// Implemented method from MyIterator. returns the value of array in index i and
		// Increments i, it uses hasNext to check if i is a valid index, if not it
		// throws an NoSuchElementException exception
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		return array[i++];

	}
}
