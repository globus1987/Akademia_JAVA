package pl.atena.edu.akademia.firmyiosoby;

public class Slowa {
	private Integer ilosc;
	private String slowo;

	public Slowa(final String slowo) {
		super();
		this.ilosc = 1;
		this.slowo = slowo;
	}
	public Slowa(final String slowo,final Integer liczba) {
		super();
		this.ilosc = liczba;
		this.slowo = slowo;
	}
	public Integer getIlosc() {
		return this.ilosc;
	}
	public void setIlosc(final Integer ilosc) {
		this.ilosc = ilosc;
	}
	public void zwiekszIloscOJeden() {
		this.ilosc++;
	}
	@Override
	public String toString() {
		return String.format("Slowa [ilosc=%s, slowo=%s]", this.ilosc, this.slowo);
	}
	public String getSlowo() {
		return this.slowo;
	}
	public void setSlowo(final String slowo) {
		this.slowo = slowo;
	}
}
