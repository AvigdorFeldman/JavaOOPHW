package circuits;

public class NotGate extends Gate {
	// The NotGate inherits from the Gate class. It implements all the abstract
	// classes of Gate, it has only one input gate and returns its opposite value
	public NotGate(Gate in) {
		// Constructor of the class, the NotGate has only one input gate
		super(new Gate[] { in });
	}

	@Override
	protected boolean func(boolean[] inValues) throws CircuitException {
		// The method implements the abstract method from Gate class. If the input gate
		// is null it throws a CircuitException
		if (inValues == null) {
			throw new CircuitException("NOT gate must have exactly one input.");
		}
		// Otherwise it returns the input gate's opposite value
		return !inValues[0];
	}

	@Override
	public String getName() {
		// The method implements the abstract method from Gate class. For NotGate the
		// returned name of the gate will be "NOT"
		return "NOT";
	}

	@Override
	public Gate simplify() {
		// The method implements the abstract method from Gate class. It simplifies the
		// input gates in the NotGate

		// If the input gate is TrueGate it will return a FalseGate
		if (inGates[0].simplify() instanceof TrueGate)
			return FalseGate.instance();
		// If the input gate is FalseGate it will return a TrueGate
		else if (inGates[0].simplify() instanceof FalseGate)
			return TrueGate.instance();
		// If the input gate is a NotGate it will return a NotGate of the input gate
		else if (inGates[0].simplify() instanceof NotGate)
			return (NotGate) inGates[0].simplify();
		else
			// Otherwise, it will return itself (its object)
			return this;
	}
}
