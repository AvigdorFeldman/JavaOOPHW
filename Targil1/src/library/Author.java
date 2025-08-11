package library;

public class Author {
	// The class holds details of an Author
	private String name;
	private int birthYear;

	public Author(String name, int birthYear) {
		// Constructor for the Author class
		this.name = name;
		this.birthYear = birthYear;
	}

	public String getName() {
		// Getter for the name field
		return this.name;
	}

	public int getBirthYear() {
		// Getter for the birthYear field
		return this.birthYear;
	}

	public int getAge(int thisYear) {
		// Returns the age of the author
		return thisYear - this.birthYear;
	}

	public String toString() {
		// Returns a formatted string: author's name(author's birth year)
		return this.name + "(" + this.birthYear + ")";
	}
}
