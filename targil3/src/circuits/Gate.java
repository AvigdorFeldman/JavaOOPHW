package circuits;

public abstract class Gate {
	// The Gate class is an abstract class. It calculates the gates values and
	// returns a string of the gate and its input gates, there are 3 abstract
	// methods that will be implemented by the inherited classes
	protected Gate[] inGates; // Array of input gates

	public Gate(Gate[] inGates) {
		// Constructor of the Gate class
		this.inGates = inGates;
	}

	public boolean calc() throws CircuitException {
		// The method calculates the value of the current gate using method func
		// To calculate the current Gate it also calculates the values of inputed gates
		// as well
		if (inGates == null) // Returns func(null) if the inGates is an empty array
			return func(null);
		boolean[] inValues = new boolean[inGates.length];
		for (int i = 0; i < inValues.length; i++) {
			// For each of the input gates it calculates recursively
			if (inGates[i] == null) // Throws an exception if an input gate is null
				throw new CircuitException("The is null!");
			if (inGates[i].inGates == null)
				inValues[i] = inGates[i].func(null);
			else
				inValues[i] = inGates[i].calc(); // The recursive call for calc on the input gate
		}
		return func(inValues); // Calls func to get the value of the gate
	}

	protected abstract boolean func(boolean[] inValues) throws CircuitException; // Abstract method, will be implemented
																					// by the inherited classes

	public abstract String getName(); // Abstract method, will be implemented by the inherited classes

	public abstract Gate simplify(); // Abstract method, will be implemented by the inherited classes

	public String toString() {
		// The method returns a string of the gate and then it's input gates in []
		// recursively using StringBuilder
		StringBuilder sb = new StringBuilder();
		sb.append(getName());
		if (inGates == null) {
			// If the gate has no input gates it will return the name of the current gate
			return sb.toString();
		}
		// String of the input gates
		sb.append("[");
		for (int i = 0; i < inGates.length; i++) {
			// It will call recursively to toString on each input gate (as long as it isn't
			// null)
			if (inGates[i] != null)
				sb.append(inGates[i].toString());
			if (i == inGates.length - 1) // Adds "]" at the last input gate
				sb.append("]");
			else
				sb.append(", "); // Adds ", " between input gates
		}
		return sb.toString();
	}
}
