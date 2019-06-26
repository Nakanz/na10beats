package com.nathanrileyhester.na10beats.persistance;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.nathanrileyhester.na10beats.domain.Track;

public class TrackMapper extends PersistenceMapper {
	private ArrayList<Track> map(Connection con) {
		ArrayList<Track> eList = new ArrayList<Track>();
		
		try {
			//create the statement object
			Statement stmt = con.createStatement();

			
			ResultSet rs = stmt.executeQuery("select TID, Tname, Ptrack, Author from TRACK;");
			
			while (rs.next()) {
				Track tk = new Track();
				
				
			
				eList.add(tk);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return eList;
	}

}
