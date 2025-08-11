package images;

public class TwoColorImage extends BaseImage {
	// The class inherits from BaseImage class, it uses a strategy scheme to send a
	// function to the class to do that it has the field func. It calculate the
	// alpha that will be used in the super class
	private TwoDFunc func;

	public TwoColorImage(int width, int height, RGB zero, RGB one, TwoDFunc func) {
		// Constructor of the class
		super(width, height, zero, one);
		this.func = func;
	}

	@Override
	protected double calcAlpha(int x, int y) {
		// Implements the abstract method of the super class. calculates alpha according
		// to method f from func. If alpha is bigger than 1 it returns 1, if alpha is
		// smaller than 1 it returns 0, otherwise it will return the calculated alpha
		// from func.f
		double alpha = func.f((double) x / getWidth(), (double) y / getHeight());
		return Math.max(0, Math.min(1, alpha));
	}
}