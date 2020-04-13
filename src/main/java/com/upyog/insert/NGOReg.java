package com.upyog.insert;

import java.sql.SQLException;

import org.springframework.stereotype.Component;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Component("NGOReg")
public class NGOReg extends QueryExecute {
	
	final String insertSql = "insert into upyogdb.ngo(firstName,lastName,ngoName,mobileNo,password,address,customer_status,email,govtRegistrationNo) values ('%s','%s','%s','%s','%s','%s','%s','%s','%s')";

	@Override
	public String runQuery(String jsonStr) {
		// TODO Auto-generated method stub
		JsonObject requestJson = JsonParser.parseString(jsonStr).getAsJsonObject();
		String[] param = new String[9];
		param[0] = requestJson.get("firstName").getAsString();
		param[1] = requestJson.get("lastName").getAsString();
		param[2] = requestJson.get("nameOfNGO").getAsString();
		param[3] = requestJson.get("mobileNo").getAsString();
		param[4] = requestJson.get("password").getAsString();
		param[5] = requestJson.get("address").getAsString();
		param[6] = requestJson.get("customer_status").getAsString();
		param[7] = requestJson.get("email").getAsString();
		param[8] = requestJson.get("govtRegistrationNo").getAsString();
		JsonObject responseJson = new JsonObject();
		responseJson.addProperty("status", "success");
		try {
			execute(String.format(insertSql, param));
		} catch (SQLException e) {
			responseJson.addProperty("status", "failure");
			responseJson.addProperty("stackTrace", e.getMessage());
		}
		return responseJson.toString();
	}

}
