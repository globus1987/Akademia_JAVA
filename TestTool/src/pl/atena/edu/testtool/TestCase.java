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
	SalesProduct salesproduct;
	Risk[] riskList;
	RiskObject[] riskObjectList;
	RiskSubject[] riskSubjectList;
	private String result;
	private String expectedResult;
	
	
	
	
	public TestCase() {
		// Auto-generated constructor stub
	}
	public TestCase(String name) {
		/**
		 * TestCase with specific name
		 */
		tcName=name;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Auto-generated method stub
	


	}

}
