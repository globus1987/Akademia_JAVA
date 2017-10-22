package pl.atena.edu.akademia.kolekcje;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class Lista {

	private static void printf(final Collection<?> collection) {
		collection.forEach(o->System.out.println(o));
	}
	public static void main(final String[] args) {

		List<String> list = new ArrayList<>();
		list.add("Jan");
		list.add("Adam");
		list.add("Zdzisiek");
		list.add("Bartek");

		printf(list);

		list.sort(new Comparator<String>() {
			@Override
			public int compare(final String o1, final String o2) {
				return o1.compareTo(o2);
			}
		});
		printf(list);



	}
}
