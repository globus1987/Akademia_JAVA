package pl.atena.edu.testtool;

import pl.atena.edu.testtool.metamodel.Risk;
import pl.atena.edu.testtool.metamodel.RiskSubject;
/**
 * @author Arkadiusz
 *
 */


public class TestTool {

	public static void main(final String[] args) {
		RiskSubject podmiot = new RiskSubject();
		podmiot.setName("w³aœciciel");
		System.out.println(podmiot.getName());
		Risk ryzyko= new Risk();
		System.out.println(ryzyko.getPrintName());

	}

}
