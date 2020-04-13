package com.upyog.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DbConnnection {
	final String userId = "db_dev";
	final String password = "upyog@2020";
	final String dbURL = "jdbc:sqlserver://upyog-db.database.windows.net:1433;database=upyog;user=%s@upyog-db;password=%s;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
	Connection conn;

	@Bean("connection")
	public Connection getConnection() {
		try {
			if (conn == null) {
				conn = DriverManager.getConnection(String.format(dbURL, userId, password));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}
