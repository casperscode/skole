package model;

import model.Hotel;

import java.util.ArrayList;

import model.ExtraService;

public class Tilmelding {

	private Hotel hotel;
	private Deltager delt;
	private Konference konf;
	private ArrayList<ExtraService> extra = new ArrayList<>();

	public Tilmelding(Hotel hotel, Deltager deltager, Konference konference) {
		this.hotel = hotel;
		this.delt = deltager;
		this.konf = konference;
	}

	public void setDelt(Deltager deltager) {
		this.delt = deltager;
	}

	public void setExtras(ExtraService extra) {
		this.extra.add(extra);
	}

	public ArrayList<ExtraService> getExtras() {
		return extra;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public Deltager getDelt() {
		return delt;
	}

	public Konference getKonf() {
		return konf;
	}

}