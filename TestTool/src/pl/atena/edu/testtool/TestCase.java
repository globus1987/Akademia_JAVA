/**
 * 
 */
package pl.atena.edu.testtool;

import pl.atena.edu.testtool.metamodel.*;

/**
 * @author Arkadiusz
 *
 */
public class TestCase {

	/**
	 * 
	 */
	private String tcName;
	private int tcNumber;
	private String actualResult;
	private String expectedResult;
	private boolean regressionTestCase;
	SalesProduct salesproduct;
	Risk[] riskList;
	RiskObject[] riskObjectList;
	RiskSubject[] riskSubjectList;

	public TestCase() {
		// Auto-generated constructor stub
	}

	public TestCase(String name) {
		tcName = name;
	}

	public void ExecuteTestCase() {

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Auto-generated method stub

	}

}
