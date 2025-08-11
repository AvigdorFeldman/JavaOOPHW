package game;

public class Board {
	// The class creates a board and puts players from the Player class in it, it
	// also checks the maximal line of the same player from a starting point
	protected Player[][] board;
	protected int n, m;

	public Board(int n, int m) {
		// Constructor for the Board class
		this.n = n;
		this.m = m;
		board = new Player[n][m];
	}

	public boolean isEmpty(int i, int j) {
		// The method checks if there is a player in the board in row i and column j,
		// and if not it returns true, otherwise false
		if (board[i][j] == null)
			return true;
		return false;
	}

	protected boolean set(int i, int j, Player p) {
		// The method puts player p in the board in row i and column j.
		// If in that placement already has a player it returns false, otherwise it
		// returns true
		if (!isEmpty(i, j))
			return false;
		board[i][j] = p;
		return true;
	}

	public Player get(int i, int j) {
		// The method returns a player in row i and column j, if there is no player in
		// that placement it returns null
		if (isEmpty(i, j))
			return null;
		return board[i][j];
	}

	public boolean isFull() {
		// The method checks if the board is full. If it finds even 1 available
		// placement it returns false, otherwise true
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (isEmpty(i, j))
					return false;
			}
		}
		return true;
	}

	public String toString() {
		// Returns a formatted string of the board, a dot points an empty placement and
		// the mark of a player points that the player is in that placement
		// Using StringBuilder for efficiency
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (isEmpty(i, j))
					sb.append(".");
				else
					sb.append(get(i, j).getMark());
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	private int rayLength(int i, int j, int di, int dj) {
		// The method calculates the line of a player from row i in
		// column j recursively using di and dj
		// di(-1=downer row ,0=same row, 1=upper row)
		// dj(-1=left column ,0=same column, 1=right column)
		if ((i == 0 && di == -1) || (i == n - 1 && di == 1) || (j == 0 && dj == -1) || (j == m - 1 && dj == 1)
				|| (di == 0 && dj == 0))
			// This condition checks that the line calculation wont get out of bounds and
			// doesn't calculate if di and dj are 0 (it means that it just stays in the same
			// place) returns 0
			return 0;
		if (board[i][j] == board[i + di][j + dj])
			// Confirms the next place in the line is the same player and if so it adds 1
			// and calls the method again with the next placement of the player
			return 1 + rayLength(i + di, j + dj, di, dj);
		// Otherwise it returns 0
		return 0;
	}

	protected int maxLineContaining(int i, int j) {
		// The method gets the row i and column j of a player and returns the longest
		// line from that position using rayLength method
		if (!isEmpty(i, j)) {
			// The placement is of a player it's possible to find the longest line
			int maxLine = 0, positiveLine = 0, negativeLine = 0, totalCurLine = 0;
			// Will call method rayLength 9 times each with different di and dj (between -1
			// and 1, rayLength() returns false when di and dj are both 0 so it will actually
			// check at most 8 lines)
			for (int di = -1; di <= 1; di++) {
				for (int dj = -1; dj <= 1; dj++) {
					// To get the full line we will separate to 2 runs on rayLength
					// Calculates the line in the positive direction di, dj
					positiveLine = rayLength(i, j, di, dj);
					// Calculates the line in the negative direction -di, -dj
					negativeLine = rayLength(i, j, -di, -dj);
					// The total length is the sum of the positive and the negative plus the current
					// cell
					totalCurLine = positiveLine + negativeLine + 1;
					// Puts in maxLine the longest line
					if (maxLine < totalCurLine)
						maxLine = totalCurLine;
				}
			}
			// Returns maxLine
			return maxLine;
		}
		// There is no player in that placement it returns 0
		return 0;
	}

}
