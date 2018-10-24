package customdialog;

import java.util.Optional;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class NewEntryDialog extends Stage {
	private Optional<Entry> result = Optional.empty();

	public NewEntryDialog() {
		this.initModality(Modality.APPLICATION_MODAL);
		this.setResizable(false);

		this.setTitle("Custom Dialog");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		this.setScene(scene);
	}

	//-------------------------------------------------------------------------

	private final TextField txfName = new TextField(), txfPhone = new TextField();

	private void initContent(GridPane pane) {
		// pane.setGridLinesVisible(true);
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setPadding(new Insets(10));

		Text txtHeader = new Text("New phone book entry");
		pane.add(txtHeader, 0, 0, 2, 1);
		txtHeader.setStyle("-fx-font-size: 15");
		GridPane.setMargin(txtHeader, new Insets(2, 0, 12, 0));

		Label lblName = new Label("Name: ");
		pane.add(lblName, 0, 1);

		pane.add(txfName, 1, 1);

		Label lnlPhone = new Label("Phone: ");
		pane.add(lnlPhone, 0, 2);

		pane.add(txfPhone, 1, 2);

		HBox buttonBox = new HBox(10);
		pane.add(buttonBox, 1, 3);
		buttonBox.setPadding(new Insets(11, 0, 0, 0));
		buttonBox.setAlignment(Pos.TOP_RIGHT);

		Button btnCancel = new Button("Cancel");
		buttonBox.getChildren().add(btnCancel);
		btnCancel.setPrefWidth(70);
		btnCancel.setCancelButton(true);
		btnCancel.setOnAction(event -> this.cancelAction());

		Button btnOK = new Button("OK");
		buttonBox.getChildren().add(btnOK);
		btnOK.setPrefWidth(70);
		btnOK.setDefaultButton(true);
		btnOK.setOnAction(event -> this.okAction());
	}

	public Optional<Entry> getResult() {
		return result;
	}

	// -------------------------------------------------------------------------

	private void cancelAction() {
		this.clearTextFields();
		this.hide();
	}

	private void okAction() {
		if (txfName.getText().isEmpty() || txfPhone.getText().isEmpty()) {
			txfName.requestFocus();
		} else {
			Entry entry = new Entry(txfName.getText(), txfPhone.getText());
			result = Optional.of(entry);
			this.clearTextFields();
			this.hide();
		}
	}

	private void clearTextFields() {
		txfName.clear();
		txfPhone.clear();
	}
}
