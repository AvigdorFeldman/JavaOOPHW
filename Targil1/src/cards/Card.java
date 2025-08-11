package cards;

public class Card {
	// The class holds the number of a card and its suit
	private int num, suit;

	public Card(int num, int suit) {
		// Constructor for the Card class
		this.num = num;
		this.suit = suit;
	}

	public int getNum() {
		// Getter for the num field
		return this.num;
	}

	public int getSuit() {
		// Getter for the suit field
		return this.suit;
	}

	public String toString() {
		// Returns a formatted string of the card: its number and then the actual
		// meaning of the number in suit: 0-C, 1-D, 2-H, 3-S
		switch (this.suit) {
		case 0:
			return this.num + "C";
		case 1:
			return this.num + "D";
		case 2:
			return this.num + "H";
		default:
			return this.num + "S";
		}
	}

	public int compareTo(Card other) {
		// The method compares between this card and card other, if this card is bigger
		// it returns a positive number(1) if they are equal then it returns 0 and if
		// this card is smaller it returns a negative number(-1). It first checks the
		// value of the numbers and if they are equal it check by the number in suit
		if ((this.num == other.getNum()) && (this.suit == other.getSuit())) {
			return 0;
		} else if (this.num == other.getNum()) {
			if (this.suit > other.getSuit())
				return 1;
			else
				return -1;
		} else if (this.num > other.getNum())
			return 1;
		else
			return -1;
	}
}
