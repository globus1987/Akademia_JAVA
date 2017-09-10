package pl.atena.edu.akademia1;

import java.util.Scanner;

public class Miesiace {
	private static Scanner scanner = new Scanner(System.in);

	public static String miesiac(int liczba) {
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
			return "Ta liczba nie odpowiada ¿adnemu z miesiêcy";
		}
	}

	public static void main(String[] args) {

		int miesiacLiczba = 0;
		System.out.println("podaj nr miesi¹ca");
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
