package com.upyog;

import java.sql.ResultSet;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.upyog.query.TestQuery;

@SpringBootApplication
public class UpyogApplication implements ApplicationRunner{

	public static void main(String[] args){
		SpringApplication.run(UpyogApplication.class, args);
		
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		TestQuery ob=new TestQuery();
		ResultSet runQuery = ob.runQuery();
		System.out.println(runQuery);
	}

}
