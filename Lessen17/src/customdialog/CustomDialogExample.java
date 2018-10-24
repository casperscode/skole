package customdialog;

import java.util.Optional;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CustomDialogExample extends Application {
	private final NewEntryDialog dialog = new NewEntryDialog();

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

		dialog.initOwner(stage);
	}

	// -------------------------------------------------------------------------

	private final Text txtStatus = new Text();

	private void initContent(GridPane pane) {
		// pane.setGridLinesVisible(true);
		pane.setPadding(new Insets(20));
		pane.setHgap(10);
		pane.setVgap(20);

		VBox vbox = new VBox(30);
		pane.add(vbox, 0, 0);
		vbox.setAlignment(Pos.CENTER);

		// header label
		Label lblHeader = new Label("Custom Dialog");
		vbox.getChildren().add(lblHeader);
		lblHeader.setTextFill(Color.DARKBLUE);
		lblHeader.setFont(Font.font("Calibri", FontWeight.BOLD, 36));

		// new PhoneBook entry button
		Button btnNewEntry = new Button("New PhoneBook Entry");
		vbox.getChildren().add(btnNewEntry);
		btnNewEntry.setOnAction(event -> this.newEntryAction());

		// status text
		vbox.getChildren().add(this.txtStatus);
		txtStatus.setText("No text");
		txtStatus.setFont(Font.font("Calibri", FontWeight.NORMAL, 20));
		txtStatus.setFill(Color.FIREBRICK);
	}

	//-------------------------------------------------------------------------

	public void newEntryAction() {
		dialog.showAndWait();
		// wait for the dialog to close...

		Optional<Entry> result = dialog.getResult();
		if (result.isPresent()) {
			txtStatus.setText("Result: " + result.get());
		} else {
			txtStatus.setText("Result cancelled");
		}
	}
}