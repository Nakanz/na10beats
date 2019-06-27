package com.nathanrileyhester.na10beats.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
/*import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;*/
  

public abstract class PersistenceMapper {
	public Connection connectToDb() {
		Connection con = null;
		try {
			// step1 load the driver class
			Class.forName("com.mysql.cj.jdbc.Driver");

			// step2 create the connection object
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/na10beats", "root", "Pauahi808");

		} catch (Exception e) {
			System.out.println(e);
		}

		return con;
	}

	public void closeDB(Connection con) {
		// step5 close the connection object
		try {
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
}
