package com.nathanrileyhester.na10beats.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.nathanrileyhester.na10beats.domain.Like;
import com.nathanrileyhester.na10beats.domain.Track;

public class TrackMapper extends PersistenceMapper {
	public ArrayList<Track> map(Connection con) {
		ArrayList<Track> eList = new ArrayList<Track>();
		
		try {
			//create the statement object
			Statement stmt = con.createStatement();

			
			ResultSet rs = stmt.executeQuery("select TID, AuthorID, Tname, Ptrack from TRACK;");
			
			while (rs.next()) {
				Track tk = new Track();
				tk.setId(rs.getInt("TID"));
				tk.setName(rs.getString("Tname"));
				tk.setTrack(rs.getBytes("Ptrack"));
			
				AuthorMapper am = new AuthorMapper();
				tk.setAuthor(am.map(con, rs.getInt("AuthorID")));

				ArrayList<Like> la = new ArrayList<Like>();
				LikeMapper lm = new LikeMapper();
				la = lm.map(con, tk.getId());
				tk.setLikes(la);
				
				eList.add(tk);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return eList;
	}
	
	public void insert(Connection con, Track obj, int authorId) {
		obj.setId(getNextId(con, "TRACK"));
		
		try {
			//create the statement object
			Statement stmt = con.createStatement();
			//insert new track
			String sql = "INSERT INTO TRACK(TID, AuthorID, Tname) VALUES(" + obj.getId() + ", " + 
					authorId + ", '" + obj.getName() + "');";
			stmt.executeUpdate(sql);
		
		//	con.commit();	
			
		} catch (Exception e) {
			System.out.println(e);
		}
	
	}
		
	

}
