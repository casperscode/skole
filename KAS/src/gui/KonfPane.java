package gui;

import model.Konference;
import storage.Storage;
import controller.controller;

import java.time.LocalDate;
import java.util.ArrayList;

import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class KonfPane extends GridPane {

	private final TextField txfHotelName = new TextField();
	private final TextField txfAdress = new TextField();
	private final TextField txfDato = new TextField();
	private final TextArea txaExtraService = new TextArea();
	private static final ListView<Konference> lvwKonferencer = new ListView<>();

	public KonfPane() {
		this.setPadding(new Insets(20));
		this.setHgap(20);
		this.setVgap(10);
		this.setGridLinesVisible(false);

		Label lblHotels = new Label("Konferencer :");
		this.add(lblHotels, 0, 0);

		Label lblHotelName = new Label("Navn :");
		this.add(lblHotelName, 1, 1);

		Label lblAdress = new Label("Adresse :");
		this.add(lblAdress, 1, 2);

		Label lblTelephone = new Label("Dato :");
		this.add(lblTelephone, 1, 3);

		Label lblExtraService = new Label("Andet");
		this.add(lblExtraService, 1, 4);
		GridPane.setValignment(lblExtraService, VPos.BASELINE);
		lblExtraService.setPadding(new Insets(4, 0, 4, 0));

		// Listview til konferencer

		this.add(this.lvwKonferencer, 0, 1, 1, 4);
		this.lvwKonferencer.setPrefWidth(200);
		this.lvwKonferencer.setPrefHeight(250);

		ChangeListener<Konference> listener = (ov, oldA, newA) -> this.selectedKonfRediger();
		this.lvwKonferencer.getSelectionModel().selectedItemProperty().addListener(listener);
		
		// felter til konference pane

		this.add(this.txfHotelName, 2, 1);
		this.txfHotelName.setEditable(false);

		this.add(this.txfAdress, 2, 2);
		this.txfAdress.setEditable(false);
		
		this.add(this.txfDato, 2, 3);
		this.txfDato.setEditable(false);

		this.add(this.txaExtraService, 2, 4);
		this.txaExtraService.setPrefWidth(200);
		this.txaExtraService.setPrefHeight(100);
		this.txaExtraService.setEditable(false);

		// Knapper til konference pane

		HBox hbxButtons = new HBox(10);
		this.add(hbxButtons, 0, 5, 3, 1);
		hbxButtons.setPadding(new Insets(10, 0, 0, 0));
		hbxButtons.setAlignment(Pos.BASELINE_RIGHT);

		Button btnAddParticipant = new Button("Tilføj");
		hbxButtons.getChildren().add(btnAddParticipant);
		btnAddParticipant.setOnAction(event -> this.addAction());

		Button btnUpdateParticipant = new Button("Rediger");
		hbxButtons.getChildren().add(btnUpdateParticipant);

		Button btnDeleteParticipant = new Button("Slet");
		hbxButtons.getChildren().add(btnDeleteParticipant);

		if (this.lvwKonferencer.getItems().size() > 0) {
			this.lvwKonferencer.getSelectionModel().select(0);
		}
	}

	// ----------------------------------------------------------- \\

	public void addAction() {
		System.out.println(Storage.getKonferencer());
		KonfVindue konfVindue = new KonfVindue("Opret Konference");
		System.out.println(Storage.getKonferencer());
		konfVindue.showAndWait();
	}

	private void selectedKonfRediger() {
		this.updateControls();
	}

	public static void updateList(ArrayList<Konference> view) {
	//	System.out.println(view);
//		lvwKonferencer.getItems().clear();
//		lvwKonferencer.getItems().addAll(0, view);
		lvwKonferencer.getItems().addAll(Storage.getKonferencer());
	}
	
	public void updateControls() {
		Konference ar1 = this.lvwKonferencer.getSelectionModel().getSelectedItem();
		if (ar1 != null) {
			this.txfHotelName.setText(ar1.getNavn());
			this.txfAdress.setText(ar1.getAdresse());
			this.txfDato.setText(ar1.getDato());
		} else {
			this.txfHotelName.clear();
			this.txfAdress.clear();
			this.txfDato.clear();
		}

	}

}
