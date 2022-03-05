<%-- import any packages needed by the page --%>
<%@ page import="business.*, data.*, java.util.Date, 
    java.io.*" %>
<%! 
    // declare an instance variable for the page
    int globalCount = 0;  // this is not thread-safe
%>
<%!
    // declare a method for the page
    public void add(User user, String filename)
            throws IOException
    {
        PrintWriter out = new PrintWriter(
                new FileWriter(filename, true));
        out.println(user.getEmailAddress()+ "|"
                + user.getFirstName() + "|"
                + user.getLastName());
        out.close();
    }
%>
<%
    String firstName = request.getParameter("firstName");
    String lastName = request.getParameter("lastName");
    String emailAddress = 
        request.getParameter("emailAddress");
	
    ServletContext sc = getServletContext();
    String path = sc.getRealPath("/WEB-INF/EmailList.txt");

    User user = new User(firstName, lastName, emailAddress);

    // use the declared method
    this.add(user, path);

    // update the instance variable
    globalCount++;  // this is not thread-safe
%>
<p>
    This email address was added to our list on 
        <%= new Date() %><br>
    This page has been accessed <%= globalCount %> times.
</p>
