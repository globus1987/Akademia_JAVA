/**
 * 
 */
package pl.atena.edu.akademia1;

import java.util.Random;

/**
 * @author Arkadiusz Mój pierwszy program
 * 
 * 
 */

public class WitajSwiecie {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String par = " w niedzielny poranek";
		System.out.println("Witaj œwiecie" + par);

		System.out.println((new Random()).nextInt());

		byte bajt = -100;
		short krotki = 10000;
		int integer = -100000;
		long dlugi1 = 1_000_000L;
		long dlugi2 = 10000000L;
		System.out.println(dlugi2);
		dlugi2 = dlugi2 + dlugi1;
		System.out.println(dlugi2);

		dlugi2 = dlugi2 + integer;
		System.out.println(dlugi2);

		dlugi2 = dlugi2 + bajt + krotki;
		System.out.println(dlugi2);
		// System.out.println(Long.MAX_VALUE);
		// System.out.println(Long.MIN_VALUE);
		// System.out.println(Byte.MAX_VALUE);
		// System.out.println(Byte.MIN_VALUE);
		// System.out.println(Integer.MAX_VALUE);
		// System.out.println(Integer.MIN_VALUE);
		// System.out.println(Short.MAX_VALUE);
		// System.out.println(Short.MIN_VALUE);
		float lFloat = 4232.2323f;
		double lDouble = -434.223;
		double lDouble2 = 343434.343d;
		System.out.println(1.0d / 0.0d); // Infinity
		System.out.println(0.0d / 0.0d); // NaN
		System.out.println(Double.NEGATIVE_INFINITY);
		System.out.println(Double.POSITIVE_INFINITY);
		float j = 0f;
		for (double i = 0; i < 1; i += 0.1) {
			System.out.println("double ma " + i + " a float ma " + j);
			j += 0.1;
		}

		char znak = '\u004a';
		System.out.println(znak);

		char[] znaki = "Witaj Œwiecie".toCharArray();
		znaki[4] = 'm';
		for (byte i = 0; i < znaki.length; i++) {
			System.out.println(znaki[i]);
		}
		znaki[4] = znak;
		for (byte i = 0; i < znaki.length; i++) {
			System.out.println(znaki[i]);
		}
		final double test = 3.14;
		int liczba1 = 1222;
		liczba1++;
		System.out.println(liczba1);
		System.out.println(Zwierzak.KOT);
	}

}