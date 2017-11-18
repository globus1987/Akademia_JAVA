package pl.atena.edu.akademia.firmyiosoby;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Kolekcje {

	private static void printf(final Collection<?> collecttion) {
		collecttion.forEach(o -> System.out.println(o));
	}

	private static void listaSort() {
		List<String> list = new ArrayList<>();
		list.add("Staszek");
		list.add("Czesław");
		list.add("Leon");
		list.add("Adam");
		printf(list);

		list.sort(new Comparator<String>() {
			@Override
			public int compare(final String o1, final String o2) {
				return o1.compareTo(o2);
			}
		});

		System.out.println();
		printf(list);

	}

	private static void listaFilter() {

		List<String> list = new ArrayList<>();
		list.add("Staszek");
		list.add("Andrzej");
		list.add("Leon");
		list.add("Adam");
		printf(list);

		// Do nowej listy przy pomocy forEach
		final List<String> result = new ArrayList<>();
		list.forEach(item -> {
			if ("A".equals(item.substring(0, 1).toUpperCase())) {
				result.add(item);
			}
		});
		System.out.println();
		printf(result);

		// Nowa instancja przy pomocy strumienia
		List<String> result2 = list.stream().filter(item -> "A".equals(item.substring(0, 1).toUpperCase()))
				.collect(Collectors.toList());
		System.out.println();
		printf(result2);

		// usuwam z tej listy
		list.removeIf(item -> "A".equals(item.substring(0, 1).toUpperCase()));

		System.out.println();
		printf(list);

	}

	public static void main(final String[] args) {
		listaSort();

		String[] test = { "Edek", "Kredek" };
		List<String> lista = Arrays.asList(test);
		//lista.add("Tadek");

		Collections.singletonList("test");

		Collections.emptyMap();

		Collections.unmodifiableList(lista);

		Collections.checkedList(new ArrayList<String>(), String.class);

	}

}
