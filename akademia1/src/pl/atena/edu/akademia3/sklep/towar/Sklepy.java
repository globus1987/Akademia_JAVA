package pl.atena.edu.akademia3.sklep.towar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sklepy {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(final String[] args) {

		Osiedlowy sklepik = new Osiedlowy();
		Biedronka biedroneczka = new Biedronka();
		¯abka ¿abcia = new ¯abka();
		List<SklepNowy> listaSklepow = new ArrayList<>();
		listaSklepow.add(sklepik);
		listaSklepow.add(biedroneczka);
		listaSklepow.add(¿abcia);
		OsobaFizyczna klient = new OsobaFizyczna("Jan", "Nowak", 17);
		OsobaFizyczna klient2 = new OsobaFizyczna("Marek", "Kowalski", 22);
		List<OsobaFizyczna> listaKlientow = new ArrayList<>();
		listaKlientow.add(klient);
		listaKlientow.add(klient2);
		Integer x = 0;
		do {
			System.out.println("\n1. Dostawa\n" + "2. Sprzedaj Janowi\n" + "3. Sprzedaj Markowi\n"
					+ "4. Wyœwietl stan\n" + "5. Wyœwietl stan sklepow\n" + "6. uruchom promocje\n" + "inne. zakoñcz");
			try {
				x = Integer.valueOf(scanner.nextLine());
			} catch (Exception e) {
				System.out.println("Naucz siê korzystaæ z programu!!!");
			}
			switch (x) {
			case 1:
				sklepik.dostawa();
				break;
			case 2:
				sklepik.procesSprzedazy(klient);
				break;
			case 3:
				sklepik.procesSprzedazy(klient2);
				break;
			case 4:
				System.out.println("Sklepy:");
				listaSklepow.forEach(System.out::println);
				System.out.println("Klienci:");
				listaKlientow.forEach(System.out::println);

				System.out.println("\n");
				break;
			case 5:
				listaSklepow.forEach(System.out::println);
				System.out.println("\n");
				break;
			case 6:
				listaSklepow.forEach(o -> o.promocja());
				break;
			default:
				break;
			}
		} while (x.compareTo(7) < 0 && x.compareTo(0) > 0);

	}

}
