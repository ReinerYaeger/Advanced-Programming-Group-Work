package driver;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import Log.*;
import controller.CustomerController;
import controller.InvoiceController;
import factories.HBFactory;
import model.Customer;
import model.ServerCommands;
import org.hibernate.Session;

import javax.swing.*;

public class Handler implements Runnable, LoggingService {

	private Socket socket;
	private ObjectOutputStream objOut;
	private ObjectInputStream objIn;

	public Handler(Socket socket) {

		try {
			this.socket = socket;
		} catch (Exception e) {
			log.error("Error in Handler constructor: " + e);
		}
	}

	@Override
	public void run() {

		log.info("Handler has started");
		System.out.println("Running");
		try {
			System.out.println("Assigning");
			this.objOut = new ObjectOutputStream(this.socket.getOutputStream());
			this.objIn = new ObjectInputStream(this.socket.getInputStream());

			System.out.println("Assigned");

			try {
				while (true) {
					log.info("Waiting for command");
					System.out.println("While Loop");
					ServerCommands sc = (ServerCommands) objIn.readObject();
					log.info("Client Called Thread");

					if (sc == ServerCommands.GETCUSTOMERS) {
						objOut.writeObject(new CustomerController().getAllCustomers());
					}
					if (sc == ServerCommands.GETSALESREPORT) {
						String fromDate = (String) objIn.readObject();
						String toDate = (String) objIn.readObject();

						objOut.writeObject(new InvoiceController().getInvoiceReport(fromDate, toDate));

						// List<Invoice> invoices = new InvoiceController().getInvoiceReport(fromDate,
						// toDate);

						// objOut.writeObject(invoices);
					}
					if(sc == ServerCommands.REGISTERCUSTOMER){
						Customer customer = (Customer) objIn.readObject();

						Session sesh = new HBFactory().getSession();

						sesh.beginTransaction();
						sesh.save(customer);
						sesh.getTransaction().commit();
						log.info("Customer Saved\n" + customer);
					}

					if(sc == ServerCommands.VERIFYCUSTOMER){
						String telephone = (String) objIn.readObject();

					}
				}
			} catch (IOException e) {
				socket.close();
				JOptionPane.showMessageDialog(null, "Client Disconnected: " + e);
				log.error("Client Disconnected: " + e);
				log.error("Shutting Down");
				e.printStackTrace();
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error in Handler: " + e);
			log.error("Error in Handler run: " + e);
			e.printStackTrace();
		}

	}
}
