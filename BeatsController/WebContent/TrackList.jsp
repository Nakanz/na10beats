<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "com.nathanrileyhester.na10beats.persistence.*" 
    import = "com.nathanrileyhester.na10beats.domain.*"
    import = "java.sql.*" 
    import = "java.util.*"
    %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NA-10 BEATS</title>
</head>
<body>
<%
	TrackMapper tm = new TrackMapper();
	Connection conn = tm.connectToDb();
	ArrayList<Track> tracks = tm.map(conn);
	boolean connected = false;	
	if (conn != null) {
		connected = true;
	} 

	Iterator<Track> i = tracks.iterator();
%>
<table border = "1">
	<tr>
		<th>ID</th>
		<th>Track Name</th>
		<th>Author Name</th>
	</tr>	

<%
	while(i.hasNext()) {
		Track t = i.next();
%>
	<tr>
		<td><%= t.getId() %></td>
		<td><%= t.getName() %></td>
		<td><%= t.getAuthor().getFirst() + " " + t.getAuthor().getLast() %></td>
		<td><a href="/BeatsController/TrackServlet?delTrackId=<%= t.getId() %>">DEL</a></td>
		<td><a href="/BeatsController/TrackServlet?likeTrackId=<%= t.getId() %>">LIKE [<%=t.amountOfLikes() %>]</a></td>
	</tr>

<%
	}
	tm.closeDB(conn);
%>

</table>
<a href="NewTrack.jsp">New Track</a>

</body>
</html>