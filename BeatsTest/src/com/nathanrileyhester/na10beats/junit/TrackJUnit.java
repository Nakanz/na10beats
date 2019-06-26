/**
 * 
 */
package com.nathanrileyhester.na10beats.junit;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;

import org.junit.jupiter.api.Test;


import com.nathanrileyhester.na10beats.domain.Track;
import com.nathanrileyhester.na10beats.persistence.TrackMapper;

/**
 * @author nathanhester
 *
 */
class TrackJUnit {

	@Test
	void test() {
		TrackMapper tm = new TrackMapper();
		Connection conn = tm.connectToDb();
		ArrayList<Track> tracks = tm.map(conn);
		assertNotNull(tracks);
		Iterator<Track> i = tracks.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
		}
		
		
	}

}
