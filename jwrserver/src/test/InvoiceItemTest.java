package test;

import Log.LoggingService;
import org.hibernate.Session;

import factories.HBFactory;
import model.Inventory;
import model.Invoice;
import model.InvoiceItem;

public class InvoiceItemTest implements LoggingService {
	public static void main(String[] args) {
		Session sesh = new HBFactory().getSession();

		sesh.beginTransaction();

		Invoice invoice = sesh.createQuery("from Invoice where invoiceNum = '1'", Invoice.class).uniqueResult();

		Inventory inventory = sesh.createQuery("from Inventory where productCode = '1'", Inventory.class)
				.uniqueResult();

		InvoiceItem invitem = new InvoiceItem(inventory, 10);

		invoice.addItem(invitem);

		sesh.save(invitem);

		sesh.getTransaction().commit();

		log.info("Invoice Item Saved\n" + invitem);
		log.info("\nThe invoice is now: \n" + invoice);
	}
}
/*
 * This will work by creating a inventory item from the client side as they
 * would have a list of the items that came form the database, the inventory
 * item is then passed to tthe server along with the invoice they already have
 * and the item will e added to the invoice and committed to the database and
 * the invoice is then passed back to the client so they can get the updated
 * invoice with the items
 */
