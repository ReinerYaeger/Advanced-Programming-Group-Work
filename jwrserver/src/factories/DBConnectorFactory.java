package factories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import Log.LoggingService;

public class DBConnectorFactory implements LoggingService {

	private static Connection connection = null;

	public static Connection getDatabaseConnection() {

		if (connection != null) {
			log.info("Already Connected to A Database");
		}

		if (connection == null) {
			String url = "jdbc:mysql://remotemysql.com/Ee1ZADuysl";
			log.info("Trying to Connect to" + url);

			try {
				connection = DriverManager.getConnection(url, "Ee1ZADuysl", "wEcA1u5VsF");
				if (connection != null) {
					log.trace("Connection established");
					log.info("Connection Established : " + url);
				}
			} catch (SQLException e) {
				log.error(e.getMessage());
			} catch (Exception e) {
				log.error(e.getMessage());
			}
		}

		return connection;
	}
}
