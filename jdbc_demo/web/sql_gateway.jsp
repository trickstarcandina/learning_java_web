<!doctype html public 
"-//W3C//DTD HTML 4.0 Transitional//EN">
<html>

<head>
    <title>Murach's Java Servlets and JSP</title>
</head>

<body>
    
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${sqlStatement == null}">
    <c:set var="sqlStatement" value="select * from User" />
</c:if>
    
<h1>The SQL Gateway</h1>
<p>Enter an SQL statement and click the Execute button. Then, information about the <br>
statement will appear at the bottom of t
<p>
<b>SQL statement:</b><br>
<form action="sqlGateway" method="post">
    <textarea name="sqlStatement" cols="60" 
              rows="8">${sqlStatement}
    </textarea><br><br>
    <input type="submit" value="Execute">
</form>
</p>

<p>
<b>SQL result:</b><br>
    ${sqlResult}
</p>

</body>
</html>
