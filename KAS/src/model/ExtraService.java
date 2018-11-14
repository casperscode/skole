package model;

public class ExtraService {
	private String navn;
	private String beskrivelse;
	private double pris;
	private Hotel hotel;

	public ExtraService(String navn, double pris, Hotel hotel) {
		Pre.require(hotel != null);
		Pre.require(navn != null);
		Pre.require(pris >= 0);
		this.navn = navn;
		this.pris = pris;
		this.hotel = hotel;
		hotel.addExtraservice(this);
	}

	public String getBeskrivelse() {
		return beskrivelse;
	}

	public void setBeskrivelse(String beskrivelse) {
		this.beskrivelse = beskrivelse;
	}

	public String toString() {
		return "" + navn + pris;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		Pre.require(this.hotel != null);
		this.hotel = hotel;
		hotel.addExtraservice(this);
	}

	public double getPris() {
		return pris;
	}
}
