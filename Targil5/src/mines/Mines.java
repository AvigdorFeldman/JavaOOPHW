package mines;

import java.util.Random;

public class Mines {
	// The class manages the Minesweeper game rules
	private final int height, width;
	private int numMines;
	private boolean showAll = false;
	private Cell[][] board;

	private class Cell {
		// Private class of Mines, has a status on the cells of the board
		private int i, j;
		private boolean isMine;
		private boolean isOpen;
		private boolean isFlagged;
		private int neighborMines = 0;

		public Cell(int i, int j) {
			// Constructor of the Cell class
			this.i = i;
			this.j = j;
			isMine = false;
			isOpen = false;
			isFlagged = false;
		}

		private void setNeighborMines() {
			// The method counts how many Mine neighbors the cell has
			neighborMines = 0;
			for (int i1 = -1; i1 < 2; i1++) {
				for (int j1 = -1; j1 < 2; j1++) {
					if (i1 == 0 && j1 == 0) {
						continue;
					}
					if (isInBounds(i + i1, j + j1)) {
						if (board[i + i1][j + j1].isMine) {
							neighborMines++;
						}
					}

				}
			}
		}

		private boolean isInBounds(int i, int j) {
			// The method checks if [row+i][col+j] place isn't out of bounds
			if (i >= height || i < 0 || j >= width || j < 0) {
				return false;
			}
			return true;
		}

	}

	public Mines(int height, int width, int numMines) {
		// Constructor of the Mines class
		this.height = height;
		this.width = width;
		this.numMines = numMines;
		board = new Cell[height][width];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				board[i][j] = new Cell(i, j);

			}
		}
		// Adds Mines in the board randomly
		Random minesRandom = new Random();
		int i, j;
		for (int k = 0; k < numMines; k++) {
			i = minesRandom.nextInt(height);
			j = minesRandom.nextInt(width);
			if (!board[i][j].isMine) {
				board[i][j].isMine = true;
			} else {
				k--;
			}
		}
		// Sets neighbors for each cell in the board
		for (i = 0; i < height; i++) {
			for (j = 0; j < width; j++) {
				board[i][j].setNeighborMines();
			}
		}

	}

	private boolean isInBounds(int i, int j, int row, int col) {
		// The method checks if [row+i][col+j] place isn't out of bounds and that it's
		// not the same (i=0 and j=0)
		if (row + i >= height || row + i < 0 || col + j >= width || col + j < 0
				|| ((row + i == row && col + j == col))) {
			return false;
		}
		return true;
	}

	public boolean addMine(int row, int col) {
		// The methods adds a mine to place that doesn't have a mine, it also updates
		// the neighbors of the new mine
		if (!board[row][col].isMine) {
			board[row][col].isMine = true;
			numMines++;
			for (int i = -1; i < 2; i++) {
				for (int j = -1; j < 2; j++) {
					if (isInBounds(i, j, row, col)) {
						board[row + i][col + j].setNeighborMines();
					}
				}
			}
			return true;
		}
		return false;
	}

	public boolean open(int row, int col) {
		// The method opens a cell[row][col], if its a mine it returns false, otherwise
		// it will open all the neighbors that arent mines recursively (those who don't
		// have any mines as neighbors)
		if (board[row][col].isMine) {
			return false;
		}

		if (board[row][col].isOpen) {
			return true;
		}

		board[row][col].isOpen = true;
		if (board[row][col].neighborMines == 0) {
			for (int i = -1; i < 2; i++) {
				for (int j = -1; j < 2; j++) {
					if (isInBounds(i, j, row, col)) {
						open(row + i, col + j);
					}
				}
			}
		}
		return true;
	}

	public void toggleFlag(int row, int col) {
		// The method changes from flagged to not-flagged and the opposite
		if (board[row][col].isFlagged) {
			board[row][col].isFlagged = false;
		} else {
			board[row][col].isFlagged = true;
		}
	}

	public boolean isDone() {
		// The method checks if the whole board is open and no mines were opened
		int count = 0;
		for (Cell[] cells : board) {
			for (Cell cell : cells) {
				if (cell.isOpen && !cell.isMine) {
					count++;
				}
			}
		}
		if (count == (height * width - numMines)) {
			return true;
		}
		return false;
	}

	public String get(int row, int col) {
		// The method returns a String on a cell in location [row][col]
		// If the cell is open or showAll is true, it checks if its a mine, if so it
		// returns "X", otherwise it checks if neighborMines is 0, if so it returns " ",
		// otherwise it returns neighborMines.
		// If the cell isn't open, if the cell is flagged it returns "F" otherwise it
		// returns "."
		Cell cell = board[row][col];
		if (cell.isOpen || showAll) {
			if (cell.isMine) {
				return "X";
			} else if (cell.neighborMines == 0) {
				return " ";
			} else {
				return String.format("%d", cell.neighborMines);
			}
		} else if (cell.isFlagged) {
			return "F";
		} else {
			return ".";
		}
	}

	public void setShowAll(boolean showAll) {
		// The method sets showAll as showAll that was received as a parameter
		this.showAll = showAll;
	}

	@Override
	public String toString() {
		// The method returns the board as a string using method get on each of the
		// cells of the board
		StringBuilder sb = new StringBuilder();
		if (board != null) {
			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					sb.append(get(i, j));
				}
				sb.append("\n");
			}
		}
		return sb.toString();
	}

}
