package controller;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import Log.LoggingService;
import factories.HBFactory;
import model.Invoice;
import model.InvoiceItem;
import model.Staff;

public class InvoiceController implements LoggingService {

	private Session session;

	public InvoiceController() {
		new HBFactory();
		session = HBFactory.getSession();

	}

	/*
	 * When the client wants to start a new invoice
	 */
	public Invoice createInvoice(Staff staff) {

		Invoice invoice = null;

		try {
			session.beginTransaction();
			invoice = new Invoice(staff);
			session.save(invoice);
			session.getTransaction().commit();
			log.info("Invoice Created");

		} catch (HibernateException e) {
			log.error("Error with session, Invoice Controller :" + e);
			e.printStackTrace();
		} catch (Exception e) {
			log.error("Error with session, Invoice Controller :" + e);
		} finally {
			log.info("Closing session");
			session.close();
		}

		System.out.println(invoice);

		return invoice;
	}

	/*
	 * After the client has requested a new invoice, it will then send a inventory
	 * item and a quantity along with the new invoice it got from requesting a
	 * invoice and the item will be added to the invoice
	 */
	public void submitInvoice(Invoice invoice, List<InvoiceItem> items) {

		try {
			session.beginTransaction();

			if (invoice.getCustomer() != null)
				session.save(invoice);
			// Adding invoice item to the invoice list
			invoice.setItems(items);

			for (InvoiceItem item : items)
				session.save(item);

			session.getTransaction().commit();
		} catch (HibernateException e) {
			System.out.println("Error with session, Invoice Controller");
			e.printStackTrace();
		} finally {
			session.close();
		}

		return;

	}

	/*
	 * When the client wants to get all invoices
	 */
	public List<Invoice> getAllInvoice() {

		List<Invoice> allInvoice = null;

		try {
			session.beginTransaction();

			allInvoice = session.createQuery("From Invoice", Invoice.class).getResultList();

			session.getTransaction().commit();
		} catch (HibernateException e) {
			System.out.println("Error with session, Invoice Controller");
			e.printStackTrace();
		} finally {
			session.close();
		}

		System.out.println(allInvoice);

		return allInvoice;
	}

	public List<Invoice> getInvoiceReport(String fromDate, String toDate) {
		List<Invoice> allInvoice = null;
		try {
			session.beginTransaction();

			allInvoice = session.createQuery(
					"From Invoice where billingDate >= '" + fromDate + "' AND billingDate <= '" + toDate + "'",
					Invoice.class).getResultList();

			session.close();

			return allInvoice;

		} catch (HibernateException e) {
			System.out.println("Error with session, Invoice Controller");
			e.printStackTrace();
		} finally {
			session.close();
		}

		return null;
	}

}
