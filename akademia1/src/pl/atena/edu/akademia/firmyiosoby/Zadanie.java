package pl.atena.edu.akademia.firmyiosoby;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Zadanie {

	public static void main(final String[] args) throws FileNotFoundException {
		File file = new File("D:\\dok.txt");
		List<Slowa> listaUnikalna = new ArrayList<>();
		List<String> listaWszystkich = new ArrayList<>();
		Scanner sc = new Scanner(file);
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			line = line.replace(",", "");
			line = line.replace(".", "");
			line = line.replace("—", "");
			line = line.replace(":", "");
			line = line.replace(";", "");
			line = line.replace("„", "");
			line = line.replace("”", "");
			line = line.replace("/", " ");

			String[] row = line.split(" ");

			int size = row.length;
			for (int i = 0; i < size; i++) {
				if (!row[i].equals("")) {
					listaWszystkich.add(row[i]);
				}
			}

			/*
			 * Slowa wyraz = new Slowa(row[i]); if (!listaUnikalna.contains(wyraz)) {
			 * listaUnikalna.add(wyraz); } else { int index = listaUnikalna.indexOf(wyraz);
			 * listaUnikalna.get(index).zwiekszIloscOJeden(); }
			 */

		}

		listaWszystkich.sort(new Comparator<String>() {
			@Override
			public int compare(final String o1, final String o2) {
				return o1.compareTo(o2);
			}
		});
		String poprzednieSlowo = "";
		int liczbaWystapien = 1;
		for (int j = 0; j < listaWszystkich.size(); j++) {
			String noweSlowo=listaWszystkich.get(j);
			if (noweSlowo.equals(poprzednieSlowo)) {
				liczbaWystapien++;
			}
			else {
				Slowa wyraz = new Slowa(poprzednieSlowo,liczbaWystapien);
				listaUnikalna.add(wyraz);
				liczbaWystapien=1;
				poprzednieSlowo=noweSlowo;
			}
		}
		listaUnikalna.sort(new Comparator<Slowa>() {
			@Override
			public int compare(final Slowa o1, final Slowa o2) {
				return o2.getIlosc().compareTo(o1.getIlosc());
			}
		});
		System.out.println(listaUnikalna);
	}

}
