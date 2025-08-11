package shop;

public class Guitar extends Instrument {
	// The class inherits from Instrument, it also has field type, which is an
	// enum{ACOUSTIC,ELECTRIC,CLASSICAL}, it Implements method func(), which simply
	// returns the string of the type
	private Type type;

	public Guitar(String company, int price, Type type) {
		// Constructor of the class
		super(company, price);
		this.type = type;
	}

	public Type getType() {
		// Getter of type field
		return type;
	}

	@Override
	protected String func() {
		// Implements the method from the super-class, returns the type of the guiter as
		// a string
		return type.toString();
	}
}
