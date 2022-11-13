package driver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import Log.LoggingService;
import factories.DBConnectorFactory;
import factories.HBFactory;

public class Server implements LoggingService {

	private ServerSocket serverSocket;

	public Server(ServerSocket serverSocket) {
		this.serverSocket = serverSocket;
	}

	public void startServer() {

		try {

			log.info("Server Has Started");
			System.out.println("Logged");
			new HBFactory();
			new DBConnectorFactory();
			while (!serverSocket.isClosed()) {
				Socket socket = serverSocket.accept();
				log.info("Client has connected!");

				log.info("Creating a new Handler");
				Handler handler = new Handler(socket);
				log.info("Starting a new thread");
				new Thread(handler).start();
			}
		} catch (IOException e) {
			log.error("Error in startServer: " + e);
		} catch (Exception e) {
			log.error("Error in startServer: " + e);
		}

	}

}
