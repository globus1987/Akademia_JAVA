package pl.atena.edu.akademia3;

import pl.atena.edu.akademia2.Osoba;

/**
 * @author Arkadiusz
 *
 */
public class Sklep {
	private Integer stanMagazynowyPiwa;
	private String nazwaSklepu;

	/**
	 * konstruktor z domy�lnym 0 stanu magazynowego
	 */
	public Sklep() {
		this.nazwaSklepu = "sklep z 0 na starcie";
		this.stanMagazynowyPiwa = Integer.valueOf(0);
	}

	/**
	 * @param stanStartowyMagazynu
	 *            zadana ilo�� startowa piw w magazynie przy tworzeniu obiektu
	 *            sklepu
	 */
	public Sklep(final Integer stanStartowyMagazynu) {
		this.nazwaSklepu = "sklep z " + stanStartowyMagazynu.toString() + " na starcie";
		this.stanMagazynowyPiwa = Integer.valueOf(stanStartowyMagazynu);
	}

	/**
	 * metoda dostarczaj�ca jedno piwo do sklepu
	 */
	private void dostarczPiwo() {
		this.stanMagazynowyPiwa++;
		System.out.println("Dostarczono jedno piwo do sklepu");
	}

	/**
	 * metoda dostarczaj�ca zadan� liczb� piw do sklepu
	 *
	 * @param liczbaDostarczonychPiw
	 *            liczba dostarczanych piw do sklepu
	 */
	private void dostarczPiwo(final Integer liczbaDostarczonychPiw) {
		this.stanMagazynowyPiwa += liczbaDostarczonychPiw;
		System.out.println("Dostarczono " + liczbaDostarczonychPiw + " piw do sklepu");
	}

	/**
	 * @param osoba
	 *            sprawdzany klient
	 * @return informacja czy klient jest pe�noletni
	 */
	private boolean sprawdzPelnoletnoscKlienta(final Osoba osoba) {
		return osoba.pelnoletni() ? true : false;
	}

	/**
	 * @param iloscPiwaDoZakupu zadana liczba piw do zakupu
	 * @return informacja czy w magazynie jest wystarczaj�co du�o piw
	 */
	private boolean sprawdzStanMagazynowy(final Integer iloscPiwaDoZakupu) {
		if (this.stanMagazynowyPiwa.compareTo(iloscPiwaDoZakupu) < 0) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * metoda odpowiedzialna za prob� zakupu zadanej ilo�ci piw przez klienta
	 *
	 * @param osoba obs�ugiwany klient
	 * @param iloscPiwaDoZakupu zakupywana liczba piw
	 */
	private void sprzedajPiwo(final Osoba osoba, final Integer iloscPiwaDoZakupu) {
		if (this.sprawdzIloscPiwaDoZakupu(iloscPiwaDoZakupu)) {

			if (this.sprawdzPelnoletnoscKlienta(osoba)) {
				if (!this.sprawdzStanMagazynowy(iloscPiwaDoZakupu)) {
					System.out.println(osoba.getImie() + ", nie mamy piwa w ilo�ci " + iloscPiwaDoZakupu.toString());
				} else {
					System.out.println(
							osoba.getImie() + ", sprzedam Tobie piwo w ilo�ci " + iloscPiwaDoZakupu.toString());
					this.stanMagazynowyPiwa -= iloscPiwaDoZakupu;
					osoba.setPosiadanePiwa(osoba.getPosiadanePiwa() + iloscPiwaDoZakupu);
				}
			} else {
				System.out.println("Drogi kliencie " + osoba.getImie() + " nie mog� sprzeda� Tobie piwa, poniewa� masz "
						+ osoba.getWiek() + " lat");
			}
		} else {
			return;
		}
	}
	/**
	 * metoda do sprzeda�y jednego piwa
	 *
	 * @param osoba obs�ugiwany klient
	 */
	private void sprzedajPiwo(final Osoba osoba) {
		if (this.sprawdzIloscPiwaDoZakupu(1)) {

			if (this.sprawdzPelnoletnoscKlienta(osoba)) {
				if (!this.sprawdzStanMagazynowy(1)) {
					System.out.println(osoba.getImie() + ", nie mamy piwa w ilo�ci " + 1);
				} else {
					System.out.println(
							osoba.getImie() + ", sprzedam Tobie piwo w ilo�ci " + 1);
					this.stanMagazynowyPiwa --;
					osoba.setPosiadanePiwa(osoba.getPosiadanePiwa() + 1);
				}
			} else {
				System.out.println("Drogi kliencie " + osoba.getImie() + " nie mog� sprzeda� Tobie piwa, poniewa� masz "
						+ osoba.getWiek() + " lat");
			}
		} else {
			return;
		}
	}

	/**
	 * @param iloscPiwaDoZakupu liczba zakupywanych piw
	 * @return informacja czy ilo�� zakupywanych piw jest wi�ksza od 0
	 */
	private boolean sprawdzIloscPiwaDoZakupu(final Integer iloscPiwaDoZakupu) {
		if (iloscPiwaDoZakupu.compareTo(1) < 0) {
			System.out.println("Podana ilo�� piw do zakupu jest niepoprawna");
			return false;
		} else {
			return true;
		}
	}

	public static void main(final String[] args) {
		// generujemy pusty sklep
		Sklep monopolowy = new Sklep();
		System.out.println(monopolowy);
		// tworzymy obiekt niepe�noletniej osoby
		Osoba klient = new Osoba("Jan", "Nowak", 17);
		// proba sprzeda�y piwa nieletniemu
		monopolowy.sprzedajPiwo(klient, 1);
		System.out.println(monopolowy);
		// tworzymy obiekt osoby pelnoletniej
		Osoba klient2 = new Osoba("Marek", "Kowalski", 18);
		// sprzedajemy piwo pe�noletniemu przy pustym sklepie
		monopolowy.sprzedajPiwo(klient2, 1);
		System.out.println(monopolowy);
		// dostarczamy jedno piwo
		monopolowy.dostarczPiwo();
		System.out.println(monopolowy);
		// sprzedajemy jedno dostarcozne piwo
		monopolowy.sprzedajPiwo(klient2, 1);
		System.out.println(monopolowy);
		// kolejna proba sprzeda�y z pustego sklepu
		monopolowy.sprzedajPiwo(klient2, 1);
		System.out.println(monopolowy);
		// dostarczenie wi�kszej ilo�ci
		monopolowy.dostarczPiwo(12);
		System.out.println(monopolowy);
		// sprzedajemy wi�ksz� ilo�� piwa
		monopolowy.sprzedajPiwo(klient2, 6);
		System.out.println(monopolowy);
		// proba sprzeda�y z niepustego sklepu niepe�noletniemu
		monopolowy.sprzedajPiwo(klient, 1);
		System.out.println(klient);
		System.out.println(klient2);
		monopolowy.sprzedajPiwo(klient2, 0);

		Sklep monopolowyNowy = new Sklep(12);
		System.out.println(monopolowyNowy);
		monopolowyNowy.sprzedajPiwo(klient2, 11);

		System.out.println(klient);
		System.out.println(klient2);
		System.out.println(monopolowy);
		System.out.println(monopolowyNowy);

		monopolowy.sprzedajPiwo(klient2);
		monopolowyNowy.sprzedajPiwo(klient2);
		System.out.println(klient);
		System.out.println(klient2);
		System.out.println(monopolowy);
		System.out.println(monopolowyNowy);

	}

	@Override
	public String toString() {
		return String.format("Sklep [stanMagazynowyPiwa=%s, nazwaSklepu=%s]", this.stanMagazynowyPiwa,
				this.nazwaSklepu);
	}

}
