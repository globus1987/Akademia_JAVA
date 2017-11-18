package pl.atena.edu.akademia.wyjatkigeneryki;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.logging.Logger;

public class RTest {
	public static void main(final String[] args) throws TableException {
		Class<Table> klasa = Table.class;
		Logger.getGlobal().info(klasa.getName());
		Method[] me = klasa.getMethods();
		Field[] pola = klasa.getDeclaredFields();
		Arrays.asList(me).forEach(o->System.out.println(o.getName()));
		System.out.println("\n");
		Arrays.asList(pola).forEach(o->System.out.println(o.getName()));
		System.out.println("\n");

		Parameter[] par = me[1].getParameters();
		Arrays.asList(par).forEach(o->System.out.println(o.getName()));
		try {
			Table<Integer, String> tablica = klasa.newInstance();
			tablica.addEntry(2, "Jan");
			System.out.println("\n");

		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("\n");

	}
}
