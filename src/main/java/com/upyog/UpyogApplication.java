package com.upyog;

import java.util.List;

import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.RowSetDynaClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.upyog.query.TestQuery;

@SpringBootApplication
public class UpyogApplication implements ApplicationRunner {
	@Autowired
	TestQuery ob;

	public static void main(String[] args) {
		SpringApplication upyogApplication = new SpringApplication(UpyogApplication.class);
		upyogApplication.run(args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		RowSetDynaClass dynaBeanList = ob.runQuery();
		for (DynaBean row : (List<DynaBean>)dynaBeanList.getRows()) {
			System.out.println(row.get("pname"));
		}
	}

}
