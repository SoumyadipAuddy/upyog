package com.upyog.query;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.RowSetDynaClass;
import org.springframework.stereotype.Component;

import com.upyog.insert.QueryExecute;
@Component("testQuery")
public class TestQuery extends QueryExecute{
	@Override
	public String runQuery(String s)
	{
			RowSetDynaClass dynaBeanList=null;
			try {
				dynaBeanList = execute("select * from dummy_table");
			} catch (SQLException e) {
				return e.getStackTrace().toString();
			}
			StringBuffer st = new StringBuffer();
			for (DynaBean row : (List<DynaBean>) dynaBeanList.getRows()) {
				st.append("\n" + row.get("pid") + " " + row.get("name"));
			}
			return st.toString();
	}
}