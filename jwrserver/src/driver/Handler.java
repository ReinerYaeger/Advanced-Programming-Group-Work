package driver;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;

import Log.*;

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

	}

}
