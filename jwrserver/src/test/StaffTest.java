package test;

import java.time.LocalDate;

import org.hibernate.Session;

import Log.LoggingService;
import factories.HBFactory;
import model.Department;
import model.Staff;

public class StaffTest implements LoggingService {

	public static void main(String[] args) {

		Session sesh = new HBFactory().getSession();

		sesh.beginTransaction();

		Department dep = sesh.createQuery("from Department where name= 'Management' ", Department.class).uniqueResult();

		Staff staff = new Staff("Kimone", LocalDate.of(1990, 2, 16), "2 Kings Street", "0395873625", "Alesha@gmail.com",
				"Manager", "password");

		staff.setDepartment(dep);

		sesh.save(staff);
		sesh.getTransaction().commit();

		log.info("Staff Saved\n" + staff);
	}
}
