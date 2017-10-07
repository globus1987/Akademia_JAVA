/**
 * 
 */
package pl.atena.edu.testtool.metamodel;

/**
 * @author Arkadiusz
 *
 */
public class Risk extends MetamodelObject {

	/**
	 * 
	 */
	private RiskSubject[] subjectList;
	private RiskObject[] objectList;
	private Tariff tariff;
	
	/**
	 * get/set methods
	 */
	public void setTariff(Tariff sTariff) {
		tariff=sTariff;
	}
	public Tariff getTariff() {
		return tariff;
	}
	public void setSubjectList(RiskSubject[] sSubjectList) {
		subjectList=sSubjectList;
	}
	public RiskSubject[] getSubjectList() {
		return subjectList;
	}
	public void setObjectList(RiskObject[] sObjectList) {
		objectList=sObjectList;
	}
	public RiskObject[] getObjectList() {
		return objectList;
	}
	/**
	 * constructors
	 */
	public Risk() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
