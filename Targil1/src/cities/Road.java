package cities;

public class Road {
	// The class holds the road that connects two cities (and their details) and the
	// road's length
	private City city1, city2;
	private int length;

	public Road(City city1, City city2, int length) {
		// Constructor for the Road class
		// Uses the connect method from the City class to add the road to both of the
		// cities city1 and city2
		city1.connect(this);
		city2.connect(this);
		this.city1 = city1;
		this.city2 = city2;
		this.length = length;
	}

	public City getCity1() {
		// Getter for the city1 field
		return this.city1;
	}

	public City getCity2() {
		// Getter for the city2 field
		return this.city2;
	}

	public int getLength() {
		// Getter for the length field
		return this.length;
	}
}
