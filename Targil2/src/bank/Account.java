package bank;

public class Account {
	// The Class holds information about an account, with fields name and shekels,
	// getters for the fields and changes the amount of shekels to an account
	// toString for the Class
	private String name;
	private int shekels;

	public Account(String name) {
		// Constructor for the Account class
		this.name = name;
		shekels = 0;
	}

	public int getShekels() {
		// Getter for shekels field
		return shekels;
	}

	public String getName() {
		// Getter for name field
		return name;
	}

	public void add(int amount) {
		// Adds amount to shekels
		shekels += amount;
	}

	@Override
	public String toString() {
		// Returns a string with the name of the account " has " amount of the shekels
		// in the account " shekels"
		// Using StringBuilder for efficiency
		StringBuilder sb = new StringBuilder();
	    sb.append(name);
	    sb.append(" has ");
	    sb.append(shekels);
	    sb.append(" shekels");
		return sb.toString();
	}
}
