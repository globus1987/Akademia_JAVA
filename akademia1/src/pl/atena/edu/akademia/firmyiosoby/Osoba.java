package pl.atena.edu.akademia.firmyiosoby;

public interface Osoba {
	/**
	 * Metoda zwracaj�ca nazw�
	 *
	 * @return
	 */
	String nazwa();
	default String nazwaNowa() {
		return "Nowa Osoba";
	}
}
