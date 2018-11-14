package storage;

import java.util.ArrayList;
import model.Konference;
import model.Udflugt;
import model.Deltager;
import model.Hotel;
import tests.test1;

public class Storage {
	
	private static final ArrayList<Konference> Konferencer = new ArrayList<>();
	private static final ArrayList<Hotel> Hoteller = new ArrayList<>();
	private static final ArrayList<Udflugt> Udflugter = new ArrayList<>();
	private static final ArrayList<Deltager> Deltagere = new ArrayList<>();
	
	public static ArrayList<Konference> getKonferencer() {
		return new ArrayList<Konference>(Konferencer);
	}
	
	public static void addKonference(Konference konference) {
		Konferencer.add(konference);
	}
	
	public static void removeKonference(Konference konference) {	
		Konferencer.remove(konference);
	}
	
	public static ArrayList<Hotel> getHoteller() {
		return new ArrayList<Hotel>(Hoteller);
	}
	
	public static void addHoteller(Hotel hotel) {
		Hoteller.add(hotel);
	}
	
	public static void removeHoteller(Hotel hotel) {
		Hoteller.remove(hotel);
	}
	
	public static ArrayList<Udflugt> getUdflugter() {
		return new ArrayList<Udflugt>(Udflugter);
	}
	
	public static void addUdflugter(Udflugt udflugt) {
		Udflugter.add(udflugt);
	}
	
	public static void removeUdflugter(Udflugt udflugt) {
		Udflugter.remove(udflugt);
	}
	
	public static ArrayList<Deltager> getDeltagere() {
		return new ArrayList<Deltager>(Deltagere);
	}
	
	public static void addDeltager(Deltager deltager) {
		Deltagere.add(deltager);
	}
	
	public static void removeDeltager(Udflugt deltager) {
		Deltagere.remove(deltager);
	}
	
	
	

}
