package pl.atena.edu.akademia3.sklep.towar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

/**
 * @author Arkadiusz
 *
 */
public class ListaTowarow {

	private List<Towar> towary;

	public ListaTowarow() {
		List<Towar> towaryinicjalne = new ArrayList<>();
		Set<RodzajTowaru> rodzajeTowarow = EnumSet.allOf(RodzajTowaru.class);
		rodzajeTowarow.forEach(o->towaryinicjalne.add(new Towar(o)));
		towaryinicjalne.sort(new Comparator<Towar>() {
			@Override
			public int compare(final Towar o1, final Towar o2) {
				return o1.getCena().compareTo(o2.getCena());
			}
		});
		this.towary = towaryinicjalne;	}

	public List<Towar> getTowary() {
		return this.towary;
	}

	public void setTowary(final List<Towar> towary) {
		this.towary = towary;
	}

	@Override
	public String toString() {
		return String.format("ListaTowarow [towary=%s]", this.towary);
	}

}
