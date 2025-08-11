package circuits;

public class TrueGate extends Gate {
	// The TrueGate class inherits from Gate class, it implements the abstract
	// methods from Gate and creates the object in singleton way
	private TrueGate(Gate inGates[]) {
		// Constructor of the class, it is in private because it will be implemented in
		// a singleton way
		super(inGates);
	}

	private static Gate trueInstance = null; // A static variable that will hold the TrueGate, initialized to null

	public static Gate instance() {
		// The method creates a TrueGate object in a singleton way
		// If it's the first time instance has been called on to this class it will
		// create a TrueGate
		if (trueInstance == null)
			trueInstance = new TrueGate(null);
		// Otherwise, it won't create a new object it will return trueInstance
		return trueInstance;
	}

	@Override
	public String getName() {
		// The method implements the abstract method from Gate class. For TrueGate the
		// returned name of the gate will be "T"
		return "T";
	}

	@Override
	protected boolean func(boolean[] inValues) throws CircuitException {
		// The method implements the abstract method from Gate class. Returns true,
		// since the TrueGate only returns true
		return true;
	}

	@Override
	public Gate simplify() {
		// The method implements the abstract method from Gate class. The TrueGate is
		// already simplified so it will return itself (it's object)
		return this;
	}

}
