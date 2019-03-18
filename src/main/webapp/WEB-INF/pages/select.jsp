<%@ page import="model.Game" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: thorv
  Date: 2/15/2019
  Time: 4:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>BlockBluster</title>
</head>
<body>
<p>Welkom! Hier is een lijst van games:</p>
<%
    for(Game game : (List<Game>)request.getAttribute("gameList")) {
        out.write("<p>" + game.getName() + "</p>");
    }

%>
<p>Welke is jouw favoriet?</p>
<form method="post" action="${pageContext.request.contextPath}/choice">
    <input type="text" name="choice">
    <input type="submit" value="Deze!" />
</body>
</html>