package test;

import java.time.LocalDate;

import org.hibernate.Session;

import factories.HBFactory;
import model.Customer;

public class CustomerTest {

	public static void main(String[] args) {
		Session sesh = new HBFactory().getSession();

		sesh.beginTransaction();
		Customer customer = new Customer("Anthony Miller", LocalDate.of(2003, 6, 23), "Hannings Road", 8761234536L,
				"AnthonyTest1@gmail.com");
		sesh.save(customer);
		sesh.getTransaction().commit();
		System.out.println("Customer Saved\n" + customer);
	}

}

/*
 * "Anthony Miller", new Date(2003, 5, 23), "Hannings Road", 8761234536,
 * "Anthony@gmail.com", new Date(2022, 6, 4), new Date(2026, 6, 4)
 */