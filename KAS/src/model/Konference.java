package model;

import java.time.LocalDate;
import java.time.Period;

public class Konference {

	private static String lokation;
	private static int pris;
	private static LocalDate startDato;
	private static LocalDate slutDato;
	private static String navn;
//	private static final ArrayList<Arrangør> Konferencer = new ArrayList<>();
//	private static final ArrayList<Hotel> Hoteller = new ArrayList<>();
//	private static final ArrayList<Udflugt> Udflugter = new ArrayList<>();
//	private static final ArrayList<Deltager> Deltagere = new ArrayList<>();

	public Konference(String navn, String lokation, LocalDate startDato, LocalDate slutDato, int pris ) {
		Pre.require(pris >= 0);
		Pre.require(startDato.isBefore(slutDato));
		Pre.require(navn != null && lokation != null);

		this.lokation = lokation;
		this.pris = pris;
		this.startDato = startDato;
		this.slutDato = slutDato;
		this.navn = navn;

	}

	public String toString() {
		String returString = "Navn: " + navn + "\nAdresse: " + lokation + "\nDato: " + startDato
				+ " til " + slutDato + "\nPris: " + pris+"Kr";
		return returString;
	}

	public int getPris() {
		return pris;
	}
	
	public String getNavn() {
		return this.navn;
	}
	
	public String getDato() {
		String dato = startDato+" til "+slutDato;
		return dato;
	}
	
	public String getAdresse() {
		return this.lokation;
	}

}
