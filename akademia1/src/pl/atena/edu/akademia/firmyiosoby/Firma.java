package pl.atena.edu.akademia.firmyiosoby;

import pl.atena.edu.akademia3.sklep.OsobaFizyczna;

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
