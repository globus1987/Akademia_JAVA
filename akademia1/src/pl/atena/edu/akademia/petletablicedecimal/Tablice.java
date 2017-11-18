package pl.atena.edu.akademia.petletablicedecimal;

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
		int[][] ttt= {{1},{2,3},{4,5,6,7}};
		System.out.println(Arrays.toString(ttt[2]));
		
		int[][] tab5 = new int[3][];
		tab5[0]= new int[6];
		tab5[1]= new int [1];
		tab5[2]=new int [2];
		System.out.println(Arrays.toString(tab5[2]));
		int iterator = 9;
		int[][] macierz = new int [10][10];
		for (int i=0;i<10;i++)
		{
			for (int j=0;j<10;j++) {
				if (i==j)
				{
					macierz[i][j]=1;
				}
				if (j==iterator) {
					macierz[i][j]=1;
					iterator--;
				}
			}
		}
		for (int[] kolumna:macierz) {
			for (int element:kolumna) {
				System.out.printf("%d ",element);
			}
			System.out.println("\n");
		}	
		
		
	}
}
