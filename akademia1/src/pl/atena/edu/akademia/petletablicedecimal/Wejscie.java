package pl.atena.edu.akademia.petletablicedecimal;

import java.util.Scanner;

public class Wejscie {

	public Wejscie() {
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String tekst = "to jest pierwsza linia \n to jest druga linia\n";
		Scanner scanner = new Scanner(tekst);
		System.out.println("pierwsza linia: " + scanner.hasNext());
		System.out.println("wczytuje " + scanner.nextLine());
		System.out.println("druga linia: " + scanner.hasNext());
		System.out.println("wczytuje " + scanner.nextLine());
		System.out.println("pierwsza linia: " + scanner.hasNext());

		scanner.close();

		System.out.println(1000.0 / 3.0);
		System.out.printf("%8.2f", 100000.0 / 3.0);
		System.out.println();

		System.out.printf("%.2f", 100000.0 / 3.0);
		System.out.println();

		System.out.printf("%,+.4f", 100000.0 / 3.0);
		System.out.println();

		String message = String.format("%s ma %d koty", "Ala", 2);
		System.out.println(message);

		System.out.printf("%.5f", Math.PI);
		System.out.println();
		System.out.printf("%.3f", Math.pow(Math.E, Math.PI));
		System.out.println();

		
	}

}
