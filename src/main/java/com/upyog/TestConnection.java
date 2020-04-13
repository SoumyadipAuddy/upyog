package com.upyog;

import java.sql.Connection;
import java.util.List;

import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.RowSetDynaClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.upyog.query.TestQuery;
//@SpringBootApplication used to implement application runner
public class TestConnection{
	/*
	@Autowired
	Connection conn;
	@Autowired
	TestQuery ob;
public static void main(String[] args) {
	SpringApplication.run(TestConnection.class, args);
}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println( ob.runQuery(""));
	}
	*/
}
