package game;

public class TicTacToe extends Game {
	// This class extends class Game it's rules are of a TicTacToe game

	public TicTacToe(String player1, String player2) {
		// Constructor for the TicTacToe class, in the game the board is a 3X3
		super(3, 3, new Player(player1, 'X'), new Player(player2, 'O'));
	}

	@Override
	protected boolean doesWin(int row, int col) {
		// This method overrides the method in the Game class, it returns true if there
		// is a line in size 3 of the player
		if (super.maxLineContaining(row, col) == 3)
			return true;
		return false;
	}
}
