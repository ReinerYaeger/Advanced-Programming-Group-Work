package controller;

import java.util.List;

import model.Customer;
import model.ServerCommands;
import model.Staff;

public class Controller {

	private Client client;

	public Controller() {
		;
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

		return allCustomers;

	}

}
