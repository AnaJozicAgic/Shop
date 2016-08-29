package shop.dao;

import java.sql.Connection;
import java.sql.DriverManager;

//Singleton - class that can be instantiated once
public class ConectionManager {

	// instance of itself
	private static ConectionManager instance = null;

	// DB credentials
	private final String USERNAME = "root";
	private final String PASSWORD = "root";
	private final String CONN_STRING = "jdbc:mysql://localhost/shop";
	private final String DRIVER = "com.mysql.jdbc.Driver";
	
	// connection object
	private Connection connection = null;

	// private constructor - can only be constructed from within this class
	private ConectionManager() {

	}

	// check if instance is null, instantiate and return or return
	public static ConectionManager getInstance() {
		if (instance == null) {
			instance = new ConectionManager();
		}
		return instance;
	}

	private boolean openConnection() {
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
			
			return true;
		} catch (Exception e) {
			System.err.println(e);
			return false;
		}
	}

	public Connection getConnection() {
		if (connection == null) {
			if (openConnection()) {
//				 System.out.println("Connection opened");
				return connection;
			} else {
				return null;
			}
		}
		return connection;
	}

	public void close() {
//		 System.out.println("Closing connection");
		try {
			connection.close();
			connection = null;
		} catch (Exception e) {
		}
	}
}