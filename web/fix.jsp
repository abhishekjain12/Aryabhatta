<%--
  Created by IntelliJ IDEA.
  User: jabhi
  Date: 04-Apr-17
  Time: 8:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page errorPage="Alert/Error-found.html" %>

<html>
<head>
    <title>Updating...</title>
</head>

<body onload="setTimeout(function() { document.myForm.submit() }, 10)">

<% String username = (String) session.getAttribute("user"); %>

<form action="smartComp" method="post" name="myForm">
    <input name="username" type="hidden" value="<%=username%>">
</form>

</body>
</html>
