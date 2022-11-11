package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.hibernate.Session;

import Log.LoggingService;
import factories.DBConnectorFactory;
import factories.HBFactory;
import model.Department;
import model.Staff;

public class StaffController implements LoggingService {

	private Session session;
	private Connection connection;
	private Statement statement = null;
	private ResultSet result = null;
	private int affectedRows = 0;

	public StaffController() {
		new HBFactory();
		session = HBFactory.getSession();

		connection = DBConnectorFactory.getDatabaseConnection();
	}

	public List<Staff> getAllStaff() {
		session.beginTransaction();
		List<Staff> allStaff = session.createQuery("from Staff", Staff.class).getResultList();
		session.close();
		return allStaff;
	}

	public void registerStaff(Staff staff) {
		session.beginTransaction();
		session.save(staff);
		session.getTransaction().commit();
		session.close();
	}

	public Staff verifyStaff(String username, String password) {
		Staff staff = null;
		String query = "Select * from Staff where name = '" + username + "' and password = '" + password + "'";
		try {
			statement = connection.createStatement();
			result = statement.executeQuery(query);
			System.out.println("res\n" + result);

			System.out.println(result);
			if (result.next()) {
				staff = new Staff(result.getString("name"), result.getDate("dob").toLocalDate(),
						result.getString("address"), result.getString("telephone"), result.getString("email"),
						result.getString("type"));
				staff.setId(result.getString("staffId"));

				result = statement.executeQuery(
						"Select * from Department where departmentCode = '" + result.getString("department") + "'");
				result.next();
				Department department = new Department(result.getString("departmentCode"), result.getString("name"));

				staff.setDepartment(department);

				return staff;
			}
		} catch (SQLException e) {
			log.error("Error in StaffController.verifyStaff: " + e);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return staff;
	}

}
