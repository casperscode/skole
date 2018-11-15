package gui;

import model.Hotel;
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

public class HotelPane extends GridPane {

	// --- These are the Fields for the Company class --- \\

	private final TextField txfHotelNavn = new TextField();
	private final TextField txfAdresse = new TextField();
	private final TextArea txaExtraServices = new TextArea();
	private final ListView<Hotel> lvwHoteller = new ListView<>();

	// --- --- \\

	public HotelPane() {
		this.setPadding(new Insets(20));
		this.setHgap(20);
		this.setVgap(10);
		this.setGridLinesVisible(false);

		// --- These are the labels for the Company class --- \\

		Label lblHotels = new Label("Hoteller :");
		this.add(lblHotels, 0, 0);

		Label lblHotelName = new Label("Navn :");
		this.add(lblHotelName, 1, 1);

		Label lblAdress = new Label("Adresse :");
		this.add(lblAdress, 1, 2);
		
		Label lblExtraService = new Label("Extra Services :");
		this.add(lblExtraService, 1, 3); 
		GridPane.setValignment(lblExtraService, VPos.BASELINE);
		lblExtraService.setPadding(new Insets(4, 0, 4, 0));

		// Listview til hoteller

		this.add(this.lvwHoteller, 0, 1, 1, 4);
		this.lvwHoteller.setPrefWidth(200);
		this.lvwHoteller.setPrefHeight(250);

		ChangeListener<Hotel> listener = (ov, oldH, newH) -> this.selectedCompanyChanged();
		this.lvwHoteller.getSelectionModel().selectedItemProperty().addListener(listener);

		// felter til hotel pane

		this.add(this.txfHotelNavn, 2, 1);
		this.txfHotelNavn.setEditable(false);

		this.add(this.txfAdresse, 2, 2);
		this.txfAdresse.setEditable(false);

		this.add(this.txaExtraServices, 2, 3);
		this.txaExtraServices.setPrefWidth(200);
		this.txaExtraServices.setPrefHeight(130);
		this.txaExtraServices.setEditable(false);

		// Knapper til hotel pane

		HBox hbxButtons = new HBox(10);
		this.add(hbxButtons, 0, 5, 3, 1);
		hbxButtons.setPadding(new Insets(10, 0, 0, 0));
		hbxButtons.setAlignment(Pos.BASELINE_RIGHT);

		Button btnAddParticipant = new Button("Tilf�j");
		hbxButtons.getChildren().add(btnAddParticipant);
		btnAddParticipant.setOnAction(event -> this.addAction());

		Button btnUpdateParticipant = new Button("Rediger");
		hbxButtons.getChildren().add(btnUpdateParticipant);

		Button btnDeleteParticipant = new Button("Slet");
		hbxButtons.getChildren().add(btnDeleteParticipant);

		if (this.lvwHoteller.getItems().size() > 0) {
			this.lvwHoteller.getSelectionModel().select(0);
		}
	}

	// ----------------------------------------------------------- \\

	public void addAction() {
		HotelVindue hotelVindue = new HotelVindue("Tilf�j Hotel");
		hotelVindue.showAndWait();
	}

	private void selectedCompanyChanged() {
		this.updateControls();
	}

	public void updateControls() {
		Hotel ar1 = this.lvwHoteller.getSelectionModel().getSelectedItem();
		if (ar1 != null) {
			this.txfHotelNavn.setText(ar1.getHotel());
			this.txfAdresse.setText(ar1.getAdresse());
			//this.txfTelephone.setText(ar1.getTelephone());
		} else {
			this.txfHotelNavn.clear();
			this.txfAdresse.clear();
			//this.txfTelephone.clear();
		}

	}
	
}