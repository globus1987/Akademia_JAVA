/**
 * 
 */
package pl.atena.edu.testtool;

import pl.atena.edu.testtool.metamodel.*;

/**
 * @author Arkadiusz
 *
 */


public class TestTool {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RiskSubject podmiot = new RiskSubject();
		podmiot.setName("w�a�ciciel");
		System.out.println(podmiot.getName());
		Risk ryzyko= new Risk();
		System.out.println(ryzyko.getPrintName());
		
		
	}

}
