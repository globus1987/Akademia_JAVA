/**
 * 
 */
package pl.atena.edu.testtool.metamodel;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

/**
 * @author Arkadiusz
 *
 */
public class MetamodelObject {

	/**
	 * 
	 */
	private String printName;
	private String name;
	private String symbol;

	public MetamodelObject() {
		// TODO Auto-generated constructor stub
		name="temporary name";
		printName="temporary printname";
		symbol="temporary symbol";
		
	}

	public void setName(String sname) {
		name = sname;
	}

	public String getName() {
		return name;
	}

	public void setPrintName(String sprintName) {
		printName = sprintName;
	}

	public String getPrintName() {
		return printName;
	}

	public void setSymbol(String sSymbol) {
		symbol = sSymbol;
	}

	public String getSymbol() {
		return symbol;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
