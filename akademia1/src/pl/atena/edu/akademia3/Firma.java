package pl.atena.edu.akademia3;

import pl.atena.edu.akademia2.Gracz;

public class Firma {
	public static final Gracz PREZES=new Gracz();

	static {
		PREZES.setImie("Tomasz");
		PREZES.setNazwisko("Pszczolka");
	}

	public static void main(final String[] argc) {
		System.out.println(Firma.PREZES.getImie()+" "+Firma.PREZES.getNazwisko());
	}
}
