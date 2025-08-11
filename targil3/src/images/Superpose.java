package images;

public class Superpose extends BinaryImageDecorator {
	// The class inherits from the BinaryImageDecorator class. It implements the
	// method binDecorator. The class performs RGB.superpose between the two colors
	public Superpose(Image base1, Image base2) {
		// Constructor of the class
		super(base1, base2);
	}

	@Override
	protected RGB binDecorator(RGB color1, RGB color2) {
		// Implements the abstract method of the super class. Gets the colors from the
		// get method and returns a new color using the static method RGB.superpose
		return RGB.superpose(color1, color2);

	}
}
