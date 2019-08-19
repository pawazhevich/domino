<%--
  Created by IntelliJ IDEA.
  User: 37529
  Date: 2019-08-15
  Time: 12:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main Page</title>
</head>
<body>
    ${login}, Hello!
    <div class="game_field">
        ТУТ БУДЕТ ИГРА
    </div>
<form name="logout" action="controller" method="post">
    <input type="hidden" name="command" value="logout"/>
    <button type="submit" value="logout">Log out</button>
</form>
</body>
</html>
