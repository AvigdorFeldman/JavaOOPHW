package images;

public class RGB {
	// The class RGB has fields Red, Green, Blue which represent a color. each field
	// is between the values 0-1. The class has 2 constructors, getters for each
	// field, two methods on the object itself and 2 static methods. It also has 5
	// base colors as static final
	private double Red, Green, Blue;

	public RGB(double Red, double Green, double Blue) {
		// Constructor for the RGB class
		this.Red = Red;
		this.Green = Green;
		this.Blue = Blue;
	}

	public RGB(double grey) {
		// Constructor for the RGB class, grey is in all the fields
		this.Red = grey;
		this.Green = grey;
		this.Blue = grey;
	}

	public double getRed() {
		// Getter for the Red field
		return Red;
	}

	public double getGreen() {
		// Getter for the Green field
		return Green;
	}

	public double getBlue() {
		// Getter for the Blue field
		return Blue;
	}

	public RGB invert() {
		// The method inverts all the fields by making each field be 1-field and returns
		// a color with the new fields
		return new RGB(1 - Red, 1 - Green, 1 - Blue);
	}

	public RGB filter(RGB filter) {
		// The method returns a new color from the original multiplies each field with
		// color filter.field
		return new RGB(Red * filter.getRed(), Green * filter.getGreen(), Blue * filter.getBlue());
	}

	public static RGB superpose(RGB rgb1, RGB rgb2) {
		// A static method. It returns a new color which each of the fields is the sum
		// of the fields, if the sum is bigger than 1 it stays 1
		return new RGB(Math.min(rgb1.getRed() + rgb2.getRed(), 1), Math.min(rgb1.getGreen() + rgb2.getGreen(), 1),
				Math.min(rgb1.getBlue() + rgb2.getBlue(), 1));
	}

	public static RGB mix(RGB rgb1, RGB rgb2, double alpha) {
		// A static method. It returns a new color by performing the next formula on
		// each of the fields: alpha * color1.field + (1-alpha) * color2.field
		return new RGB(alpha * rgb1.getRed() + (1 - alpha) * rgb2.getRed(),
				alpha * rgb1.getGreen() + (1 - alpha) * rgb2.getGreen(),
				alpha * rgb1.getBlue() + (1 - alpha) * rgb2.getBlue());
	}

	public String toString() {
		// The method returns the color with 4 digits after the dot on each of the
		// fields in the brackets <>
		return String.format("<%.4f, %.4f, %.4f>", Red, Green, Blue);
	}

	// 5 base static final colors
	public static final RGB BLACK = new RGB(0);
	public static final RGB WHITE = new RGB(1);
	public static final RGB RED = new RGB(1, 0, 0);
	public static final RGB GREEN = new RGB(0, 1, 0);
	public static final RGB BLUE = new RGB(0, 0, 1);
}
