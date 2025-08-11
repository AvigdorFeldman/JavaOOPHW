package images;

public class Mix extends BinaryImageDecorator {
	// The class inherits from the BinaryImageDecorator class. It implements the
	// method binDecorator. The class performs RGB.mix between the two colors, for
	// that reason it needs the field alpha
	private double alpha;

	public Mix(Image base1, Image base2, double alpha) {
		// Constructor of the class
		super(base1, base2);
		this.alpha = alpha;
	}

	@Override
	protected RGB binDecorator(RGB color1, RGB color2) {
		// Implements the abstract method of the super class. Gets the colors from the
		// get method and returns a new color using the static method RGB.mix
		return RGB.mix(color1, color2, alpha);

	}

}