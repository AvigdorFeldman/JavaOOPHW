package circuits;

public class FalseGate extends Gate {
	// The FalseGate class inherits from Gate class, it implements the abstract
	// methods from Gate and creates the object in singleton way
	private FalseGate(Gate inGates[]) {
		// Constructor of the class, it is in private because it will be implemented in
		// a singleton way
		super(inGates);
	}

	private static Gate falseInstance = null; // A static variable that will hold the FalseGate, initialized to null

	public static Gate instance() {
		// The method creates a FalseGate object in a singleton way
		// If it's the first time instance has been called on to this class it will
		// create a FalseGate
		if (falseInstance == null)
			falseInstance = new FalseGate(null);
		// Otherwise, it won't create a new object it will return falseInstance
		return falseInstance;
	}

	@Override
	public String getName() {
		// The method implements the abstract method from Gate class. For FalseGate the
		// returned name of the gate will be "F"
		return "F";
	}

	@Override
	protected boolean func(boolean[] inValues) throws CircuitException {
		// The method implements the abstract method from Gate class. Returns false,
		// since the FalseGate only returns false
		return false;
	}

	@Override
	public Gate simplify() {
		// The method implements the abstract method from Gate class. The FalseGate is
		// already simplified so it will return itself (it's object)
		return this;
	}

}