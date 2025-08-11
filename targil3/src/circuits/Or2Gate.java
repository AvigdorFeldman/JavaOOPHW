package circuits;

public class Or2Gate extends OrGate {
	// The class inherits from AndGate. The only difference is it works with 2 input
	// gates in the constructor
	public Or2Gate(Gate g1, Gate g2) {
		// Constructor of the class
		super(new Gate[] { g1, g2 });
	}

}
