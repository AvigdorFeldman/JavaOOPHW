package circuits;

public class VarGate extends Gate {
	// The class inherits from abstract class Gate. It implements the abstract
	// methods from Gate, the gate is variable in other words it can be set to true
	// or false but in the beginning it is set to null
	private Boolean val; // Use wrapper to use null in booleans
	private String name; // Name of the variable

	public VarGate(String name) {
		// Constructor of the class
		super(null);
		this.name = name;
		val = null; // initializes val to null
	}

	public void setVal(boolean value) {
		// Sets the value of val to value
		this.val = value;
	}

	@Override
	protected boolean func(boolean[] inValues) throws CircuitException {
		// The method implements the abstract method from Gate class. If no value has
		// been set in val (in other words its null) it throws a CircutException
		if (val == null)
			throw new CircuitException("VarGate gate value hasn't been set yet.");
		// Otherwise it returns the value in val
		return val;
	}

	@Override
	public String getName() {
		// The method implements the abstract method from Gate class. Returns a string
		// that starts with V and then the variable's name
		return String.format("V%s", name);
	}

	@Override
	public Gate simplify() {
		// The method implements the abstract method from Gate class. If a value in val
		// hasn't been set yet it will return itself (this object), otherwise according
		// to the value in val it will return a TrueGate or a FalseGate
		if (val == null)
			return this;
		else if (val == true) // If val is true it will return a TrueGate
			return TrueGate.instance();
		else // Otherwise it will return a FalseGate
			return FalseGate.instance();

	}

}
