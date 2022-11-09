package factories;

import Log.LoggingService;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectorFactory  implements LoggingService {

    private static Connection connection = null;

    public DBConnectorFactory(){
        getDatabaseConnection();
    }
    public static Connection getDatabaseConnection(){

        if(connection != null){
            log.info("Already Connected to A Database");
        }

        if(connection == null){
            String url="jdbc:mysql://localhost:3307/dbTest";
            log.info("Trying to Connect to" + url);

			try {
				connection= DriverManager.getConnection(url, "root", "");
				if(connection!=null) {
					 log.trace("Connection established");
                     log.info("Connection Established : "+ url);
				}
			}catch(SQLException e){
                log.error(e.getMessage());
            }
            catch(Exception e) {
				log.error(e.getMessage());
			}
        }

        return connection;
    }
}
