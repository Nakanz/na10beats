package com.nathanrileyhester.na10beats.persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public abstract class PersistanceMapper {
	private Connection connectToDb() {
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

	/*private ArrayList<Employee> queryDB(Connection con) {
		ArrayList<Employee> eList = new ArrayList<Employee>();

		try {
			// step3 create the statement object
			Statement stmt = con.createStatement();

			// step4 execute query
			ResultSet rs = stmt.executeQuery("select id, name, age from emp");

			while (rs.next()) {
				Employee emp = new Employee();
				emp.setId(rs.getInt(1));
				emp.setName(rs.getString(2));
				emp.setAge(rs.getInt(3));
				eList.add(emp);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return eList;
	}*/

	private void closeDB(Connection con) {
		// step5 close the connection object
		try {
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
