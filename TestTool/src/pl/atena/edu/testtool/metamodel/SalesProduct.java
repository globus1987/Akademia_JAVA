package pl.atena.edu.testtool.metamodel;

/**
 * @author Arkadiusz
 *
 */
public class SalesProduct extends MetamodelObject {

	/**
	 * variables
	 */
	private Tariff tariff;
	private Risk[] riskList;

	/**
	 * constructors
	 */
	public SalesProduct() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * get/set methods
	 */
	public void setTariff(Tariff sTariff) {
		tariff = sTariff;
	}

	public Tariff getTariff() {
		return tariff;
	}

	public Risk[] getRiskList() {
		return riskList;
	}

	public void setRiskList(Risk[] riskList) {
		this.riskList = riskList;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
