package controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import model.Customer;
import model.Department;
import model.Inventory;
import model.Invoice;
import model.InvoiceItem;
import model.ServerCommands;
import model.Staff;

public class Client {
	private ObjectInputStream objIn;
	private ObjectOutputStream objOs;
	private Socket connectionSocket;

	public Client() {
		createConnection();
		configureConnection();
	}

	public void createConnection() {
		try {
			connectionSocket = new Socket("localhost", 8080);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void configureConnection() {
		try {
			objIn = new ObjectInputStream(connectionSocket.getInputStream());
			objOs = new ObjectOutputStream(connectionSocket.getOutputStream());
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	// close connection
	public void closeConnection() {
		try {
			objIn.close();
			objOs.close();
			connectionSocket.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void sendCommand(ServerCommands command) {
		try {
			objOs.writeObject(command);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	// send Customer object to server
	public void sendCustomer(Customer customer) {
		try {
			objOs.writeObject(customer);
			// objOs.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	// send Inventory object to server
	public void sendInventory(Inventory inventory) {
		try {
			objOs.writeObject(inventory);
			// objOs.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	// send Invoice Item object to server
	public void sendInventory(InvoiceItem item) {
		try {
			objOs.writeObject(item);
			// objOs.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	// send Staff object to server
	public void sendStaff(Staff staff) {
		try {
			objOs.writeObject(staff);

		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	// send Department object to server
	public void sendDepartment(Department department) {
		try {
			objOs.writeObject(department);

		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	// send Invoice object to server
	public void sendInvoice(Invoice invoice) {
		try {
			objOs.writeObject(invoice);

		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void sendObject(Object object) {
		try {
			objOs.writeObject(object);

		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public Object receiveInvoiceResponse() {
		try {
			System.out.println();
			return objIn.readObject();

		} catch (IOException e) {
			System.out.println("IO");
			e.printStackTrace();

		} catch (ClassNotFoundException e) {
			System.out.println("Rec Invoice");
			e.printStackTrace();

		}

		return null;
	}

	public Object receiveResponse() {
		try {
			System.out.println();
			return objIn.readObject();
		} catch (IOException e) {
			System.out.println("IO");
			e.printStackTrace();

		} catch (ClassNotFoundException e) {
			System.out.println("Rec");
			e.printStackTrace();

		}

		return null;
	}

	public Staff sendLoginResponse(String username, String password) {
		try {
			objOs.writeObject(username);
			objOs.writeObject(password);
			Staff staff = (Staff) objIn.readObject();
			return staff;
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public Invoice recieveInvoice() {
		Invoice invoice = new Invoice();
		try {
			invoice = (Invoice) objIn.readObject();
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return invoice;
	}

	// get customer from server
	public List<Customer> requestCustomer() {
		List<Customer> customer = new ArrayList<Customer>();
		try {
			customer.add((Customer) objIn.readObject());
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return customer;
	}

	public Customer checkCustomerExist(String number) {
		Customer customer;
		try {
			objOs.writeObject(number);
			customer = (Customer) objIn.readObject();
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return customer;
	}

}
