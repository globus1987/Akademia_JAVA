/**
 * 
 */
package pl.atena.edu.akademia1;

import java.util.Scanner;

/**
 * @author Arkadiusz
 *
 */
public class PoleProstokata {

	private static Scanner scanner = new Scanner(System.in);

	public static final int MIN = 1;
	public static final int MAX = 10;

	public static boolean sprawdz(double liczba, String komunikat) {
		if (liczba <= MIN || liczba > MAX) {
			System.out.println("bok " + komunikat + " jest spoza zakresu " + MIN + "-" + MAX);
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println("Podaj d�ugo�� boku A:");
		String da = scanner.nextLine();

		System.out.println("Podaj d�ugo�� boku B:");
		String db = scanner.nextLine();
		boolean resultA = true, resultB = true;
		double dlugoscA2 = Double.valueOf(da), dlugoscB2 = Double.valueOf(db);

		resultA = sprawdz(dlugoscA2, "A");
		resultB = sprawdz(dlugoscB2, "B");
		// oba boki musz� spe�nia� warunek warto�ci granicznych
		if (!resultA || !resultB) {
			return;
		}
		double Pole2 = dlugoscA2 * dlugoscB2;
		System.out.println("D�ugo�� A:" + dlugoscA2 + ",d�ugo�� B:" + dlugoscB2 + ", Pole:" + Pole2);
	}

}
