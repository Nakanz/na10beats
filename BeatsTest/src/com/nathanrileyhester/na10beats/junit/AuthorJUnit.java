/**
 * 
 */
package com.nathanrileyhester.na10beats.junit;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;

import org.junit.jupiter.api.Test;

import com.nathanrileyhester.na10beats.domain.Author;
import com.nathanrileyhester.na10beats.persistance.AuthorMapper;

/**
 * @author nathanhester
 *
 */
class AuthorJUnit {

	@Test
	void test() {
		AuthorMapper am = new AuthorMapper();
		Connection conn = am.connectToDb();
		ArrayList<Author> authors = am.map(conn);
		assertNotNull(authors);
		Iterator<Author> i = authors.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
		}
		
		
	}

}
