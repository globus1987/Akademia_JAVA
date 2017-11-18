package pl.atena.edu.akademia4;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Set;

import pl.atena.edu.akademia3.sklep.RodzajTowaru;

public class Test5 {

	public Test5() {
	}
	public static void main(final String[] args) {
		Double pi = Math.PI;
		assert pi>0;
		assert pi<0:pi;
		IObiekt obiekt = new Rower();
		Rower rower = (Rower) obiekt;
		obiekt.przedstawSie();
		rower.dzwon();
		((Rower) obiekt).dzwon();
		Set<RodzajTowaru> towary1 = EnumSet.allOf(RodzajTowaru.class);
		towary1.forEach(System.out::println);
		Set<RodzajTowaru> towary2 = EnumSet.noneOf(RodzajTowaru.class);
		towary2.forEach(System.out::println);
		Set<RodzajTowaru> towary3 = EnumSet.range(RodzajTowaru.Maslo, RodzajTowaru.Papierosy);
		towary3.forEach(System.out::println);
		Set<RodzajTowaru> towary4 = EnumSet.of(RodzajTowaru.Piwo,RodzajTowaru.Papierosy);
		towary4.forEach(System.out::println);

		towary1.forEach(o->System.out.println(o.tekst()));
		EnumMap<RodzajTowaru,String> eMap = new EnumMap<>(RodzajTowaru.class);
		eMap.put(RodzajTowaru.Jogurt, "jogobella");

	}
}
