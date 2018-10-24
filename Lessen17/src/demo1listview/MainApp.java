package demo1listview;

import java.util.ArrayList;
import java.util.Arrays;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApp extends Application {
	private final ArrayList<String> names = new ArrayList<>();

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void init() {
		this.initNames();
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("ListView Demo1");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	// -------------------------------------------------------------------------

	private final TextField txfName = new TextField();
	private final ListView<String> lvwNames = new ListView<>();

	private void initContent(GridPane pane) {
		// pane.setGridLinesVisible(true);
		pane.setPadding(new Insets(20));
		pane.setHgap(10);
		pane.setVgap(10);

		Label lblNames = new Label("Names:");
		pane.add(lblNames, 0, 0);

		pane.add(lvwNames, 0, 1);
		lvwNames.setPrefWidth(250);
		lvwNames.setPrefHeight(200);
		lvwNames.getItems().setAll(names);

		lvwNames.getSelectionModel().selectedItemProperty().addListener(
				(p, ov, nv) -> this.selectedNameChanged());

		VBox vbox = new VBox(5);
		pane.add(vbox, 1, 1);

		Label lblSelected = new Label("Selected:");
		vbox.getChildren().add(lblSelected);

		vbox.getChildren().add(txfName);
	}

	// -------------------------------------------------------------------------

	public void initNames() {
		String[] items = {
				"Jane", "Eva", "Lene", "Mette", "Tine",
				"Line", "Lone", "Alberte", "Pia" };
		names.addAll(Arrays.asList(items));
	}

	public void selectedNameChanged() {
		String selected = lvwNames.getSelectionModel().getSelectedItem();
		if (selected != null) {
			txfName.setText(selected);
		} else {
			txfName.clear();
		}
	}

}
