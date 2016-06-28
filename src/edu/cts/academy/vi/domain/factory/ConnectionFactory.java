package edu.cts.academy.vi.domain.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static ConnectionFactory instance = new ConnectionFactory();

	String url = "jdbc:mysql://localhost:3306/vehicle_insurance";
	String user = "root";
	String password = "root";

	String driverClass = "com.mysql.jdbc.Driver";

	private ConnectionFactory() {
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
//Singleton class
	public static ConnectionFactory getInstance() {
		return instance;
	}

	public Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
