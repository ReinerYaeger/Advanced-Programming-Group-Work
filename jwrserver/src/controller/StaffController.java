package controller;

import java.util.List;

import org.hibernate.Session;

import factories.HBFactory;
import model.Staff;

public class StaffController {

	private Session session;

	public StaffController() {
		new HBFactory();
		session = HBFactory.getSession();
	}

	public List<Staff> getAllCustomers() {

		session.beginTransaction();

		List<Staff> allStaff = session.createQuery("from Staff", Staff.class).getResultList();

		session.close();

		return allStaff;
	}

}
