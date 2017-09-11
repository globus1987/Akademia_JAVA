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
	private String[] subjectList;
	private String[] objectList;
	private String tariff;
	
	/**
	 * get/set methods
	 */
	public void setTariff(String sTariff) {
		tariff=sTariff;
	}
	public String getTariff() {
		return tariff;
	}
	public void setSubjectList(String[] sSubjectList) {
		subjectList=sSubjectList;
	}
	public String[] getSubjectList() {
		return subjectList;
	}
	public void setObjectList(String[] sObjectList) {
		objectList=sObjectList;
	}
	public String[] getObjectList() {
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
