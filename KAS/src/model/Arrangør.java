package model;

import storage.Storage;
import model.Konference;

public class Arrangør {
	
	private String navn;
	private Konference konf;
	private String adresse;

	public Arrangør(String navn, Konference konf) {
		this.navn = navn;
		this.konf = konf;
	}
	
	public String getName() {
		return this.navn;
	}

	public Konference getTelephone() {
		return this.konf;
	}

	public String getAdresse() {
		return this.adresse;
	}
	
}
