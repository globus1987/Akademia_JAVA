package pl.atena.edu.akademia3;

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
