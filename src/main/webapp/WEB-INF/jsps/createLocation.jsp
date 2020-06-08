<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Location</title>
</head>
<body>

<form action="savelocation" method="post">
<pre>
ID:<input type="text" name="id"/>
CODE:<input type="text" name="code"/>
NAME:<input type="text" name="name"/>
TYPE: Urban<input type="radio" name="type" value="URBAN"/>
      Rural<input type="radio" name="type" value="RURAL"/>
 <input type="submit" value="save"/>     
</pre>
</form>

   ${msg}

<a href="displayLocations">view All</a>

</body>
</html>