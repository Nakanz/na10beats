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
<title>Add a New Track</title>
</head>
<body>
<%
	AuthorMapper am = new AuthorMapper();
	Connection conn = am.connectToDb();
	ArrayList<Author> authors = am.map(conn);
	boolean connected = false;	
	if (conn != null) {
		connected = true;
	} 

	Iterator<Author> i = authors.iterator();
%>
	<form action= "TrackServlet" method = "post">
	  Track Name:<br>
	  <input type="text" name="TrackName" value="">
	  <br>
	   Author:<br>
	   	<select name="author">
<%
	while(i.hasNext()) {
		Author au = i.next();
%>
		  <option value="<%= au.getId() %>"> <%=au.getFirst() + " " + au.getLast() %></option>
		 
<%
	}
	am.closeDB(conn);
%>		
		</select>
	  
	  <br><br>
	  <input type="submit" value="Submit">
	</form> 

</body>
</html>