package model;

public class LoggedIn {

	// Singleton Class - Only one instance of the class exists

	private static LoggedIn loggedIn = null;
	private static Staff staff;

	private LoggedIn() {

	}

	public static LoggedIn getInstance() {
		if (loggedIn == null)
			loggedIn = new LoggedIn();

		return loggedIn;
	}

	public static Staff getStaff() {
		return staff;
	}

	public static void setStaff(Staff staff) {
		LoggedIn.staff = staff;
	}

}
