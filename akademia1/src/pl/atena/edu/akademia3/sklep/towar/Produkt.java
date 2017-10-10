package pl.atena.edu.akademia3.sklep.towar;

public interface Produkt {
	RodzajTowaru nazwaProduktu();
	default Boolean dlaPelnoletnich() {
		return false;
	};
}
