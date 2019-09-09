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
    <div class="helloDiv">
        ${login}, Hello!
    </div>
    <button id="findGameButton">
        find game
    </button>
<script>
    let button = document.getElementById("findGameButton");
    button.addEventListener("click", (event)=>{
        //todo fix path /domino_war_exploded
        let socket = new WebSocket("ws://localhost:8080/domino_war_exploded/dominoGame/${userId}");

        socket.onopen = ()=>{
          console.log("Socket opened");
        };

        socket.onmessage = (event)=>{
            console.log(event.data);
        };
    });
</script>
</body>
</html>
