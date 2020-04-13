package com.upyog.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/* old for ms sql*/
@Component
public class DbConnnection {
	final String userId = "db_dev";
	final String password = "upyog@2020";
	final String dbURL = "jdbc:sqlserver://upyog-db.database.windows.net:1433;database=upyog;user=%s@upyog-db;password=%s;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
	Connection conn;
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
//
//	final String userId = "upyog@upyog-mysql";
//	final String password = "password@1234";
//	final String dbURL ="jdbc:mysql://upyog-mysql.mysql.database.azure.com:3306/upyog?useSSL=true&requireSSL=false&serverTimezone=UTC"; 
//	
//	Connection conn;
//	
//	public Connection getConnection() {
//		try {
//			if (conn == null) {
//				conn = DriverManager.getConnection(dbURL, userId, password);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return conn;
//	}
//}