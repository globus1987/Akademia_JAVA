/**
 *
 */
package pl.atena.edu.testtool;

import pl.atena.edu.testtool.metamodel.Risk;
import pl.atena.edu.testtool.metamodel.RiskSubject;

/**
 * @author Arkadiusz
 *
 */


public class TestTool {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {
		// TODO Auto-generated method stub
		RiskSubject podmiot = new RiskSubject();
		podmiot.setName("w³aœciciel");
		System.out.println(podmiot.getName());
		Risk ryzyko= new Risk();
		System.out.println(ryzyko.getPrintName());


	}

}
