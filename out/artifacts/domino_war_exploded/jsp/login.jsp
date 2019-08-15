<%--
  Created by IntelliJ IDEA.
  User: 37529
  Date: 2019-08-15
  Time: 11:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
    <form name="LoginForm" action="controller" method="POST" >
        <input type="hidden" name="command" value="login" />

        <input type="text" name="login" placeholder="login" value="" />
        <input type="password" name="password" placeholder="password" value="" />
        <input type="submit" value="Log in"/>
    </form>
    <div class="error_alert">
        ${loginError}
    </div>
</body>
</html>
