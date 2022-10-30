package driver;

import Log.LoggingService;

import javax.swing.*;
import java.io.IOException;
import java.net.ServerSocket;

public class Main implements LoggingService {
	public static void main(String[] args) {
		try {

			log.info("Creating a new Server");
			new Server(new ServerSocket(8080)).startServer();

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error in Main: " + e);
			log.error("Error in main: " + e);
		}catch (Exception e){
			JOptionPane.showMessageDialog(null, "Error in Main: " + e);
			log.error("Error in main: " + e);
		}

	}
}
