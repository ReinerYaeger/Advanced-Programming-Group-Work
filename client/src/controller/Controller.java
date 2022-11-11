package controller;

import java.util.List;

import model.Customer;
import model.Inventory;
import model.Invoice;
import model.InvoiceItem;
import model.ServerCommands;
import model.Staff;
import view.DashBoard;

public class Controller {

	Client client;

	public Controller() {
		client = new Client();
	}

	public void registerCustomer(Customer customer) {

		client.sendCommand(ServerCommands.REGISTERCUSTOMER);
		client.sendCustomer(customer);

	}

	public Staff loginStaff(String username, String password) {
		client.sendCommand(ServerCommands.VERIFYSTAFF);
		Staff staff = client.sendLoginResponse(username, password);

		return staff;
	}

	public Object navigationController(String viewName) {

		if (viewName.equals("Dashboard")) {
			return new DashBoard();
		} else if (viewName.equals("Customer StaffDatabase")) {
			// TODO
		} else if (viewName.equals("Staff StaffDatabase")) {
			// TODO
		} else if (viewName.equals("Stock and Inventory")) {
			// TODO
		} else if (viewName.equals("Check Out")) {
			// TODO
		} else if (viewName.equals("Sales Reports")) {
			// TODO
		} else if (viewName.equals("Register Customer")) {
			// TODO
		}
		return null;

	}

	public List<Customer> getAllCustomers() {
		ServerCommands command = ServerCommands.GETCUSTOMERS;

		client.sendCommand(command);

		List<Customer> allCustomers = (List<Customer>) client.receiveResponse();

		System.out.println("Got the customers");

		// client.closeConnection();

		return allCustomers;

	}

	/*
	 * Returns a list of sales report based on the given dates
	 */
	public List<Invoice> searchSalesReport(String fromDate, String toDate) {

		ServerCommands command = ServerCommands.GETSALESREPORT;

		client.sendCommand(command);
		client.sendObject(fromDate);
		client.sendObject(toDate);

		List<Invoice> invoiceList = (List<Invoice>) client.receiveResponse();
		System.out.println("In Controller ");

		return invoiceList;

	}

	public void submitInvoice(Invoice invoice, List<InvoiceItem> items) {
		client.sendCommand(ServerCommands.SUBMITINVOICE);

		client.sendInvoice(invoice);
		client.sendObject(items);
		client.receiveInvoiceResponse();

	}

	public Customer verifyCustomer(String value) {
		client.sendCommand(ServerCommands.VERIFYCUSTOMER);
		return client.checkCustomerExist(value);
	}

	public void registerDiscount() {

	}

	public List<Inventory> getAllInventory() {
		client.sendCommand(ServerCommands.GETALLINVENTORY);

		return (List<Inventory>) client.receiveResponse();
	}

	public void registerStaff(Staff staff) {
		client.sendCommand(ServerCommands.REGISTERSTAFF);
		client.sendStaff(staff);

	}

	public Invoice newInvoice(Staff staff) {
		client.sendCommand(ServerCommands.NEWINVOICE);
		client.sendStaff(staff);
		return client.recieveInvoice();
	}

}
