<!DOCTYPE HTML PUBLIC 
"-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>
    <title>Murach's Java Servlets and JSP</title>
</head>

<body>
  <h1>Join our email list</h1>
  <p>To join our email list, enter your name and
     email address below. <br>
     Then, click on the Submit button.</p>

  <p><i>${message}</i></p>
<form action="addToEmailList" method="post">
  <table cellspacing="5" border="0">
    <tr>
      <td align="right">First name:</td>
      <td><input type="text" name="firstName" 
          value="${user.firstName}">
      </td>
    </tr>
    <tr>
      <td align="right">Last name:</td>
      <td><input type="text" name="lastName" 
          value="${user.lastName}">
      </td>
    </tr>
    <tr>
      <td align="right">Email address:</td>
      <td><input type="text" name="emailAddress" 
          value="${user.emailAddress}">
      </td>
    </tr>
  </table>
      <input type="submit" value="Submit">
</form>
</body>
  </html>

