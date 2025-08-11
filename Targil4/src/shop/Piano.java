package shop;

public class Piano extends Instrument {
	// The class inherits from Instrument, it has also field which is the number of
	// octaves, it implements func() which only returns a string that fits to the
	// piano class
	private int octaves;

	public Piano(String company, int price, int octaves) {
		// Constructor of the class
		super(company, price);
		this.octaves = octaves;
	}

	public int getOctaves() {
		// Getter of the octaves field
		return octaves;
	}

	@Override
	protected String func() {
		// The method implements the method from the super-class, it returns string that
		// fits to the piano class
		return String.format("%d octaves", octaves);
	}
}
