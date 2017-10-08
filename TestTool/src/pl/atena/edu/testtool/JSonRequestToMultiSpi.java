package pl.atena.edu.testtool;

import pl.atena.edu.testtool.metamodel.Risk;
import pl.atena.edu.testtool.metamodel.RiskObject;
import pl.atena.edu.testtool.metamodel.RiskSubject;
import pl.atena.edu.testtool.metamodel.SalesProduct;
import pl.atena.edu.testtool.metamodel.Tariff;

public class JSonRequestToMultiSpi {
	private String testCaseIdRef;
	private String request;
	private TestCase testCase;
	private String requestPart;

	public JSonRequestToMultiSpi(final TestCase testCase) {
		this.request = "";
		this.CreateRiskList(testCase.getRiskList());
		this.request = this.request.concat(this.requestPart);
		this.CreateRiskObjectList(testCase.getRiskObjectList());
		this.request = this.request.concat(this.requestPart);
		this.CreateRiskSubjectList(testCase.getRiskSubjectList());
		this.request = this.request.concat(this.requestPart);
		this.CreateSalesProduct(testCase.getSalesproduct());
		this.request = this.request.concat(this.requestPart);

	}

	private String CreateRiskList(final Risk[] riskList) {
		return this.requestPart;
	}

	private String CreateRiskObjectList(final RiskObject[] objectList) {
		return this.requestPart;
	}

	private String CreateRiskSubjectList(final RiskSubject[] subjectList) {
		return this.requestPart;
	}

	private String CreateSalesProduct(final SalesProduct salesProduct) {
		this.CreateTariff(salesProduct.getTariff());
		return this.requestPart;
	}

	private String CreateTariff(final Tariff tariff) {
		return this.requestPart;
	}

}
