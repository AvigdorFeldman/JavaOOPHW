package root;

public class Rooter {
	// The class holds a certain precision, mainly used to get the square root of a
	// number
	private double precision;

	public Rooter(double precision) {
		// Constructor method of Rooter, uses setPrecision() method to set the value of
		// precision
		setPrecision(precision);
	}

	public void setPrecision(double precision) {
		// Sets the value of variable precision
		this.precision = precision;
	}

	public double sqrt(double x) {
		// The method gets a real number and returns its square root
		// Sets the values of the guesses to 1 and x
		double one = 1;
		double two = x;
		// The do while loop makes the guesses closer the root of x
		do {
			one = (one + two) / 2;
			two = x / one;
		}
		// Checks if the difference between the guesses is smaller than the
		// precision or the guesses are equal, and if so ends the loop
		while (((one - two >= this.precision) || (two - one >= this.precision)) && (one != two));
		// Exits the loop and returns the root of x
		return one;
	}
}
