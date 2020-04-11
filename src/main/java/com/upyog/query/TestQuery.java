package com.upyog.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.beanutils.RowSetDynaClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
@Component
public class TestQuery {
	@Autowired
	ApplicationContext context;

	public RowSetDynaClass runQuery() {
		try {
			Connection conn=context.getBean("connection", Connection.class);
			PreparedStatement prepareStatement =conn.prepareStatement("select * from dbo.Product");
			prepareStatement.execute();
			return new RowSetDynaClass(prepareStatement.getResultSet());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
