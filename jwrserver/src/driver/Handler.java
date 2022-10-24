package driver;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import controller.CustomerContoller;
import controller.InvoiceController;
import model.ServerCommands;

public class Handler implements Runnable {

	private Socket socket;
	private ObjectOutputStream objOut;
	private ObjectInputStream objIn;

	public Handler(Socket socket) {

		try {
			this.socket = socket;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {

		System.out.println("Running");
		try {
			System.out.println("Assigning");
			this.objOut = new ObjectOutputStream(this.socket.getOutputStream());
			this.objIn = new ObjectInputStream(this.socket.getInputStream());

			System.out.println("Assigned");

			try {
				while (true) {
					System.out.println("WHile Loop");
					ServerCommands sc = (ServerCommands) objIn.readObject();
					System.out.println("Client Called Thread");

					if (sc == ServerCommands.GETCUSTOMERS) {
						objOut.writeObject(new CustomerContoller().getAllCustomers());
					}
					if (sc == ServerCommands.GETSALESREPORT) {
						String fromDate = (String) objIn.readObject();
						String toDate = (String) objIn.readObject();

						objOut.writeObject(new InvoiceController().getInvoiceReport(fromDate, toDate));

						// List<Invoice> invoices = new InvoiceController().getInvoiceReport(fromDate,
						// toDate);

						// objOut.writeObject(invoices);

					}

				}
			} catch (IOException e) {
				socket.close();
				System.out.println("Shutting Down");
				e.printStackTrace();
			}

		} catch (Exception e) {
			System.out.println("Some exception found server");
			e.printStackTrace();
		}

	}
}
