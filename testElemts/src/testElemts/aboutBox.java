package testElemts;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class aboutBox {
	

	public static void display() {
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("About");
		window.setMinWidth(250);
		Label label = new Label();
		label.setText("Skrew you I went home hours ago");
		
		Button yesButton = new Button("Ok");
				
		yesButton.setOnAction(e -> window.close());
				
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label, yesButton);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
	}
}
