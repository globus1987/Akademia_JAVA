package pl.atena.edu.akademia3.sklep.towar;

import java.math.BigDecimal;

public class Towar implements Produkt {
	protected RodzajTowaru nazwa;
	protected BigDecimal cena;
	protected Integer ilosc;
	public Towar() {
		this.ilosc=Integer.valueOf(0);
	}

	public void dostarczTowar(final Integer ilosc) {
		if (ilosc!=null) {
			this.ilosc+=ilosc;
		}

	}
	@Override
	public String toString() {
		return String.format("Towar [nazwa=%s, cena=%s, ilosc=%s]\n", this.nazwa, this.cena, this.ilosc);
	}

	@Override
	public RodzajTowaru nazwaProduktu() {
		return this.nazwa;
	}

}
