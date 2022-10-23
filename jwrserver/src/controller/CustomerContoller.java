package controller;

import java.util.List;

import org.hibernate.Session;

import factories.HBFactory;
import model.Customer;

public class CustomerContoller {

	private Session session;

	public CustomerContoller() {
		new HBFactory();
		session = HBFactory.getSession();
	}

	public List<Customer> getAllCustomers() {

		session.beginTransaction();

		List<Customer> allCustomer = session.createQuery("from Customer", Customer.class).getResultList();

		session.close();

		return allCustomer;
	}

}
