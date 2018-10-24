package demo3listview;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainApp extends Application {
	private final ArrayList<Person> persons = new ArrayList<>();

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void init() {
		this.initPersons();
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("ListView Demo3");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	// -------------------------------------------------------------------------

	private final TextField txfName = new TextField();
	private final ListView<Person> lvwPersons = new ListView<>();

	private void initContent(GridPane pane) {
		// pane.setGridLinesVisible(true);
		pane.setPadding(new Insets(20));
		pane.setHgap(10);
		pane.setVgap(10);

		Label lblName = new Label("Name:");
		pane.add(lblName, 0, 0);

		Label lblNames = new Label("Names:");
		pane.add(lblNames, 0, 1);
		GridPane.setValignment(lblNames, VPos.TOP);

		pane.add(txfName, 1, 0);

		pane.add(lvwPersons, 1, 1);
		lvwPersons.setPrefWidth(250);
		lvwPersons.setPrefHeight(200);
		lvwPersons.getItems().setAll(this.persons);

		lvwPersons.getSelectionModel().selectedItemProperty().addListener(
				(p, ov, nv) -> this.selectedPersonChanged());

		Button btnAdd = new Button("Add");
		pane.add(btnAdd, 2, 0);
		btnAdd.setOnAction(event -> this.addAction());

		Button btnDelete = new Button("Delete");
		pane.add(btnDelete, 2, 1);
		btnDelete.setOnAction(event -> this.deleteAction());
	}

	// -------------------------------------------------------------------------

	public void initPersons() {
		persons.add(new Person("Jens", "Jensen", "jj@eaaa.dk"));
		persons.add(new Person("Hans", "Hansen", "hh@eaaa.dk"));
		persons.add(new Person("Pia", "Peters", "pp@eaaa.dk"));
	}

	public void selectedPersonChanged() {
		Person selected = lvwPersons.getSelectionModel().getSelectedItem();
		if (selected != null) {
			txfName.setText(selected.toString());
		} else {
			txfName.clear();
		}
	}

	public void addAction() {
		String name = txfName.getText().trim();
		if (name.length() > 0) {
			String email = name.substring(0, 2).toLowerCase() + "h@mail.com";
			Person p = new Person(name, "Hansen", email);
			persons.add(p);
			lvwPersons.getItems().setAll(persons);
		}
	}

	public void deleteAction() {
		int index = lvwPersons.getSelectionModel().getSelectedIndex();
		if (index >= 0) {
			persons.remove(index);
			txfName.clear();
			lvwPersons.getItems().setAll(persons);
		}
	}
}
