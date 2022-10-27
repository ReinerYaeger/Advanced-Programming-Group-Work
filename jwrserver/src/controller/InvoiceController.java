package controller;

import java.util.List;

import Log.LoggingService;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import factories.HBFactory;
import model.Inventory;
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
		}catch (Exception e) {
			log.error("Error with session, Invoice Controller :" + e);
		} finally {
			log.info("Closing session");
			session.close();
		}

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

		return allInvoice;
	}

}
