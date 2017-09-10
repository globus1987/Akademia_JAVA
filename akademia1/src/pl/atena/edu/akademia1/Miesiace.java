package pl.atena.edu.akademia1;

import java.util.Scanner;

public class Miesiace {
	private static Scanner scanner = new Scanner(System.in);

	public static String miesiac(int liczba) {
		switch (liczba) {
		case 1:
			return "Stycze�";
		case 2:
			return "Luty";
		case 3:
			return "Marzec";
		case 4:
			return "Kwiecie�";
		case 5:
			return "Maj";
		case 6:
			return "Czerwiec";
		case 7:
			return "Lipiec";
		case 8:
			return "Sierpie�";
		case 9:
			return "Wrzesie�";
		case 10:
			return "Pazdziernik";
		case 11:
			return "Listopad";
		case 12:
			return "Grudzie�";
		default:
			return "Ta liczba nie odpowiada �adnemu z miesi�cy";
		}
	}

	public static void main(String[] args) {

		int miesiacLiczba = 0;
		System.out.println("podaj nr miesi�ca");
		String mies = scanner.nextLine();
		try {
			miesiacLiczba = Integer.valueOf(mies);
		} catch (Exception e) {
			System.out.println("to nie numer miesiaca!!!");
			return;
		}
		String miech = miesiac(miesiacLiczba);
		System.out.println(miech);
	}

}
