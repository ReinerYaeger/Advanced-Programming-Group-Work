package test;

import org.hibernate.Session;

import Log.LoggingService;
import factories.HBFactory;
import model.Department;

public class DepartmentTest implements LoggingService {

	public static void main(String[] args) {
		new HBFactory();
		Session sesh = HBFactory.getSession();

		sesh.beginTransaction();

		Department dep = new Department("300", "Accounting");

		sesh.save(dep);
		sesh.getTransaction().commit();

		log.info("Dep ID: " + dep.getName());

	}

}
