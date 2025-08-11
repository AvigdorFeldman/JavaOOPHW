package cities;

import java.util.*;

public class World {
	// The class manages a map of countries, it has methods such as addCountry,
	// addCity, population, smallCities and report
	private Map<String, Country> countries = null;

	public void addCountry(String name) {
		// The method adds a country to the map
		if (countries == null)
			countries = new TreeMap<>();
		countries.put(name, new Country(name));
	}

	public void addCity(String name, String countryName, int population) {
		// The method adds a city to a country, if there is no country like that in the
		// map it throws an IllegalArgumentException
		if (countries == null || !countries.containsKey(countryName))
			throw new IllegalArgumentException();
		else
			countries.get(countryName).addCity(new City(name, countries.get(countryName), population));
	}

	public int population() {
		// The method returns the total population of the map, by summing up the
		// population of each country in the map
		int sum = 0;
		if (countries != null) { // Makes sure countries isn't empty
			for (Map.Entry<String, Country> entry : countries.entrySet()) {
				sum += entry.getValue().population();
			}
		}
		return sum;
	}

	public List<City> smallCities(int under) {
		// The method returns a list of the cities in the map that their population is
		// under variable under
		List<City> smallCities = new ArrayList<>();
		if (countries != null) { // Makes sure countries isn't empty
			for (Map.Entry<String, Country> entry : countries.entrySet()) {
				smallCities.addAll(entry.getValue().smallCities(under));
			}
		}
		return smallCities;
	}

	public String report() {
		// The methods calls report for all the countries in the map, and puts it in the
		// same string
		StringBuilder sb = new StringBuilder();
		if (countries != null) { // Makes sure countries isn't empty
			for (Map.Entry<String, Country> entry : countries.entrySet()) {
				sb.append(String.format("%s\n", entry.getValue().report()));
			}
		}
		sb.append(String.format("Total population is %d\n", population()));
		return sb.toString();
	}
}
