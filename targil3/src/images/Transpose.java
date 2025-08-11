package images;

public class Transpose implements Image {
	// The class implements the interface Image. It implements each of the methods
	// from Image so that a received image will be transposed
	private Image base;

	public Transpose(Image base) {
		// Constructor of the class
		this.base = base;
	}

	@Override
	public RGB get(int x, int y) {
		// Implements from the interface Image, returns the transposed point of the base
		// image
		return base.get(y, x);
	}

	@Override
	public int getHeight() {
		// Implements from the interface Image, getter for height of the transposed
		// image for this case it makes sure the height will be the width of the base
		// image
		return base.getWidth();
	}

	@Override
	public int getWidth() {
		// Implements from the interface Image, getter for width of the transposed
		// image for this case it makes sure the width will be the height of the base
		// image
		return base.getHeight();
	}

}
