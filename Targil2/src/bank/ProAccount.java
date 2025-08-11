package bank;

public class ProAccount extends Account {
	// This class inherits from class Account, it has an array of history of the
	// amount of shekels in the account
	private int[] history;
	private int cur; // An index of the array

	public ProAccount(String name) {
		// Constructor for the ProAccount class
		super(name); // Calls the constructor from class Account
		history = new int[100]; // Initializes the history array and the maximum size is 100
		cur = -1; // Initializes the index of the array to be -1
	}

	@Override
	public void add(int amount) {
		// This method overrides the method from the super class
		if (cur < 99) {
			// As long as there weren't 100 transactions it will increase cur, update the
			// history, and will change the amount of shekels using add from the super class
			cur++;
			super.add(amount);
			history[cur] = super.getShekels();
		}
	}

	@Override
	public String toString() {
		// This method overrides the method from the super class, it will return a
		// string that has the toString from Account and will also show the history
		// until now of the current ProAccount
		String str = super.toString() + " [";
		for (int i = 0; i < cur; i++) {
			str += history[i] + ",";
		}
		str += history[cur] + "]";
		return str;
	}

	public static void transfer(ProAccount from, ProAccount to, int amount) {
		// This static method removes an amount from ProAccount from and adds it to
		// ProAccount to
		// removes amount from from
		from.add(-amount);
		// adds that amount to to
		to.add(amount);
	}
}
