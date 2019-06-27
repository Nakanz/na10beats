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
	<form action= "trackServlet" method = "post">
	  Track Name:<br>
	  <input type="text" name="TrackName" value="">
	  <br>
	   Author:<br>
	  <input type="text" name="AuthorName" value="">
	  <br><br>
	  <input type="submit" value="Submit">
	</form> 

</body>
</html>