<!DOCTYPE HTML PUBLIC 
"-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <title>Murach's Java Servlets and JSP</title>
</head>
<body>
    <!-- import packages and classes needed by scripts -->
    <%
        // get parameters from the request
        String firstName = 
            request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String emailAddress = 
            request.getParameter("emailAddress");
        //session.setAttribute("email", emailAddress);
        //session.setMaxInactiveInterval(1000);
    %>
    <%
        Cookie emailCookie=new Cookie("email",emailAddress);
        emailCookie.setMaxAge(365*24*60*60);
        emailCookie.setPath("/");
        response.addCookie(emailCookie);
    %>

    <h1>Thanks for joining our email list</h1>

    <p>Here is the information that you entered:</p>
    <table cellspacing="5" cellpadding="5" border="1">
        <tr>
            <td align="right">First name:</td>
            <td><%=firstName%></td>
        </tr>
        <tr>
            <td align="right">Last name:</td>
            <td><%= lastName %></td>
        </tr>
        <tr>
            <td align="right">Email address:</td>
            <td><%= emailAddress %></td>
        </tr>
    </table>

    <p>To enter another email address, click on the Back <br>
    button in your browser or the Return button shown <br>
    below.</p>
    <form action="<%= response.encodeURL("index.jsp") %>" method="post">
        <input type="submit" value="Return">
    </form>
</body>
</html>
