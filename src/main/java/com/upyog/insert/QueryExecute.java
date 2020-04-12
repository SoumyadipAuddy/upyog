package com.upyog.insert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.commons.beanutils.RowSetDynaClass;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class QueryExecute {
	@Autowired
	public Connection conn;

	/**
	 * @param sql
	 * @return {@link RowSetDynaClass} : Result set in Dyna Bean format
	 * @throws SQLException 
	 */
	protected RowSetDynaClass execute(String sql) throws SQLException {
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		preparedStatement.execute();
		return new RowSetDynaClass(preparedStatement.getResultSet());
	}

	/**
	 * @param jsonStr
	 * @return {@link String} : Json formatted result
	 */
	public abstract String runQuery(String jsonStr);
}