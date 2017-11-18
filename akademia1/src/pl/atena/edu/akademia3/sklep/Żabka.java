package pl.atena.edu.akademia3.sklep;

import java.math.BigDecimal;

public class ¯abka extends SklepNowy {

	public ¯abka() {
		super();
		this.nazwaSklepu = "¿abka";
	}

	@Override
	void promocja() {
		for (Towar towar : this.listaZatowarowania.getTowary()) {
			switch (towar.nazwa) {
			case Maslo:
				towar.setCenaPromocyjna(BigDecimal.valueOf(10));
				break;
			case Mleko:
				towar.setCenaPromocyjna(BigDecimal.valueOf(15));
				break;
			case Papierosy:
				towar.setCenaPromocyjna(BigDecimal.valueOf(20));
				break;
			case Piwo:
				towar.setCenaPromocyjna(BigDecimal.valueOf(25));
				break;
			case Jogurt:
				towar.setCenaPromocyjna(BigDecimal.valueOf(30));
				break;
			}
		}
	}

}
