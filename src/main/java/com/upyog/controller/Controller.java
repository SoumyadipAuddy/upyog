package com.upyog.controller;

import java.util.List;

import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.RowSetDynaClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upyog.query.TestQuery;

@RestController
public class Controller {
	@Autowired
	TestQuery ob;

	@GetMapping(path = "/test")
	public String test() {
		RowSetDynaClass dynaBeanList = ob.runQuery();
		StringBuffer st=new StringBuffer();
		for (DynaBean row : (List<DynaBean>) dynaBeanList.getRows()) {
			st.append("\r\n"+row.get("pname"));
		}
		return st.toString();

	}
}
