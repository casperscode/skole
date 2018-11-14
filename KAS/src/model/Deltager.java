package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import model.Ledsager;

public class Deltager {
	
	private String navn;
	private String adresse;
	private String firma;
	private boolean foredragsholder;
	private Ledsager ledsager;
	private int status;
	private ArrayList<Konference> konferencer = new ArrayList<>();
	private Tilmelding tilmelding;
	private LocalDate startDato;
	private LocalDate slutDato;
	
	public Deltager(String navn, String firma, boolean foredragsholder, Ledsager ledsager, int status,
			Tilmelding tilmelding, LocalDate startDato, LocalDate slutDato) {
		Pre.require(firma != null && navn != null && firma != null);

		this.navn = navn;
		this.adresse = adresse;
		this.firma = firma;
		this.foredragsholder = foredragsholder;
		this.ledsager = ledsager;
		this.status = status;
		this.tilmelding = tilmelding;
		this.startDato = startDato;
		this.slutDato = slutDato;

	}

//	public void setKonferencer(Konference konference) {
//		if(!konferencer.contains(konference)) {
//			konferencer.add(konference);
//			konference.tilmeldDeltager(this);
//		}
//		konferencer.add(konference);
//	}

	public Ledsager getLedsager() {
		return ledsager;
	}

	public void setLedsager(Ledsager ledsager) {
		this.ledsager = ledsager;
	}

	public Tilmelding getTilmeding() {
		return tilmelding;
	}

	public long getPeriod() {
		long dage = this.startDato.until(slutDato, ChronoUnit.DAYS) + 1;
		return dage;

	}

	public boolean isForedragsholder() {
		return foredragsholder;
	}

}
