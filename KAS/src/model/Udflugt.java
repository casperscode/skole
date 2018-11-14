package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Udflugt {
	private String lokation;
	private String dato;
	public static ArrayList<Ledsager> DeltagendeLedsagere = new ArrayList<>();
	private String navn;
	private Konference konference;
	private double pris;

	public Udflugt(String Lokation, String dato, String navn, Konference konference, int pris) {
		Pre.require(navn != null && Lokation != null);
		Pre.require(konference != null);

		this.lokation = Lokation;
		this.navn = navn;
		this.konference = konference;
		this.pris = pris;
		this.dato = dato;
	}

	public double getPris() {
		return pris;
	}

	public String toString() {
		String returnString = "Udflugt: \n" + "Navn: " + navn + " " + lokation + "pris: " + pris;
		return returnString;
	}

	public static ArrayList<Ledsager> getTilmeldte(Udflugt udflugt) {
		return DeltagendeLedsagere;
	}

	public void addLedsager(Ledsager ledsager) {
		if (!DeltagendeLedsagere.contains(ledsager)) {
			Pre.require(ledsager != null);
			DeltagendeLedsagere.add(ledsager);
			ledsager.deltagUdflugt(this);
		}
	}

	public static void removeLedsager(Ledsager ledsager) {
		Pre.require(ledsager != null);
		DeltagendeLedsagere.remove(ledsager);
	}

}
