package images;

public class Circle extends BaseImage {
	// The Circle class inherits from BaseImage, it represents a an Image where the
	// color of inside the circle is center but as further it gets from it it will
	// color according to distance/radius
	private int centerX, centerY, radius;

	public Circle(int width, int height, int centerX, int centerY, int radius, RGB center, RGB outside) {
		// Constructor of the class
		super(width, height, center, outside);
		this.centerX = centerX;
		this.centerY = centerY;
		this.radius = radius;
	}

	public Circle(int size, int radius, RGB center, RGB outside) {
		// Constructor of the class, width=size and height=size, centerX and centerY
		// would be half of the size
		super(size, size, center, outside);
		this.centerX = size / 2;
		this.centerY = size / 2;
		this.radius = radius;
	}

	@Override
	protected double calcAlpha(int x, int y) {
		// Implements the abstract method of the super class. Returns the alpha for the
		// mix in the get method from the super class.
		double d = Math.sqrt(Math.pow(x - centerX, 2) + Math.pow(y - centerY, 2)); // calculates distance (x,y) to
																					// (centerX,centerY)
		return Math.min(1, d / radius); // Returns 1 if the distance is bigger than the radius, otherwise returns
										// distance/radius
	}
}
