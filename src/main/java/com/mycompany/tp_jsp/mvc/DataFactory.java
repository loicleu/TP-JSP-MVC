package com.mycompany.tp_jsp.mvc;

import javax.sql.DataSource;

public class DataFactory {


	public static DataSource getDataSource() {
		DataSource result;
		org.apache.derby.jdbc.ClientDataSource ds = new org.apache.derby.jdbc.ClientDataSource();
		ds.setDatabaseName("sample");
				ds.setUser("app");
				ds.setPassword("app");
				// The host on which Network Server is running
				ds.setServerName("localhost");
				// port on which Network Server is listening
				ds.setPortNumber(1527);
				result = ds;
		

		return result;
	}

}
