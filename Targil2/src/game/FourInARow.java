package game;

public class FourInARow extends Game {
	public FourInARow(String player1, String player2) {
		// Constructor for the FourInARow class, the board is a fixed 6X7 size
		super(6, 7, null, null);
		players[0] = new Player(player1, 'W');
		players[1] = new Player(player2, 'B');
	}

	@Override
	protected boolean doesWin(int i, int j) {
		// This method overrides the method in the Game class, it returns true if there
		// is a line in size 3 of the player
		if (super.maxLineContaining(i, j) == 4)
			return true;
		return false;
	}

	@Override
	protected boolean onePlay(Player p) {
		// The method is basically 1 turn of player p in the game. It gets the row i and
		// column j using the scanner and is checking if that placement is available, if
		// not it asks for a new column, it will do so until the column
		// is available and then will add the player to the board in that placement.
		// Returns true if the player won using doesWin() method
		int i, j;
		boolean flag;
		do {
			System.out.println(p.toString() + ", please enter column: ");
			j = s.nextInt();
			for (i = n - 1; i >= 0; i--) {
				if (isEmpty(i, j)) {
					break;
				}
			}
			// Checks if the inputed column is available
			if (i == -1) {
				System.out.println("The column is full, pick a different column...\n" + this.toString());
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

}
