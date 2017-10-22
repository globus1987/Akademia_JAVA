package pl.atena.edu.akademia3.sklep.towar;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @author Arkadiusz
 *
 */
abstract public class SklepNowy {
	protected String nazwaSklepu;
	private static Scanner scanner = new Scanner(System.in);
	protected ListaTowarow listaZatowarowania;

	public ListaTowarow getListaZatowarowania() {
		return this.listaZatowarowania;
	}

	private void setListaZatowarowania(final ListaTowarow listaZatowarowania) {
		this.listaZatowarowania = listaZatowarowania;
	}

	/**
	 * konstruktor z domyœlnym 0 stanu magazynowego
	 */
	public SklepNowy() {
		this.nazwaSklepu = "sklep pusty na starcie";
		this.listaZatowarowania = new ListaTowarow();
	}

	/**
	 * @param osoba
	 *            sprawdzany klient
	 * @return informacja czy klient jest pe³noletni
	 */
	private boolean sprawdzPelnoletnoscKlienta(final OsobaFizyczna osoba) {
		return osoba.pelnoletni();
	}

	/**
	 * @param iloscPiwaDoZakupu
	 *            zadana liczba piw do zakupu
	 * @return informacja czy w magazynie jest wystarczaj¹co du¿o piw
	 */
	private boolean sprawdzStanMagazynowy(final Towar towarDoZakupu, final Integer iloscTowaruDoZakupu) {
		if (towarDoZakupu.podajIloscTowaru().compareTo(iloscTowaruDoZakupu) <= 0) {
			System.out.println("Nie mamy tyle w magazynie");
			return false;
		} else {
			System.out.println("Mamy tak¹ iloœæ");
			return true;
		}
	}

	public void dostawa() {
		for (Towar towar : this.listaZatowarowania.getTowary()) {
			System.out.println("ile " + towar.nazwaProduktu() + "?");
			Integer n = Integer.valueOf(0);
			try {
				n = Integer.valueOf(scanner.nextLine());
			} catch (Exception e) {
				System.out.println("B³êdne dane!!!");
			}
			if (n.compareTo(0) > 0) {
				towar.dostarczTowar(n);
			} else if (n.compareTo(0) == 0) {
			} else {
				System.out.println("B³êdne dane!!!");
			}
		}
	}

	public void procesSprzedazy(final OsobaFizyczna klient) {
		BigDecimal sumaDoZap³aty = BigDecimal.valueOf(0);
		for (Towar towar : this.listaZatowarowania.getTowary()) {
			System.out.println("ile " + towar.nazwaProduktu() + " chce kupiæ klient?");
			Integer n = Integer.valueOf(0);
			try {
				n = Integer.valueOf(scanner.nextLine());
			} catch (Exception e) {
				System.out.println("B³êdne dane!!!");
			}
			if (n.compareTo(0) == 0) {
				continue;
			}
			if (this.walidujZakup(klient, towar, n)) {
				this.sprzedajTowar(klient, towar, n);
				BigDecimal bdn = new BigDecimal(n);
				sumaDoZap³aty = sumaDoZap³aty.add(towar.getCena().multiply(bdn));
			}
		}
		System.out.println("poproszê " + sumaDoZap³aty + " z³");
	}

	private boolean walidujZakup(final OsobaFizyczna klient, final Towar towarDoZakupu, final Integer iloscDoZakupu) {
		if (!this.walidujZakupPelnoletnosci(klient, towarDoZakupu)) {
			return false;
		}
		if (!this.sprawdzStanMagazynowy(towarDoZakupu, iloscDoZakupu)) {
			return false;
		}
		return true;
	}

	private void sprzedajTowar(final OsobaFizyczna klient, final Towar towarDoZakupu, final Integer iloscDoZakupu) {
		klient.KupTowar(towarDoZakupu, iloscDoZakupu);
		towarDoZakupu.sprzedajTowar(iloscDoZakupu);
	}

	private boolean walidujZakupPelnoletnosci(final OsobaFizyczna klient, final Towar towarDoZakupu) {
		if (klient.pelnoletni() && towarDoZakupu.dlaPelnoletnich()) {
			return true;
		} else if (!towarDoZakupu.dlaPelnoletnich()) {
			return true;
		} else {
			System.out.println("jesteœ niepe³noletni!!! Spadaj");
			return false;
		}
	}

	abstract void promocja();

	void ustalPromocja() {
		// TODO Auto-generated method stub
		for (Towar towar : this.listaZatowarowania.getTowary()) {
			System.out.println("podaj kwotê promocji dla " + towar.nazwa + " w sklepie " + this.nazwaSklepu);
			towar.setCenaPromocyjna(BigDecimal.valueOf(5));
		}
	}

	@Override
	public String toString() {
		return String.format("SklepNowy [nazwaSklepu=%s,\ntowary=\n%s\n]", this.nazwaSklepu, this.listaZatowarowania);
	}

}
