<%--
  Created by IntelliJ IDEA.
  User: jabhi
  Date: 04-Apr-17
  Time: 3:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Sign out</title>
    <link rel="stylesheet" href="res/cssfile.css" type="text/css" >
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">

    <link rel="stylesheet" href="Alert/alertcss.css" type="text/css">
    <style>
        body{
            background: #e52d27;
            background: -webkit-linear-gradient(to left, #e52d27 , #b31217);
            background: linear-gradient(to left, #e52d27 , #b31217);
        }
    </style>

</head>
<body>

<%  session.invalidate();
    Cookie cookie = null;
    Cookie[] cookies = null;
    cookies = request.getCookies();
    if( cookies != null ) {
        for (int i = 0; i < cookies.length; i++) {
            cookie = cookies[i];
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
    }
%>

<div class="card">
    <div class="waring">
        <span class="waring-i"></span>
        <span class="waring-dot"></span>
    </div>
    <h1 style="color: #575757">Sign out</h1>
    <p style="margin-bottom: 30px;color: #797979"> successfully.</p>
    <a href="main.html" class="btn white-text green hoverable">Back to Home<i class="material-icons right">&#xE5C8;</i></a>
</div>

</body>
</html>