package pl.atena.edu.testtool;

import pl.atena.edu.testtool.metamodel.Risk;
import pl.atena.edu.testtool.metamodel.RiskObject;
import pl.atena.edu.testtool.metamodel.RiskSubject;
import pl.atena.edu.testtool.metamodel.SalesProduct;

/**
 * @author Arkadiusz
 *
 */
public class TestCase {

	private String tcName;
	private int tcNumber;
	private String actualResult;
	private String expectedResult;
	private boolean regressionTestCase;
	private SalesProduct salesproduct;
	private Risk[] riskList;
	private RiskObject[] riskObjectList;
	private RiskSubject[] riskSubjectList;

	public TestCase() {
	}

	public TestCase(final String name) {
		this.tcName = name;
	}

	public void executeTestCase() {

	}
	public Risk[] getRiskList() {
		return this.riskList;
	}

	public void setRiskList(final Risk[] riskList) {
		this.riskList = riskList;
	}

	public RiskObject[] getRiskObjectList() {
		return this.riskObjectList;
	}

	public void setRiskObjectList(final RiskObject[] riskObjectList) {
		this.riskObjectList = riskObjectList;
	}

	public RiskSubject[] getRiskSubjectList() {
		return this.riskSubjectList;
	}

	public void setRiskSubjectList(final RiskSubject[] riskSubjectList) {
		this.riskSubjectList = riskSubjectList;
	}

	public SalesProduct getSalesproduct() {
		return this.salesproduct;
	}

	public void setSalesproduct(final SalesProduct salesproduct) {
		this.salesproduct = salesproduct;
	}

}
