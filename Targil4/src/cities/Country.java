package cities;

import java.util.*;

public class Country implements Comparable<Country> {
	// The class defines a country, it has a set of cities in the country and its
	// name as fields. The class has methods to manage the country such as addCity,
	// population, toString, smallCities and report. Since the class implements
	// Comparable it has methods equals and comparTo
	private Set<City> cities;
	private String name;

	public Country(String name) {
		// Constructor of the class, simply initializes the set of cities and puts name
		// in field name
		cities = new TreeSet<>();
		this.name = name;
	}

	public void addCity(City city) {
		// Adds a city to the set, if the city's getCountry value doesn't equal to this
		// country name then it throws an IllegalArgumentException
		if (!city.getCountry().equals(this))
			throw new IllegalArgumentException();
		else
			cities.add(city);
	}

	public int population() {
		// The method returns the population of the country by summing up the population
		// of the cities of the country
		int sum = 0;
		if (cities != null) {
			for (City city : cities) {
				sum += city.getPopulation();
			}
		}
		return sum;
	}

	@Override
	public String toString() {
		// The toString method returns the name of the country
		return name;
	}

	public List<City> smallCities(int under) {
		// The method returns a list of cities that their population is under the value
		// of under, the returned list is sorted in the order of their names
		List<City> smallCities = new ArrayList<>();
		if (cities == null)
			return smallCities;
		for (City city : cities) {
			if (city.getPopulation() < under)
				smallCities.add(city);
		}
		smallCities.sort(null); // Sorts the cities according to their names in a lexicographic order
		return smallCities;
	}

	public String report() {
		// The method returns a string, a report on the country:
		// The name of the country, total population, the cities of the country and
		// their population
		StringBuilder sb = new StringBuilder();
		boolean flag = true;
		sb.append(this.toString());
		sb.append(String.format("(%d) : ", population()));
		if (cities != null) { // Checks if the cities set isn't empty
			for (City city : cities) {
				sb.append(String.format("%s(%d), ", city.getName(), city.getPopulation()));
				flag = false;
			}
		}
		if (!flag) // Removes the last ", " from the StringBuilder
			sb.delete(sb.length() - 2, sb.length());
		return sb.toString();
	}

	@Override
	public boolean equals(Object obj) {
		// The method Checks if this country is equal to another object. Two countries
		// are considered equal if their names are the same.
		if(obj instanceof Country) {
			Country country = (Country) obj;
			return name.equals(country.toString());
		}
		return false;
	}

	@Override
	public int compareTo(Country other) {
		// The method compares this country to another country based on their names
		// lexicographically
		if(name.compareTo(other.toString())==0)
			return 0;
		else if(name.compareTo(other.toString())>0)
			return 1;
		else
			return -1;

	}

}
