package com.upyog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.upyog.insert.QueryExecute;

@RestController
public class Controller {
	@Autowired
	ApplicationContext context;
	@GetMapping(path = "/test")
	public String test() {
		return "Hello home from Spring boot!!!#SocialDistancing";
	}

	@GetMapping(path = "/error")
	public String error() {
		return "Some Error occured!!I don't know what!";
	}

	@GetMapping(path = "/query")
	public String query(@RequestParam(required = false) String id) {
		QueryExecute ob=context.getBean("testQuery",QueryExecute.class);
		return ob.runQuery("select * from dummy_table");
	}

	@PostMapping(path = "/registration_seller", consumes = {"application/json","text/plain"}, produces = {"application/json","text/plain"})
	public @ResponseBody String registrationSeller(@RequestBody String jsonStr) {
		return context.getBean("sellerReg",QueryExecute.class).runQuery(jsonStr);
	}
	@PostMapping(path = "/registration_buyer", consumes = {"application/json","text/plain"}, produces = {"application/json","text/plain"})
	public @ResponseBody String registrationBuyer(@RequestBody String jsonStr) {
		return context.getBean("buyerReg",QueryExecute.class).runQuery(jsonStr);
	}
	@PostMapping(path = "/registration_ngo", consumes = {"application/json","text/plain"}, produces = {"application/json","text/plain"})
	public @ResponseBody String registrationNgo(@RequestBody String jsonStr) {
		return context.getBean("NGOReg",QueryExecute.class).runQuery(jsonStr);
	}
	@PostMapping(path = "/login", consumes = {"application/json","text/plain"}, produces = {"application/json","text/plain"})
	public @ResponseBody String login(@RequestBody String jsonStr) {
		return context.getBean("login",QueryExecute.class).runQuery(jsonStr);
	}
	@GetMapping(path = "/")
	public String home() {
		return "Hello from heroku! #SocialDistancing";
	}
}
