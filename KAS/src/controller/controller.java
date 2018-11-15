package controller;

import java.time.LocalDate;
import java.util.ArrayList;

import model.Deltager;
import model.ExtraService;
import model.Konference;
import model.Pre;
import model.Udflugt;
import gui.KonfPane;
import storage.Storage;

public class controller {

	public static double beregnpris(Deltager deltager) {
		Pre.require(deltager != null);
		double samletpris = 0;
		if (deltager.isForedragsholder() != true) {
			samletpris += deltager.getTilmeding().getKonf().getPris() * deltager.getPeriod();
			System.out.println("konf pris: " + samletpris);
		}
		for (ExtraService service : deltager.getTilmeding().getExtras()) {
			samletpris += service.getPris() * (deltager.getPeriod() - 1);
			System.out.println("extra pris: " + samletpris);
		}
		if (deltager.getLedsager() != null) {
			if (deltager.getLedsager().getTilmeldtUdflugter() != null) {
				for (Udflugt udflugt : deltager.getLedsager().getTilmeldtUdflugter()) {
					samletpris += udflugt.getPris();
					System.out.println("udflugts pris: " + samletpris);
				}
			}
		}

		if (deltager.getTilmeding().getHotel() != null) {
			if (deltager.getLedsager() == null) {
				samletpris += deltager.getTilmeding().getHotel().getPris() * (deltager.getPeriod() - 1);
				System.out.println("pris single: " + samletpris);
			} else {
				samletpris += deltager.getTilmeding().getHotel().getPrisDouble() * (deltager.getPeriod() - 1);
				System.out.println("pris double: " + samletpris);
			}
		}

		return samletpris;
	}
	
	public static Konference redigerKonference(Konference konference, String konferenceNavn, String konferenceAdresse, LocalDate konferenceStartDato, LocalDate konferenceSlutDato, int konferencePris) {
		return null;
	}
	
	
	public static Konference opretKonference(String navn, String lokation, LocalDate startDato, LocalDate slutDato, int pris) {
		Konference konference = new Konference(navn, lokation, startDato, slutDato, pris);
		System.out.println(Storage.getKonferencer());
		Storage.addKonference(konference);
		System.out.println(Storage.getKonferencer());
		KonfPane.updateList(Storage.getKonferencer());
		return konference;
	}
	
	public static ArrayList<Konference> getKonferencer() {
		return Storage.getKonferencer();
	}
	
}