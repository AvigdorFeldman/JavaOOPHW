package game;

public class Player {
	// The class holds information about a player
	private String name;
	private char mark;

	public Player(String name, char mark) {
		// Constructor for Player class
		this.name = name;
		this.mark = mark;
	}

	public String getName() {
		// Getter of the name field;
		return name;
	}

	public char getMark() {
		// Getter of the mark field
		return mark;
	}

	public String toString() {
		// Returns a formatted string of the player: name(mark)
		return name + "(" + mark + ")";
	}

}
