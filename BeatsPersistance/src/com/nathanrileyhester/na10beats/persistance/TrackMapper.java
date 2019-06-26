package com.nathanrileyhester.na10beats.persistance;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.nathanrileyhester.na10beats.domain.Track;

public class TrackMapper {
	private ArrayList<Track> queryDB(Connection con) {
		ArrayList<Track> eList = new ArrayList<Track>();

		try {
			// step3 create the statement object
			Statement stmt = con.createStatement();

			// step4 execute query
			ResultSet rs = stmt.executeQuery("select Tname, Ptrack, Author, Tlikes from TRACK;");
			//Tname varchar(42),Ptrack blob,Author varchar(42),Tlikes INTEGER
			while (rs.next()) {
				Track tk = new Track();
				
				tk.setName(rs.getString(2));
			
				eList.add(tk);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return eList;
	}

}
