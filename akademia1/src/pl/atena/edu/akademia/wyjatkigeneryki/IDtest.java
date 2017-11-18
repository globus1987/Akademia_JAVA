package pl.atena.edu.akademia.wyjatkigeneryki;

public class IDtest {

	public static void main(final String[] args) {
		// TODO Auto-generated method stub
		MObiekt o = new MObiekt();
		ID<Integer> id1 = new ID<>(20);
		ID<String> id2 = new ID<>("jakiœ klucz");
		ID<ID<Integer>> id3 = new ID<>(id1);
		id1.przypiszId(id1);
		id2.przypiszId(id2);
		id3.przypiszId(id3);
	}

}
