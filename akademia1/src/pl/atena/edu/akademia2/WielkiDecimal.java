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
		
		Gracz gracz = new Gracz();
		Gracz gracz2 = new Gracz("uda³o siê");
		
		System.out.println(gracz.wzrost);
	}

}
