package pl.atena.edu.akademia.firmyiosoby;

public interface Osoba {
	/**
	 * Metoda zwracaj¹ca nazwê
	 *
	 * @return
	 */
	String nazwa();
	default String nazwaNowa() {
		return "Nowa Osoba";
	}
}
