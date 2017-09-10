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
		if (liczba < MIN || liczba > MAX) {
			System.out.println("bok " + komunikat + " jest spoza zakresu " + MIN + "-" + MAX);
			return false;
		}
		return true;
	}



	public static void main(String[] args) {
		System.out.println("Podaj d³ugoœæ boku A:");
		String da = scanner.nextLine();

		System.out.println("Podaj d³ugoœæ boku B:");
		String db = scanner.nextLine();
		boolean resultA = true, resultB = true;
		double dlugoscA2 = 0, dlugoscB2 = 0;
		try {
			dlugoscA2 = Double.valueOf(da);

		} catch (Exception e) {
			System.out.println("B³êdny bok A");
			resultA = false;
		}
		try {
			dlugoscB2 = Double.valueOf(db);

		} catch (Exception e) {
			System.out.println("B³êdny bok B");
			resultB = false;
		}
		if (!resultA || !resultB) {
			return;
		}
		resultA = sprawdz(dlugoscA2, "A");
		resultB = sprawdz(dlugoscB2, "B");
		// oba boki musz¹ spe³niaæ warunek wartoœci granicznych
		if (!resultA && !resultB) {
			System.out.println("popraw dane A i B");
			return;
		} else if (!resultA && resultB) {
			System.out.println("popraw dane A");
			return;
		} else if (resultA && !resultB) {
			System.out.println("popraw dane B");
			return;
		} else {
			double Pole2 = dlugoscA2 * dlugoscB2;
			System.out.println("D³ugoœæ A:" + dlugoscA2 + ",d³ugoœæ B:" + dlugoscB2 + ", Pole:" + Pole2);
		}
		String testowa = "raz";
		switch (da) {
		case "1":
			testowa = "jeden";
			break;
		case "2":
			testowa = "dwa";
			break;
		case "3":
			testowa = "trzy";
			break;
		default:
			testowa = "nie wiem ile to";
			break;
		}
		System.out.println(testowa);

	
	}

}
