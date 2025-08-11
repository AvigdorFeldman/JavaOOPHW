package library;

public class Library {
	// The class holds an array of books
	private Book[] books;

	public Library(int size) {
		// Constructor of the Library class
		this.books = new Book[size];
	}

	public void setBook(int bookNum, String title, Author auth) {
		// Adds a new book to the library
		if ((bookNum < this.books.length) && (bookNum > -1))// Checks that the array isn't full and that bookNum is a
															// non-negative number
			this.books[bookNum] = new Book(title, auth);
		else
			System.out.println("bookNum value isn't legal");
	}

	public Book getBook(int bookNum) {
		// Returns a specific book in the bookNum placement in the array books
		if (!(bookNum < this.books.length) && (bookNum > -1)) {// Checks if the array is empty, and if so it returns
																// null
			return null;
		}
		// Otherwise, it returns the book in the bookNum placement in the array books
		return books[bookNum];
	}
}
