package com.nathanrileyhester.na10beats.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.nathanrileyhester.na10beats.domain.Author;

public class AuthorMapper extends PersistenceMapper {

	public ArrayList<Author> map(Connection con) {
		ArrayList<Author> eList = new ArrayList<Author>();

		try {
			// create the statement object
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("select AID, firstN, lastN, homepage from Author;");

			while (rs.next()) {
				Author au = mapAu(rs);
				eList.add(au);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return eList;
	}

	public Author map(Connection con, int AuthorID) {
		Author au = null;
		try {
			// create the statement object
			Statement stmt = con.createStatement();

			ResultSet rs = stmt
					.executeQuery("select AID, firstN, lastN, homepage from Author where AID = " + AuthorID + ";");

			if (rs.next()) {
				au = mapAu(rs);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return au;
	}

	private Author mapAu(ResultSet rs) {
		Author au = null;
		try {
			au = new Author();

			au.setId(rs.getInt("AID"));
			au.setFirst(rs.getString("firstN"));
			au.setLast(rs.getString("lastN"));
			au.setAuthorHomePage(rs.getString("homepage"));
		} catch (Exception e) {
			System.out.println(e);
		}
		return au;
	}

}
