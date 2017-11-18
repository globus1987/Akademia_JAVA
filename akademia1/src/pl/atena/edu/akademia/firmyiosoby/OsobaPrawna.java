package pl.atena.edu.akademia.firmyiosoby;

public class OsobaPrawna implements Osoba {
	private String nazwa;

	public OsobaPrawna(final String nazwa) {
		this.nazwa=nazwa;
	}
	public void setNazwa(final String nazwa) {
		this.nazwa = nazwa;
	}
	@Override
	public String nazwa() {
		return this.nazwa;
	}

}
