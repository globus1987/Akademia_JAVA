package pl.atena.edu.akademia2;

/**
 * @author Arkadiusz
 *
 */
public class Osoba {
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
	 * @return zwraca instancjê obiektu {@link Osoba}
	 */
	public static Osoba instance(final String nazwisko, final int wzrost) {
		return new Osoba(nazwisko, wzrost);
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

	public Osoba() {
		System.out.println("hello");
		this.setWzrost(160);
	}

	public int getWiek() {
		return this.wiek;
	}

	public Osoba(final int wzrost, final String imie, final String nazwisko) {
		this(imie, nazwisko);
		this.wzrost = wzrost;

	}
	public Osoba(final String imie, final String nazwisko, final int wiek) {
		this.imie=imie;
		this.nazwisko=nazwisko;
		this.wiek=wiek;
		this.posiadanePiwa=Integer.valueOf(0);
	}

	public Osoba(final String tekst) {
		System.out.println(tekst);
	}

	private Osoba(final String nazwisko, final int wzrost) {
		this.nazwisko = nazwisko;
		this.wzrost = wzrost;
	}

	public Osoba(final String imie, final String nazwisko) {
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
	public static void main(final String[] argc) {
		Osoba gracz = new Osoba();
		gracz.KupButy("Adidas", "XXX");
		System.out.println(gracz);
		Osoba.Buty buty = new Osoba.Buty("Nike", "YYY");
		System.out.println(buty);
		Osoba gracz2 = new Osoba();
		gracz2.KupKoszulka("adidasowa");
		System.out.println(gracz2);


	}

}
