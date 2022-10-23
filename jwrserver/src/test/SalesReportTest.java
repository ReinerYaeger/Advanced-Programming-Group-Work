package test;

import org.hibernate.Session;

import factories.HBFactory;
import model.Invoice;
import model.Staff;

public class SalesReportTest {

	public static void main(String[] args) {
		Session sesh = new HBFactory().getSession();

		sesh.beginTransaction();

		

		sesh.getTransaction().commit();

		
		
	}
}
