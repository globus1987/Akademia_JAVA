package pl.atena.edu.akademia3.sklep;

import java.math.BigDecimal;

public class Biedronka extends SklepNowy {

	public Biedronka() {
		super();
		this.nazwaSklepu = "biedronka";
	}
	@Override
	void promocja() {
		for (Towar towar : this.listaZatowarowania.getTowary()) {
			switch (towar.nazwa) {
			case Maslo:
				towar.setCenaPromocyjna(BigDecimal.valueOf(1));
				break;
			case Mleko:
				towar.setCenaPromocyjna(BigDecimal.valueOf(2));
				break;
			case Papierosy:
				towar.setCenaPromocyjna(BigDecimal.valueOf(3));
				break;
			case Piwo:
				towar.setCenaPromocyjna(BigDecimal.valueOf(4));
				break;
			case Jogurt:
				towar.setCenaPromocyjna(BigDecimal.valueOf(5));
				break;
			}
		}
	}

}
