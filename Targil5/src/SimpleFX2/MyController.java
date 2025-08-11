/**
 * Sample Skeleton for 'Voting.fxml' Controller Class
 */

package SimpleFX2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MyController {
	/* Controller for the Voting Machine application */
	@FXML
	private Button b1;

	@FXML
	private Button b2;

	@FXML
	private Label label;

	@FXML
	private int count = 0;

	@FXML
	void ofraButton(ActionEvent event) {
		// The method for onAction of Ofra Haza button
		count++;
		label.setText(String.format("%d", count));
	}

	@FXML
	void yardenaButton(ActionEvent event) {
		// The method for onAction of Yardena Arazi button
		count--;
		label.setText(String.format("%d", count));
	}
}
