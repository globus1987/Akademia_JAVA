package pl.atena.edu.akademia2;

import java.math.BigDecimal;
import java.math.BigInteger;

public class WielkiDecimal {

	public WielkiDecimal() {
	}

	public static void main(String[] args) {
		BigDecimal wielkid = BigDecimal.valueOf(12);
		BigDecimal jeden = BigDecimal.ONE;
		BigDecimal zero = BigDecimal.ZERO;
		BigDecimal suma = wielkid.add(jeden);
		BigDecimal odejmowanie = zero.subtract(wielkid);
		BigDecimal mnozenie = suma.multiply(wielkid);
		BigDecimal dzielenie = mnozenie.divide(wielkid);
		BigInteger nwd = BigInteger.valueOf(100).gcd(BigInteger.valueOf(8));

		Osoba gracz = new Osoba();
		Osoba gracz2 = new Osoba("uda³o siê");
		Osoba gracz3 = new Osoba("Jan", "Nowak");
		Osoba gracz4 = new Osoba(176, "marek", "kowalski");
		Osoba gracz5 = Osoba.instance("Kuchta", 156);
		System.out.println(
				gracz3.getImie() + " a na nazwisko ma " + gracz3.getNazwisko() + " o wzroœcie " + gracz3.getWzrost());
		System.out.println(
				gracz4.getImie() + " a na nazwisko ma " + gracz4.getNazwisko() + " o wzroœcie " + gracz4.getWzrost());
		System.out.println("na nazwisko ma " + gracz5.getNazwisko() + " o wzroœcie " + gracz5.getWzrost());

		System.out.println(gracz.getWzrost());
		System.out.println(gracz);
		System.out.println(gracz2);
		System.out.println(gracz3);
		System.out.println(gracz4);
		gracz3.starzejemySie(2);
		gracz4.starzejemySie(23);
		System.out.println(gracz3);
		System.out.println(gracz4);
		System.out.println("gracz4 pe³noletni? " + gracz4.pelnoletni());
		gracz4.starzejemySie(-15);
		System.out.println("gracz4 pe³noletni? " + (gracz4.pelnoletni()?"Tak":"Nie"));

	}

}
