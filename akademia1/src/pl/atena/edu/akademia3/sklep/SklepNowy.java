package pl.atena.edu.akademia3.sklep;

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * @author Arkadiusz
 *
 */
abstract public class SklepNowy {
	protected String nazwaSklepu;
	private static Scanner scanner = new Scanner(System.in);
	protected ListaTowarow listaZatowarowania;
	private static Logger logger = Logger.getLogger("Sklep");


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
	private void sprawdzStanMagazynowy(final Towar towarDoZakupu, final Integer iloscTowaruDoZakupu) {
		if (towarDoZakupu.podajIloscTowaru().compareTo(iloscTowaruDoZakupu) < 0) {
			throw new IllegalArgumentException("Nie mamy tyle na stanie.");
		}
	}

	public void dostawa() {
		for (Towar towar : this.listaZatowarowania.getTowary()) {
			System.out.println("ile " + towar.nazwaProduktu() + "?");
			Integer n = Integer.valueOf(0);
			try {
				n = Integer.valueOf(scanner.nextLine());
			} catch (Exception e) {
				Logger.getGlobal().severe("B³êdne dane!!! Nie podano liczby");
			}
			assert n.compareTo(0) >= 0:n;
			if (n.compareTo(0) > 0) {
				towar.dostarczTowar(n);
			} else if (n.compareTo(0) == 0) {
			} else {
				Logger.getGlobal().severe("B³êdne dane!!! Nie podano liczby");
			}
		}
	}

	public void procesSprzedazy(final OsobaFizyczna klient) throws UnderAgeException {
		BigDecimal sumaDoZap³aty = BigDecimal.valueOf(0);
		for (Towar towar : this.listaZatowarowania.getTowary()) {
			System.out.println("ile " + towar.nazwaProduktu() + " chce kupiæ klient?");
			Integer n = Integer.valueOf(0);
			try {
				n = Integer.valueOf(scanner.nextLine());
			} catch (Exception e) {
				Logger.getGlobal().severe("B³êdne dane!!! Nie podano liczby");
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
		try {
			this.walidujZakupPelnoletnosciZWyjatkiem(klient, towarDoZakupu);
		} catch (UnderAgeException e) {
			System.out.println(e.getMessage());
			return false;
		}
		try {
			this.sprawdzStanMagazynowy(towarDoZakupu, iloscDoZakupu);
		}catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
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
	private void walidujZakupPelnoletnosciZWyjatkiem(final OsobaFizyczna klient, final Towar towarDoZakupu) throws UnderAgeException{
		if (!klient.pelnoletni() && towarDoZakupu.dlaPelnoletnich())
		{
			throw new UnderAgeException("Jesteœ niepe³noletni!!! "+klient.getImie()+" "+klient.getNazwisko()+" chce kupiæ "+towarDoZakupu.nazwaProduktu());
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
