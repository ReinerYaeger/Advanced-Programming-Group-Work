package test;

import org.hibernate.Session;

import Log.LoggingService;
import factories.HBFactory;
import model.Invoice;
import model.Staff;

public class InvoiceTest implements LoggingService {
	public static void main(String[] args) {
		Session sesh = new HBFactory().getSession();

		sesh.beginTransaction();

		Staff staff = sesh.createQuery("from Staff where name = 'Kimone'", Staff.class).uniqueResult();

		Invoice invoice = new Invoice(staff);

		sesh.save(invoice);
		sesh.getTransaction().commit();

		log.info("Invoice Saved\n" + invoice);
		System.out.println(invoice);
	}
}
/*
 * In a live example the client would have which staff is loggin in and passed
 * that to the server when making a new invoice so the staff is added to the
 * invoice in the server then uploaded to the database
 *
 * -----
 *
 * The invoice is then passed back so the client can add items to it then when a
 * new invoice is made that is passed so essentially would finish working with
 * one invoice and on to the next
 *
 * ----
 *
 * Also if any customer code is passed in the client it would be passed to the
 * server then queried then added to the invoice
 *
 */
