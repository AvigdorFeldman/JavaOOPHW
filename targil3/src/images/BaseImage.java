package images;

public abstract class BaseImage implements Image {
	// The class is abstract and implements interface image, it has the measurements
	// of an image and 2 colors for an image. Implements the methods from Image and
	// has an abstract method that it's sub-classes will have to implement
	private int width, height;
	private RGB color1, color2;

	public BaseImage(int width, int height, RGB color1, RGB color2) {
		// Constructor of the BaseImage class
		this.width = width;
		this.height = height;
		this.color1 = color1;
		this.color2 = color2;
	}

	@Override
	public int getWidth() {
		// Implements from the interface Image, getter for width
		return width;
	}

	@Override
	public int getHeight() {
		// Implements from the interface Image, getter for height
		return height;
	}

	@Override
	public RGB get(int x, int y) {
		// Implements from the interface Image. The method colors the point in (x,y), it
		// uses static method RGB.mix to color the point, also it checks that the point
		// is valid according to the measurements, if not it returns null.
		if (x >= 0 && x <= getWidth() && y <= getHeight() && y >= 0) {
			return RGB.mix(color2, color1, calcAlpha(x, y)); // Each sub-class has calcAlpha of their own
		}
		return null;
	}

	protected abstract double calcAlpha(int x, int y); // The abstract method which will be implemented by the
														// sub-classes
}
