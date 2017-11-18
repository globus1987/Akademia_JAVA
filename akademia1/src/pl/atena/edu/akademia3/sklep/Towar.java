package pl.atena.edu.akademia3.sklep;

import java.math.BigDecimal;

public class Towar implements Produkt {
	protected RodzajTowaru nazwa;
	protected BigDecimal cena;
	protected Integer ilosc;

	public void setCenaPromocyjna(final BigDecimal cena) {
		this.cena = this.cena.multiply((BigDecimal.valueOf(100).subtract(cena)).divide(BigDecimal.valueOf(100))).setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	public Towar() {
		this.ilosc = Integer.valueOf(0);
	}
	public Towar(final RodzajTowaru rodzaj) {
		this.ilosc = Integer.valueOf(0);
		this.nazwa=rodzaj;
		this.cena=rodzaj.getCenaBazowa();
	}
	public void dostarczTowar(final Integer ilosc) {
		if (ilosc != null) {
			this.ilosc += ilosc;
		}

	}

	public BigDecimal getCena() {
		return this.cena;
	}

	public void sprzedajTowar(final Integer ilosc) {
		if (ilosc != null) {
			this.ilosc -= ilosc;
		}

	}

	public Integer podajIloscTowaru() {
		return this.ilosc;
	}

	@Override
	public String toString() {
		return String.format("Towar [nazwa=%s, cena=%s, ilosc=%s, %s\n]", this.nazwa, this.cena, this.ilosc,this.nazwa.tekst());
	}

	@Override
	public RodzajTowaru nazwaProduktu() {

		return this.nazwa;
	}

	@Override
	public Boolean dlaPelnoletnich() {
		return this.nazwa.getDlaPelnoletnich();
	};
}
