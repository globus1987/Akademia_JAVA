package pl.atena.edu.akademia3;

import java.util.ArrayList;
import java.util.List;

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

	private Buty buty;
	private Integer posiadanePiwa;
	private Koszulka Koszulka;

	/**
	 * @param nazwisko nazwisko nowej osoby
	 * @param wzrost wzrost nowej osoby
	 * @return zwraca instancjê obiektu {@link OsobaFizyczna}
	 */
	public static OsobaFizyczna instance(final String nazwisko, final int wzrost) {
		return new OsobaFizyczna(nazwisko, wzrost);
	}

	public Integer getPosiadanePiwa() {
		return this.posiadanePiwa;
	}

	public void setPosiadanePiwa(final Integer posiadanePiwa) {
		this.posiadanePiwa = posiadanePiwa;
	}
	public void dodajPosiadanePiwa(final Integer piwaDoDodania) {
		this.posiadanePiwa += piwaDoDodania;
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
		this.imie=imie;
		this.nazwisko=nazwisko;
		this.wiek=wiek;
		this.posiadanePiwa=Integer.valueOf(0);
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
	//klasa zagnie¿dzona
	/**
	 * @author Arkadiusz
	 *
	 */
	public static class Buty{
		private String marka;
		private String model;
		public Buty(final String marka, final String model) {
			this.marka=marka;
			this.model=model;
		}
		@Override
		public String toString() {
			return String.format("Buty [marka=%s] [model=%s]", this.marka,this.model);
		}
	}
	//klasa wewnêtrzna
	/**
	 * @author Arkadiusz
	 *
	 */
	public class Koszulka{
		private String marka;
		public Koszulka(final String marka) {
			this.marka=marka;
		}
		@Override
		public String toString() {
			return String.format("Koszulka [marka=%s]]", this.marka);
		}
	}
	public void KupButy(final String marka, final String model) {
		this.buty = new Buty(marka,model);
	}
	/**
	 * @param marka
	 */
	public void KupKoszulka(final String marka) {
		this.Koszulka = new Koszulka(marka);
	}
	@Override
	public String toString() {
		return String.format("Osoba [imie=%s, wiek=%s, nazwisko=%s, posiadanePiwa=%s]", this.imie, this.wiek, this.nazwisko,
				this.posiadanePiwa);
	}
	public String toStringImieNazwisko() {
		return String.format("Osoba [imie=%s, nazwisko=%s]", this.imie, this.nazwisko);
	}
	public static void main(final String[] argc) {
		OsobaFizyczna gracz = new OsobaFizyczna();
		gracz.KupButy("Adidas", "XXX");
		System.out.println(gracz);
		OsobaFizyczna.Buty buty = new OsobaFizyczna.Buty("Nike", "YYY");
		System.out.println(buty);
		OsobaFizyczna gracz2 = new OsobaFizyczna();
		gracz2.KupKoszulka("adidasowa");
		System.out.println(gracz2);

		OsobaFizyczna Jan = new OsobaFizyczna("Jan", "Nowak");
		OsobaPrawna Atena= new OsobaPrawna("Atena");
		List<Osoba> osoby = new ArrayList<>();
		osoby.add(Jan);
		osoby.add(Atena);
		osoby.forEach(i->System.out.println(i.nazwa()));
		OsobaFizyczna Marek = new OsobaFizyczna("Marek", "Kowalski");
		osoby.add(Marek);
		osoby.forEach(i->System.out.println(i.nazwa()));

	}

	@Override
	public String nazwa() {
		return String.format("%s %s", this.imie, this.nazwisko);
	}

}
