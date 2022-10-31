package test;

import java.time.LocalDate;

import Log.LoggingService;
import org.hibernate.Session;

import factories.HBFactory;
import model.Customer;

public class CustomerTest implements LoggingService {

	public static void main(String[] args) {
		Session sesh = new HBFactory().getSession();

		Customer customer = new Customer(Math.random()*99999999 + "","Fred Miller", LocalDate.of(2000, 10, 15), "Manor Park", "87612355126",
				"Test1@gmail.com");

		sesh.beginTransaction();

		sesh.save("Customer", customer);
		sesh.getTransaction().commit();
		log.info("Customer Saved\n" + customer);
	}

}

/*
 * "Anthony Miller", new Date(2003, 5, 23), "Hannings Road", 8761234536,
 * "Anthony@gmail.com", new Date(2022, 6, 4), new Date(2026, 6, 4)
 */