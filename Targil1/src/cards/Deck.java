package cards;

public class Deck {
	// The class holds an array of cards
	private Card[] cards;
	private int cur; // Index of the last card in the deck (cards array), set to zero

	public Deck(int num) {
		// Constructor for the Deck class. It gets a number and creates a deck in the
		// size
		// of 4 times that number in an organized way (number first, then suit): 0 0,0
		// 1,
		// 0 2,0 3,1 0,1 1,1 2,1 3,...,num-1 0, num-1 1, num-1 2, num-1 3
		// num = count of unique numbers that will be inside the deck
		int number = 0;
		int typeSuit = 0;
		this.cur = num * 4 - 1;
		this.cards = new Card[this.cur + 1];
		for (int i = 0; i < cards.length; i++)// pass the array of card
		{
			// Checks if i is divided by 4 without a residue to get 4 cards with different
			// suits but the same number
			if (i % 4 == 0 && i != 0)
				number += 1;
			cards[i] = new Card(number, typeSuit);
			// Checks if typeSuite is 3 and if so resets it back to 0
			if (typeSuit == 3)
				typeSuit = 0;
			else // Otherwise increases typeSuit by 1
				typeSuit += 1;
		}
	}

	public Deck(Deck from, int num) {
		// Constructor for the Deck class. It creates a deck from the last num cards of
		// deck
		// from using the takeOne method
		int count = 0;
		this.cards = new Card[num];
		while ((from.getNumCards() > 0) && (count < num)) {// The loop stops if num cards were taken from deck from or
															// the deck from is empty
			this.cards[this.cur] = from.takeOne();
			this.cur++;
			count++;
		}
		this.cur--; // Updates the value of the index of the last card in cards
	}

	public Deck(Deck first, Deck second) {
		// Constructor for the Deck class. It creates a combined deck from the decks
		// first
		// and second in the size of both the decks in the next order: it takes the last
		// card from the first deck and then the last one from the second deck, and it
		// keeps repeating that until there are no cards in both of the decks
		this.cards = new Card[first.getNumCards() + second.getNumCards()];
		while ((first.getNumCards() > 0) || (second.getNumCards() > 0)) {
			if (first.getNumCards() > 0) {
				this.cards[this.cur] = first.takeOne();
				this.cur++;
			}
			if (second.getNumCards() > 0) {
				this.cards[this.cur] = second.takeOne();
				this.cur++;
			}
		}
		this.cur--; // Updates the value of the index of the last card in cards
	}

	public int getNumCards() {
		// Returns the number of cards in the deck
		return this.cur + 1;
	}

	public Card takeOne() {
		// Returns and removes the last card of the deck
		if (cur >= 0) {
			Card last = this.cards[this.cur];
			this.cur--;
			return last;
		} else
			return null;
	}

	public String toString() {
		// Returns a formatted string of the Deck class: [card1, card2,...]. it gets the
		// string of a card from the toString method in the card Class
		String str = "[";
		if (this.cur >= 0) {// Checks that the deck isn't empty
			for (int i = 0; i < this.cards.length - 1; i++) {
				str += this.cards[i].toString() + ", ";
			}

			str += this.cards[this.cur].toString() + "]";
		} else
			str += "]";
		return str;
	}

	public void sort() {
		// The method performs a Bubble Sort on the cards array
		Card temp;
		for (int i = 0; i < this.cards.length - 1; i++) {
			for (int j = 0; j < this.cards.length - i - 1; j++) {
				if (this.cards[j].compareTo(this.cards[j + 1]) == 1) {// Uses compareTo method from the Card class
					temp = cards[j];
					cards[j] = cards[j + 1];
					cards[j + 1] = temp;
				}
			}
		}
	}
}
