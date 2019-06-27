package com.nathanrileyhester.na10beats.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nathanrileyhester.na10beats.domain.Track;
import com.nathanrileyhester.na10beats.persistence.LikeMapper;
import com.nathanrileyhester.na10beats.persistence.TrackMapper;

/**
 * Servlet implementation class TrackServlet
 */
@WebServlet("/TrackServlet")
public class TrackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TrackServlet() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String delTrackId = request.getParameter("delTrackId");
		String likeTrackId = request.getParameter("likeTrackId");
		if (delTrackId != null) {
			deleteTrack(request, response);
		}
		else if (likeTrackId != null) {
			likeTrack(request, response);
		}	
		else {
			ServletContext sc = this.getServletContext();	
			RequestDispatcher rd = sc.getRequestDispatcher("/TrackList.jsp");
			rd.forward(request, response);
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		TrackMapper tm = new TrackMapper();
		Track t = new Track();
		t.setName(request.getParameter("TrackName"));
		int authorId = new Integer(request.getParameter("author"));
		Connection conn = tm.connectToDb();
		tm.insert(conn, t, authorId);
		// Set response content type (called a mime type)
		response.setContentType("text/html");

		response.getWriter().append("<HTML>" + "<head>" + "</head>" + "<body>").append("<h2>New Track Created!</h2>" +
			 "<p>Successfully inserted " + t.getName() + "</p>").append("<a href=\"/BeatsController/TrackList.jsp\">Return To TrackList</a>")
				.append("</body>" + "</HTML>");
		tm.closeDB(conn);
	}
	
	private void deleteTrack(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int delTrackId = new Integer(request.getParameter("delTrackId"));
		TrackMapper tm = new TrackMapper();
		Connection conn = tm.connectToDb();
		tm.delete(conn, delTrackId);
		// Set response content type (called a mime type)
		response.setContentType("text/html");

		response.getWriter().append("<HTML>" + "<head>" + "</head>" + "<body>").append("<h2>Track Deleted!</h2>" +
			 "<p>Successfully deleted " + delTrackId + "!"+ "</p>").append("<a href=\"/BeatsController/TrackList.jsp\">Return To TrackList</a>")
				.append("</body>" + "</HTML>");
		tm.closeDB(conn);
		
	}
	private void likeTrack(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int likeTrackId = new Integer(request.getParameter("likeTrackId"));
		LikeMapper tm = new LikeMapper();
		Connection conn = tm.connectToDb();
		tm.insert(conn, likeTrackId);
		// Set response content type (called a mime type)
		response.setContentType("text/html");

		response.getWriter().append("<HTML>" + "<head>" + "</head>" + "<body>").append("<h2>Track Liked!</h2>" +
			 "<p>Successfully liked " + likeTrackId + "!"+ "</p>").append("<a href=\"/BeatsController/TrackList.jsp\">Return To TrackList</a>")
				.append("</body>" + "</HTML>");
		tm.closeDB(conn);
		
	}
	
}
