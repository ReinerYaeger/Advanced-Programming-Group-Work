package controller;

import java.util.List;

import org.hibernate.Session;

import factories.HBFactory;
import model.Customer;

public class CustomerController {
	private Session session;

	public CustomerController() {
		session = HBFactory.getSession();
	}

	public List<Customer> getAllCustomers() {

		session.beginTransaction();

		List<Customer> allCustomer = session.createQuery("from Customer", Customer.class).getResultList();

		// System.out.println(allCustomer);

		session.close();

		return allCustomer;
	}

	public Customer verifyCustomer(String telephone) {
		Customer customer;
		session.beginTransaction();

		customer = session.createQuery("from Customer where telephone = " + telephone + "", Customer.class)
				.uniqueResult();
		session.close();

		return customer;
	}

}
