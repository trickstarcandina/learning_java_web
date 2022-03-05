<%@page import="java.util.List"%>
<%@page import="dao.DaoStudentImpl"%>
<jsp:include page="header.html"/>
<%@ page import="model.Student" %>
<%@ page import="dao.DaoStudentImpl" %>

<h1>Students</h1>
<%
    // get attributes from the request

    DaoStudentImpl dao = new DaoStudentImpl();
    List<Student> students = dao.getAll();
    System.out.println("==> " + students.toString());
    request.setAttribute("list", students);
%>

<table>
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>Age</td>
    </tr>
    <%
        for (int i = 0; i < students.size(); i++) {%>
    <tr>
        <td><%= students.get(i).getId()%></td>
        <td><%= students.get(i).getName()%></td>
        <td><%= students.get(i).getAge()%></td>
    </tr>
    <%}%>
</table>

<br/>
<hr/>


<h1>Add Student</h1>
<form action="addStudent" method="post">
    <table cellspacing="5" border="0">
        <tr>
            <td align="right">ID:</td>
            <td><input type="text" name="id"> </td>
        </tr>
        <tr>
            <td align="right">Name:</td>
            <td><input type="text" name="name"> </td>
        </tr>
        <tr>
            <td align="right">Age:</td>
            <td><input type="text" name="age"></td>
        </tr>
        <tr>
            <td></td>
            <td><br>
                <input type="submit" value="Submit" ></td>
        </tr>
    </table>
</form>


<jsp:include page="footer.jsp"/>