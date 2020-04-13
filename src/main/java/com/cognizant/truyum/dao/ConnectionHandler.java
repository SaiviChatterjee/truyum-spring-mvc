package com.cognizant.truyum.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:connection.properties")
public class ConnectionHandler {
	@Autowired
	Environment environment;
	private Connection conn = null;

	public Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
		if (conn != null)
			return conn;

		Class.forName(environment.getProperty("DEV_DRIVER_CLASS"));
		conn = DriverManager.getConnection(environment.getProperty("DEV_URL"), environment.getProperty("DEV_USERNAME"), environment.getProperty("DEV_PASSWORD"));
		
		return conn;
	}
}
