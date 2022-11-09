package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import Log.LoggingService;
import org.hibernate.Session;

import factories.HBFactory;
import model.Staff;

import javax.swing.*;

public class StaffController implements LoggingService {

	private Session session;
	private Connection connection;
    private Statement statement = null;
    private ResultSet result = null;
    private int affectedRows = 0;

	public StaffController() {
		new HBFactory();
		session = HBFactory.getSession();
	}

	public List<Staff> getAllStaff() {
		session.beginTransaction();
		List<Staff> allStaff = session.createQuery("from Staff", Staff.class).getResultList();
		session.close();
		return allStaff;
	}

	public void registerStaff(Staff staff){
		session.beginTransaction();
		session.save(staff);
		session.getTransaction().commit();
		session.close();
	}

	public boolean verifyStaff(String username, String password) {
		String query = "from Staff where username = '" + username + "' and password = '" + password + "'";
		try {
            statement = connection.createStatement();
            result = statement.executeQuery(query);

            if(result.getBoolean("username") && result.getBoolean("password")){
				return true;
			}
		} catch (SQLException e) {
			log.error("Error in StaffController.verifyStaff: " + e);
        }catch(Exception e){
            log.error(e.getMessage());
        }
		return false;
	}

}
