package com.nathanrileyhester.na10beats.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.nathanrileyhester.na10beats.domain.Like;

public class LikeMapper extends PersistenceMapper {
	
	public ArrayList<Like> map(Connection con, int TrackID) {		
		ArrayList<Like> alikes = new ArrayList<Like>();
		try {
			//create the statement object
			Statement stmt = con.createStatement();

			
			ResultSet rs = stmt.executeQuery("select LID, TRACKid, Lwho, Ltime from TLIKE where TRACKid = " + TrackID + ";");
			
			while (rs.next()) {
				Like lk = new Like();
				lk.setId(rs.getInt("LID"));
				lk.setWho((rs.getString("Lwho")));
				lk.setTime((rs.getDate("Ltime")));
				alikes.add(lk);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return alikes;
	}
}
