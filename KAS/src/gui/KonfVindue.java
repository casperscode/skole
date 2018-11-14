package gui;

import model.Konference;

import java.time.LocalDate;
import controller.controller;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class KonfVindue extends Stage {
	private Konference konference;
	private DatePicker datePickerIn;
	private DatePicker datePickerOut;

	public KonfVindue(String title, Konference konference) {
		this.initStyle(StageStyle.UTILITY);
		this.initModality(Modality.APPLICATION_MODAL);
		this.setResizable(false);

		this.konference = konference;

		this.setTitle(title);
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane, 300, 220);
		this.setScene(scene);
	}

	public KonfVindue(String title) {
		this(title, null);
	}

	// -------------------------------------------------------------------------

	private final TextField txfNavn = new TextField();
	private final TextField txfAdresse = new TextField();
	private final TextField txfStartDato = new TextField();
	private final TextField txfSlutDato = new TextField();
	private final TextField txfPris = new TextField();
	private final Label lblErrorNavn = new Label();
	private final Label lblErrorAdresse = new Label();
	private final Label lblErrorDato = new Label();
	private final Label lblErrorPris = new Label();

	private void initContent(GridPane pane) {
		pane.setPadding(new Insets(10));
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setGridLinesVisible(false);

		Label lblName = new Label("Navn :");
		pane.add(lblName, 0, 0);

		Label lblAdress = new Label("Adresse :");
		pane.add(lblAdress, 0, 1);

		Label lblStartDato = new Label("Start dato :");
		pane.add(lblStartDato, 0, 2);
		
		Label lblSlutDato = new Label("Slut dato :");
		pane.add(lblSlutDato, 0, 3);

		Label lblPris = new Label("Pris :");
		pane.add(lblPris, 0, 4);

		pane.add(this.txfNavn, 1, 0);
		this.txfNavn.setPrefWidth(200);

		pane.add(this.txfAdresse, 1, 1);
		this.txfAdresse.setPrefWidth(200);

		datePickerIn = new DatePicker();
		datePickerOut = new DatePicker();
		
		pane.add(datePickerIn, 1, 2);
		this.datePickerIn.setPrefWidth(200);
		
		pane.add(datePickerOut, 1, 3);
		this.datePickerOut.setPrefWidth(200);

		pane.add(this.txfPris, 1, 4);
		this.txfPris.setPrefWidth(200);

		Button btnCancel = new Button("Annuller");
		pane.add(btnCancel, 1, 6);
		GridPane.setHalignment(btnCancel, HPos.RIGHT);
		btnCancel.setOnAction(event -> this.cancelAction());

		Button btnOK = new Button("OK");
		pane.add(btnOK, 0, 6);
		GridPane.setHalignment(btnOK, HPos.RIGHT);
		btnOK.setOnAction(event -> this.okAction());
		

		pane.add(this.lblErrorNavn, 0, 5);
		this.lblErrorNavn.setStyle("-fx-text-fill: red");
		pane.add(this.lblErrorAdresse, 0, 5);
		this.lblErrorAdresse.setStyle("-fx-text-fill: red");
		pane.add(this.lblErrorDato, 0, 5);
		this.lblErrorDato.setStyle("-fx-text-fill: red");
		pane.add(this.lblErrorPris, 0, 5);
		this.lblErrorPris.setStyle("-fx-text-fill: red");

		this.initControls();
	}

	// ---------------- \\

	private void initControls() {
		if (this.konference != null) {
			this.txfNavn.setText(this.konference.getNavn());
			this.txfAdresse.setText(this.konference.getAdresse());
			this.txfStartDato.setText(this.konference.getDato());
			this.txfSlutDato.setText(this.konference.getDato());
		} else {
			this.txfNavn.clear();
			this.txfAdresse.clear();
			this.txfStartDato.clear();
			this.txfSlutDato.clear();
		}
	}

	private void okAction() {
		String konferenceNavn = this.txfNavn.getText().trim();
		String konferenceAdresse = this.txfAdresse.getText().trim();
		LocalDate konferenceStartDato = datePickerIn.getValue();
		LocalDate konferenceSlutDato = datePickerOut.getValue();
		int konferencePris = Integer.valueOf(txfPris.getText());

		// Name of Company is empty
		if (konferenceNavn.length() == 0) {
			this.lblErrorNavn.setText("Name is empty");
			return;
		} else if (konferenceNavn.length() >= 1) {
			this.lblErrorNavn.setVisible(false);
		}

		// Adress of Company is empty
		if (konferenceAdresse.length() == 0) {
			this.lblErrorAdresse.setText("Adress is empty");
			return;
		} else if (konferenceAdresse.length() >= 1) {
			this.lblErrorAdresse.setVisible(false);
		}

		// Dato ikke sat
		if (konferenceSlutDato.isBefore(konferenceStartDato)) {
			this.lblErrorDato.setText("Forkert slut dato");
			datePickerOut.requestFocus();
			return;
		} else if (konferenceStartDato.isAfter(konferenceSlutDato)) {
			datePickerOut.requestFocus();
			return;
		} 

		// Cvr of Company is empty
		if (konferencePris == 0) {
			this.lblErrorPris.setText("Konference er gratis");
			return;
		} else {
			this.lblErrorPris.setVisible(false);
		}

		if (this.konference != null) {
			controller.redigerKonference(this.konference, konferenceNavn, konferenceAdresse, konferenceStartDato, konferenceSlutDato, konferencePris);
		} else {
			controller.opretKonference(konferenceNavn, konferenceAdresse, konferenceStartDato, konferenceSlutDato, konferencePris);
			
		}

		// hide
		this.hide();
	}

	private void cancelAction() {
		this.hide();
	}

}
