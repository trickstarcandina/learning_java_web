<%@ page import="java.util.*" %>
<%
    // initialize the current year that's used in the 
    // copyright notice
    GregorianCalendar currentDate = new GregorianCalendar();
    int currentYear = currentDate.get(Calendar.YEAR);
    ServletContext context=this.getServletContext();
    String custServEmail=context.getInitParameter("custServEmail");
%>	

<p><small>
&copy; Copyright <%= currentYear %> 
Mike Murach &amp; Associates, Inc. 
All rights reserved<br>
Email us at: <%= custServEmail%>
</small></p>
</body>
</html>
