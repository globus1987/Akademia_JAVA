package pl.atena.edu.testtool.metamodel;


/**
 * @author Arkadiusz
 *
 */
public class MetamodelObject {

	private String printName;
	private String name;
	private String symbol;

	public MetamodelObject() {
		this.name="temporary name";
		this.printName="temporary printname";
		this.symbol="temporary symbol";
	}

	public void setName(final String sname) {
		this.name = sname;
	}

	public String getName() {
		return this.name;
	}

	public void setPrintName(final String sprintName) {
		this.printName = sprintName;
	}

	public String getPrintName() {
		return this.printName;
	}

	public void setSymbol(final String sSymbol) {
		this.symbol = sSymbol;
	}

	public String getSymbol() {
		return this.symbol;
	}
}
