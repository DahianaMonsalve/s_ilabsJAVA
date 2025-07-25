<%-- 
    Document   : bienvenido
    Created on : 25/07/2025, 4:48:09 p. m.
    Author     : Dahia
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Bienvenida</title></head>
<body>
    <h2>Hola, <%= request.getAttribute("nombre") %></h2>
    <p>Bienvenid@ a Supplies iLab</p>
</body>
</html>
