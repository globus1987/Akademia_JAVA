package pl.atena.edu.akademia.wyjatkigeneryki;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.logging.Logger;

public class MObiekt {
	private Logger log = Logger.getLogger("MObiekt");

	public <T> void przypiszIdka(final T id) {
		T mId = id;
		this.logujInfo(mId);
	}

	public <T> void przypiszIdka(final T id1, final T id2) {
		List<T> list = new ArrayList<>();
		list.add(id1);
		list.add(id2);
		this.logujInfo(list);
	}

	@Override
	public String toString() {
		return String.format("MObiekt [log=%s]", this.log);
	}

	public <L> void logujInfo(final L value) {
		this.log.info(this.log.getName() + ":" + value.toString());
	}

	public void Idiki(final List<? extends IDString> list) {
		for (IDString idString : list) {
			System.out.println(idString.przedstawSie());
		}
	}
	public <T extends AId> void wyswietlWszystko(final List<T> elementy, final Predicate<? super T> filtr) {
		for (T e : elementy) {
			if (filtr.test(e)) {
				System.out.println(e.przedstawSie());
			}
		}
	}

	public static void main(final String[] args) throws SecurityException, IOException {
		MObiekt o = new MObiekt();
		o.przypiszIdka(20);
		o.przypiszIdka("Jan", 23);
		o.przypiszIdka(new Date());
		Predicate<IDString> predicate = new Predicate<IDString>() {
			@Override
			public boolean test(final IDString t) {
				return t.przedstawSie().startsWith("test");
			}
		};
		MObiekt o2 = new MObiekt();
		List<IDStringV0> list1 = new ArrayList<>();
		list1.add(new IDStringV0("test", 1111));
		list1.add(new IDStringV0("test1", 1111));
		list1.add(new IDStringV0("test2", 1111));
		list1.add(new IDStringV0("2test", 1111));

		List<IDString> list2 = new ArrayList<>();
		list2.add(new IDString("test2"));

		o2.Idiki(list1);
		o2.Idiki(list2);
		o2.wyswietlWszystko(list1, predicate);
	}

}
