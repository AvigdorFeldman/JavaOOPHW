package simpleFX;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Count extends Application {
	/* This simulates Voting machine application using only javaFX */
	private int count;

	@Override
	public void start(Stage primaryStage) {
		VBox root = new VBox();
		HBox h = new HBox();
		h.setPadding(new Insets(10));
		h.setSpacing(20);

		Button b1 = new Button("Ofra Haza");
		Button b2 = new Button("Yardena Arazi");

		Label label = new Label("0");

		VBox v = new VBox(10, label);
		v.setAlignment(Pos.CENTER); // Center the label in the VBox
		v.setPadding(new Insets(10));

		label.setPrefHeight(50);
		label.setStyle("-fx-background-color:red");
		label.setAlignment(Pos.CENTER);
		label.setPrefWidth(Double.MAX_VALUE);
		b1.setMaxWidth(Double.MAX_VALUE);
		b2.setMaxWidth(Double.MAX_VALUE);
		b1.setAlignment(Pos.CENTER_LEFT);
		b2.setAlignment(Pos.CENTER_RIGHT);
		b1.setPadding(new Insets(5, 10, 5, 20));
		b2.setPadding(new Insets(5, 10, 5, 19));
		// Ofra Haza button
		b1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				count++;
				label.setText(String.format("%d", count));
			}
		});
		// Yardena Arazi button
		b2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				count--;
				label.setText(String.format("%d", count));
			}
		});

		h.getChildren().addAll(b1, b2);
		root.getChildren().addAll(h, v);
		Scene scene = new Scene(root, 225, 100);
		primaryStage.setTitle("Voting Machine"); // Title
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}