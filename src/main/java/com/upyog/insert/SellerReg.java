package com.upyog.insert;

import java.sql.SQLException;

import org.springframework.stereotype.Component;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Component("sellerReg")
public class SellerReg extends QueryExecute {

	final String insertSql = "insert into mydb.Register(Reg_Id,Reg_First name,Reg_Last name,Reg_Contact no,Reg_Email address,Reg_Password,Reg_Confirm Password,Reg_Address,Reg_type) values (%s,%s,%s,%s,%s,%s,%s,%s,%s)";

	@Override
	public String runQuery(String jsonStr) {
		JsonObject requestJson = JsonParser.parseString(jsonStr).getAsJsonObject();
		String[] param = new String[9];
		param[0] = String.valueOf((int)(Math.random()*1000));
		param[1] = requestJson.get("firstName").getAsString();
		param[2] = requestJson.get("lastName").getAsString();
		param[3] = requestJson.get("mobileNo").getAsString();
		param[4] = requestJson.get("email").getAsString();
		param[5] = requestJson.get("password").getAsString();
		param[6] = requestJson.get("password").getAsString();
		param[7] = requestJson.get("address").getAsString();
		param[8] = requestJson.get("customer_status").getAsString();
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
