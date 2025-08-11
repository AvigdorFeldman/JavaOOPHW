package images;

public abstract class ImageDecorator implements Image {
	// The class is abstract and implements interface image, it has a base image and
	// Implements the methods from the interface. Also it has an abstract method
	// that
	// will be implemented by each of the sub-classe
	private Image base;

	public ImageDecorator(Image base) {
		// Constructor for the ImageDecorator class
		this.base = base;
	}

	@Override
	public int getWidth() {
		// Implements from the interface Image. Getter for the width of the image
		return base.getWidth();
	}

	@Override
	public int getHeight() {
		// Implements from the interface Image. Getter for the height of the image
		return base.getHeight();
	}

	public RGB get(int x, int y) {
		// Implements from the interface Image. gets the color of each point in (x,y)
		// and calls the abstract method decorator to fill that point in that manner, if
		// the point is null it returns null.
		RGB originalColor = base.get(x, y);
		if (originalColor != null)
			return decorator(originalColor);
		return null;
	}

	protected abstract RGB decorator(RGB color); // The abstract method which will be implemented by the sub-classes

}
