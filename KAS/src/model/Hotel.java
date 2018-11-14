package model;

import java.util.ArrayList;

public class Hotel {
	private String navn;
	private String adresse;
	private double pris;
	private double prisDouble;
	private final ArrayList<ExtraService> services = new ArrayList<>();

	public Hotel(String navn, String adresse, double pris, double prisDouble) {
		this.navn = navn;
		this.adresse = adresse;
		this.pris = pris;
		this.prisDouble = prisDouble;
	}

	public String toString() {
		return "" + navn + adresse + pris + prisDouble;

	}

	public ArrayList<ExtraService> getservices() {
		return new ArrayList<>(services);
	}
	
	public String getHotel() {
		return this.navn;
	}
	
	public String getAdresse() {
		return this.adresse;
	}

	public void addExtraservice(ExtraService service) {
		if (!services.contains(service)) {
			Pre.require(service.getHotel() != null);
			services.add(service);
			service.setHotel(this);
		}
	}

	public double getPris() {
		double pris = 0;
		pris += this.getPrisExtraService() + this.pris;
		return pris;
	}
	
	public double getPrisDouble() {
		return prisDouble;
	}

	public double getPrisExtraService() {
		double ExtraServicePris = 0;
		for (ExtraService extraService : services) {
			ExtraServicePris += extraService.getPris();

		}
		return ExtraServicePris;
	}

}
