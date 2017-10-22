package pl.atena.edu.akademia3.sklep.towar;

import java.util.ArrayList;
import java.util.List;

public class ListaTowarow {
	private List<Towar> towary;

	public ListaTowarow() {
		Jogurt jogurt = new Jogurt();
		Maslo maslo = new Maslo();
		Mleko mleko = new Mleko();
		Papierosy papierosy = new Papierosy();
		Piwo piwo = new Piwo();
		List<Towar> towaryinicjalne = new ArrayList<>();
		towaryinicjalne.add(jogurt);
		towaryinicjalne.add(maslo);
		towaryinicjalne.add(mleko);
		towaryinicjalne.add(papierosy);
		towaryinicjalne.add(piwo);
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
