package model;

import java.util.ArrayList;

public class Ledsager {
	private String navn;
	private String adresse;
	private Deltager deltager;
	private static ArrayList<Udflugt> tilmeldtUdflugter = new ArrayList<>();

	public Ledsager(String navn, String adresse, Deltager deltager) {
		Pre.require(navn != null && adresse != null && deltager != null);
		this.navn = navn;
		this.adresse = adresse;
		this.deltager = deltager;
		deltager.setLedsager(this);

	}

	public void deltagUdflugt(Udflugt udflugt) {
		if (!tilmeldtUdflugter.contains(udflugt)) {
			tilmeldtUdflugter.add(udflugt);
			udflugt.addLedsager(this);
		}

	}

	public void AfmeldUdflugt(Udflugt udflugt) {
		Udflugt.removeLedsager(this);
	}

	public ArrayList<Udflugt> getTilmeldtUdflugter() {
		return tilmeldtUdflugter;
	}

}
