package game;

import java.util.Scanner;

public class Game extends Board {
	protected Player[] players;
	protected Scanner s = new Scanner(System.in);

	public Game(int n, int m, Player p1, Player p2) {
		// Constructor for the Game class
		super(n, m);
		players = new Player[2];
		players[0] = p1;
		players[1] = p2;
	}

	protected boolean doesWin(int i, int j) {
		// This method check if the last move was in placement 0 0 and if so it returns
		// true (wins) false otherwise (the game will continue);
		if (i == 0 && j == 0)
			return true;
		return false;
	}

	protected boolean onePlay(Player p) {
		// The method is basically 1 turn of player p in the game. It gets the row i and
		// column j using the scanner and is checking if that placement is available, if
		// not it asks for a new row and column, it will do so until the row and column
		// are available and then will add the player to the board in that placement.
		// Returns true if the player won using doesWin() method
		int i, j;
		boolean flag;
		do {
			System.out.println(p.toString() + ", please enter row and column: ");
			i = s.nextInt();
			j = s.nextInt();
			// Checks if the inputed row and column are available
			if (!super.isEmpty(i, j)) {
				System.out.println("There is a piece there already...\n" + this.toString());
				flag = false;
			} else {
				flag = true;
				super.set(i, j, p);
				System.out.println(this.toString());
			}
			// Ends the loop if the placement was okay, otherwise it will continue the loop
		} while ((flag == false));

		return doesWin(i, j);
	}

	public Player play() {
		// The method manages the game, it calls method onePlay for each turn of the 2
		// players and ends the game if the board is full(a tie) using isFull method and
		// returns null or onePlay returned true(that player won) and then returns the
		// player who won
		// Change do while to while
		while (!isFull()) {
			if (onePlay(players[0])) { // Starts the turn of the first player, if the
				// turn made the player win the game it prints a message and returns
				// the player
				System.out.println(players[0].toString() + " Won!");
				s.close(); // Closes the scanner at the end of the game
				return players[0];
			}
			if (onePlay(players[1])) {// Starts the turn of the second player, if the
				// turn made the player win the game it prints a message and returns
				// the player
				System.out.println(players[1].toString() + " Won!");
				s.close(); // Closes the scanner at the end of the game
				return players[1];
			}
		}
		s.close(); // Closes the scanner at the end of the game
		// Ended the loop because the board is full and it prints an
		// appropriate message and returns null
		System.out.println("The board is full");
		return null;
	}

}
