package pl.atena.edu.akademia3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import pl.atena.edu.akademia3.sklep.towar.Jogurt;
import pl.atena.edu.akademia3.sklep.towar.Maslo;
import pl.atena.edu.akademia3.sklep.towar.Mleko;
import pl.atena.edu.akademia3.sklep.towar.Papierosy;
import pl.atena.edu.akademia3.sklep.towar.Piwo;
import pl.atena.edu.akademia3.sklep.towar.Towar;

/**
 * @author Arkadiusz
 *
 */
public class SklepNowy {
	private Integer stanMagazynowyPiwa;
	private String nazwaSklepu;
	private static Scanner scanner = new Scanner(System.in);
	private List<Towar> towary;

	/**
	 * konstruktor z domyœlnym 0 stanu magazynowego
	 */
	public SklepNowy() {
		this.nazwaSklepu = "sklep pusty na starcie";
		this.stanMagazynowyPiwa = Integer.valueOf(0);
		Jogurt jogurt = new Jogurt();
		Maslo maslo = new Maslo();
		Mleko mleko = new Mleko();
		Papierosy papierosy = new Papierosy();
		Piwo piwo = new Piwo();
		List<Towar> towaryinicjalne = new ArrayList<>();
		towaryinicjalne.add(jogurt);
		towaryinicjalne.add(maslo);
		towaryinicjalne.add(mleko);
		towaryinicjalne.add(papierosy);
		towaryinicjalne.add(piwo);
		this.towary = towaryinicjalne;
	}

	/**
	 * @param stanStartowyMagazynu
	 *            zadana iloœæ startowa piw w magazynie przy tworzeniu obiektu
	 *            sklepu
	 */
	public SklepNowy(final Integer stanStartowyMagazynu) {
		this.nazwaSklepu = "sklep z " + stanStartowyMagazynu.toString() + " na starcie";
		this.stanMagazynowyPiwa = Integer.valueOf(stanStartowyMagazynu);
	}

	/**
	 * metoda dostarczaj¹ca jedno piwo do sklepu
	 */
	private void dostarczPiwo() {
		System.out.println("Ile dostarczamy do sklepu " + this.nazwaSklepu + " ?");
		Integer n = 0;
		try {
			n = Integer.valueOf(scanner.nextLine());
		} catch (Exception e) {
			System.out.println("B³êdne dane!!!");
		}
		;
		if (n < 1) {
			System.out.println("Niepoprawna iloœæ piw do dostawy");
			return;
		}
		this.stanMagazynowyPiwa += n;
		System.out.println("Dostarczono " + n + " piw do sklepu " + this.nazwaSklepu);
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
	private boolean sprawdzStanMagazynowy(final Integer iloscPiwaDoZakupu) {
		if (this.stanMagazynowyPiwa.compareTo(iloscPiwaDoZakupu) < 0) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * metoda do sprzeda¿y jednego piwa
	 *
	 * @param osoba
	 *            obs³ugiwany klient
	 */
	private void sprzedajPiwo(final OsobaFizyczna osoba) {
		System.out.println("Ile piw dla " + osoba.getImie() + " ?");
		Integer n = 0;
		try {
			n = Integer.valueOf(scanner.nextLine());
		} catch (Exception e) {
			System.out.println("B³êdne dane!!!");
		}
		;
		if (this.sprawdzIloscPiwaDoZakupu(n)) {

			if (this.sprawdzPelnoletnoscKlienta(osoba)) {
				if (!this.sprawdzStanMagazynowy(n)) {
					System.out.println(osoba.getImie() + ", nie mamy piwa w iloœci " + n);
				} else {
					System.out.println(osoba.getImie() + ", sprzedam Tobie piwo w iloœci " + n);
					this.stanMagazynowyPiwa -= n;
					osoba.dodajPosiadanePiwa(n);
				}
			} else {
				System.out.println("Drogi kliencie " + osoba.getImie() + " nie mogê sprzedaæ Tobie piwa, poniewa¿ masz "
						+ osoba.getWiek() + " lat");
			}
		} else {
			return;
		}
	}

	/**
	 * @param iloscPiwaDoZakupu
	 *            liczba zakupywanych piw
	 * @return informacja czy iloœæ zakupywanych piw jest wiêksza od 0
	 */
	private boolean sprawdzIloscPiwaDoZakupu(final Integer iloscPiwaDoZakupu) {
		if (iloscPiwaDoZakupu.compareTo(1) < 0) {
			System.out.println("Podana iloœæ piw do zakupu jest niepoprawna");
			return false;
		} else {
			return true;
		}
	}
	private void dostawa() {
		for (Towar towar : this.towary) {
			System.out.println("ile " + towar.nazwaProduktu() + "?");
			Integer n = Integer.valueOf(0);
			try {
				n = Integer.valueOf(scanner.nextLine());
			} catch (Exception e) {
				System.out.println("B³êdne dane!!!");
			}
			towar.dostarczTowar(n);
		}
	}
	public void procesSprzedazy(final Osoba klient) {
		for (Towar towar : this.towary) {
			System.out.println("ile " + towar.nazwaProduktu() + " chce kupiæ klient?");
			Integer n = Integer.valueOf(0);
			try {
				n = Integer.valueOf(scanner.nextLine());
			} catch (Exception e) {
				System.out.println("B³êdne dane!!!");
			}
			if (this.walidujZakup()) {
				this.sprzedajTowar(towar towar);
			}
			else
			{
				return;
			}
		}
	}
	public boolean walidujZakup() {
		return true;
	}
	public void sprzedajTowar(final Towar towar) {

	}

	public static void main(final String[] args) {

		SklepNowy sklepik = new SklepNowy();

		OsobaFizyczna klient = new OsobaFizyczna("Jan", "Nowak", 17);
		OsobaFizyczna klient2 = new OsobaFizyczna("Marek", "Kowalski", 22);

		Integer x;
		do {
			System.out.println("\n1. Dostawa\n" + "2. Sprzedaj Janowi\n" + "3. Sprzedaj Markowi\n"
					+ "4. Marek kupuje z drugiego\n5. Jan kupuje z drugiego\n" + "6. Marek kupuje z drugiego\n"
					+ "7. Wyœwietl stan\n" + "8. zakoñcz");
			x = Integer.valueOf(scanner.nextLine());
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
				sklepik.sprzedajPiwo(klient2);
				break;
			case 5:
				sklepik.sprzedajPiwo(klient);
				break;
			case 6:
				sklepik.sprzedajPiwo(klient2);
				break;
			case 7:
				System.out.println(sklepik);
				System.out.println("\n");
			default:
				break;
			}
		} while (x.compareTo(8) < 0 && x.compareTo(0) > 0);

	}

	@Override
	public String toString() {
		return String.format("SklepNowy [nazwaSklepu=%s,\ntowary=%s]",
				this.nazwaSklepu, this.towary);
	}

}
