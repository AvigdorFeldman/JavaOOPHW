package graph;

public class Place {
	// The class represents a coordinate, it has fields x,y, getters and implements
	// equals and hashCode
	private int x, y;

	public Place(int x, int y, int bound) {
		// Constructor of the class. it makes sure x,y aren't out of bound when the
		// bound is [0,bound-1] by throwing an IllegalArgumentException
		if (x > bound - 1 || x < 0 || y > bound - 1 || y < 0) {
			throw new IllegalArgumentException();
		} else {
			this.x = x;
			this.y = y;
		}
	}

	public int getX() {
		// Getter for the x field
		return x;
	}

	public int getY() {
		// getter for the y field
		return y;
	}

	@Override
	public boolean equals(Object obj) {
		// Checks if this Place object equals to obj
		// Two places are equal if they have the same x and y
		if (obj instanceof Place) {
			Place place = (Place) obj;
			return x == place.getX() && y == place.getY();
		}
		return false;
	}

	@Override
	public int hashCode() {
		// Generated hash function
		int result = 31 + x;
		result = 31 * result + y;
		return result;
	}

	@Override
	public String toString() {
		// toString of the Place returns "(x,y)"
		return String.format("(%d,%d)", x, y);
	}
}
