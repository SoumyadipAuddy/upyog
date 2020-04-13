package com.upyog.query;

import java.sql.SQLException;

import org.apache.commons.beanutils.RowSetDynaClass;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.upyog.insert.QueryExecute;

public class Login extends QueryExecute {

	final String querySql = "select uid,customer_status from upyogdb.%s where email='%s' and password='%s';";

	@Override
	public String runQuery(String jsonStr) {
		JsonObject requestJson = JsonParser.parseString(jsonStr).getAsJsonObject();
		String[] param = new String[2];
		param[0] = requestJson.get("email").getAsString();
		param[1] = requestJson.get("password").getAsString();
		JsonObject responseJson = new JsonObject();
		responseJson.addProperty("status", "success");
		try {
			JsonObject data = new JsonObject();
			extractResult(param, data, "seller");
		/*	extractResult(param, data, "buyer");
			extractResult(param, data, "ngo");*/
			requestJson.add("data", data);
		} catch (SQLException e) {
			responseJson.addProperty("status", "failure");
			responseJson.addProperty("stackTrace", e.getMessage());
		}
		
		return responseJson.toString();
	}

	/**
	 * @param param
	 * @param data
	 * @param table
	 * @throws SQLException
	 */
	private void extractResult(String[] param, JsonObject data, String table) throws SQLException {
		RowSetDynaClass result = execute(String.format(querySql, table, param));
		if (result != null) {
			data.addProperty("uid", result.getRows().get(0).get("uid").toString());
			data.addProperty("customer_status", result.getRows().get(0).get("customer_status").toString());
		}
	}

}
