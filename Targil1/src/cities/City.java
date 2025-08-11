package cities;

public class City {
	// The class holds details of the city and the roads connected to the city
	private String name;
	private Road[] roads;
	private int numRoads;

	public City(String name) {
		// Constructor for the City class
		this.name = name;
		this.roads = new Road[10];
		// numRoads is set to 0
	}

	public void connect(Road r) {
		// The method adds a road that is connected to the city
		if ((numRoads < 10)) {// Checks that the numRoads is lower than 10 because there are 10 roads
								// maximum, also numRoads is a non-negative number
			this.roads[numRoads] = r;
			this.numRoads++;
		}
	}

	public City nearestCity() {
		// The method Returns the closest city by finding which road has the minimal
		// length
		if (numRoads > 0) {
			int indOfMin = 0;
			if (roads[0] == null) // Returns null if there are no cities connected to this city
				return null;
			// Searches the index of the shortest road that this city is connected to
			int min = roads[0].getLength();
			for (int i = 0; i < numRoads; i++) {
				if (min > roads[i].getLength()) {
					min = roads[i].getLength();
					indOfMin = i;
				}
			}

			// Returns the closest city to this city using getCity methods from class Road

			if (this.roads[indOfMin].getCity1().toString() == this.name) {
				return this.roads[indOfMin].getCity2();
			}
			return this.roads[indOfMin].getCity1();
		} else
			// returns null because no roads are connected to the city
			return null;
	}

	public String toString() {
		// Returns a formatted string of class City
		return this.name;
	}
}
