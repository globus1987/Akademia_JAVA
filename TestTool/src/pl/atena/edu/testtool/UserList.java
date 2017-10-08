package pl.atena.edu.testtool;

public class UserList {
	private String userName;
	private String userEmailAddress;
	private boolean notifyAboutResults;
	private boolean notifyAboutRegressionResults;

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(final String userName) {
		this.userName = userName;
	}

	public String getUserEmailAddress() {
		return this.userEmailAddress;
	}

	public void setUserEmailAddress(final String userEmailAddress) {
		this.userEmailAddress = userEmailAddress;
	}

	public boolean isNotifyAboutResults() {
		return this.notifyAboutResults;
	}

	public void setNotifyAboutResults(final boolean notifyAboutResults) {
		this.notifyAboutResults = notifyAboutResults;
	}

	public boolean isNotifyAboutRegressionResults() {
		return this.notifyAboutRegressionResults;
	}

	public void setNotifyAboutRegressionResults(final boolean notifyAboutRegressionResults) {
		this.notifyAboutRegressionResults = notifyAboutRegressionResults;
	}

}
