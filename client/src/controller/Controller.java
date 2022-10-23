package controller;

import java.time.LocalDate;
import java.util.List;

import model.Customer;
import model.Invoice;
import model.ServerCommands;
import model.Staff;

public class Controller {

	private Client client;

	public Controller() {
		client = new Client();
	}

	public void registerCustomer(Customer customer) {
		client.sendCustomer(customer);
	}

	public void loginStaff(String username, String password) {

		// TODO Check if staff is in database and if password is correct
		Staff staff = new Staff();
		Client client = new Client();
		client.sendStaff(staff);

	}

	public List<Customer> getAllCustomers() {
		ServerCommands command = ServerCommands.GETCUSTOMERS;

		client.sendCommand(command);

		List<Customer> allCustomers = (List<Customer>) client.receiveResponse();
		
		System.out.println("Got the customers");
		
		client.closeConnection();

		return allCustomers;

	}
	
	
	/*
	 * Returns a list of sales report based on
	 * the given dates
	 */
	public List<Invoice> searchSalesReport(LocalDate fromDate, LocalDate toDate) {
		
		ServerCommands command= ServerCommands.GETSALESREPORT;
		
		client.sendCommand(command);
		client.sendObject(fromDate);
		client.sendObject(toDate);
		
		List<Invoice> salesReport = (List<Invoice>) client.receiveResponse();
		
		return salesReport;
		
	}

}
