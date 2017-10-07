package pl.atena.edu.testtool;

public class UserList {
	private String userName;
	private String userEmailAddress;
	private boolean notifyAboutResults;
	private boolean notifyAboutRegressionResults;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmailAddress() {
		return userEmailAddress;
	}
	public void setUserEmailAddress(String userEmailAddress) {
		this.userEmailAddress = userEmailAddress;
	}
	public boolean isNotifyAboutResults() {
		return notifyAboutResults;
	}
	public void setNotifyAboutResults(boolean notifyAboutResults) {
		this.notifyAboutResults = notifyAboutResults;
	}
	public boolean isNotifyAboutRegressionResults() {
		return notifyAboutRegressionResults;
	}
	public void setNotifyAboutRegressionResults(boolean notifyAboutRegressionResults) {
		this.notifyAboutRegressionResults = notifyAboutRegressionResults;
	}
	
	
}
