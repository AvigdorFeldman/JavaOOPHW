package images;

public interface Image {
	// The interface represents an Image, classes that implement this interface will
	// need to implement the following methods:
	public int getWidth(); // Returns the width of an image

	public int getHeight(); // Returns the height of an image

	public RGB get(int x, int y); // Returns the color of a point in (x,y)
}
