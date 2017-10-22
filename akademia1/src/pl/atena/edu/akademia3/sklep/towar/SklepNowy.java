package pl.atena.edu.akademia3.sklep.towar;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @author Arkadiusz
 *
 */
public class SklepNowy {
	private String nazwaSklepu;
	private static Scanner scanner = new Scanner(System.in);
	private ListaTowarow listaZatowarowania;

	public ListaTowarow getListaZatowarowania() {
		return this.listaZatowarowania;
	}

	public void setListaZatowarowania(final ListaTowarow listaZatowarowania) {
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

	private void dostawa() {
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

	public boolean walidujZakup(final OsobaFizyczna klient, final Towar towarDoZakupu, final Integer iloscDoZakupu) {
		if (!this.walidujZakupPelnoletnosci(klient, towarDoZakupu)) {
			return false;
		}
		if (!this.sprawdzStanMagazynowy(towarDoZakupu, iloscDoZakupu)) {
			return false;
		}
		return true;
	}

	public void sprzedajTowar(final OsobaFizyczna klient, final Towar towarDoZakupu, final Integer iloscDoZakupu) {
		klient.KupTowar(towarDoZakupu, iloscDoZakupu);
		towarDoZakupu.sprzedajTowar(iloscDoZakupu);
	}

	public boolean walidujZakupPelnoletnosci(final OsobaFizyczna klient, final Towar towarDoZakupu) {
		if (klient.pelnoletni() && towarDoZakupu.dlaPelnoletnich()) {
			return true;
		} else if (!towarDoZakupu.dlaPelnoletnich()) {
			return true;
		} else {
			System.out.println("jesteœ niepe³noletni!!! Spadaj");
			return false;
		}
	}

	public static void main(final String[] args) {

		SklepNowy sklepik = new SklepNowy();

		OsobaFizyczna klient = new OsobaFizyczna("Jan", "Nowak", 17);
		OsobaFizyczna klient2 = new OsobaFizyczna("Marek", "Kowalski", 22);

		Integer x = 0;
		do {
			System.out.println("\n1. Dostawa\n" + "2. Sprzedaj Janowi\n" + "3. Sprzedaj Markowi\n"
					+ "4. Wyœwietl stan\n" + "5. zakoñcz");
			try {
				x = Integer.valueOf(scanner.nextLine());
			} catch (Exception e) {
				System.out.println("Naucz siê korzystaæ z programu!!!");
			}
			switch (x) {
			case 1:
				sklepik.dostawa();
				break;
			case 2:
				sklepik.procesSprzedazy(klient);
				break;
			case 3:
				sklepik.procesSprzedazy(klient2);
				break;
			case 4:
				System.out.println(sklepik);
				System.out.println(klient);
				System.out.println(klient2);
				System.out.println("\n");
				break;
			default:
				break;
			}
		} while (x.compareTo(5) < 0 && x.compareTo(0) > 0);

	}

	@Override
	public String toString() {
		return String.format("SklepNowy [nazwaSklepu=%s,\ntowary=\n%s\n]", this.nazwaSklepu, this.listaZatowarowania);
	}

}
