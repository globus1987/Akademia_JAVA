package pl.atena.edu.akademia3.sklep.towar;

import java.math.BigDecimal;

public class Piwo extends Towar {

	public Piwo() {
		// TODO Auto-generated constructor stub
		this.nazwa=RodzajTowaru.Piwo;
		this.cena=BigDecimal.valueOf(1.50);
		this.ilosc=Integer.valueOf(0);

	}
	@Override
	public Boolean dlaPelnoletnich() {
		return true;
	}
}
