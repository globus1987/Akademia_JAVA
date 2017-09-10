package pl.atena.edu.akademia1;

import java.util.Scanner;

public class Miesiace {
	private static Scanner scanner = new Scanner(System.in);
	public final static int MIN_MONTH = 1;
	public final static int MAX_MONTH = 12;

	public static String jakiToMiesiac(int liczba) {
		switch (liczba) {
		case 1:
			return "Styczeñ";
		case 2:
			return "Luty";
		case 3:
			return "Marzec";
		case 4:
			return "Kwiecieñ";
		case 5:
			return "Maj";
		case 6:
			return "Czerwiec";
		case 7:
			return "Lipiec";
		case 8:
			return "Sierpieñ";
		case 9:
			return "Wrzesieñ";
		case 10:
			return "Pazdziernik";
		case 11:
			return "Listopad";
		case 12:
			return "Grudzieñ";
		default:
			return "???";
		}
	}

	public static boolean sprawdzMiesiac(int liczba) {
		if (liczba < MIN_MONTH || liczba > MAX_MONTH) {
			return false;
		}
		return true;
	}

	public static int pobierzNumerMiesiaca() {
		int miesiacLiczba = 0;
		System.out.println("podaj nr miesi¹ca");
		try {
			miesiacLiczba = Integer.valueOf(scanner.nextLine());
		} catch (Exception e) {
			System.out.println("to nie numer miesiaca!!!");
			return 0;
		}
		return miesiacLiczba;
	}

	public static void main(String[] args) {

		int miesiacLiczba = pobierzNumerMiesiaca();
		if (miesiacLiczba==0) {
			return;
		}
		if (sprawdzMiesiac(miesiacLiczba)) {d
			System.out.println("podany miesi¹c to " + jakiToMiesiac(miesiacLiczba));
		} else {
			System.out.println("Ta liczba nie odpowiada ¿adnemu z miesiêcy");
		}
	}

	
}
