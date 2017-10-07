package pl.atena.edu.testtool;

import pl.atena.edu.testtool.metamodel.*;

public class JSonRequestToMultiSpi {
	private String testCaseIdRef;
	private String request;
	private TestCase testCase;
	private String requestPart;

	public JSonRequestToMultiSpi(TestCase testCase) {
		request = "";
		CreateRiskList(testCase.riskList);
		request = request.concat(requestPart);
		CreateRiskObjectList(testCase.riskObjectList);
		request = request.concat(requestPart);
		CreateRiskSubjectList(testCase.riskSubjectList);
		request = request.concat(requestPart);
		CreateSalesProduct(testCase.salesproduct);
		request = request.concat(requestPart);

	}

	private String CreateRiskList(Risk[] riskList) {
		return requestPart;
	}

	private String CreateRiskObjectList(RiskObject[] objectList) {
		return requestPart;
	}

	private String CreateRiskSubjectList(RiskSubject[] subjectList) {
		return requestPart;
	}

	private String CreateSalesProduct(SalesProduct salesProduct) {
		CreateTariff(salesProduct.getTariff());
		return requestPart;
	}

	private String CreateTariff(Tariff tariff) {
		return requestPart;
	}

}
