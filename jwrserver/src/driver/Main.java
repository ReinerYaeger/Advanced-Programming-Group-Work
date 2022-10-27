package driver;

import Log.LoggingService;

import java.io.IOException;
import java.net.ServerSocket;

public class Main implements LoggingService {
	public static void main(String[] args) {
		try {

			log.info("Creating a new Server");
			new Server(new ServerSocket(8080)).startServer();

		} catch (IOException e) {
			log.error("Error in main: " + e);
		}catch (Exception e){
			log.error("Error in main: " + e);
		}

	}
}
