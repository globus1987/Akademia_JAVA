package pl.atena.edu.akademia3.sklep.towar;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class Test {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@org.junit.Test
	public final void testTowar() {

	}

	@org.junit.Test
	public final void testDostarczTowar() {
		Towar towar2 = new Towar();
		Integer liczba = Integer.valueOf(-1);
		towar2.dostarczTowar(liczba);



	}

	@org.junit.Test
	public final void testToString() {
	}

	@org.junit.Test
	public final void testNazwaProduktu() {
		Mleko towar = new Mleko();
		assertEquals("b³edna nazwa towaru",RodzajTowaru.Mleko,towar.nazwa);
		Papierosy Papierosy = new Papierosy();
		assertEquals("b³edna nazwa towaru",RodzajTowaru.Papierosy,Papierosy.nazwa);
		Piwo Piwo = new Piwo();
		assertEquals("b³edna nazwa towaru",RodzajTowaru.Piwo,Piwo.nazwa);
		Maslo Maslo = new Maslo();
		assertEquals("b³edna nazwa towaru",RodzajTowaru.Maslo,Maslo.nazwa);
		Jogurt Jogurt = new Jogurt();
		assertEquals("b³edna nazwa towaru",RodzajTowaru.Jogurt,Jogurt.nazwa);
	}
	@org.junit.Test
	public final void testDlaPe³noletnich() {
		Mleko towar = new Mleko();
		assertEquals("pelnoletni ok",false,towar.dlaPelnoletnich());
		Papierosy Papierosy = new Papierosy();
		assertEquals("niepelnoletni ",true,Papierosy.dlaPelnoletnich());
	}


}
