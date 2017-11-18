package pl.atena.edu.akademia.wyjatkigeneryki;

public class TestGen {

	public static void main(final String[] args) throws TableException {
		// TODO Auto-generated method stub
		Table<Integer, String> tablica = new Table<>();

		tablica.addEntry(1, "Jan");

		tablica.addEntry(12, "Ana");
		tablica.addEntry(2, "Marian");
		tablica.addEntry(3, "Mirek");
		tablica.getValue(2);
		tablica.changeValue(2, "Tomek");
		tablica.getValue(2);
		tablica.wyswietl();
		tablica.deleteEntry(2);
		tablica.wyswietl();

		tablica.getValue(2);
	}
}
