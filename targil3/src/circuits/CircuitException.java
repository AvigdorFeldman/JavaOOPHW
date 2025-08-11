package circuits;

public class CircuitException extends Exception {
	// A class that inherits from Exception, usually will be used to throw exception about a ceratin gate
	private static final long serialVersionUID = 4081258731210654545L;

	public CircuitException(String str) {
		// Constructor of the class
		super(str);
	}
}
