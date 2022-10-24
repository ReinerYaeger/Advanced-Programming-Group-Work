package factories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Customer;
import model.Department;
import model.Inventory;
import model.Invoice;
import model.InvoiceItem;
import model.Staff;

/*
 * This class is to get a session factory from hibernate,
 * hibernate connects to the database when called
 * and returns a session
 */
public class HBFactory {

	public static SessionFactory factory;

	public HBFactory() {
		factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Customer.class)
				.addAnnotatedClass(Department.class).addAnnotatedClass(Inventory.class)
				.addAnnotatedClass(InvoiceItem.class).addAnnotatedClass(Staff.class).addAnnotatedClass(Invoice.class)
				.buildSessionFactory();

	}

	public static Session getSession() {
		return factory.getCurrentSession();
	}

}
