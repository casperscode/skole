package gui;

import model.Hotel;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class HotelVindue extends Stage {

	private Hotel hotel;

	public HotelVindue(String title, Hotel hotel) {
		this.initStyle(StageStyle.UTILITY);
		this.initModality(Modality.APPLICATION_MODAL);
		this.setResizable(false);

		this.hotel = hotel;

		this.setTitle(title);
		GridPane pane = new GridPane();
		//this.initContent(pane);

		Scene scene = new Scene(pane);
		this.setScene(scene);
	}

	public HotelVindue(String title) {
		this(title, null);
	}

}
