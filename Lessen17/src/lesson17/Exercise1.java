package lesson17;

import java.util.ArrayList;
import java.util.Arrays;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class Exercise1 extends Application{
	
	Stage window;
	Scene scene;
	GridPane GP;
	Label lName;
	Label lTitle;
	Label lPersons;
	
	TextField tName;
	TextField tTitle;
	
	CheckBox cb;	

	private final ArrayList<String> names = new ArrayList<>();
	private TextField txfName = new TextField();
	private TextField txfTitle = new TextField();
	private ListView<String> lvwNames = new ListView<>();
	
	@Override
	public void init() {
		this.initNames();
	}
	
	@Override
	public void start(Stage PrimaryStage) {
		window = PrimaryStage;
		window.setTitle("Exercise 1");
		GP = new GridPane();
		this.initContent(GP);
			
		lName = new Label();
		lTitle = new Label();
		lName.setText("Name:");
		lTitle.setText("Title:");
				
		scene = new Scene(GP, 500, 500);
		
		window.setResizable(false);
		window.setScene(scene);
		window.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

	private void initContent(GridPane pane) {
		// pane.setGridLinesVisible(true);
		pane.setPadding(new Insets(20));
		pane.setHgap(10);
		pane.setVgap(10);

		Label lblName = new Label("Name:");
		pane.add(lblName, 0, 0);
		
		Label lblTitle = new Label("Title:");
		pane.add(lblTitle, 0, 1);

		Label lblNames = new Label("Names:");
		pane.add(lblNames, 0, 3);
		GridPane.setValignment(lblNames, VPos.TOP);

		
		txfName = new TextField();
		pane.add(txfName, 1, 0);
		GridPane.setHgrow(txfName, Priority.ALWAYS);

		txfTitle = new TextField();
		pane.add(txfTitle, 1, 1);
		GridPane.setHgrow(txfTitle, Priority.ALWAYS);
		
		cb = new CheckBox();
		cb.setText("Senior");
		pane.add(cb, 1, 2);
		GridPane.setHgrow(cb, Priority.ALWAYS);
		
		lvwNames = new ListView<String>();
		pane.add(lvwNames, 1, 3);
		lvwNames.setPrefWidth(250);
		lvwNames.setPrefHeight(200);
		lvwNames.getItems().setAll(names);

		lvwNames.getSelectionModel().selectedItemProperty().addListener(
				(p, ov, nv) -> this.selectedNameChanged());

		Button btnAdd = new Button("Add");
		pane.add(btnAdd, 2, 0);
		btnAdd.setOnAction(event -> this.addAction());

		Button btnDelete = new Button("Delete");
		pane.add(btnDelete, 2, 1);
		btnDelete.setOnAction(event -> this.deleteAction());
	}
	
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

	public void addAction() {
		String name = txfName.getText().trim();
		if (name.length() > 0) {
			names.add(0, name);
			System.out.println(names);
			lvwNames.getItems().setAll(names);
		}
	}

	public void deleteAction() {
		int index = lvwNames.getSelectionModel().getSelectedIndex();
		if (index >= 0) {
			names.remove(index);
			txfName.clear();
			lvwNames.getItems().setAll(names);
		}
	}
}
