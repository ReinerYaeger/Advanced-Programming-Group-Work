package controller;

import model.*;
import view.DashBoard;

import java.util.List;

public class Controller {

    Client client;
    public Controller(){
        client = new Client();
    }

    public void registerCustomer(Customer customer){

        client.sendCommand(ServerCommands.REGISTERCUSTOMER);
        client.sendCustomer(customer);
    }

    public void loginStaff(String username, String password){

        // TODO Check if staff is in database and if password is correct
        Staff staff = new Staff();
        Client client = new Client();
        client.sendStaff(staff);

    }

    public Object navigationController(String viewName){

        if(viewName.equals("Dashboard")){
            return new DashBoard();
        } else if(viewName.equals("Customer Database")){
            // TODO
        } else if(viewName.equals("Staff Database")){
            // TODO
        } else if(viewName.equals("Stock and Inventory")){
            // TODO
        } else if(viewName.equals("Check Out")){
            // TODO
        } else if(viewName.equals("Sales Reports")){
            // TODO
        } else if(viewName.equals("Register Customer")){
            // TODO
        }
        return null;

    }

    public List<Customer> getAllCustomers() {
		ServerCommands command = ServerCommands.GETCUSTOMERS;

		client.sendCommand(command);

		List<Customer> allCustomers = (List<Customer>) client.receiveResponse();

		System.out.println("Got the customers");

		//client.closeConnection();

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

    public void verifyCustomer(String value){
        client.sendCommand(ServerCommands.VERIFYCUSTOMER);
        client.send(value);
    }

}
