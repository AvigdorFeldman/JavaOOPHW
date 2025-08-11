package shop;

public enum Type {
	// This is enum which will be used by the Guitar class it can one of the three
	// values:ACOUSTIC,ELECTRIC,CLASSICAL. It has a toString method which returns
	// the current value of the enum as a string
	ACOUSTIC, ELECTRIC, CLASSICAL;

	@Override
	public String toString() {
		// Returns a string according to the current instance of this Type
		if (this.equals(ACOUSTIC)) // If the Type is ACOUSTIC it returns Acoustic
			return "Acoustic";
		else if (this.equals(CLASSICAL)) // If the Type is CLASSICAL it returns Classical
			return "Classical";
		else
			return "Electric"; // Otherwise it returns Electric

	}
}
