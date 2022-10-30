package driver;

import Log.LoggingService;

import javax.swing.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;

public class Server implements LoggingService {

	private ServerSocket serverSocket;

	public Server(ServerSocket serverSocket) {
		this.serverSocket = serverSocket;
	}

	public void startServer() {

		try {
			log.info("Server Has Started");

			while (!serverSocket.isClosed()) {
				Socket socket = serverSocket.accept();
				log.info("Client has connected!");

				log.info("Creating a new Handler");
				Handler handler = new Handler(socket);
				log.info("Starting a new thread");
				new Thread(handler).start();
			}
		}catch (IOException e) {
			log.error("Error in startServer: " + e);
		}catch (Exception e){
			log.error("Error in startServer: " + e);
		}

	}

}
