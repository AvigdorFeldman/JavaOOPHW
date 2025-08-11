package cities;

public class City implements Comparable<City> {
	// This class defines a city, it has the fields: name, country, population. It
	// has getters for each of the fields, toString, and since it implements
	// Comparable, it will implement equals and compareTo
	private String name;
	private Country country;
	private int population;

	public City(String name, Country country, int population) {
		// Constructor of the class
		this.name = name;
		this.country = country;
		this.population = population;
	}

	public String getName() {
		// Getter for the name field
		return name;
	}

	public Country getCountry() {
		// Getter for the country field
		return country;
	}

	public int getPopulation() {
		// Getter for the population field
		return population;
	}

	public String toString() {
		// Returns a string of the city: "City name (of country name)"
		return String.format("%s (of %s)", name, country.toString());
	}

	@Override
	public boolean equals(Object obj) {
		// The method checks if this city equals to object obj
		if (obj instanceof City) { // Checks if the two cities equal by comparing their names and country names,
			// notice that in Country class the equals method checks using the countries
			// names
			City city = (City) obj;
			return country.equals(city.getCountry()) && name.equals(city.getName());
		} // Otherwise return false
		return false;
	}

	@Override
	public int compareTo(City other) {
		// The method compares this object to other first by the names of the countries
		// lexicographically if the countries equal then it compares this city to
		// another city based on their names lexicographically
		if (country.compareTo(other.getCountry()) == 0) {
			// Compares this city to another city based on their names lexicographically
			if (name.compareTo(other.getName()) == 0)
				return 0;
			else if (name.compareTo(other.getName()) > 0)
				return 1;
			else
				return -1;
		} else
			return country.compareTo(other.getCountry());
	}
}
