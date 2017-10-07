package pl.atena.edu.akademia2;

public class Gracz {
	public static Gracz instance(String nazwisko, int wzrost) {
		return new Gracz(nazwisko, wzrost);
	}
	public static final int PELNOLETNOSC= 18;
	private int wzrost;
	private String imie;
	private int wiek;
	private String nazwisko;

	public Gracz() {
		System.out.println("hello");
		this.setWzrost(160);
	}

	public Gracz(int wzrost, String imie, String nazwisko) {
		this(imie, nazwisko);
		this.wzrost = wzrost;

	}

	public Gracz(String tekst) {
		System.out.println(tekst);
	}

	private Gracz(String nazwisko, int wzrost) {
		this.nazwisko = nazwisko;
		this.wzrost = wzrost;
	}

	public Gracz(String imie, String nazwisko) {
		this.setImie(imie);
		this.setNazwisko(nazwisko);
	}

	public String getImie() {
		return imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public int getWzrost() {
		return wzrost;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public void setWzrost(int wzrost) {
		this.wzrost = wzrost;
	}

	@Override
	public String toString() {
		return String.format("Gracz [wzrost=%s, imie=%s, wiek=%s, nazwisko=%s]", wzrost, imie, wiek, nazwisko);
	}

	public void starzejemySie(int lata) {
		this.wiek += lata;
		System.out.println(this.getNazwisko() + " postarza³ siê o " + lata);
	}

	public boolean pelnoletni() {
		return this.wiek<PELNOLETNOSC ? false:true;
	}

}
