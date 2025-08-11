package iterator;

public class Fibonacci implements MyIterator {
	// The class implements MyIterator interface. The class handles Fibonacci
	// sequence up to a certain number
	private int upperBound; // The maximal value of the Fibonacci sequence
	private int a, b; // Two adjacent numbers of the Fibonacci sequence

	public Fibonacci(int upperBound) {
		// The constructor for Fibonacci class, gets the maximal value of the sequence
		// and resets a to 0 and b to 1
		this.upperBound = upperBound;
		a = 0;
		b = 1;
	}

	@Override
	public boolean hasNext() {
		// Implemented method from MyIterator. returns if a value of the last element in
		// the sequence is valid (isn't bigger then the maximal value of the sequence)
		// We assume upperBound is bigger then 2
		return b < upperBound;
	}

	@Override
	public int next() {
		// Implemented method from MyIterator. returns the last valid value of the
		// sequence, it also increases a and b so they will have their next values in the
		// sequence
		if (!hasNext()) {
			// If we reached the bounds of upperbound, on the next time next will be called
			// it will return a, the last valid value of the sequence
			return a;
		}
		// Increases a and b according to the rules of the Fibonacci sequence
		// it will return a, the last valid value of the sequence
		int temp = b;
		b += a;
		a = temp;
		return a;
	}
}
