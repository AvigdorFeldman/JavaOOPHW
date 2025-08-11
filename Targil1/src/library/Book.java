package library;

public class Book {
	// The class holds the book's title and author
	private String title;
	private Author auth;

	public Book(String title, Author auth) {
		// Constructor for the Book class
		this.title = title;
		this.auth = auth;
	}

	public String getTitle() {
		// Getter for the title field
		return this.title;
	}

	public String getAuthorName() {
		// Returns the name of the book's author
		return this.auth.getName();
	}

	public int getAuthorBirthYear() {
		// Returns the birth year of the book's author
		return this.auth.getBirthYear();
	}

	public String toString() {
		// Returns a formatted string: title of the book, "written by" and the formatted
		// string from class Author of the book's Author
		return this.title + " written by " + this.auth.toString();
	}
}
