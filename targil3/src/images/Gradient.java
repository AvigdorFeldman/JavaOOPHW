package images;

public class Gradient extends BaseImage {
	// The class inherits from class BaseImage, it has a constructor and
	// calcAlpha(), it starts as the start color from the left and changes in a
	// gradual form to the end color in the right
	public Gradient(int width, int height, RGB start, RGB end) {
		// Constructor of the class
		super(width, height, start, end);
	}

	@Override
	protected double calcAlpha(int x, int y) {
		// Implements the abstract method of the super class. Returns the alpha for the
		// mix in the get method from the super class, in this case each x of a point is
		// rational to the width of the image
		return (double) x / getWidth();
	}
}
