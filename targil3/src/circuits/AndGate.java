package circuits;

public class AndGate extends Gate {
	// The AndGate inherits from the abstract class Gate. it implements the abstract
	// methods from Gate so they perform in the same logic as a And Gate should work
	public AndGate(Gate[] inGates) {
		// Constructor for the class
		super(inGates);
	}

	@Override
	protected boolean func(boolean[] inValues) throws CircuitException {
		// The method implements the abstract method from Gate class. If the input gates
		// are null or there are less then 2 input gates it will throw CircutException,
		// The method returns the boolean AND of all the input Gates values
		if (inGates == null)
			throw new CircuitException("AND gate must have at least one input.");
		boolean res = true;
		for (boolean b : inValues) {
			res = res && b;
		}
		return res;
	}

	@Override
	public String getName() {
		// The method implements the abstract method from Gate class. For AndGate the
		// returned name of the gate will be "AND"
		return "AND";
	}

	@Override
	public Gate simplify() {
		// The method implements the abstract method from Gate class. it simplifies the
		// current gate Firstly it simplifies each of the input gates, and then it
		// checks if one of the gates is FalseGate, since it automatically returns a
		// FalseGate. If there are no FalseGates it will remove all the TrueGate that
		// were simplified before And will create a new AndGate with inputed
		// non-TrueGates. If it removed all of the input gates then it means the
		// simplified AndGate is a TrueGate and so it will return a TrueGate

		// Gets the simplified gates from the input gates and puts them in
		// simplifiedGates array
		Gate[] simplifiedGates = new Gate[inGates.length];
		for (int i = 0; i < simplifiedGates.length; i++) {
			simplifiedGates[i] = inGates[i].simplify();
		}
		// Counts how many TrueGate there are in the simplified gates
		int count = 0;
		for (Gate gate : simplifiedGates) {
			if (gate instanceof FalseGate) // If an input gate is a FalseGate it will return a FalseGate
				return FalseGate.instance();
			if (gate instanceof TrueGate)
				count++;
		}
		// If all the simplified input gates are TrueGates it will return a TrueGate
		if (simplifiedGates.length - count == 0) {
			return TrueGate.instance();
		}
		// Otherwise it will create a new AndGate from the non-TrueGates simplified
		// input gates
		Gate[] nonTrueGates = new Gate[inGates.length - count];
		int index = 0;
		for (Gate gate : simplifiedGates) {
			if (!(gate instanceof TrueGate))
				nonTrueGates[index++] = gate;
		}
		// If there is only one non-TrueGate simplified it will return that gate
		if (simplifiedGates.length - count == 1) {
			return nonTrueGates[index - 1];
		}
		return new AndGate(nonTrueGates);
	}

}
