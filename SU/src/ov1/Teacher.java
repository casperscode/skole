package ov1;

public class Teacher extends Person{
	
	private double Salery;
	
	
	public Teacher(String name, String addresse, String qual) {
		super(name, addresse, qual);
		Salery = 100000;
	}
	
	public double getSalery() {
		return Salery;
	}
	
	public void udskrivPerson() {
		super.udskrivPerson();
		System.out.println("Navn: " + getName());
		System.out.println("Adresse: " + address);
		System.out.println("Kvalifikation: " + qualification);
	}
	
	public double yearSalery() {
		double yearSalery1 = getSalery();
		yearSalery1 = yearSalery1*1.125;
		return yearSalery1;
	}
}
