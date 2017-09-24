package pl.atena.edu.akademia2;

import java.util.Arrays;
import java.util.Random;

public class Tablice {

	public Tablice() {
	}

	public static void main(String[] args) {
		// deklaracje
		int x = 3;
		long[] liczby = new long[x];
		boolean[] warunki = new boolean[x];
		Boolean[] warunki2 = new Boolean[x];

		float[] floaty = new float[x];
		char[] znaki = new char[x];
		for (int i = 0; i < liczby.length; i++) {
			System.out.println(liczby[i]);
			System.out.println(warunki[i]);
			System.out.println(warunki2[i]);
			System.out.println(floaty[i]);
			System.out.println(znaki[i]);
			System.out.println();

		}
		System.out.println();

		for (long item : liczby) {
			System.out.println(item);
		}
		// Zadanie tablice

		int[] tabliczka = new int[10];
		int value = 9;
		for (int z = 0; z < tabliczka.length; z++, value--) {
			tabliczka[z] = value;
			System.out.printf("Dane[%d] = %d%n", z, tabliczka[z]);
		}

		System.out.println("tabliczka " + Arrays.toString(tabliczka));
		int[] tabliczkaNowa = Arrays.copyOf(tabliczka, tabliczka.length + 5);
		int[] tabliczkaref = tabliczka;
		System.out.println("tabliczkaref " + Arrays.toString(tabliczkaref));
		tabliczkaref[2] = 10000;
		System.out.println("tabliczka " + Arrays.toString(tabliczka));
		System.out.println("tabliczkaref " + Arrays.toString(tabliczkaref));
		System.out.println("tabliczkanowa " + Arrays.toString(tabliczkaNowa));
		//tablice wielowymiarowe
		int[] tab = { 4, 12, 58, 45, 5, 23, 52, 1, 44 };
		Arrays.sort(tab);
		System.out.println(Arrays.toString(tab));
		int[] tab2 = new int[10];
		Random generator = new Random();
		Arrays.fill(tab2, generator.nextInt(11));
		System.out.println(Arrays.toString(tab2));
		
		Integer[][] tab3= {{1,2,3,4},{4,3,2,1},{9,8,7,4}};
		for (Integer[] kolumna:tab3) {
			for (Integer element:kolumna) {
				System.out.print(element+" ");
			}
			System.out.println("\n");
		}
		
		
		
	}
}
