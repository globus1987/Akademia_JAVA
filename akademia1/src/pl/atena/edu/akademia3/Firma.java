package pl.atena.edu.akademia3;

import pl.atena.edu.akademia3.sklep.towar.OsobaFizyczna;

public class Firma {
	public static final OsobaFizyczna PREZES=new OsobaFizyczna();

	static {
		PREZES.setImie("Tomasz");
		PREZES.setNazwisko("Pszczolka");
	}

	public static void main(final String[] argc) {
		System.out.println(Firma.PREZES.getImie()+" "+Firma.PREZES.getNazwisko());
		System.out.println(Firma.PREZES);

	}
}
