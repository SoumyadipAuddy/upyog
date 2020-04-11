package com.upyog.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public class TestQuery {
	@Autowired
	ApplicationContext context;

	public ResultSet runQuery() {
		try {
			Connection conn=context.getBean("connection", Connection.class);
			PreparedStatement prepareStatement =conn.prepareStatement("select * from dbo.Product");
			prepareStatement.execute();
			return prepareStatement.getResultSet();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
