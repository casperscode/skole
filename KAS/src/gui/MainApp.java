package gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("KAS");
		BorderPane pane = new BorderPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	// -------------------------------------------------------------------------

	private void initContent(BorderPane pane) {
		TabPane tabPane = new TabPane();
		this.initTabPane(tabPane);
		pane.setCenter(tabPane);
	}

	private void initTabPane(TabPane tabPane) {
		tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);

		Tab tabKonf = new Tab("Konference");
		tabPane.getTabs().add(tabKonf);

		KonfPane konfPane = new KonfPane();
		tabKonf.setContent(konfPane);
		tabKonf.setOnSelectionChanged(event -> konfPane.updateControls());
/*
		Tab tabParticipant = new Tab("Participant");
		tabPane.getTabs().add(tabParticipant);

		ParticipantPane ParticipantPane = new ParticipantPane();
		tabParticipant.setContent(ParticipantPane);
		tabParticipant.setOnSelectionChanged(event -> ParticipantPane.updateControls());

		// ----- //

		Tab tabCompanies = new Tab("Companies");
		tabPane.getTabs().add(tabCompanies);

		CompanyPane companyPane = new CompanyPane();
		tabCompanies.setContent(companyPane);
		tabCompanies.setOnSelectionChanged(event -> companyPane.updateControls());
*/
		// ----- //

		Tab tabHotel = new Tab("Hotel");
		tabPane.getTabs().add(tabHotel);

		HotelPane HotelPane = new HotelPane();
		tabHotel.setContent(HotelPane);
		tabHotel.setOnSelectionChanged(event -> HotelPane.updateControls());

	}

}
