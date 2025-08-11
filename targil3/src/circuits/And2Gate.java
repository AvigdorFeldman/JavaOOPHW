package circuits;

public class And2Gate extends AndGate {
	// The class inherits from AndGate. The only difference is it works with 2 input
	// gates in the constructor
	public And2Gate(Gate g1, Gate g2) {
		// Constructor of the class
		super(new Gate[] { g1, g2 });
	}

}
