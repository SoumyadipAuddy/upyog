package com.upyog.config;

import java.sql.Connection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
	@Autowired
	DbConnnection conObject;
	@Bean
	public Connection provideConnection() {
		return conObject.getConnection();
	}

}
