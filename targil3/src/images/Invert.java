package images;

public class Invert extends ImageDecorator {
	// The class inherits from ImageDecorator class, it has a constructor and the
	// Decorator method which will call invert() to invert the fields of the color
	public Invert(Image base) {
		// Constructor of the class
		super(base);
	}

	@Override
	protected RGB decorator(RGB color) {
		// Implements the abstract method of the super class. Gets the color from the
		// get method and returns a new color using the invert method on it (inverts
		// each of the color fields)
		return color.invert();
	}
}
