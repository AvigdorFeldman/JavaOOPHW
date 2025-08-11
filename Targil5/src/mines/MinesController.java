package mines;

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.util.Duration;

public class MinesController {

	@FXML
	private GridPane grid;
	@FXML
	private TextField rowsField, colsField, minesField;
	@FXML
	private Label label;
	private Mines game;
	private int rows = 10;
	private int cols = 10;
	private int numMines = 10;

	private class MineButton extends Button {
		/* Private class for buttons */
		@SuppressWarnings("unused")
		private int row, col;

		private MineButton(int row, int col) {
			// Constructor of a button in the game
			super(".");
			this.row = row;
			this.col = col;
			setMinSize(40, 40);
			setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					event.consume();
					if (event.getButton() == MouseButton.PRIMARY) { // Left click
						boolean success = game.open(row, col);
						boolean Win = game.isDone();
						if (!success) { // If pressed on mine you loose
							gameLost();
							disableBoard();

						}
						if (Win) { // If all the cells are open except the mines you win
							gameWon();
							disableBoard();
						}
						updateBoard();
					}
				}
			});
			setOnContextMenuRequested(event -> { // Right click - toggleFlag
				event.consume();
				game.toggleFlag(row, col);
				setText(game.get(row, col)); // Update the text on the button to show "F"/ Remove "F"
				boolean Win = game.isDone();
				if (Win) { //
					gameWon();
					disableBoard();
				}
				// Update the board
				updateBoard();
			});
		}
	}

	@FXML
	public void initialize() {
		/* The method initializes the board by calling createBoard() */
		label.setText("");
		game = new Mines(rows, cols, numMines);
		createBoard();
	}

	@FXML
	private void applySettings() {
		/* Changes the width, height and number of mines according to the input */
		try {
			rows = Integer.parseInt(rowsField.getText());
			cols = Integer.parseInt(colsField.getText());
			numMines = Integer.parseInt(minesField.getText());
			label.setText("");
			game = new Mines(rows, cols, numMines);
			createBoard();
		} catch (NumberFormatException e) {
			System.out.println("Invalid input! Please enter valid numbers.");
		}
	}

	private void createBoard() {
	    // Clear the previous board
	    grid.getChildren().clear();
	    
	    // Dynamically update the column and row constraints based on the grid size
	    grid.getColumnConstraints().clear();
	    grid.getRowConstraints().clear();

	    // Update column and row constraints based on number of rows and columns
	    for (int i = 0; i < cols; i++) {
	        grid.getColumnConstraints().add(new ColumnConstraints(40));  // Adjust button width
	    }
	    for (int i = 0; i < rows; i++) {
	        grid.getRowConstraints().add(new RowConstraints(40));  // Adjust button height
	    }

	    // Add new MineButtons for each cell in the grid
	    for (int i = 0; i < rows; i++) {
	        for (int j = 0; j < cols; j++) {
	            MineButton btn = new MineButton(i, j);
	            grid.add(btn, j, i);
	        }
	    }
	}

	private void updateBoard() {
		/* Updates the board after each button action */
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				Button btn = (Button) getNodeFromGridPane(grid, j, i);
				if (btn != null) {
					if (game.get(i, j).equals("X")) {
						// Puts an image instead of "X" when there is a mine
						try {
							// Load the image from the correct path
							Image xImage = new Image("mines/mine.png");
							ImageView view = new ImageView(xImage);
							view.setFitHeight(20); // Set the size of the image
							view.setFitWidth(20);
							view.setPreserveRatio(true);
							btn.setGraphic(view); // Set the image as the button graphic
							btn.setText(""); // Clear the text
						} catch (Exception e) {
							System.out.println("Error loading mine image: " + e.getMessage());
						}
					} else {
						btn.setText(game.get(i, j));
					}
				}
			}
		}
	}

	private void disableBoard() {
		// The method disables the buttons on the board
		for (Node node : grid.getChildren()) {
			if (node instanceof MineButton) {
				node.setDisable(true);
			}
		}
	}

	private Node getNodeFromGridPane(GridPane gridPane, int col, int row) {
		for (Node node : gridPane.getChildren()) {
			if (GridPane.getRowIndex(node) == row && GridPane.getColumnIndex(node) == col) {
				return node;
			}
		}
		return null;
	}

	// Call this method after the game is lost
	private void gameLost() {
		game.setShowAll(true);
		label.setText("You Lose");
		showLosingAnimation();
		updateBoard();
	}

	// Call this method after the game is won
	private void gameWon() {
		game.setShowAll(true);
		label.setText("You Win");
		showWinningAnimation();
		updateBoard();
	}

	private void showWinningAnimation() {
		// Fade-in the label with "You Win"
		FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), label);
		fadeTransition.setFromValue(0);
		fadeTransition.setToValue(1);
		fadeTransition.play();

		label.setText("You Win!");

		// Scale animation on the grid (zoom in)
		ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(1), grid);
		scaleTransition.setFromX(1);
		scaleTransition.setFromY(1);
		scaleTransition.setToX(1.1);
		scaleTransition.setToY(1.1);
		scaleTransition.setCycleCount(2);
		scaleTransition.setAutoReverse(true);
		scaleTransition.play();
	}

	private void showLosingAnimation() {
		// Fade-in the label with "You Lose"
		FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), label);
		fadeTransition.setFromValue(0);
		fadeTransition.setToValue(1);
		fadeTransition.play();

		label.setText("You Lose");

		// Shake effect on the grid to indicate disappointment
		for (Node node : grid.getChildren()) {
			if (node instanceof MineButton) {
				TranslateTransition translateTransition = new TranslateTransition(Duration.millis(200), node);
				translateTransition.setByX(10);
				translateTransition.setCycleCount(6);
				translateTransition.setAutoReverse(true);
				translateTransition.play();
			}
		}
	}

}
