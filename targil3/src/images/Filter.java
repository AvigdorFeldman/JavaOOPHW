package images;

public class Filter extends ImageDecorator {
	// The class inherits from ImageDecorator class, it has a constructor and a
	// field filter which will be used by the decorator method
	private RGB filter;

	public Filter(Image base, RGB filter) {
		// Constructor of the class
		super(base);
		this.filter = filter;
	}

	@Override
	protected RGB decorator(RGB color) {
		// Implements the abstract method of the super class. Gets the color from the
		// get method and returns a new color using the filter method on it (multiply
		// each of the color fields with the filter fields)
		return color.filter(filter);
	}
}
