package pl.atena.edu.testtool.metamodel;

/**
 * @author Arkadiusz
 *
 */
public class SalesProduct extends MetamodelObject {

	private Tariff tariff;
	private Risk[] riskList;


	public SalesProduct() {
	}

	public void setTariff(final Tariff sTariff) {
		this.tariff = sTariff;
	}

	public Tariff getTariff() {
		return this.tariff;
	}

	public Risk[] getRiskList() {
		return this.riskList;
	}

	public void setRiskList(final Risk[] riskList) {
		this.riskList = riskList;
	}

}
