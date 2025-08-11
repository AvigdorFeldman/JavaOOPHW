package images;

public abstract class BinaryImageDecorator implements Image {
	// The class implements the interface Image, it implemented each of the methods
	// from Image, and has an abstract method that will be implemented by the sub
	// classes which is used in method get. This class has 2 base images and creates
	// a new Image using them
	private Image base1, base2;

	public BinaryImageDecorator(Image I1, Image I2) {
		// Constructor of the method
		this.base1 = I1;
		this.base2 = I2;
	}

	@Override
	public int getWidth() {
		// Implements from the interface Image, getter for width of the image, it
		// chooses the biggest width from the base images to be the width for the
		// current image
		return Math.max(base1.getWidth(), base2.getWidth());
	}

	@Override
	public int getHeight() {
		// Implements from the interface Image, getter for height of the image, it
		// chooses the biggest height from the base images to be the height for the
		// current image
		return Math.max(base1.getHeight(), base2.getHeight());
	}

	@Override
	public RGB get(int x, int y) {
		// Implements from the interface Image, it chooses how to fill point (x,y) in
		// the following form: if both of the colors from the base images in that point
		// aren't null it will return a color binDeorator which is implemented
		// differently for each of the sub classes, if one of the colors is null it will
		// choose to fill the point in the color which isn't null, otherwise both of the
		// colors are null and then it will fill the point in the color black
		RGB color1 = base1.get(x, y);
		RGB color2 = base2.get(x, y);
		// Both of the colors aren't null
		if (color1 != null && color2 != null)
			return binDecorator(color1, color2);
		// One of the colors is null
		else if (color1 != null && color2 == null)
			return color1;
		else if (color1 == null && color2 != null)
			return color2;
		else // Both of the colors are null
			return RGB.BLACK;

	}

	protected abstract RGB binDecorator(RGB color1, RGB color2); // The abstract method which will be implemented by the
																	// sub-classes
}
