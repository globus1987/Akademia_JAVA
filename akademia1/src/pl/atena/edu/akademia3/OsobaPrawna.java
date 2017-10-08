package pl.atena.edu.akademia3;

public class OsobaPrawna implements Osoba {
	private String nazwa;

	public OsobaPrawna(final String nazwa) {
		this.nazwa=nazwa;
	}
	@Override
	public String nazwa() {
		return this.nazwa;
	}

}
