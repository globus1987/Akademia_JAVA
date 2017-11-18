package pl.atena.edu.akademia.petletablicedecimal;

import java.util.Random;

public class Petle {

	public Petle() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		// zadanie
		Integer liczba = Integer.valueOf(1);
		Integer warunekDo = Integer.valueOf(100);
		Integer suma = Integer.valueOf(0);

		while (liczba.compareTo(warunekDo) <= 0) {
			if (liczba % 2 == 0) {
				suma += liczba;
			}
			liczba++;
		}
		System.out.println(suma);

		// slajd while
		Integer war = Integer.valueOf(100);
		Integer sum = Integer.valueOf(0);
		int iter = 0;
		Random generator = new Random();

		while (sum.compareTo(war) < 0) {
			sum += generator.nextInt(10);
			iter++;
		}
		System.out.printf("osi¹gniêto sumê %d w %d iteracjach", sum, iter);
		System.out.println();

		// slajd do while
		int iteracje = 0;
		int licz = 5, los = 0;
		do {
			los = generator.nextInt(10);
			iteracje++;
		} while (los != licz);
		System.out.printf("osi¹gniêto liczbê %d w %d itercjach", licz, iteracje);
		System.out.println();
		// zadanie do while
		int n = 5;
		double sum2 = 0;
		int min = 99, max = 0;
		iteracje = 0;
		do {
			los = generator.nextInt(100);
			System.out.println("Losujemy, losujemy. \nwylosowana liczba to " + los);
			sum2 += los;
			max = Math.max(los, max);
			min = Math.min(los, min);

			iteracje++;
		} while (iteracje < n);
		System.out.printf("WYNIKI:\nŒrednia z %d liczb to %.2f. \nNajmniejsza to %d.\nNajwiêksza to %d.", n, sum2 / n,
				min, max);
		System.out.println();
		// pêtla for slajd
		for (int i = 1; i <= 10; i++) {
			System.out.printf("wartoœæ indeksu %d\n", i);
		}

		// pêtla for zadanie
		char koniec = 'Z';
		for (char poczatek = 'A'; poczatek <= koniec; poczatek++) {
			System.out.println(poczatek);
		}
		koniec = 'A';
		System.out.println();
		for (char poczatek = 'Z'; poczatek >= koniec; poczatek--) {
			System.out.println(poczatek);
		}

		// petle zagniezdzenie zadanie
		int i = 1, j = 1, maximum = 100;

		System.out.printf("\n");

		for (i = 0; i <= maximum; i++) {
			for (j = 0; j <= maximum; j++) {
				if (i == 0) {
					System.out.printf("%5d |", j);
				} else if (j == 0) {
					System.out.printf("%5d |", i);
				} else {
					System.out.printf("%5d |", i * j);
				}
			}
			System.out.printf("\n");
		}

		// coontinue i break
		for (int ii = 0; ii < 10; ii++) {
			if (ii % 2 != 0) {
				continue;
			}
			System.out.println(ii);
		}
		for (int ii = 0; ii < 10; ii++) {
			if (ii > 5) {
				break;
			}
			System.out.println(ii);
		}
		
	}

}
