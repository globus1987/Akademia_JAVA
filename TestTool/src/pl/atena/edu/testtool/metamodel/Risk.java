package pl.atena.edu.testtool.metamodel;

/**
 * @author Arkadiusz
 *
 */
public class Risk extends MetamodelObject {


	private RiskSubject[] subjectList;
	private RiskObject[] objectList;
	private Tariff tariff;


	public void setTariff(final Tariff sTariff) {
		this.tariff=sTariff;
	}
	public Tariff getTariff() {
		return this.tariff;
	}
	public void setSubjectList(final RiskSubject[] sSubjectList) {
		this.subjectList=sSubjectList;
	}
	public RiskSubject[] getSubjectList() {
		return this.subjectList;
	}
	public void setObjectList(final RiskObject[] sObjectList) {
		this.objectList=sObjectList;
	}
	public RiskObject[] getObjectList() {
		return this.objectList;
	}

	public Risk() {
	}
}
