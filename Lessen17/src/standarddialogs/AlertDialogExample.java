package standarddialogs;

import java.util.Optional;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AlertDialogExample extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("JavaFX Dialogs Example");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	// -------------------------------------------------------------------------

	private final TextField txfInput = new TextField();
	private final Text txtStatus = new Text();

	public void initContent(GridPane pane) {
		// pane.setGridLinesVisible(true);
		pane.setPadding(new Insets(20));
		pane.setHgap(10);
		pane.setVgap(20);

		// header label
		Label lblHeader = new Label("Alert Dialogs");
		pane.add(lblHeader, 1, 0);
		lblHeader.setTextFill(Color.DARKBLUE);
		lblHeader.setFont(Font.font("Calibri", FontWeight.BOLD, 36));

		// label for input text field
		Label lblInput = new Label("A Text field:");
		pane.add(lblInput, 0, 1);
		lblInput.setFont(Font.font("Calibri", FontWeight.NORMAL, 20));

		// input text field
		pane.add(txfInput, 1, 1);
		txfInput.setMinHeight(30.0);
		txfInput.setPromptText("Enter some text and save.");

		// horizontal box for buttons
		HBox hbox = new HBox(20);
		pane.add(hbox, 1, 2);
		hbox.setAlignment(Pos.CENTER);

		// info button
		Button btnInfo = new Button("Info");
		btnInfo.setOnAction(event -> this.infoAction());
		hbox.getChildren().add(btnInfo);

		// save button
		Button btnSave = new Button("Save");
		btnSave.setOnAction(event -> this.saveAction());
		hbox.getChildren().add(btnSave);

		//clear button
		Button btnClear = new Button("Clear");
		btnClear.setOnAction(event -> this.clearAction());
		hbox.getChildren().add(btnClear);

		// status text
		pane.add(txtStatus, 0, 4, 3, 1);
		txtStatus.setFont(Font.font("Calibri", FontWeight.NORMAL, 20));
		txtStatus.setFill(Color.FIREBRICK);
		txtStatus.setText("An example of Alert Dialogs. Enter some text and save.");

		btnInfo.requestFocus();
	}

	//-------------------------------------------------------------------------

	public void infoAction() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information Dialog");
		alert.setHeaderText("Info");
		String s = "This is an example of JavaFX 8 Dialogs.\n"
				+ "This is an Alert Dialog of Alert type - INFORMATION." + " \n \n"
				+ "Other Alert types are: CONFIRMATION, ERROR, NONE and WARNING.";
		alert.setContentText(s);

		alert.showAndWait();
		// wait for the dialog to close
	}

	public void saveAction() {
		String txt = txfInput.getText().trim();
		String msg = "Text saved: ";
		boolean valid = true;

		if ((txt.isEmpty()) || (txt.length() < 5)) {
			valid = false;
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			String s = "Text should be at least 5 characters long. "
					+ "Enter valid text and save. ";
			alert.setContentText(s);

			alert.showAndWait();
			// wait for the dialog to close

			msg = "Invalid text entered: ";
		}

		txtStatus.setText(msg + txt);
		if (!valid) {
			txfInput.requestFocus();
		}
	}

	public void clearAction() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmation Dialog");
		String s = "Confirm to clear text in text field ! ";
		alert.setContentText(s);

		Optional<ButtonType> result = alert.showAndWait();
		// wait for the dialog to close

		if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
			txfInput.setText("");
			txtStatus.setText(
					"An example of Alert Dialogs. Enter some text and save.");
			txfInput.requestFocus();
		}
	}
}
