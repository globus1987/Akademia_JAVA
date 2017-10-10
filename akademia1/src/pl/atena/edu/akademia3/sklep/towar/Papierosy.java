package pl.atena.edu.akademia3.sklep.towar;

import java.math.BigDecimal;

public class Papierosy extends Towar {

	public Papierosy() {
		// TODO Auto-generated constructor stub
		this.nazwa=RodzajTowaru.Papierosy;
		this.cena=BigDecimal.valueOf(113.50);
		this.ilosc=Integer.valueOf(0);

	}
	@Override
	public Boolean dlaPelnoletnich() {
		return true;
	}
}
