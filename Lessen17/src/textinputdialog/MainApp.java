package textinputdialog;

import java.util.Optional;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainApp extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Gui Demo: Text Input Dialog");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	// -------------------------------------------------------------------------

	private final TextArea txaDescription = new TextArea();

	private void initContent(GridPane pane) {
		// pane.setGridLinesVisible(true);
		pane.setPadding(new Insets(20));
		pane.setHgap(20);
		pane.setVgap(10);

		Label lblName = new Label("TextArea:");
		pane.add(lblName, 0, 0);

		pane.add(txaDescription, 0, 1);
		txaDescription.setPrefRowCount(7);
		txaDescription.setPrefWidth(270);
		txaDescription.setEditable(false);

		Button btnFill = new Button("Fill TextArea");
		pane.add(btnFill, 1, 1);
		btnFill.setOnAction(event -> this.fillAction());
	}

	// -------------------------------------------------------------------------

	public void fillAction() {
		TextInputDialog dialog = new TextInputDialog("Default text");
		dialog.setTitle("Text Input Dialog");
		dialog.setHeaderText("Please enter some text");
		dialog.setContentText("Text:");

		Optional<String> result = dialog.showAndWait();
		//wait for the dialog to close

		if (result.isPresent()) {
			String response = result.get();
			txaDescription.setText(txaDescription.getText() + response + "\n");
		}
	}
}
