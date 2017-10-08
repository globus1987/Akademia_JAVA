package pl.atena.edu.akademia2;

public class Gracz {
	public static final int PELNOLETNOSC = 18;

	private int wzrost;
	private String imie;
	private int wiek;
	private String nazwisko;

	private Buty buty;

	private Koszulka Koszulka;

	public static Gracz instance(final String nazwisko, final int wzrost) {
		return new Gracz(nazwisko, wzrost);
	}

	public Gracz() {
		System.out.println("hello");
		this.setWzrost(160);
	}

	public Gracz(final int wzrost, final String imie, final String nazwisko) {
		this(imie, nazwisko);
		this.wzrost = wzrost;

	}

	public Gracz(final String tekst) {
		System.out.println(tekst);
	}

	private Gracz(final String nazwisko, final int wzrost) {
		this.nazwisko = nazwisko;
		this.wzrost = wzrost;
	}

	public Gracz(final String imie, final String nazwisko) {
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

	public void setNazwisko(final String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public void setWzrost(final int wzrost) {
		this.wzrost = wzrost;
	}

	public void starzejemySie(final int lata) {
		this.wiek += lata;
		System.out.println(this.getNazwisko() + " postarza³ siê o " + lata);
	}
	//klasa zagnie¿dzona
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
	public void KupKoszulka(final String marka) {
		this.Koszulka = new Koszulka(marka);
	}
	@Override
	public String toString() {
		return String.format("Gracz [wzrost=%s, imie=%s, wiek=%s, nazwisko=%s, buty=%s,koszulka=%s]", this.wzrost, this.imie, this.wiek, this.nazwisko,
				this.buty,this.Koszulka);
	}
	public static void main(final String[] argc) {
		Gracz gracz = new Gracz();
		gracz.KupButy("Adidas", "XXX");
		System.out.println(gracz);
		Gracz.Buty buty = new Gracz.Buty("Nike", "YYY");
		System.out.println(buty);
		Gracz gracz2 = new Gracz();
		gracz2.KupKoszulka("adidasowa");
		System.out.println(gracz2);


	}

}
