package controller;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import factories.HBFactory;
import model.Inventory;
import model.Invoice;
import model.InvoiceItem;
import model.Staff;

public class InvoiceController {

	private Session session;

	public InvoiceController() {
		new HBFactory();
		session = HBFactory.getSession();
	}

	/*
	 * When the client wants to start a new invoice
	 */
	public Invoice createInvoice() {

		Invoice invoice = null;

		try {
			session.beginTransaction();
			Staff staff = session.createQuery("From Staff where id = 1", Staff.class).uniqueResult();
			invoice = new Invoice(staff);
			session.save(invoice);
			session.getTransaction().commit();

		} catch (HibernateException e) {
			System.out.println("Error with session, Invoice Controller");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
	public Invoice addItemToInvoice(Invoice invoice, Inventory inventory, int quantity) {

		try {
			session.beginTransaction();

			// Creating a new invoice item to add to invoice.
			// i.e a Inventory item with a quantitiy
			InvoiceItem invoiceItem = new InvoiceItem(inventory, quantity);

			// Adding invoice item to the invoice list
			invoice.addItem(invoiceItem);

			session.save(invoiceItem);

			session.getTransaction().commit();
		} catch (HibernateException e) {
			System.out.println("Error with session, Invoice Controller");
			e.printStackTrace();
		} finally {
			session.close();
		}

		return invoice;

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
