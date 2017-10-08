package pl.atena.edu.akademia3;

import pl.atena.edu.akademia2.Osoba;

public class Firma {
	public static final Osoba PREZES=new Osoba();

	static {
		PREZES.setImie("Tomasz");
		PREZES.setNazwisko("Pszczolka");
	}

	public static void main(final String[] argc) {
		System.out.println(Firma.PREZES.getImie()+" "+Firma.PREZES.getNazwisko());
		System.out.println(Firma.PREZES);

	}
}
