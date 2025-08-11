package circuits;

public class OrGate extends Gate {
	// The OrGate inherits from the abstract class Gate. it implements the abstract
	// methods from Gate so they perform in the same logic as a Or Gate should work
	public OrGate(Gate[] inGates) {
		// Constructor for the class
		super(inGates);
	}

	@Override
	protected boolean func(boolean[] inValues) throws CircuitException {
		// The method implements the abstract method from Gate class. If the input gates
		// are null or there are less then 2 input gates it will throw CircutException,
		// The method returns the boolean OR of all the input Gates values
		if (inGates == null)
			throw new CircuitException("OR gate must have at least one inputs.");
		boolean res = false;
		for (boolean b : inValues) {
			res = res || b;
		}
		return res;
	}

	@Override
	public String getName() {
		// The method implements the abstract method from Gate class. For OrGate the
		// returned name of the gate will be "OR"
		return "OR";
	}

	@Override
	public Gate simplify() {
		// The method implements the abstract method from Gate class. it simplifies the
		// current gate Firstly it simplifies each of the input gates, and then it
		// checks if one of the gates is TrueGate, since it automatically returns a
		// TrueGate. If there are no TrueGates it will remove all the FalseGate that
		// were simplified before And will create a new OrGate with inputed
		// non-FalseGates. If it removed all of the input gates then it means the
		// simplified OrGate is a FalseGate and so it will return a FalseGate

		// Gets the simplified gates from the input gates and puts them in
		// simplifiedGates array
		Gate[] simplifiedGates = new Gate[inGates.length];
		for (int i = 0; i < simplifiedGates.length; i++) {
			simplifiedGates[i] = inGates[i].simplify();
		}
		// Counts how many FalseGate there are in the simplified gates
		int count = 0;
		for (Gate gate : simplifiedGates) {
			if (gate instanceof TrueGate) // If an input gate is a TrueGate it will return a TrueGate
				return TrueGate.instance();
			if (gate instanceof FalseGate)
				count++;
		}
		// If all the simplified input gates are FalseGates it will return a FalseGate
		if (simplifiedGates.length - count == 0) {
			return FalseGate.instance();
		}
		// Otherwise it will create a new OrGate from the non-FalseGates simplified
		// input gates
		Gate[] nonFalseGates = new Gate[inGates.length - count];
		int index = 0;
		for (Gate gate : simplifiedGates) {
			if (!(gate instanceof FalseGate))
				nonFalseGates[index++] = gate;
		}
		// If there is only one non-FalseGate simplified it will return that gate
		if (simplifiedGates.length - count == 1) {
			return nonFalseGates[index - 1];
		}
		return new OrGate(nonFalseGates);
	}

}