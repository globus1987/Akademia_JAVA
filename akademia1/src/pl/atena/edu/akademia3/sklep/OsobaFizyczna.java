package pl.atena.edu.akademia3.sklep;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import pl.atena.edu.akademia.firmyiosoby.Osoba;
import pl.atena.edu.akademia.firmyiosoby.OsobaPrawna;

/**
 * @author Arkadiusz
 *
 */
public class OsobaFizyczna implements Osoba {
	/**
	 *
	 */
	public static final int PELNOLETNOSC = 18;

	private int wzrost;
	private String imie;
	private int wiek;
	private String nazwisko;
	private ListaTowarow listaTowarow;

	/**
	 * @param nazwisko
	 *            nazwisko nowej osoby
	 * @param wzrost
	 *            wzrost nowej osoby
	 * @return zwraca instancjê obiektu {@link OsobaFizyczna}
	 */
	public static OsobaFizyczna instance(final String nazwisko, final int wzrost) {
		return new OsobaFizyczna(nazwisko, wzrost);
	}



	public OsobaFizyczna() {
		System.out.println("hello");
		this.setWzrost(160);
	}

	public int getWiek() {
		return this.wiek;
	}

	public OsobaFizyczna(final int wzrost, final String imie, final String nazwisko) {
		this(imie, nazwisko);
		this.wzrost = wzrost;

	}

	public OsobaFizyczna(final String imie, final String nazwisko, final int wiek) {
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.wiek = wiek;
		this.listaTowarow = new ListaTowarow();
	}


	public OsobaFizyczna(final String tekst) {
		System.out.println(tekst);
	}

	private OsobaFizyczna(final String nazwisko, final int wzrost) {
		this.nazwisko = nazwisko;
		this.wzrost = wzrost;
	}

	public OsobaFizyczna(final String imie, final String nazwisko) {
		this.setImie(imie);
		this.setNazwisko(nazwisko);
	}

	public String getImie() {
		return this.imie;
	}

	public String getNazwisko() {
		return this.nazwisko;
	}

	public int getWzrost() {
		return this.wzrost;
	}

	public boolean pelnoletni() {
		return this.wiek < PELNOLETNOSC ? false : true;
	}

	public void setImie(final String imie) {
		this.imie = imie;
	}

	/**
	 * @param nazwisko
	 */
	public void setNazwisko(final String nazwisko) {
		this.nazwisko = nazwisko;
	}

	/**
	 * @param wzrost
	 */
	public void setWzrost(final int wzrost) {
		this.wzrost = wzrost;
	}

	public void starzejemySie(final int lata) {
		this.wiek += lata;
		System.out.println(this.getNazwisko() + " postarza³ siê o " + lata);
	}

	// klasa zagnie¿dzona
	/**
	 * @author Arkadiusz
	 *
	 */
	public static class Buty {
		private String marka;
		private String model;

		public Buty(final String marka, final String model) {
			this.marka = marka;
			this.model = model;
		}

		@Override
		public String toString() {
			return String.format("Buty [marka=%s] [model=%s]", this.marka, this.model);
		}
	}


	public void KupTowar(final Towar towarKupiony, final Integer ilosc) {
		for (Towar towar : this.listaTowarow.getTowary()) {
			if (towar.nazwaProduktu().equals(towarKupiony.nazwaProduktu())) {
				towar.dostarczTowar(ilosc);
			}
		}
	}

	@Override
	public String toString() {
		return String.format("OsobaFizyczna [imie=%s, nazwisko=%s, wiek=%s, towary=%s]", this.imie, this.nazwisko, this.wiek, this.listaTowarow);
	}

	public String toStringImieNazwisko() {
		return String.format("Osoba [imie=%s, nazwisko=%s]", this.imie, this.nazwisko);
	}

	public static void main(final String[] argc) {
		OsobaFizyczna gracz = new OsobaFizyczna();
		System.out.println(gracz);
		OsobaFizyczna.Buty buty = new OsobaFizyczna.Buty("Nike", "YYY");
		System.out.println(buty);
		OsobaFizyczna gracz2 = new OsobaFizyczna();
		System.out.println(gracz2);

		OsobaFizyczna Jan = new OsobaFizyczna("Jan", "Nowak");
		OsobaPrawna Atena = new OsobaPrawna("Atena");
		List<Osoba> osoby = new ArrayList<>();
		osoby.add(Jan);
		osoby.add(Atena);
		// osoby.forEach(i->System.out.println(i.nazwa()));
		OsobaFizyczna Marek = new OsobaFizyczna("Marek", "Kowalski");
		osoby.add(Marek);
		// osoby.forEach(i->System.out.println(i.nazwa()));
		for (Osoba osoba : osoby) {
			if (osoba instanceof OsobaFizyczna) {
				System.out.println(osoba.nazwa());
			}
		}
		osoby.sort(new Comparator<Osoba>() {
			@Override
			public int compare(final Osoba o1, final Osoba o2) {
				return o1.nazwa().length() - o2.nazwa().length();
			}
		});

	}

	@Override
	public String nazwa() {
		return String.format("%s %s", this.imie, this.nazwisko);
	}

	@Override
	public String nazwaNowa() {
		return String.format("%s %s", this.imie, this.nazwisko);
	}

}
