package pl.atena.edu.akademia3;

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
