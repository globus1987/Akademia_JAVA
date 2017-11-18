package pl.atena.edu.akademia.firmyiosoby;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import pl.atena.edu.akademia3.sklep.OsobaFizyczna;

public class Lista2 {

	private static void printf(final Collection<?> collection) {
		collection.forEach(o->System.out.println(o.toString()));
	}
	public static void main(final String[] args) {

		List<String> list = new ArrayList<>();
		list.add("Jan");
		list.add("Adam");
		list.add("Zdzisiek");
		list.add("Bartek");

		//printf(list);

		list.sort(new Comparator<String>() {
			@Override
			public int compare(final String o1, final String o2) {
				return o1.compareTo(o2);
			}
		});
		//printf(list);

		OsobaFizyczna fiz = new OsobaFizyczna("jan","nowak",12);
		OsobaPrawna praw = new OsobaPrawna("Atena");
		Set<Osoba> osoby = new TreeSet<>(new Comparator<Osoba>() {
			@Override
			public int compare(final Osoba o1, final Osoba o2) {
				// TODO Auto-generated method stub
				return o1.nazwa().compareTo(o2.nazwa());
			}
		});
		osoby.add(fiz);
		osoby.add(praw);
		osoby.forEach(o->System.out.println(o.nazwa()));

		fiz.setImie("marian");
		osoby.forEach(o->System.out.println(o.nazwa()));
		praw.setNazwa("lidl");
		osoby.forEach(o->System.out.println(o.nazwa()));
		fiz.setImie("bartek");
		osoby.forEach(o->System.out.println(o.nazwa()));
		OsobaFizyczna fiz2 = new OsobaFizyczna("Adrian","nowak",12);
		osoby.add(fiz2);
		osoby.forEach(o->System.out.println(o.nazwa()));

	}
}
