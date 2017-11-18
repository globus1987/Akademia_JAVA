package pl.atena.edu.akademia3.sklep;

import java.math.BigDecimal;

public enum RodzajTowaru {
	Piwo(true,BigDecimal.valueOf(10)) {
		@Override
		public String tekst() {
			return "Pijemy";
		}
	},
	Jogurt(false,BigDecimal.valueOf(2)) {
		@Override
		public String tekst() {
			return "Wcinamy";
		}
	},
	Maslo(false,BigDecimal.valueOf(4)) {
		@Override
		public String tekst() {
			return "Smarujemy";
		}
	},
	Mleko(false,BigDecimal.valueOf(5)) {

		@Override
		public String tekst() {
			return "gdzie s¹ p³atki?";
		}
	},
	Papierosy(true,BigDecimal.valueOf(100)) {

		@Override
		public String tekst() {
			return "Zapalmy";
		}
	};
	private Boolean dlaPelnoletnich;
	private BigDecimal cenaBazowa;
	public BigDecimal getCenaBazowa() {
		return this.cenaBazowa;
	}

	private RodzajTowaru(final Boolean dlaPelnoletnich) {
		this.dlaPelnoletnich = dlaPelnoletnich;
	}
	private RodzajTowaru(final Boolean dlaPelnoletnich,final BigDecimal cena) {
		this.dlaPelnoletnich = dlaPelnoletnich;
		this.cenaBazowa=cena;
	}

	public Boolean getDlaPelnoletnich() {
		return this.dlaPelnoletnich;
	}

	public abstract String tekst();

}
